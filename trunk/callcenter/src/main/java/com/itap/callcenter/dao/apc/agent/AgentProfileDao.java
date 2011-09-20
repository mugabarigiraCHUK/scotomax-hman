package com.itap.callcenter.dao.apc.agent;

import java.util.List;

import com.itap.callcenter.dao.GenericDao;
import com.itap.callcenter.entity.apc.agent.AgentProfile;

/**
 * 
 * @author scotomax
 *
 */
public interface AgentProfileDao extends GenericDao<AgentProfile, Integer> {

	/**
	 * Find the AgentProfile entity class by user name and password
	 * 
	 * @param username
	 * @param password
	 * @return AgentProfile.class entity
	 */
	AgentProfile findBy(String username, String password);
	
	/**
	 * Search list of Agent profile entity data by Agent full name and user name.
	 * 
	 * @param fullname
	 * @param username
	 * @return List of AgentProfile.class entity
	 */
	List<AgentProfile> searchBy(String fullname, String username);
	
}
