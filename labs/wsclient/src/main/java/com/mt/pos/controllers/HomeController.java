package com.mt.pos.controllers;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mt.pos.beans.Feeds;
import com.mt.pos.beans.News;
import com.mt.pos.dto.HomeDTO;

@ManagedBean
@ViewScoped
public class HomeController extends HomeDTO {

	final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6977702846979035212L;
	
	public HomeController() {
		feeds = new ArrayList<Feeds>();
		news = new ArrayList<News>();
	}
	
	public void search(){
		logger.debug("Entering search() by keyword: " + keyword);
	}

}
