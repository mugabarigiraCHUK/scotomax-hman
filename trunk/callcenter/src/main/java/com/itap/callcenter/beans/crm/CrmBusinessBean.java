package com.itap.callcenter.beans.crm;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 *
 */
public abstract class CrmBusinessBean implements Serializable {

	private static final long serialVersionUID = -8606450889643841104L;

	protected Integer businessId;
	protected String businessName;
	protected String businessDescription;
	protected Date businessUpdateDate;
	
	protected Integer selectedBusinessId;

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessDescription() {
		return businessDescription;
	}

	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

	public Date getBusinessUpdateDate() {
		return businessUpdateDate;
	}

	public void setBusinessUpdateDate(Date businessUpdateDate) {
		this.businessUpdateDate = businessUpdateDate;
	}

	public Integer getSelectedBusinessId() {
		return selectedBusinessId;
	}

	public void setSelectedBusinessId(Integer selectedBusinessId) {
		this.selectedBusinessId = selectedBusinessId;
	}
	
	
}
