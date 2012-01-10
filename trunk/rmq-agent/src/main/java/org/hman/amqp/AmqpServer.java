package org.hman.amqp;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	private Logger log = LoggerFactory.getLogger(AmqpServer.class);
	
	private final AmqpUtil amqpUtil;
	private ExecutorService es;
	
	//private final long TIME_OUT = 60000;
	private final boolean AUTO_ACK = false;
	
	/**
	 * Constructor
	 */
	public AmqpServer () {
		amqpUtil = AmqpUtil.getInstance();
		
		log.debug("Registering thread work shutdowm on runtime.");
		// Shutdown thread worker when application receive signal exit 0.
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					es.shutdown();
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
			
			int numOfPools = 1;
			if ( amqpUtil.getConfigures().containsKey( AmqpUtil.RMQ_CONN_POOL_SIZE ) )
				numOfPools = Integer.parseInt( amqpUtil.getConfigures().get( AmqpUtil.RMQ_CONN_POOL_SIZE ) );
			
			log.debug("Start AMQP server over number of thread pool is " + numOfPools );
			
			log.debug("Initialing thread pool executors belongs to number of AMQP connections");
			// Initial thread pool executor
			es = Executors.newFixedThreadPool( numOfPools );
			
			for ( int i = 0; i < numOfPools; i++ ) {
				final int noOfthread = i;
				es.execute(new Runnable() {
					@Override
					public void run() {
						try {
							log.debug("Initialing queueing consumer(subscriber).");
							
							// Create consumer object
							QueueingConsumer rmqConsumer = new QueueingConsumer(amqpUtil.getChannel());
						    log.debug("Registering consumer(subscriber) on defined queue.");
						    
						    // Register consumer to the queue
						    final String EXCHANGE_NAME = amqpUtil.getConfigures().get(AmqpUtil.RMQ_EXCHANGE);
						    final String QUEUE_NAME = amqpUtil.getConfigures().get(AmqpUtil.RMQ_QUEUE);
						    // Register consumer exchange
						    amqpUtil.getChannel().basicConsume( QUEUE_NAME, AUTO_ACK, rmqConsumer);
						    
						    log.debug("Initialing thread worker for fetching message delivery.");
							
							while (true) {
								try {
									// Consume message when message arrived in the queue.
									QueueingConsumer.Delivery delivery;
									
							        delivery = rmqConsumer.nextDelivery();
							        // Acknowledgment message after processing
									amqpUtil.getChannel().basicAck(delivery.getEnvelope().getDeliveryTag(), false);
							        
									// Processing work for this message
									String response = receiver.handleMessage( delivery );
									
									// Properties for reply message back
									BasicProperties props = delivery.getProperties();
									log.debug(" Worker {thread:"+noOfthread+", correlationid:"+props.getCorrelationId()+"}");
									
									// Checking, Is the client required message reply?
									if ( props.getReplyTo() != null && props.getReplyTo().length() > 0 ) {
										BasicProperties replyProps = new BasicProperties
			                                     .Builder()
			                                     .correlationId(props.getCorrelationId())
			                                     .build();
										// publish message back
										amqpUtil.getChannel().basicPublish( EXCHANGE_NAME, props.getReplyTo(), replyProps, response.getBytes());
									} else {
										log.debug("The message["+props.getCorrelationId()+"] is not required for reply");
									}
								    
								} catch (Exception ex) {
									log.warn("Failed to fetching message, "+ex.getMessage(), ex);
									synchronized(AmqpServer.class){
										try {
											Thread.sleep(3000);
										} catch (InterruptedException iex) {
											/* Nothing to do */
										}
									}
								}
						    }
						} catch ( Exception ex ) {
							log.error("Failed to execute AMQP processor in thread pool, "+ex.getMessage(), ex);
						}
					}
				});
			}
			
			return 0;
		} catch (Exception ex) {
			log.warn("Failed to startup Cmi, "+ex.getMessage(), ex);
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
