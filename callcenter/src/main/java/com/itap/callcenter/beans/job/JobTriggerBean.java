package com.itap.callcenter.beans.job;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 *
 */
public abstract class JobTriggerBean implements Serializable {

	private static final long serialVersionUID = -1463492243608861929L;

	protected Integer triggerId;
	protected String triggerName;
	protected String triggerDescription;
	protected String triggerCommand;
	protected Date triggerCreateDate;
	protected Date triggerUpdateDate;
    
	protected Integer selectedTriggerId;

	public Integer getTriggerId() {
		return triggerId;
	}

	public void setTriggerId(Integer triggerId) {
		this.triggerId = triggerId;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerDescription() {
		return triggerDescription;
	}

	public void setTriggerDescription(String triggerDescription) {
		this.triggerDescription = triggerDescription;
	}

	public String getTriggerCommand() {
		return triggerCommand;
	}

	public void setTriggerCommand(String triggerCommand) {
		this.triggerCommand = triggerCommand;
	}

	public Date getTriggerCreateDate() {
		return triggerCreateDate;
	}

	public void setTriggerCreateDate(Date triggerCreateDate) {
		this.triggerCreateDate = triggerCreateDate;
	}

	public Date getTriggerUpdateDate() {
		return triggerUpdateDate;
	}

	public void setTriggerUpdateDate(Date triggerUpdateDate) {
		this.triggerUpdateDate = triggerUpdateDate;
	}

	public Integer getSelectedTriggerId() {
		return selectedTriggerId;
	}

	public void setSelectedTriggerId(Integer selectedTriggerId) {
		this.selectedTriggerId = selectedTriggerId;
	}
	
	
}
