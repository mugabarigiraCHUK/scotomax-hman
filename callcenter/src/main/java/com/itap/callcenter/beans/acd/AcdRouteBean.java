package com.itap.callcenter.beans.acd;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import com.itap.callcenter.entity.apc.acd.AcdCondition;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class AcdRouteBean implements Serializable {

	private static final long serialVersionUID = 7487463800031390635L;

	protected Integer routeId;
	protected String routeName;
	protected String routeDescription;
	protected String routeCaller;
	protected String routeCalled;
	protected Date routeCreateDate;
	protected Date routeUpdateDate;
	
	protected AcdCondition routeCondition;
	
	protected Integer selectedRouteId;
}
