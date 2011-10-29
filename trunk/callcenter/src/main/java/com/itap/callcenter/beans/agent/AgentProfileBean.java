package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public abstract class AgentProfileBean implements Serializable {

	private static final long serialVersionUID = -4110467305550564449L;

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
    
    protected Integer selectedAgentId;
    
    protected List<AgentProfile> agentProfileList;

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public AgentProfile getAgentProfile() {
		return agentProfile;
	}

	public void setAgentProfile(AgentProfile agentProfile) {
		this.agentProfile = agentProfile;
	}

	public AgentLevel getAgentLevel() {
		return agentLevel;
	}

	public void setAgentLevel(AgentLevel agentLevel) {
		this.agentLevel = agentLevel;
	}

	public AgentSkill getAgentSkill() {
		return agentSkill;
	}

	public void setAgentSkill(AgentSkill agentSkill) {
		this.agentSkill = agentSkill;
	}

	public AgentStatus getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(AgentStatus agentStatus) {
		this.agentStatus = agentStatus;
	}

	public WkfWorkplan getWkfWorkplan() {
		return wkfWorkplan;
	}

	public void setWkfWorkplan(WkfWorkplan wkfWorkplan) {
		this.wkfWorkplan = wkfWorkplan;
	}

	public String getAgentFullname() {
		return agentFullname;
	}

	public void setAgentFullname(String agentFullname) {
		this.agentFullname = agentFullname;
	}

	public String getAgentUsername() {
		return agentUsername;
	}

	public void setAgentUsername(String agentUsername) {
		this.agentUsername = agentUsername;
	}

	public String getAgentPassword() {
		return agentPassword;
	}

	public void setAgentPassword(String agentPassword) {
		this.agentPassword = agentPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Integer getAgentMaxCall() {
		return agentMaxCall;
	}

	public void setAgentMaxCall(Integer agentMaxCall) {
		this.agentMaxCall = agentMaxCall;
	}

	public Integer getAgentAllowOutbound() {
		return agentAllowOutbound;
	}

	public void setAgentAllowOutbound(Integer agentAllowOutbound) {
		this.agentAllowOutbound = agentAllowOutbound;
	}

	public Date getAgentCreateDate() {
		return agentCreateDate;
	}

	public void setAgentCreateDate(Date agentCreateDate) {
		this.agentCreateDate = agentCreateDate;
	}

	public Date getAgentUpdateDate() {
		return agentUpdateDate;
	}

	public void setAgentUpdateDate(Date agentUpdateDate) {
		this.agentUpdateDate = agentUpdateDate;
	}

	public Integer getSelectedAgentId() {
		return selectedAgentId;
	}

	public void setSelectedAgentId(Integer selectedAgentId) {
		this.selectedAgentId = selectedAgentId;
	}

	public List<AgentProfile> getAgentProfileList() {
		return agentProfileList;
	}

	public void setAgentProfileList(List<AgentProfile> agentProfileList) {
		this.agentProfileList = agentProfileList;
	}
    
    
}
