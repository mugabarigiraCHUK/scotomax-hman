package com.mt.http.client;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.contrib.ssl.AuthSSLProtocolSocketFactory;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.protocol.Protocol;

/**
 * 
 * @author scotomax
 *
 */
public class SSL2WaysClient {

	public void createConnection() throws HttpException, IOException {
		AuthSSLProtocolSocketFactory authSSLprotocolSF = 
				new AuthSSLProtocolSocketFactory(new URL("file:my.keystore"), "mypassword", 
																	new URL("file:my.truststore"), "mypassword");
		 Protocol authhttps = new Protocol("https", authSSLprotocolSF , 443);
		 HttpClient client = new HttpClient();
		 client.getHostConfiguration().setHost("localhost", 443, authhttps);
		 
		// Get target URL
        String strURL = "/services";
        // Get SOAP action
        String strSoapAction = "ebXML";
        // Get file to be posted
        String strXMLFilename = "soap.xml";
        // Prepare HTTP post
        PostMethod post = new PostMethod(strURL);
        // Request content will be retrieved directly
        // from the input stream
        RequestEntity entity = new ByteArrayRequestEntity(strXMLFilename.getBytes(), "text/xml; charset=ISO-8859-1");
        post.setRequestEntity(entity);
        // consult documentation for your web service
        post.setRequestHeader("SOAPAction", strSoapAction);
        // Execute request
        try {
            int result = client.executeMethod(post);
            // Display status code
            System.out.println("Response status code: " + result);
            // Display response
            System.out.println("Response body: ");
            System.out.println(post.getResponseBodyAsString());
        } finally {
            // Release current connection to the connection pool once you are done
            post.releaseConnection();
        }
	}
}
