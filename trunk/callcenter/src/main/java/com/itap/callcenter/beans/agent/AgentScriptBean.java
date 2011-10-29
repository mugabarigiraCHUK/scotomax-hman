package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.itap.callcenter.entity.apc.agent.AgentScript;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;
import com.itap.callcenter.entity.apc.knw.KnwTopic;

/**
 * 
 * @author scotomax
 *
 */
public abstract class AgentScriptBean implements Serializable {

	private static final long serialVersionUID = 5136838054612071136L;

	protected Integer scriptId;
    
	protected String scriptName;
	protected String scriptDescription;
	protected Integer scriptStep;
	protected String scriptMessage;
	protected Date scriptCreateDate;
	protected Date scriptUpdateDate;
    
	protected CrmBusiness business;
	protected KnwTopic topic;
	
	protected Integer selectedScriptId;

	protected List<AgentScript> agentScripts;

	public Integer getScriptId() {
		return scriptId;
	}

	public void setScriptId(Integer scriptId) {
		this.scriptId = scriptId;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getScriptDescription() {
		return scriptDescription;
	}

	public void setScriptDescription(String scriptDescription) {
		this.scriptDescription = scriptDescription;
	}

	public Integer getScriptStep() {
		return scriptStep;
	}

	public void setScriptStep(Integer scriptStep) {
		this.scriptStep = scriptStep;
	}

	public String getScriptMessage() {
		return scriptMessage;
	}

	public void setScriptMessage(String scriptMessage) {
		this.scriptMessage = scriptMessage;
	}

	public Date getScriptCreateDate() {
		return scriptCreateDate;
	}

	public void setScriptCreateDate(Date scriptCreateDate) {
		this.scriptCreateDate = scriptCreateDate;
	}

	public Date getScriptUpdateDate() {
		return scriptUpdateDate;
	}

	public void setScriptUpdateDate(Date scriptUpdateDate) {
		this.scriptUpdateDate = scriptUpdateDate;
	}

	public CrmBusiness getBusiness() {
		return business;
	}

	public void setBusiness(CrmBusiness business) {
		this.business = business;
	}

	public KnwTopic getTopic() {
		return topic;
	}

	public void setTopic(KnwTopic topic) {
		this.topic = topic;
	}

	public Integer getSelectedScriptId() {
		return selectedScriptId;
	}

	public void setSelectedScriptId(Integer selectedScriptId) {
		this.selectedScriptId = selectedScriptId;
	}

	public List<AgentScript> getAgentScripts() {
		return agentScripts;
	}

	public void setAgentScripts(List<AgentScript> agentScripts) {
		this.agentScripts = agentScripts;
	}
	
	
}
