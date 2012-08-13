package org.cathod.sample.jsf2if2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.cathod.sample.jsf2if2.dto.LocaleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ManagedBean(name="localeBean")
@SessionScoped
public class LocaleController extends LocaleBean {
	
	final Logger logger = LoggerFactory.getLogger(StyleController.class);

	/**
	 * 
	 * @param e
	 */
	public void changeLanguage(ValueChangeEvent e){
		
	}
	
}
