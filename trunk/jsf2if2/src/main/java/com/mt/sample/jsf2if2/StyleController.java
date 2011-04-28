package com.mt.sample.jsf2if2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mt.sample.jsf2if2.dto.StyleBean;

@ManagedBean(name="styleBean")
@SessionScoped
public class StyleController extends StyleBean {
	
	final Logger logger = LoggerFactory.getLogger(StyleController.class);

	public void changeStyle(ValueChangeEvent e) {
		
	}
}
