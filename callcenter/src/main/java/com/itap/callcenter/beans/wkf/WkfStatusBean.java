package com.itap.callcenter.beans.wkf;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class WkfStatusBean implements Serializable {

	private static final long serialVersionUID = -7033882484487939010L;
	
	protected Integer statusId;
	protected String statusName;
	protected String statusDescription;
	protected Date statusUpdateDate;
    
	protected Integer selectedStatusId;

}
