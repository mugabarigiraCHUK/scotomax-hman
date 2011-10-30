package com.itap.rest.client;

import java.io.Serializable;

/**
 * 
 * @author scotomax
 *
 */
public class UriRemote implements Serializable {

	private static final long serialVersionUID = 7087135970560971814L;
	
	private String UriAuth;
	private String UriCheck;
	private String UriCallback;
	
	public String getUriAuth() {
		return UriAuth;
	}
	public void setUriAuth(String uriAuth) {
		UriAuth = uriAuth;
	}
	public String getUriCheck() {
		return UriCheck;
	}
	public void setUriCheck(String uriCheck) {
		UriCheck = uriCheck;
	}
	public String getUriCallback() {
		return UriCallback;
	}
	public void setUriCallback(String uriCallback) {
		UriCallback = uriCallback;
	}
	
}
