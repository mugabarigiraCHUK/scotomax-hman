package com.itap.callcenter.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itap.callcenter.dao.apc.agent.AgentProfileDao;

/**
 * 
 * @author seven
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService, Serializable {

	private static final long serialVersionUID = 5409068896328123303L;
	
	final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	private HashMap<String, User> users = new HashMap<String, User>();
	
	// AgentProfile DAO
	@Autowired
	AgentProfileDao agentProfileDao;
	
	@PostConstruct
	public void init() {
		logger.debug("Create sample role");
		//Create sample role
		List<GrantedAuthority> grantedAuthoritiesForSystem = new ArrayList<GrantedAuthority>();
		grantedAuthoritiesForSystem.add(new GrantedAuthorityImpl("ROLE_SYSTEM"));
		
		List<GrantedAuthority> grantedAuthoritiesForAdministrator = new ArrayList<GrantedAuthority>();
		grantedAuthoritiesForAdministrator.add(new GrantedAuthorityImpl("ROLE_ADMINISTRATOR"));
		
		List<GrantedAuthority> grantedAuthoritiesForUser = new ArrayList<GrantedAuthority>();
		grantedAuthoritiesForUser.add(new GrantedAuthorityImpl("ROLE_USER"));
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		logger.debug("Create sample user with role");
		//Create sample user with role
		User systemUser = new User("system", "systempw", enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuthoritiesForSystem);
		
		User adminUser = new User("admin", "adminpw", enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuthoritiesForAdministrator);
		
		User userUser = new User("user", "userpw", enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuthoritiesForUser);
		
		users.put("system", systemUser);
		users.put("admin", adminUser);
		users.put("user", userUser);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		User user = users.get(username);
		if (user == null) {
			throw new UsernameNotFoundException("User account for username '"+username+"' not found.");
		}
		
		return user;
	}

}
