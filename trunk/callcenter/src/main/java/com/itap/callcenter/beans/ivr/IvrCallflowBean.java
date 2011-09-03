package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import com.itap.callcenter.entity.apc.ivr.IvrCallflow;
import com.itap.callcenter.entity.apc.ivr.IvrDtmf;
import com.itap.callcenter.entity.apc.ivr.IvrVoiceprompt;

/**
 * 
 * @author phamon
 *
 */
public @Data abstract class IvrCallflowBean implements Serializable {
	
	
	protected Integer callflowId;
	protected String callflowName;
	protected String callflowDescription;
	protected Integer callflowStep;
	protected Integer callflowTimeout;
	protected Integer callflowVoiceRepeatEnable;
	protected Date callflowCreateDate;
	protected Date callflowUpdateDate;
	
	protected Integer parentCallflowId;
	protected String parentCallflowName; 
	
	protected IvrVoiceprompt ivrVoiceprompt;
	protected IvrCallflow callflowBack;
	protected List<IvrDtmf> listIvrDtmf;
	
	
	protected void reset() {
		callflowId = null;
		callflowName = null;
		callflowDescription = null;
		callflowStep = null;
		callflowTimeout = null;
		callflowVoiceRepeatEnable = null;
		callflowCreateDate = null;
		callflowUpdateDate = null;
		parentCallflowId = null;
		parentCallflowName = null;
		ivrVoiceprompt = null;
		callflowBack = null;
		listIvrDtmf = null;
	}
	
}
