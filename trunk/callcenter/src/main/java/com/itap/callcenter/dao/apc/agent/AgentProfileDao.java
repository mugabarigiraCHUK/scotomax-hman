package com.itap.callcenter.dao.apc.agent;

import com.itap.callcenter.dao.GenericDao;
import com.itap.callcenter.entity.apc.agent.AgentProfile;

/**
 * 
 * @author scotomax
 *
 */
public interface AgentProfileDao extends GenericDao<AgentProfile, Integer> {

	AgentProfile findBy(String username, String password);
	
}
