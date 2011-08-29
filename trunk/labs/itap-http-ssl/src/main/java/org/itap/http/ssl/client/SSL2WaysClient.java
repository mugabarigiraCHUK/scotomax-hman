package org.itap.http.ssl.client;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.contrib.ssl.AuthSSLProtocolSocketFactory;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author scotomax
 *
 */
public class SSL2WaysClient {
	
	/** Log object for this class. */
    private static final Log LOG = LogFactory.getLog(AuthSSLProtocolSocketFactory.class);
    // Get HTTP client object
	private HttpClient client;
	
	/**
	 * Create HTTP SSL connection pipe to HTTP server
	 * 
	 * @param HOST
	 * @param PORT
	 * @param keyStoreFilePath
	 * @param keyStorePassword
	 * @param trustStoreFilePath
	 * @param trustStorePassword
	 * @throws HttpException
	 * @throws IOException
	 */
	public void createConnection(String HOST,
											int PORT,
											String keyStoreFilePath, 
											String keyStorePassword, 
											String trustStoreFilePath, 
											String trustStorePassword) 
		throws HttpException, IOException {
		AuthSSLProtocolSocketFactory authSSLprotocolSF = 
				new AuthSSLProtocolSocketFactory(new URL("file:"+keyStoreFilePath), keyStorePassword, 
																	new URL("file:"+trustStoreFilePath), trustStorePassword);
		 Protocol authhttps = new Protocol("https", authSSLprotocolSF , PORT);
		 client = new HttpClient(new MultiThreadedHttpConnectionManager());
		 client.getHostConfiguration().setHost(HOST, PORT, authhttps);
	}
	
	/**
	 * Create HTTP post for put SOAP/XML to server and waiting for response.
	 * 
	 * @param strURL
	 * @param strSoapAction
	 * @param contentXML
	 * @param contentType : null is default ( "text/xml; charset=ISO-8859-1")
	 * @return HttpServerResponse object which contain result from HTTP response
	 * @throws HttpException
	 * @throws IOException
	 */
	public HttpServerResponse communicate(String strURL, String strSoapAction, String contentXML, String contentType) 
		throws HttpException, IOException {
		
		HttpServerResponse resp = null;
		
		if ( client != null ) {
			// Default content type assign
			if ( contentType==null || contentType.trim().length()==0 ) {
				contentType = "text/xml; charset=ISO-8859-1";
			}
	        // Prepare HTTP post
	        PostMethod post = new PostMethod(strURL);
	        // Request content will be retrieved directly
	        // from the input stream
	        RequestEntity entity = new ByteArrayRequestEntity(	contentXML.getBytes(), contentType);
	        post.setRequestEntity(entity);
	        // consult documentation for your web service
	        post.setRequestHeader("SOAPAction", strSoapAction);
	        // Execute request
	        try {
	        	
	            int result = client.executeMethod(post);
	            // Display status code
	            LOG.debug("Response status code: " + result);
	            // Display response
	            LOG.debug("Response body: ");
	            LOG.debug(post.getResponseBodyAsString());
	            
	            resp = new HttpServerResponse(String.valueOf(result), post.getResponseBodyAsString());
	        } finally {
	            // Release current connection to the connection pool once you are done
	            post.releaseConnection();
	        }
		} else {
			throw new HttpException("HttpClient doest not initial yet. please execute .createConnection(..) first.");
		}
		return resp;
	}
}
