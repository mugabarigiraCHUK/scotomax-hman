package com.itap.callcenter.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

	//From Spring Security
	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Override
	public boolean login(String username, String password) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			if (authentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				return true;
			}
		} catch (AuthenticationException e) {
			logger.error(e.getMessage());
		}
		
		return false;
	}

	@Override
	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}

}
