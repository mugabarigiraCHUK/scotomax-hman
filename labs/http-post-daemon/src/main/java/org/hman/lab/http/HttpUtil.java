package org.hman.lab.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Sarayut Utsakoo
 * @version 1.0.0
 *
 */
public class HttpUtil {

	// Logging
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	
	/**
     * Inner-class implement for Fixing Double-Checked Locking for Singleton class
     * @author Sarayut Utsakoo
     *
     */
    private static class LazyHolder {
        private static final HttpUtil httpUtil = new HttpUtil();
    }
    
    /*
     * Constructor-method
     */
    public HttpUtil() {
    	/* Nothing */
    }
    
    /**
     * Getting HttpUtil instance class
     * 
     * @return HttpUtil instance class
     */
    public static HttpUtil getInstance() {
    	return LazyHolder.httpUtil;
    }
    
    /**
     * Do HTTP POST to destination with payload XML 
     * and waiting for response.
     * 
     * @param url
     * @param payload
     * @return String represent XML response
     * @throws Exception
     */
    public String doPost(final String url, final String payload) throws Exception {
    	String respondBody;
    	// Prepare HTTP post
    	// Get HTTP client
        HttpClient httpclient = new HttpClient();
    	PostMethod post = new PostMethod(url);
        // Request content will be retrieved directly
        // from the input stream
        RequestEntity entity = new ByteArrayRequestEntity(payload.getBytes(), "text/xml; charset=ISO-8859-1");
        post.setRequestEntity(entity);
        // Execute request
        try {
        	// Display request
        	logger.debug(" ***** Request body: ");
        	logger.debug(payload);
        	// Execute HTTP POST.
            int result = httpclient.executeMethod(post);
            // Display status code
            logger.debug(" ***** Response status code: " + result);
            // Display response
            respondBody = post.getResponseBodyAsString();
            logger.debug(" ***** Response body: ");
            logger.debug(respondBody);
        } finally {
            // Release current connection to the connection pool once you are done
            post.releaseConnection();
        }
    	return (respondBody == null)?"":respondBody;
    }
}
