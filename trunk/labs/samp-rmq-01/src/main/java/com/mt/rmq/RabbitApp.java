package com.mt.rmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author sarayut
 *
 */
public class RabbitApp {
	
	Logger log4j = LoggerFactory.getLogger(RabbitApp.class);
	
	final RabbitMQ rabbitMQ = new RabbitMQ();
	
	/**
	 * Running application listener for receiving message from
	 * RabbitMQ
	 * @param QNAME
	 */
	void execute(String QNAME) {
		// Entering RabbitMQ application
		log4j.info("Entering RabbitMQ application...");
		
		try {
			rabbitMQ.receive( QNAME );
		} catch (Exception ex) {
			log4j.error("Failed to run application, "+ex.getMessage(), ex);
		}
	}
	
	/**
	 * Main-app
	 * @param args
	 */
    public static void main( String[] args ) {
    	if (args != null) {
    		if (args.length == 1) {
    			if (!"".equals(args[0].trim())) {
    				// Execute proceed messages to RabbitMQ
    				(new RabbitApp()).execute(args[0]);
    					
    			} else System.err.println("Command: java -jar samp-rmq-01 [Qname]");
    		} else System.err.println("Command: java -jar samp-rmq-01 [Qname]");
    	} else System.err.println("Command: java -jar samp-rmq-01 [Qname]");
        
    }
}
