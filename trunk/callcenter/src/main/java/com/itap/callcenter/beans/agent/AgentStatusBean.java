package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 *
 */
public abstract class AgentStatusBean implements Serializable {

	private static final long serialVersionUID = 4070128160831185011L;

	protected Integer statusId;
	protected String statusName;
	protected String statusDescription;
	protected Date statusUpdateDate;
    
	protected Integer selectedStatusId;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Date getStatusUpdateDate() {
		return statusUpdateDate;
	}

	public void setStatusUpdateDate(Date statusUpdateDate) {
		this.statusUpdateDate = statusUpdateDate;
	}

	public Integer getSelectedStatusId() {
		return selectedStatusId;
	}

	public void setSelectedStatusId(Integer selectedStatusId) {
		this.selectedStatusId = selectedStatusId;
	}
	
	
}
