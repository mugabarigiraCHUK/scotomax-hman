package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author phamon
 *
 */
public abstract class IvrDtmfBean implements Serializable {
	
	private static final long serialVersionUID = 3508069831437583341L;
	
	protected Integer dtmfId;
	protected String dtmfName;
	protected String dtmfDescription;
	protected String dtmfDigit;
	protected Date dtmfCreateDate;
	protected Date dtmfUpdateDate;

	protected Integer selectedDtmfId;

	public Integer getDtmfId() {
		return dtmfId;
	}

	public void setDtmfId(Integer dtmfId) {
		this.dtmfId = dtmfId;
	}

	public String getDtmfName() {
		return dtmfName;
	}

	public void setDtmfName(String dtmfName) {
		this.dtmfName = dtmfName;
	}

	public String getDtmfDescription() {
		return dtmfDescription;
	}

	public void setDtmfDescription(String dtmfDescription) {
		this.dtmfDescription = dtmfDescription;
	}

	public String getDtmfDigit() {
		return dtmfDigit;
	}

	public void setDtmfDigit(String dtmfDigit) {
		this.dtmfDigit = dtmfDigit;
	}

	public Date getDtmfCreateDate() {
		return dtmfCreateDate;
	}

	public void setDtmfCreateDate(Date dtmfCreateDate) {
		this.dtmfCreateDate = dtmfCreateDate;
	}

	public Date getDtmfUpdateDate() {
		return dtmfUpdateDate;
	}

	public void setDtmfUpdateDate(Date dtmfUpdateDate) {
		this.dtmfUpdateDate = dtmfUpdateDate;
	}

	public Integer getSelectedDtmfId() {
		return selectedDtmfId;
	}

	public void setSelectedDtmfId(Integer selectedDtmfId) {
		this.selectedDtmfId = selectedDtmfId;
	}
	
	
}
