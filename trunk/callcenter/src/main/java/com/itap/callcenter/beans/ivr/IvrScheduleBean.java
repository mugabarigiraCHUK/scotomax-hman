package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import com.itap.callcenter.entity.apc.ivr.IvrChannel;

public @Data abstract class IvrScheduleBean implements Serializable {

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
}
