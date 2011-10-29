package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.itap.callcenter.entity.apc.ivr.IvrCallflow;
import com.itap.callcenter.entity.apc.ivr.IvrDtmf;
import com.itap.callcenter.entity.apc.ivr.IvrVoiceprompt;
import com.itap.callcenter.entity.apc.job.JobTrigger;

/**
 * 
 * @author phamon
 *
 */
public abstract class IvrCallflowBean implements Serializable {
	
	private static final long serialVersionUID = -3200980816857969477L;
	
	protected Integer callflowId;
	protected String callflowName;
	protected String callflowDescription;
	protected Integer callflowStep;
	protected Integer callflowTimeout;
	protected Boolean callflowVoiceRepeatEnable;
	protected Date callflowCreateDate;
	protected Date callflowUpdateDate;
	
	protected Integer parentCallflowId;
	protected String parentCallflowName; 
	
	protected IvrVoiceprompt ivrVoiceprompt;
	protected IvrCallflow callflowBack;
	protected JobTrigger correctJobTrigger;
	protected JobTrigger inCorrectJobTrigger;
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
		correctJobTrigger = null;
		inCorrectJobTrigger = null;
	}

	public Integer getCallflowId() {
		return callflowId;
	}

	public void setCallflowId(Integer callflowId) {
		this.callflowId = callflowId;
	}

	public String getCallflowName() {
		return callflowName;
	}

	public void setCallflowName(String callflowName) {
		this.callflowName = callflowName;
	}

	public String getCallflowDescription() {
		return callflowDescription;
	}

	public void setCallflowDescription(String callflowDescription) {
		this.callflowDescription = callflowDescription;
	}

	public Integer getCallflowStep() {
		return callflowStep;
	}

	public void setCallflowStep(Integer callflowStep) {
		this.callflowStep = callflowStep;
	}

	public Integer getCallflowTimeout() {
		return callflowTimeout;
	}

	public void setCallflowTimeout(Integer callflowTimeout) {
		this.callflowTimeout = callflowTimeout;
	}

	public Boolean getCallflowVoiceRepeatEnable() {
		return callflowVoiceRepeatEnable;
	}

	public void setCallflowVoiceRepeatEnable(Boolean callflowVoiceRepeatEnable) {
		this.callflowVoiceRepeatEnable = callflowVoiceRepeatEnable;
	}

	public Date getCallflowCreateDate() {
		return callflowCreateDate;
	}

	public void setCallflowCreateDate(Date callflowCreateDate) {
		this.callflowCreateDate = callflowCreateDate;
	}

	public Date getCallflowUpdateDate() {
		return callflowUpdateDate;
	}

	public void setCallflowUpdateDate(Date callflowUpdateDate) {
		this.callflowUpdateDate = callflowUpdateDate;
	}

	public Integer getParentCallflowId() {
		return parentCallflowId;
	}

	public void setParentCallflowId(Integer parentCallflowId) {
		this.parentCallflowId = parentCallflowId;
	}

	public String getParentCallflowName() {
		return parentCallflowName;
	}

	public void setParentCallflowName(String parentCallflowName) {
		this.parentCallflowName = parentCallflowName;
	}

	public IvrVoiceprompt getIvrVoiceprompt() {
		return ivrVoiceprompt;
	}

	public void setIvrVoiceprompt(IvrVoiceprompt ivrVoiceprompt) {
		this.ivrVoiceprompt = ivrVoiceprompt;
	}

	public IvrCallflow getCallflowBack() {
		return callflowBack;
	}

	public void setCallflowBack(IvrCallflow callflowBack) {
		this.callflowBack = callflowBack;
	}

	public JobTrigger getCorrectJobTrigger() {
		return correctJobTrigger;
	}

	public void setCorrectJobTrigger(JobTrigger correctJobTrigger) {
		this.correctJobTrigger = correctJobTrigger;
	}

	public JobTrigger getInCorrectJobTrigger() {
		return inCorrectJobTrigger;
	}

	public void setInCorrectJobTrigger(JobTrigger inCorrectJobTrigger) {
		this.inCorrectJobTrigger = inCorrectJobTrigger;
	}

	public List<IvrDtmf> getListIvrDtmf() {
		return listIvrDtmf;
	}

	public void setListIvrDtmf(List<IvrDtmf> listIvrDtmf) {
		this.listIvrDtmf = listIvrDtmf;
	}
	
	
	
}
