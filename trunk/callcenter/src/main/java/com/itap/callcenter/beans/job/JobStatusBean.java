package com.itap.callcenter.beans.job;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class JobStatusBean implements Serializable {

	private static final long serialVersionUID = -4195697958364355993L;
	
	protected Integer statusId;
	protected String statusName;
	protected String statusDescription;
	protected Date statusUpdateDate;
    
	protected Integer selectedStatusId;
    
}
