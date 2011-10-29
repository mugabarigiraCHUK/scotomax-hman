package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

import com.itap.callcenter.entity.apc.ivr.IvrChannel;

public abstract class IvrScheduleBean implements Serializable {

	private static final long serialVersionUID = 7229814913390878565L;
	
	protected Integer scheduleId;
    protected String scheduleName;
    protected String scheduleDescription;
    protected String scheduleCaller;
    protected String scheduleCalled;
    protected Date scheduleStartDate;
    protected Integer scheduleRetryTime;
    protected Date scheduleCreateDate;
    protected Date scheduleUpdateDate;
    protected IvrChannel scheduleChannel;
    
    protected Integer selectedScheduleId;
    
    protected void reset() {
    	scheduleId = null;
    	scheduleName = null;
    	scheduleDescription = null;
    	scheduleCaller = null;
    	scheduleCalled = null;
    	scheduleStartDate = null;
    	scheduleRetryTime = null;
    	scheduleCreateDate = null;
    	scheduleUpdateDate = null;
    	selectedScheduleId = null;
    }

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public String getScheduleDescription() {
		return scheduleDescription;
	}

	public void setScheduleDescription(String scheduleDescription) {
		this.scheduleDescription = scheduleDescription;
	}

	public String getScheduleCaller() {
		return scheduleCaller;
	}

	public void setScheduleCaller(String scheduleCaller) {
		this.scheduleCaller = scheduleCaller;
	}

	public String getScheduleCalled() {
		return scheduleCalled;
	}

	public void setScheduleCalled(String scheduleCalled) {
		this.scheduleCalled = scheduleCalled;
	}

	public Date getScheduleStartDate() {
		return scheduleStartDate;
	}

	public void setScheduleStartDate(Date scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}

	public Integer getScheduleRetryTime() {
		return scheduleRetryTime;
	}

	public void setScheduleRetryTime(Integer scheduleRetryTime) {
		this.scheduleRetryTime = scheduleRetryTime;
	}

	public Date getScheduleCreateDate() {
		return scheduleCreateDate;
	}

	public void setScheduleCreateDate(Date scheduleCreateDate) {
		this.scheduleCreateDate = scheduleCreateDate;
	}

	public Date getScheduleUpdateDate() {
		return scheduleUpdateDate;
	}

	public void setScheduleUpdateDate(Date scheduleUpdateDate) {
		this.scheduleUpdateDate = scheduleUpdateDate;
	}

	public IvrChannel getScheduleChannel() {
		return scheduleChannel;
	}

	public void setScheduleChannel(IvrChannel scheduleChannel) {
		this.scheduleChannel = scheduleChannel;
	}

	public Integer getSelectedScheduleId() {
		return selectedScheduleId;
	}

	public void setSelectedScheduleId(Integer selectedScheduleId) {
		this.selectedScheduleId = selectedScheduleId;
	}
    
    
}
