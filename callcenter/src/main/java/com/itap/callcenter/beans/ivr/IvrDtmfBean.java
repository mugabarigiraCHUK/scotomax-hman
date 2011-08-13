package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @author phamon
 *
 */
public @Data abstract class IvrDtmfBean implements Serializable {
	
	
	protected Integer dtmfId;
	protected String dtmfName;
	protected String dtmfDescription;
	protected String dtmfDigit;
	protected Date dtmfCreateDate;
	protected Date dtmfUpdateDate;
//	private IvrCallflow dtmfCorrectCallflow;
//	private IvrCallflow dtmfErrorCallflow;

	protected Integer selectedDtmfId;
	
}
