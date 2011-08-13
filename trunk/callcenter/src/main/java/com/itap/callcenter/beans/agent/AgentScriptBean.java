package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import com.itap.callcenter.entity.apc.agent.AgentScript;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;
import com.itap.callcenter.entity.apc.knw.KnwTopic;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class AgentScriptBean implements Serializable {

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
}
