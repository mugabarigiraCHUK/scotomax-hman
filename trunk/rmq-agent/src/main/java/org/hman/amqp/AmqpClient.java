package org.hman.amqp;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 
 * @author scotomax
 *
 */
public class AmqpClient implements Serializable {
	
	private static final long serialVersionUID = 6248811705534118142L;
	private Logger log = LoggerFactory.getLogger(AmqpClient.class);

	private final AmqpUtil amqpUtil;
	private final QueueingConsumer consumer;
	private String replyQueueName;
	
	// RabbitMQ parameters
	private final boolean AUTO_ACK = false;
	
	/**
	 * Constructor
	 */
	public AmqpClient () {
		amqpUtil = AmqpUtil.getInstance();
		log.debug("Initialing queueing consumer(subscriber).");
		// Declare consume response message
		consumer = new QueueingConsumer(amqpUtil.getChannel());
		try {
			log.debug("Asking individual queue name for RPC");
			// Getting auto-generated individual queue name.
			replyQueueName = amqpUtil.getConfigures().get(AmqpUtil.RMQ_QUEUE);
			
			log.debug("Register consumer(subscriber) on individual queue --> " + replyQueueName );
			// Register consumer above.
			amqpUtil.getChannel().basicConsume(replyQueueName, AUTO_ACK, consumer);
		} catch ( Exception ex ) {
			log.error("Failed to initial Amqp client RPC component, "+ex.getMessage(), ex);
		}
	}
	
	/**
	 * Send message to exchange for subscriber.
	 * 
	 * @param destExchange
	 * @param routingKey
	 * @param messageText
	 * 
	 * @throws Exception
	 */
	public void send(String destExchange, String routingKey, String messageText) throws Exception {
		amqpUtil.getChannel()
			   .basicPublish(destExchange, 
					   		 routingKey, 
					   		 MessageProperties.PERSISTENT_TEXT_PLAIN, 
					   		 messageText.getBytes(AmqpUtil.CHARSET));
	}
	
	
	/**
	 * Send message to exchange for subscriber base on RPC system.
	 * 
	 * @param destExchange
	 * @param messageText
	 * @return text result from subscriber
	 * @throws Exception
	 */
	public String call(String destExchange, String routingKey, String messageText) throws Exception {
		String response = null;
	    String correlationId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
	    long timeout = 60 * 1000;
	    if ( amqpUtil.getConfigures().containsKey(AmqpUtil.RMQ_CLIENT_TIMEOUT) )
	    	timeout = Integer.parseInt(amqpUtil.getConfigures().get(AmqpUtil.RMQ_CLIENT_TIMEOUT)) * 1000;
	    
	    BasicProperties props = new BasicProperties
						                .Builder()
						                .correlationId(correlationId)
						                .replyTo(replyQueueName)
						                .build();
	    
	    // publish message to subscriber by exchange
		amqpUtil.getChannel()
			   .basicPublish(destExchange, 
					   		 routingKey, 
					   		 props, 
					   		 messageText.getBytes(AmqpUtil.CHARSET));
		
		// Waiting for response message back from subscriber
		long startTime = System.currentTimeMillis();
		while ( true ) {
	        // Fetching message
			QueueingConsumer.Delivery delivery = consumer.nextDelivery( timeout );
			if ( delivery == null 
					|| delivery.getProperties() == null ) {
				throw new RuntimeException("System timeout for waiting response message over limit "+timeout+" millisec.");
			} else if (delivery.getProperties().getCorrelationId().equals(correlationId)) {
	        	// Acknowledgment message after processing
				amqpUtil.getChannel().basicAck(delivery.getEnvelope().getDeliveryTag(), false);
	            response = new String(delivery.getBody());
	            break;
	        } else {
	        	if ( ( System.currentTimeMillis() - startTime ) >= timeout )
	        		throw new RuntimeException("System timeout for waiting response message over limit "+timeout+" millisec.");
	        }
	    }
		
		return response;
	}
	
	/**
	 * Send message to exchange for subscriber with extra parameters
	 * 
	 * @param destExchange
	 * @param routingKey
	 * @param contentType
	 * @param contentEncoding
	 * @param headers
	 * @param deliveryMode
	 * @param priority
	 * @param correlationId
	 * @param replyTo
	 * @param expiration
	 * @param messageId
	 * @param timestamp
	 * @param type
	 * @param userId
	 * @param appId
	 * @param clusterId
	 * @param messageText
	 * 
	 * @return text result from subscriber
	 * @throws Exception
	 */
	public void send(String destExchange,
			String routingKey,
			String contentType, 
			String contentEncoding, 
			Map<String, Object> headers, 
			Integer deliveryMode,
			Integer priority, 
			String correlationId, 
			String replyTo, 
			String expiration,
			String messageId, 
			Date timestamp, 
			String type, 
			String userId,
			String appId, 
			String clusterId,
			String messageText) throws Exception {
		amqpUtil.getChannel()
			   .basicPublish(destExchange, 
					   		 routingKey, 
					   		new AMQP.BasicProperties
		                       (contentType, 
		                        contentEncoding, 
		                        headers, 
		                        deliveryMode,
		                        priority, 
		                        correlationId, 
		                        replyTo, 
		                        expiration,
		                        messageId, 
		                        timestamp, 
		                        type, 
		                        userId,
		                        appId, 
		                        clusterId), 
					   		 messageText.getBytes(AmqpUtil.CHARSET));
	}
	
	/**
	 * Inner-class implement for Fixing 
	 * Double-Checked Locking for Singleton class
	 * 
	 * @author scotomax
	 *
	 */
	private static class LazyHolder {
        private static final AmqpClient amqpClient = new AmqpClient();
    }
	
	/**
	 * Getting instance class
	 * 
	 * @return instance class
	 */
	public static synchronized AmqpClient getInstance() {
		return LazyHolder.amqpClient;
	}
}
