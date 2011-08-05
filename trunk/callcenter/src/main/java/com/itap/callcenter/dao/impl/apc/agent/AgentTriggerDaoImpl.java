package com.itap.callcenter.dao.impl.apc.agent;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.agent.AgentTriggerDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.agent.AgentTrigger;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AgentTriggerDaoImpl extends GenericDaoImpl<AgentTrigger, Integer> implements AgentTriggerDao {

	public AgentTriggerDaoImpl() {
		super(AgentTrigger.class);
	}

}
