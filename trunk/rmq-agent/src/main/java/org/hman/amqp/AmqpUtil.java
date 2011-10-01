package org.hman.amqp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 
 * @author scotomax
 *
 */
public class AmqpUtil implements Serializable {

	private static final long serialVersionUID = -3029137620640162611L;
	private Logger slf4j = LoggerFactory.getLogger(AmqpUtil.class);
	
	private ConnectionFactory rmqConnFactory;
	private Connection rmqConn;
	private Channel rmqChannel;
	private Map<String, String> configures;
	
	/**
	 * Initial all component by configure parameters
	 * 
	 * @param params
	 * @return result code, 0 is success, otherwise is -1.
	 */
	public int init(Map<String, String> params) {
		try {
			
			slf4j.debug("Copy configure parameter to local");
			configures = new HashMap<String, String>();
			configures.putAll(params);
			
			slf4j.debug("Initaling RMQ connection factory");
			// Create connection factory
			rmqConnFactory = new ConnectionFactory();
			
			slf4j.debug("Registering RMQ connection parameters");
			// Register server host.
			rmqConnFactory.setHost(params.get(RMQ_HOST));
			// Register server port. if existing
			if ( params.containsKey(RMQ_PORT) )
				rmqConnFactory.setPort(Integer.parseInt(params.get(RMQ_PORT)));
			// Register server username for authentication. if existing.
			if ( params.containsKey(RMQ_USERNAME) )
				rmqConnFactory.setUsername(params.get(RMQ_USERNAME));
			// Register server password for authentication. if existing.
			if ( params.containsKey(RMQ_PASSWORD) )
				rmqConnFactory.setPassword(params.get(RMQ_PASSWORD));
			
			slf4j.debug("Intialing RMQ connection");
			// Create connection pipe
		    rmqConn = rmqConnFactory.newConnection();
		    
		    slf4j.debug("Creating RMQ channel");
		    // Open channel
		    rmqChannel = rmqConn.createChannel();
		    
		    slf4j.debug("Declaring exchange on RMQ");
		    // Declare the exchange name for used. if required
		    /* Exchange type
		     * - direct
		     * - topic
		     * - header
		     * - fanout
		     */
		    if ( params.containsKey(RMQ_EXCHANGE) )
		    	rmqChannel.exchangeDeclare( params.get(RMQ_EXCHANGE), params.get(RMQ_EXCHANGE_TYPE), true);
		    
		    slf4j.debug("Declaring queue on RMQ");
		    // Declare the queue name for receiving message. if require.
		    String queueName = "";
		    if ( params.containsKey(RMQ_QUEUE) )
		    	queueName = params.get(RMQ_QUEUE);
		    else {
		    	queueName = rmqChannel.queueDeclare().getQueue();
		    }
		    rmqChannel.queueDeclare( queueName, true, false, false, null);
		    
		    slf4j.debug("Binding queue with exchange");
		    // Binding queue and exchange which declared.
		    rmqChannel.queueBind(queueName, params.get(RMQ_EXCHANGE), "");
			
			return 0;
		} catch (Exception ex) {
			slf4j.warn("Failed to initial Cmi object, "+ex.getMessage(), ex);
			return -1;
		}
	}
	
	/**
	 * Destroy all object is concerned Cmi.
	 */
	public void destroy() {
		try {
			slf4j.debug("Closing RMQ channel");
			// Close channel
			rmqChannel.close();
			
			slf4j.debug("Closing RMQ connection");
			// Close connection
			rmqConn.close();
		} catch (Exception ex) {
			slf4j.warn("Failed to destroy Cmi object, "+ex.getMessage(), ex);
		}
	}
	
	/**
	 * Getting status of Cmi
	 * 
	 * @return true when Cmi ready for sending message,
	 * otherwise is false.
	 */
	public boolean isRunning() {
		if ( rmqChannel != null && rmqChannel.isOpen() )
			return true;
		else return false;
	}
	
	public Channel getChannel() {
		return rmqChannel;
	}
	
	public Map<String, String> getConfigures(){
		return configures;
	}
	
	
	public static final String RMQ_HOST = "RMQ_HOST";
	public static final String RMQ_PORT = "RMQ_PORT";
	public static final String RMQ_EXCHANGE = "RMQ_EXCHANGE";
	public static final String RMQ_QUEUE = "RMQ_QUEUE";
	public static final String RMQ_USERNAME = "RMQ_USERNAME";
	public static final String RMQ_PASSWORD = "RMQ_PASSWORD";
	
	public static final String RMQ_EXCHANGE_TYPE = "EXCHANGE_TYPE";
	public static final String RMQ_EXCHANGE_DIRECT = "direct";
	public static final String RMQ_EXCHANGE_TOPIC = "topic";
	public static final String RMQ_EXCHANGE_HEADER = "header";
	public static final String RMQ_EXCHANGE_FANOUT = "fanout";
	
	public static final String CHARSET = "UTF-8";
	
	public static final int INIT_SUCCESS = 0;
	public static final int INIT_FAILED = -1;
	
	/**
	 * Inner-class implement for Fixing 
	 * Double-Checked Locking for Singleton class
	 * 
	 * @author scotomax
	 *
	 */
	private static class LazyHolder {
        private static final AmqpUtil cmiUtil = new AmqpUtil();
    }
	
	/**
	 * Getting instance class
	 * 
	 * @return instance class
	 */
	public static synchronized AmqpUtil getInstance() {
		return LazyHolder.cmiUtil;
	}
	
}
