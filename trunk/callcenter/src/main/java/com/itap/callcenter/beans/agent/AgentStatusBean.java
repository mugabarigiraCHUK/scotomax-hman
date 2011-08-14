package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class AgentStatusBean implements Serializable {

	private static final long serialVersionUID = 4070128160831185011L;

	protected Integer statusId;
	protected String statusName;
	protected String statusDescription;
	protected Date statusUpdateDate;
    
	protected Integer selectedStatusId;
}
