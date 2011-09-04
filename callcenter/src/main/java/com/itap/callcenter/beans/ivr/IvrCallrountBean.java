package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author phamon
 *
 */
public @Data abstract class IvrCallrountBean implements Serializable {
	
	protected Integer callrouteId;
	protected String callrouteName;
	protected String callrouteDescription;
	protected String callrouteCaller;
	protected String callrouteCalled;
	protected Date callrouteCreateDate;
	protected Date callrouteUpdateDate;

	
	
}
