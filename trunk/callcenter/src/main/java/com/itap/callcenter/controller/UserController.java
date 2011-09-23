package com.itap.callcenter.controller;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.UserBean;
import com.itap.callcenter.service.AuthenticationService;
import com.itap.callcenter.service.impl.AuthenticationServiceImpl;

/**
 * 
 * @author seven
 *
 */
@SessionScoped
@ManagedBean(name = "userController")
public class UserController extends UserBean {

	private static final long serialVersionUID = 2646348478781680974L;
	
	final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
	@ManagedProperty(value = "#{authenticationService}")
	private AuthenticationService authenticationService;
	
	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	public String login() {
		boolean valid = authenticationService.login(username, password);
		if ( valid ) {
			//userid = profile.getAgentId();
			authenticated = true;
			return "welcome.faces";
		} else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or password incorrect.", "Information"));			
			return "login.faces";
		}
	}
	
	public String logout() {
		authenticationService.logout();
		username = null;
		password = null;
		authenticated = false;
		
		return "home.faces";
	}
	
	/**
	 * Locale change event handle
	 */
	public void changeLocale() {
		logger.debug("Entering change locale mathod by param.locale->"+strLocale);
		try {
			if ("en".equals(strLocale)) {
				locale = new Locale("en");
			} else if ("th".equals(strLocale)) {
				locale = new Locale("th");
			} else {
				logger.warn("System could not found selected locale for updating!");
			}
		} catch ( Exception ex ) {
			logger.warn("Failed to update system locale, Cause: "+ex.getMessage(), ex);
		}
	}

}
