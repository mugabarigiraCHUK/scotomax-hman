package com.itap.rest.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.itap.rest.client.bean.XmlIvrRequest;
import com.itap.rest.client.bean.XmlIvrResponse;

/**
 * 
 * @author scotomax
 *
 */
public class ICallCenterClient {
	
	Logger logger = LoggerFactory.getLogger(ICallCenterClient.class);

	private final RestTemplate restTemplate;
	private final Credentials credentials;
	private final UriRemote uriRemote;
	
	/*
	 * Constructor method
	 */
	public ICallCenterClient(RestTemplate restTemplate, 
															Credentials credentials,
															UriRemote uriRemote){
		this.restTemplate = restTemplate;
		this.credentials = credentials;
		this.uriRemote = uriRemote;
		/*
		CommonsClientHttpRequestFactory factory = (CommonsClientHttpRequestFactory) restTemplate.getRequestFactory();
        HttpClient client = factory.getHttpClient();
        client.getState().setCredentials(AuthScope.ANY, credentials);
        */
		logger.debug("Look->Credentials->" + credentials);
	}
	
	/**
	 * REST services for authentication
	 * 
	 * @param usrname
	 * @param passwd
	 * @return XmlIvrResponse.class
	 */
	public XmlIvrResponse authService(String usrname, String passwd){
		Map<String, String> vars = new HashMap<String, String>();
        vars.put("usrname", "admin");
        vars.put("passwd", "adminadmin");
        return restTemplate.getForObject(uriRemote.getUriAuth(), XmlIvrResponse.class, vars);
	}
	
	/**
	 * REST services for checking the services
	 * 
	 * @return XmlIvrResponse.class
	 */
	public XmlIvrResponse checkService(){
		Map<String, String> vars = new HashMap<String, String>();
        return restTemplate.getForObject(uriRemote.getUriCheck(), XmlIvrResponse.class, vars);
	}
	
	/**
	 * REST services for try to post XML from client into the server
	 * 
	 * @param request
	 * @return XmlIvrResponse.class
	 */
	public XmlIvrResponse callback(XmlIvrRequest request) {
		Map<String, String> vars = new HashMap<String, String>();
		return restTemplate.postForObject(uriRemote.getUriCallback(), request, XmlIvrResponse.class, vars);
	}
	
}
