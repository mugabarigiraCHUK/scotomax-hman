package com.itap.callcenter.beans.acd;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 *
 */
public abstract class AcdConditionBean implements Serializable {

	private static final long serialVersionUID = -222032276093804538L;
	
	protected Integer conditionId;
	protected String conditionName;
	protected String conditionDescription;
	protected Date conditionUpdateDate;
	
	protected Integer selectedConditionId;

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public String getConditionDescription() {
		return conditionDescription;
	}

	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}

	public Date getConditionUpdateDate() {
		return conditionUpdateDate;
	}

	public void setConditionUpdateDate(Date conditionUpdateDate) {
		this.conditionUpdateDate = conditionUpdateDate;
	}

	public Integer getSelectedConditionId() {
		return selectedConditionId;
	}

	public void setSelectedConditionId(Integer selectedConditionId) {
		this.selectedConditionId = selectedConditionId;
	}
	
	
}
