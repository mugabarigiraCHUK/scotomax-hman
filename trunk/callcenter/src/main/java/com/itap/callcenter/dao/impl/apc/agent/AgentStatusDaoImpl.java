package com.itap.callcenter.dao.impl.apc.agent;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.agent.AgentStatusDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.agent.AgentStatus;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AgentStatusDaoImpl extends GenericDaoImpl<AgentStatus, Integer> implements AgentStatusDao {

	public AgentStatusDaoImpl() {
		super(AgentStatus.class);
	}

}
