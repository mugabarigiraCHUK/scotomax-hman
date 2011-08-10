package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.itap.callcenter.entity.apc.agent.AgentProfile;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class AgentProfileBean implements Serializable {

	private static final long serialVersionUID = -4110467305550564449L;

	protected Integer agentId;
	
	protected Integer supervisorId;
	protected Integer levelId;
	protected Integer skillId;
	protected Integer statusId;
	protected Integer workplanId;
    
	protected String agentFullname;
	protected String agentUsername;
	protected String agentPassword;
	protected String confirmPassword;
	protected Integer agentMaxCall;
	protected Integer agentAllowOutbound;
	protected Date agentCreateDate;
	protected Date agentUpdateDate;
    
    protected Integer selectedAgentId;
    
    protected List<AgentProfile> agentProfileList;
}
