package com.itap.callcenter.beans.crm;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class CrmStatusBean implements Serializable {

	private static final long serialVersionUID = 8470814559025482929L;
	
	protected Integer statusId;
	protected String statusName;
	protected String statusDescription;
	protected Date statusUpdateDate;
    
	protected Integer selectedStatusId;
	
}
