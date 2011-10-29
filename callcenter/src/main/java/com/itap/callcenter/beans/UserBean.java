package com.itap.callcenter.beans;

import java.io.Serializable;
import java.util.Locale;

/**
 * 
 * @author seven
 *
 */
public abstract class UserBean implements Serializable {
	
	private static final long serialVersionUID = 8007109425483203461L;
	
	protected String username;
	protected String password;
	
	protected Integer userid;
	protected boolean authenticated;
	
	protected String strLocale;
	protected Locale locale = new Locale("en");
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	public String getStrLocale() {
		return strLocale;
	}
	public void setStrLocale(String strLocale) {
		this.strLocale = strLocale;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
}
