package org.hman.amqp;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 
 * @author scotomax
 *
 */
public class AmqpServer implements Serializable {
	

	private static final long serialVersionUID = 7452969287348690967L;
	private Logger slf4j = LoggerFactory.getLogger(AmqpServer.class);
	
	private final AmqpUtil amqpUtil;
	private Thread worker;
	
	private QueueingConsumer rmqConsumer;
	//private final long TIME_OUT = 60000;
	private final boolean AUTO_ACK = false;
	
	/**
	 * Constructor
	 */
	public AmqpServer () {
		amqpUtil = AmqpUtil.getInstance();
		
		slf4j.debug("Registering thread work shutdowm on runtime.");
		// Shutdown thread worker when application receive signal exit 0.
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					worker.interrupt();
				} catch ( Exception ex ) {
					/* Nothing to do */
				}
			}
		}));
	}
	
	/**
	 * Startup CMI server for subscribe message
	 * and response back.
	 * 
	 * @param receiver
	 * @return result code, 0 is success. otherwise is -1.
	 */
	public int startup(final AmqpReceiver receiver) {
		try {
			
			slf4j.debug("Initialing queueing consumer(subscriber).");
			// Create consumer object
		    rmqConsumer = new QueueingConsumer(amqpUtil.getChannel());
		    
		    slf4j.debug("Registering consumer(subscriber) on defined queue.");
		    // Register consumer to the queue
		    String QUEUE_NAME = amqpUtil.getConfigures().get(AmqpUtil.RMQ_QUEUE);
		    // Register consumer exchange
		    amqpUtil.getChannel().basicConsume( QUEUE_NAME, AUTO_ACK, rmqConsumer);
		    
		    slf4j.debug("Initialing thread worker for fetching message delivery.");
			worker = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							// Consume message when message arrived in the queue.
							QueueingConsumer.Delivery delivery;
							
					        delivery = rmqConsumer.nextDelivery();
					        // Acknowledgement message after processing
							amqpUtil.getChannel().basicAck(delivery.getEnvelope().getDeliveryTag(), false);
					        
							// Processing work for this message
							String response = receiver.handleMessage( delivery );
							// Properties for reply message back
							BasicProperties props = delivery.getProperties();
						    BasicProperties replyProps = new BasicProperties
						                                     .Builder()
						                                     .correlationId(props.getCorrelationId())
						                                     .build();
						    // publish message back
						    amqpUtil.getChannel().basicPublish( "", props.getReplyTo(), replyProps, response.getBytes());
						    
						} catch (Exception ex) {
							slf4j.warn("Failed to fetching message, "+ex.getMessage(), ex);
							synchronized(AmqpServer.class){
								try {
									AmqpServer.class.wait(3000);
								} catch (InterruptedException iex) {
									/* Nothing to do */
								}
							}
						}
				    }
				}
			});
			
			slf4j.debug("Executing thread worker for fetching message delivery.");
			worker.start();
			return 0;
		} catch (Exception ex) {
			slf4j.warn("Failed to startup Cmi, "+ex.getMessage(), ex);
			return -1;
		}
	}
	
	public static final int STARTUP_SUCCESS = 0;
	public static final int STARTUP_FAILED = -1;

	/**
	 * Inner-class implement for Fixing 
	 * Double-Checked Locking for Singleton class
	 * 
	 * @author scotomax
	 *
	 */
	private static class LazyHolder {
        private static final AmqpServer amqpServer = new AmqpServer();
    }
	
	/**
	 * Getting instance class
	 * 
	 * @return instance class
	 */
	public static synchronized AmqpServer getInstance() {
		return LazyHolder.amqpServer;
	}
}
