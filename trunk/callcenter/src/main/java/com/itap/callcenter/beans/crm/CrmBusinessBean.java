package com.itap.callcenter.beans.crm;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class CrmBusinessBean implements Serializable {

	private static final long serialVersionUID = -8606450889643841104L;

	protected Integer businessId;
	protected String businessName;
	protected String businessDescription;
	protected Date businessUpdateDate;
	
	protected Integer selectedBusinessId;
}
