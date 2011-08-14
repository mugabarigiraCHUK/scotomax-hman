package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import com.itap.callcenter.entity.apc.agent.AgentLevel;
import com.itap.callcenter.entity.apc.agent.AgentSkill;
import com.itap.callcenter.entity.apc.agent.AgentStatus;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class AgentSeatBean implements Serializable {

	private static final long serialVersionUID = -8661841351476478658L;

	protected Integer seatId;
    
	protected AgentLevel agentLevel;
	protected AgentSkill agentSkill;
	protected AgentStatus agentStatus;
    
	protected String seatName;
	protected String seatDescription;
	protected Date seatStartPeriod;
	protected Date seatEndPeriod;
	protected Integer seatMaxCall;
	protected Integer seatAllowOutbound;
	protected Date seatCreateDate;
	protected Date seatUpdateDate;
	
	protected Integer selectedSeatId;
}
