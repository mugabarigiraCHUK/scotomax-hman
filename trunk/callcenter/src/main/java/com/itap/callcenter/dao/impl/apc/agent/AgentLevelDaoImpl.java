package com.itap.callcenter.dao.impl.apc.agent;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.agent.AgentLevelDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.agent.AgentLevel;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AgentLevelDaoImpl extends GenericDaoImpl<AgentLevel, Integer> implements AgentLevelDao {

	public AgentLevelDaoImpl() {
		super(AgentLevel.class);
	}

}
