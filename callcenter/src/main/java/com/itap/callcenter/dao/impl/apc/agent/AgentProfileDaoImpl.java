package com.itap.callcenter.dao.impl.apc.agent;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.agent.AgentProfileDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.agent.AgentProfile;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AgentProfileDaoImpl extends GenericDaoImpl<AgentProfile, Integer> implements AgentProfileDao {

	public AgentProfileDaoImpl() {
		super(AgentProfile.class);
	}

	@Override
	public AgentProfile findBy(String username, String password) {
		return (AgentProfile) em.createQuery("from AgentProfile ap where ap.agentUsername = :username and ap.agentPassword = :password")
																			.setParameter("username", username)
																			.setParameter("password", password)
																			.getSingleResult();
	}

}
