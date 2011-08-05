package com.itap.callcenter.dao.impl.apc.agent;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.agent.AgentSkillDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.agent.AgentSkill;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AgentSkillDaoImpl extends GenericDaoImpl<AgentSkill, Integer> implements AgentSkillDao {

	public AgentSkillDaoImpl() {
		super(AgentSkill.class);
	}

}
