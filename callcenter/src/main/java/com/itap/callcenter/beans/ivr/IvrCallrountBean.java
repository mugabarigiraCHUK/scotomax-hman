package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author phamon
 *
 */
public abstract class IvrCallrountBean implements Serializable {
	
	protected static final long serialVersionUID = -1288920131638566740L;
	
	protected Integer callrouteId;
	protected String callrouteName;
	protected String callrouteDescription;
	protected String callrouteCaller;
	protected String callrouteCalled;
	
	protected Date callrouteCreateDate;
	protected Date callrouteUpdateDate;
	
	protected Integer selectedCallrouteId;

	public Integer getCallrouteId() {
		return callrouteId;
	}

	public void setCallrouteId(Integer callrouteId) {
		this.callrouteId = callrouteId;
	}

	public String getCallrouteName() {
		return callrouteName;
	}

	public void setCallrouteName(String callrouteName) {
		this.callrouteName = callrouteName;
	}

	public String getCallrouteDescription() {
		return callrouteDescription;
	}

	public void setCallrouteDescription(String callrouteDescription) {
		this.callrouteDescription = callrouteDescription;
	}

	public String getCallrouteCaller() {
		return callrouteCaller;
	}

	public void setCallrouteCaller(String callrouteCaller) {
		this.callrouteCaller = callrouteCaller;
	}

	public String getCallrouteCalled() {
		return callrouteCalled;
	}

	public void setCallrouteCalled(String callrouteCalled) {
		this.callrouteCalled = callrouteCalled;
	}

	public Date getCallrouteCreateDate() {
		return callrouteCreateDate;
	}

	public void setCallrouteCreateDate(Date callrouteCreateDate) {
		this.callrouteCreateDate = callrouteCreateDate;
	}

	public Date getCallrouteUpdateDate() {
		return callrouteUpdateDate;
	}

	public void setCallrouteUpdateDate(Date callrouteUpdateDate) {
		this.callrouteUpdateDate = callrouteUpdateDate;
	}

	public Integer getSelectedCallrouteId() {
		return selectedCallrouteId;
	}

	public void setSelectedCallrouteId(Integer selectedCallrouteId) {
		this.selectedCallrouteId = selectedCallrouteId;
	}
	
	
}
