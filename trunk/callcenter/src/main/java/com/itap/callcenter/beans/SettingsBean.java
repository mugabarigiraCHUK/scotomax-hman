package com.itap.callcenter.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import com.itap.callcenter.entity.apc.agent.AgentLevel;
import com.itap.callcenter.entity.apc.agent.AgentProfile;
import com.itap.callcenter.entity.apc.agent.AgentSkill;
import com.itap.callcenter.entity.apc.agent.AgentStatus;
import com.itap.callcenter.entity.apc.wkf.WkfWorkplan;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class SettingsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1181725128163077473L;

	protected Integer agentId;
	
	protected AgentProfile agentProfile;
	protected AgentLevel agentLevel;
	protected AgentSkill agentSkill;
	protected AgentStatus agentStatus;
	protected WkfWorkplan wkfWorkplan;
    
	protected String agentFullname;
	protected String agentUsername;
	protected String agentPassword;
	protected String confirmPassword;
	protected Integer agentMaxCall;
	protected Integer agentAllowOutbound;
	protected Date agentCreateDate;
	protected Date agentUpdateDate;
	
}
