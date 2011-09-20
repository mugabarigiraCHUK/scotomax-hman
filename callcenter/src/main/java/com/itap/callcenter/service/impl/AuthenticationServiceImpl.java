package com.itap.callcenter.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.itap.callcenter.dao.apc.agent.AgentProfileDao;
import com.itap.callcenter.entity.apc.agent.AgentProfile;
import com.itap.callcenter.service.AuthenticationService;

/**
 * 
 * @author seven
 *
 */
@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {
	
	private static final long serialVersionUID = -6751241572564089715L;

	final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	// AgentProfile DAO
	@Autowired
	AgentProfileDao agentProfileDao;
	
	//From Spring Security
	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Override
	public AgentProfile login(String username, String password) {
		try {
			AgentProfile entry = agentProfileDao.findBy(username, password);
			
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			if (authentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			
			return entry;
		} catch (AuthenticationException e) {
			logger.error("Authentication failed, " + e.getMessage(), e);
			return null;
		} catch (Exception ex) {
			logger.error("Failed to proceed authentication, " + ex.getMessage(), ex);
			return null;
		}
	}

	@Override
	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}

}
