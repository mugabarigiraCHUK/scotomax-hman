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
	 * 
	 * @param qname
	 * @param loop
	 */
	void execute(String qname, int loop) {
		try {
			for (int i=0; i < loop; i++) {
				rabbitMQ.send(qname, String.valueOf(System.currentTimeMillis()));
			}
		} catch (Exception ex) {
			log4j.error("Failed to run application, "+ex.getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param val
	 * @return true when the value is number
	 */
	public static boolean isDigit(String val) {
    	try {
    		if (val == null) return false;
    		for (char ch : val.toCharArray()) {
    			if (!Character.isDigit(ch)) return false;
    		}
    		return true;
    	} catch (Exception ex) {
    		return false;
    	}
    }
	
	/**
	 * Main-app
	 * @param args
	 */
    public static void main( String[] args ) {
    	if (args != null) {
    		if (args.length == 2) {
    			if (!"".equals(args[0].trim())) {
    				if ( isDigit( args[1] ) ) {
        				// Execute proceed messages to RabbitMQ
    					(new RabbitApp()).execute(args[0], Integer.parseInt(args[1]));
    					
        			} else System.err.println("Command: java -jar samp-rmq-02 [Qname] [loop]");
    			} else System.err.println("Command: java -jar samp-rmq-02 [Qname] [loop]");
    		} else System.err.println("Command: java -jar samp-rmq-02 [Qname] [loop]");
    	} else System.err.println("Command: java -jar samp-rmq-02 [Qname] [loop]");
    }
    
    
}
