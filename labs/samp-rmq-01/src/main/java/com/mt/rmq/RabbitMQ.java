package com.mt.rmq;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 
 * @author sarayut
 *
 */
public class RabbitMQ {

	Logger log4j = LoggerFactory.getLogger(RabbitMQ.class);
	
	int numberOfMessage = 0;
	long firstmilliseconds = 0;
	
	NumberFormat formatter = new DecimalFormat("#0.000");
	
	/**
	 * Request sending message through RabbitMQ
	 * 
	 * @param QUEUE_NAME
	 * @param MESSAGE
	 * @throws Exception
	 */
	public void send(String QUEUE_NAME, String MESSAGE) throws Exception {
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);

	    channel.basicPublish("", QUEUE_NAME, null, MESSAGE.getBytes());
	    numberOfMessage++;
	    
	    log4j.debug(" ["+numberOfMessage+"] Sent '" + MESSAGE + "'");
	    
	    channel.close();
	    connection.close();
	}
	
	/**
	 * Request running listener for receive message from RabbitMQ
	 * 
	 * @param QUEUE_NAME
	 * @throws Exception
	 */
	public void receive(String QUEUE_NAME) throws Exception {
		
		// Create connection factory
		ConnectionFactory factory = new ConnectionFactory();
	    // Register server host.
		factory.setHost("localhost");
	    // Create connection pipe
	    Connection connection = factory.newConnection();
	    // Open channel
	    Channel channel = connection.createChannel();

	    // Declare the queue name for receiving message
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    log4j.info(" [*] Waiting for messages. To exit press CTRL+C");
	    
	    // Create consumer object
	    QueueingConsumer consumer = new QueueingConsumer(channel);
	    // Register consumer to the queue
	    channel.basicConsume(QUEUE_NAME, true, consumer);

	    while (true) {
	    	// Consume message when message arrived in the queue.
	      
	    	QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	    	String message = new String(delivery.getBody());
	    	numberOfMessage++;
	      
	    	log4j.debug(" ["+numberOfMessage+"] Received '" + message + "'");
	      
		    if (firstmilliseconds == 0) { 
		    	firstmilliseconds = Long.parseLong(message);
		    } else {
		    	float spendtime = (Long.parseLong(message) - firstmilliseconds);
		    	//log4j.debug("Differential time: "+spendtime);
		    	log4j.info("Spend-time: "+(spendtime/1000)+" seconds");
		    }
	    }
	}
}
