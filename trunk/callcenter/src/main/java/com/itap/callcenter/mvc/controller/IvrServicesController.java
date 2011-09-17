package com.itap.callcenter.mvc.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itap.callcenter.mvc.bean.XmlIvrParam;
import com.itap.callcenter.mvc.bean.XmlIvrParams;
import com.itap.callcenter.mvc.bean.XmlIvrResponse;
import com.itap.callcenter.mvc.bean.XmlIvrStatus;

/**
 * 
 * @author scotomax
 *
 */
@Controller
public class IvrServicesController implements Serializable {

	// Serialize
	private static final long serialVersionUID = -12981702740585218L;
	
	// SLF4J Logging
	Logger logger = LoggerFactory.getLogger(IvrServicesController.class);
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public XmlIvrResponse exception(Exception ex, HttpServletRequest req, HttpServletResponse resp) {
		
		logger.debug("Look->Exception->Message->" + ex.getMessage());
		logger.debug("Look->HttpServletRequest->" + req);
		logger.debug("Look->HttpServletResponse->" + resp);
		
		XmlIvrResponse response = new XmlIvrResponse();
		XmlIvrStatus status = new XmlIvrStatus();
		status.setResponseCode( HTTP_CODE_INTERNAL_ERROR );
		status.setResponseDesc("System error, please contact admin.");
		response.setStatus(status);
		
		return response;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/auth/{username}/{passwd}")
	@ResponseBody
	public XmlIvrResponse  authenticate(@PathVariable("username") String username, 
																						@PathVariable("passwd") String passwd, 
																						Model model) {
		
		logger.debug("Look->PathVariable->username->" + username );
		logger.debug("Look->PathVariable->passwd->" + passwd );
		
		logger.debug("Look->Model->" + model.toString());
		
		XmlIvrResponse response = new XmlIvrResponse();
		
		if ( "admin".equals(username) && "adminadmin".equals(passwd) ) {
			
			List<XmlIvrParam> paramList = new ArrayList<XmlIvrParam>();
			XmlIvrParam param = new XmlIvrParam();
			param.setName("token");
			param.setValue("84ksjdi82uo934iwoue8439oi93i0slxmcjew03");
			paramList.add(param);
			
			
			XmlIvrParams params = new XmlIvrParams();
			params.setParam(paramList);
			response.setParams(params);
			
			XmlIvrStatus status = new XmlIvrStatus();
			status.setResponseCode( HTTP_CODE_OK );
			status.setResponseDesc("authorize passed");
			response.setStatus(status);
			
		} else {
			XmlIvrStatus status = new XmlIvrStatus();
			status.setResponseCode( HTTP_CODE_UNAUTH );
			status.setResponseDesc("authorize failed");
			response.setStatus(status);
			
		}
		
		return response;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/check")
	@ResponseBody
	public XmlIvrResponse handcheck(Model model) {
		logger.debug("Entering handcheck)() method...");
		
		logger.debug("Look->Model->" + model.toString());
		
		List<XmlIvrParam> paramList = new ArrayList<XmlIvrParam>();
		
		XmlIvrParam param = new XmlIvrParam();
		param.setName("system");
		param.setValue("iCallCenter");
		paramList.add(param);
		
		param = new XmlIvrParam();
		param.setName("config");
		param.setValue("enabled");
		paramList.add(param);
		
		param = new XmlIvrParam();
		param.setName("setting");
		param.setValue("enabled");
		paramList.add(param);
		
		param = new XmlIvrParam();
		param.setName("uptime");
		param.setValue((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
		paramList.add(param);
		
		XmlIvrResponse response = new XmlIvrResponse();
		
		XmlIvrParams params = new XmlIvrParams();
		params.setParam(paramList);
		response.setParams(params);
		
		XmlIvrStatus status = new XmlIvrStatus();
		status.setResponseCode( HTTP_CODE_OK  );
		status.setResponseDesc("Server still alive");
		response.setStatus(status);
		
		return response;
	}
	
	public static final String HTTP_CODE_OK = "200";
	public static final String HTTP_CODE_CREATED = "201";
	public static final String HTTP_CODE_ACCEPTED = "202";
	public static final String HTTP_CODE_BAD_REQUEST = "400";
	public static final String HTTP_CODE_UNAUTH = "401";
	public static final String HTTP_CODE_FORBIDDEN = "403";
	public static final String HTTP_CODE_NOT_FOUND = "404";
	public static final String HTTP_CODE_CONFLICT= "409";
	public static final String HTTP_CODE_INTERNAL_ERROR = "500";
	
}
