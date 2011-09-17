package com.itap.rest.client;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data class UriRemote implements Serializable {

	private static final long serialVersionUID = 7087135970560971814L;
	
	private String UriAuth;
	private String UriCheck;
	private String UriCallback;
	
}
