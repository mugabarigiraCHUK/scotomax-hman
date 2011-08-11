package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class AgentTriggerBean implements Serializable {

	private static final long serialVersionUID = 1688549733868066060L;

	protected Integer triggerId;
	protected String triggerName;
	protected String triggerDescription;
	protected String triggerCommand;
	protected Date triggerCreateDate;
	protected Date triggerUpdateDate;
    
    protected Integer selectedTriggerId;
}
