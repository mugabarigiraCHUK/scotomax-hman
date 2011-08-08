package com.itap.callcenter.beans.acd;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class AcdConditionBean implements Serializable {

	private static final long serialVersionUID = -222032276093804538L;
	
	protected Integer conditionId;
	protected String conditionName;
	protected String conditionDescription;
	protected Date conditionUpdateDate;
	
	protected Integer selectedConditionId;
}
