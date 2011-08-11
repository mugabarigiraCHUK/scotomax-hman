package com.itap.callcenter.beans.job;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class JobTriggerBean implements Serializable {

	private static final long serialVersionUID = -1463492243608861929L;

	protected Integer triggerId;
	protected String triggerName;
	protected String triggerDescription;
	protected String triggerCommand;
	protected Date triggerCreateDate;
	protected Date triggerUpdateDate;
    
	protected Integer selectedTriggerId;
}
