package com.itap.callcenter.dao.impl.apc.agent;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.agent.AgentScriptDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.agent.AgentScript;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AgentScriptDaoImpl extends GenericDaoImpl<AgentScript, Integer> implements AgentScriptDao {

	public AgentScriptDaoImpl() {
		super(AgentScript.class);
	}

}
