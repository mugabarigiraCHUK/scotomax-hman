package com.itap.callcenter.beans;

import java.io.Serializable;
import java.util.Locale;

import lombok.Data;

/**
 * 
 * @author seven
 *
 */
public @Data abstract class UserBean implements Serializable {
	
	private static final long serialVersionUID = 8007109425483203461L;
	
	protected String username;
	protected String password;
	protected boolean authenticated;
	
	protected String strLocale;
	protected Locale locale = new Locale("en");
	
}
