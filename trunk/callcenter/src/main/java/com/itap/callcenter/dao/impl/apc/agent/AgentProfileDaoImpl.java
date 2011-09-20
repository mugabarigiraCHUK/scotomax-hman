package com.itap.callcenter.dao.impl.apc.agent;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	Logger logger  = LoggerFactory.getLogger(AgentProfileDaoImpl.class);

	public AgentProfileDaoImpl() {
		super(AgentProfile.class);
	}

	@Override
	@Transactional(readOnly=true)
	public AgentProfile findBy(String username, String password) {
		
		logger.debug("Look -> Username -> " + username);
		logger.debug("Look -> Password -> " + password);
		
		return (AgentProfile) em.createQuery("from AgentProfile ap where ap.agentUsername = :username and ap.agentPassword = :password")
																			.setParameter("username", username)
																			.setParameter("password", password)
																			.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<AgentProfile> searchBy(String fullname, String username) {
		
		logger.debug("Look -> Fullname -> " + fullname);
		logger.debug("Look -> Username -> " + username);
		
		return em.createQuery("from AgentProfile ap where ap.agentFullname like :fullname or ap.agentUsername like :username")
								.setParameter("fullname", "%"+fullname+"%")
								.setParameter("username", "%"+username+"%")
								.getResultList();
	}

}
