package com.itap.callcenter.service;

import javax.annotation.security.RolesAllowed;

/**
 * 
 * @author seven
 *
 */
public interface AuthenticationService {
	
	boolean login(String username, String password);

	@RolesAllowed({"ROLE_SYSTEM","ROLE_ADMINISTRATOR","ROLE_USER"})
	void logout();
	
}
