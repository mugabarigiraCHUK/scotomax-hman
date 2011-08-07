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
		authenticated = authenticationService.login(username, password);

		if (authenticated) {
			return "welcome.faces";
		} else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or password incorrect."));			
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
	
	public void changeLocale() {
		logger.debug("Entering change locale mathod by param.locale->"+locale);
		try {
			if ("en".equals(locale)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
			} else if ("th".equals(locale)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("th"));
			} else {
				logger.warn("System could not found selected locale for updating!");
			}
		} catch ( Exception ex ) {
			logger.warn("Failed to update system locale, Cause: "+ex.getMessage(), ex);
		}
	}

}
