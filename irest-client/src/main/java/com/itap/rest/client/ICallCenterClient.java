package com.itap.rest.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Credentials;
import org.springframework.web.client.RestTemplate;

import com.itap.rest.client.bean.XmlIvrResponse;

public class ICallCenterClient {

	private final RestTemplate restTemplate;
	private final Credentials credentials;
	private final UriRemote uriRemote;
	
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
	}
	
	public XmlIvrResponse authService(String usrname, String passwd){
		Map<String, String> vars = new HashMap<String, String>();
        vars.put("usrname", "admin");
        vars.put("passwd", "adminadmin");
        return restTemplate.getForObject(uriRemote.getUriAuth(), XmlIvrResponse.class, vars);
	}
	
	public XmlIvrResponse checkService(){
		Map<String, String> vars = new HashMap<String, String>();
        return restTemplate.getForObject(uriRemote.getUriCheck(), XmlIvrResponse.class, vars);
	}
	
}
