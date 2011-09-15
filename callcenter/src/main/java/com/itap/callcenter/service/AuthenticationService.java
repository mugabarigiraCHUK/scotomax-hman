package com.itap.callcenter.service;

import javax.annotation.security.RolesAllowed;

import com.itap.callcenter.entity.apc.agent.AgentProfile;

/**
 * 
 * @author seven
 *
 */
public interface AuthenticationService {
	
	AgentProfile login(String username, String password);

	@RolesAllowed({"ROLE_SYSTEM","ROLE_ADMINISTRATOR","ROLE_USER"})
	void logout();
	
}
