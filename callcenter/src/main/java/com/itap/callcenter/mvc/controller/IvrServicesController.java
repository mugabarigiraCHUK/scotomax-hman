package com.itap.callcenter.mvc.controller;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.itap.callcenter.mvc.beans.IvrParamBean;
import com.itap.callcenter.mvc.beans.IvrResponseBean;

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
	public IvrResponseBean exception(Exception ex, HttpServletRequest req, HttpServletResponse resp) {
		
		logger.debug("Look->Exception->Message->" + ex.getMessage());
		logger.debug("Look->HttpServletRequest->" + req);
		logger.debug("Look->HttpServletResponse->" + resp);
		
		IvrResponseBean response = new IvrResponseBean();
		response.setResponseCode( HTTP_CODE_INTERNAL_ERROR );
		response.setResponseDesc("System error, please contact admin.");
		
		return response;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/auth/{username}/{passwd}")
	@ResponseBody
	public IvrResponseBean  authenticate(@PathVariable("username") String username, 
																						@PathVariable("passwd") String passwd, 
																						Model model) {
		
		logger.debug("Look->PathVariable->username->" + username );
		logger.debug("Look->PathVariable->passwd->" + passwd );
		
		logger.debug("Look->Model->" + model.toString());
		
		IvrResponseBean response = new IvrResponseBean();
		
		if ( "admin".equals(username) && "adminadmin".equals(passwd) ) {
			List<IvrParamBean> params = new ArrayList<IvrParamBean>();
			IvrParamBean param = new IvrParamBean();
			param.setName("token");
			param.setValue("@#$@!@#$#%#$@!@#");
			params.add(param);
			response.setParams(params);
			response.setResponseCode( HTTP_CODE_OK );
			response.setResponseDesc("authorize passed");
		} else {
			response.setResponseCode( HTTP_CODE_UNAUTH );
			response.setResponseDesc("authorize failed");
		}
		
		return response;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/check")
	@ResponseBody
	public IvrResponseBean handcheck(Model model) {
		logger.debug("Entering handcheck)() method...");
		
		logger.debug("Look->Model->" + model.toString());
		
		IvrResponseBean response = new IvrResponseBean();
		response.setResponseCode( HTTP_CODE_OK );
		response.setResponseDesc("Server still alive");
		
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
