package org.cathod.sample.jsf2rf4;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.cathod.sample.jsf2rf4.bean.HomeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ManagedBean(name="homeBean")
@ViewScoped
public class HomeController extends HomeBean {

	final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public void login(){
		logger.debug("Entering login method.");
		message = "Login successfully, welcome " + username;
	}
	
	public void logout(){
		logger.debug("Entering logout method.");
		username = "";
		password = "";
		message = "Logout successfully";
	}
}
