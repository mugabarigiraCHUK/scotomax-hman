package com.mt.sample.jsf2if2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mt.sample.jsf2if2.dto.NavigationBean;

@ManagedBean(name="navigation")
@SessionScoped
public class NavigationController extends NavigationBean {

	final Logger logger = LoggerFactory.getLogger(NavigationController.class);
	
	public void navigationPathChange(ActionEvent event) {
		logger.debug("Entering navigationPathChange method.");
	}
}
