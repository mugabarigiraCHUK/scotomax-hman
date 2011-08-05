package com.itap.callcenter.dao.impl.apc.agent;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.agent.AgentSeatDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.agent.AgentSeat;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AgentSeatDaoImpl extends GenericDaoImpl<AgentSeat, Integer> implements AgentSeatDao {

	public AgentSeatDaoImpl() {
		super(AgentSeat.class);
	}

}
