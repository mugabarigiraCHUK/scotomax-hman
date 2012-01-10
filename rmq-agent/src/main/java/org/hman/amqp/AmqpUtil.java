package org.hman.amqp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Address;
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
	private Logger log = LoggerFactory.getLogger(AmqpUtil.class);
	
	private ConnectionFactory rmqConnFactory;
	private ExecutorService es;
	private Connection rmqConn;
	private Channel rmqChannel;
	private Map<String, String> configures;
	
	/**
	 * Initial RabbitMQ objects/connections by configure parameters
	 * - Mandatory
	 * 		- RMQ_HOST
	 * 		- RMQ_PORT
	 * 		- RMQ_EXCHANGE
	 * 		- RMQ_QUEUE
	 * - If only if Exchange is not declare yet
	 * 		- RMQ_EXCHANGE_TYPE [direct,topic,header,fanout]
	 * - Optional
	 * 		- RMQ_ROUTING_KEY ( Default is RMQ_QUEUE )
	 * 		- RMQ_MIRROR_HOST
	 * 		- RMQ_MIRROR_PORT
	 * 		- RMQ_USERNAME
	 * 		- RMQ_PASSWORD
	 * 		- RMQ_CONN_POOL_SIZE ( Default is 1 )
	 * 		- RMQ_CLIENT_TIMEOUT ( Default is 60s.)
	 * 		- RMQ_PREFETCH_COUNT ( Default is 0 : Unlimit ) 
	 * @param params
	 * @return result code, 0 is success, otherwise is -1.
	 */
	public int init(Map<String, String> params) {
		try {
			
			log.debug("Copy configure parameter to local");
			configures = new HashMap<String, String>();
			configures.putAll(params);
			
			log.debug("Initaling RMQ connection factory");
			// Create connection factory
			rmqConnFactory = new ConnectionFactory();
			
			log.debug("Registering RMQ connection parameters");
			// Register server host.
			if ( params.containsKey( RMQ_MIRROR_HOST )
				 && params.containsKey( RMQ_MIRROR_PORT )
				 && params.containsKey( RMQ_PORT ) ) {
				
				// Register server username for authentication. if existing.
				if ( params.containsKey(RMQ_USERNAME) )
					rmqConnFactory.setUsername(params.get(RMQ_USERNAME));
				// Register server password for authentication. if existing.
				if ( params.containsKey(RMQ_PASSWORD) )
					rmqConnFactory.setPassword(params.get(RMQ_PASSWORD));
				
				// Initial multiple broker address for clustering broker
				Address[] addrArr 
					= new Address[]{ new Address( params.get(RMQ_HOST), 
												  Integer.parseInt( params.get(RMQ_PORT) ) )
                				   , new Address( params.get(RMQ_MIRROR_HOST), 
                					 	    	  Integer.parseInt( params.get(RMQ_MIRROR_PORT) ) ) };
				
				log.debug("Intialing RMQ connection");
				// Create connection pipe
				if ( params.containsKey(RMQ_CONN_POOL_SIZE) ) {
					es = Executors.newFixedThreadPool( Integer.parseInt( params.get(RMQ_CONN_POOL_SIZE) ) );
					rmqConn = rmqConnFactory.newConnection( es, addrArr ); 
				} else {
					es = Executors.newFixedThreadPool( 1 );
					rmqConn = rmqConnFactory.newConnection( es, addrArr );
				}
				
			} else {
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
				
				log.debug("Intialing RMQ connection");
				// Create connection pipe
				if ( params.containsKey(RMQ_CONN_POOL_SIZE) ) {
					es = Executors.newFixedThreadPool( Integer.parseInt( RMQ_CONN_POOL_SIZE ) );
					rmqConn = rmqConnFactory.newConnection( es ); 
				} else {
					es = Executors.newFixedThreadPool( 1 );
					rmqConn = rmqConnFactory.newConnection( es );
				}
			} 
		    log.debug("Creating RMQ channel");
		    // Open channel
		    rmqChannel = rmqConn.createChannel();
		    
		    log.debug("Declaring exchange on RMQ");
		    // Declare the exchange name for used. if required
		    /* Exchange type
		     * - direct
		     * - topic
		     * - header
		     * - fanout
		     */
		    if ( params.containsKey(RMQ_EXCHANGE_TYPE) ) {
		    	rmqChannel.exchangeDeclare( params.get(RMQ_EXCHANGE), params.get(RMQ_EXCHANGE_TYPE), true);
		    }
		    
		    // log.debug("Declaring queue on RMQ");
		    // Declare the queue name for receiving message. if require.
		    String queueName = "";
		    if ( params.containsKey(RMQ_QUEUE) )
		    	queueName = params.get(RMQ_QUEUE);
		    else {
		     	queueName = rmqChannel.queueDeclare().getQueue();
		    }
		    // rmqChannel.queueDeclare( queueName, true, false, false, null);
		    
		    log.debug("Binding queue with exchange");
		    // Binding queue and exchange which declared.
		    String routingkey = queueName;
		    if ( params.containsKey( RMQ_ROUTING_KEY ) ) {
		    	routingkey = params.get( RMQ_ROUTING_KEY );
		    }
		    rmqChannel.queueBind(queueName, params.get(RMQ_EXCHANGE), routingkey);
		    
		    // Setting QoS for limit maximum number of messages that the server will deliver
		    if ( params.containsKey( RMQ_PREFETCH_COUNT ) ) {
		    	int prefetchCount = Integer.parseInt( params.get( RMQ_PREFETCH_COUNT ) );
		    	rmqChannel.basicQos( prefetchCount );
		    }
			
			return 0;
		} catch (Exception ex) {
			log.warn("Failed to initial Cmi object, "+ex.getMessage(), ex);
			return -1;
		}
	}
	
	/**
	 * Destroy all object is concerned Cmi.
	 */
	public void destroy() {
		try {
			log.debug("Closing RMQ channel");
			// Close channel
			rmqChannel.close();
			
			log.debug("Closing RMQ connection");
			// Close connection
			rmqConn.close();
		} catch (Exception ex) {
			log.warn("Failed to destroy Cmi object, "+ex.getMessage(), ex);
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
	
	/**
	 * Getting AMQP channel for utility
	 * 
	 * @return instance of AMQP channel
	 */
	public Channel getChannel() {
		return rmqChannel;
	}
	
	/**
	 * Getting configuration properties
	 * 
	 * @return List of mapped name:value of properties
	 */
	public final Map<String, String> getConfigures(){
		return configures;
	}
	
	public static final String RMQ_HOST = "RMQ_HOST";
	public static final String RMQ_PORT = "RMQ_PORT";
	public static final String RMQ_MIRROR_HOST = "RMQ_MIRROR_HOST";
	public static final String RMQ_MIRROR_PORT = "RMQ_MIRROR_PORT";
	
	public static final String RMQ_EXCHANGE = "RMQ_EXCHANGE";
	public static final String RMQ_QUEUE = "RMQ_QUEUE";
	public static final String RMQ_ROUTING_KEY = "RMQ_ROUTING_KEY";
	public static final String RMQ_USERNAME = "RMQ_USERNAME";
	public static final String RMQ_PASSWORD = "RMQ_PASSWORD";
	public static final String RMQ_CONN_POOL_SIZE = "RMQ_CONN_POOL_SIZE";
	public static final String RMQ_CLIENT_TIMEOUT = "RMQ_CLIENT_TIMEOUT";
	public static final String RMQ_PREFETCH_COUNT = "RMQ_PREFETCH_COUNT";
	
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
