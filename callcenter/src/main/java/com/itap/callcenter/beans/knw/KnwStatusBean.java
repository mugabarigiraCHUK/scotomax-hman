package com.itap.callcenter.beans.knw;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class KnwStatusBean implements Serializable {

	private static final long serialVersionUID = 5829671417114575496L;
	
	protected Integer statusId;
	protected String statusName;
	protected String statusDescription;
	protected Date statusUpdateDate;
    
	protected Integer selectedStatusId;
}
