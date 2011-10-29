package com.itap.callcenter.beans.acd;

import java.io.Serializable;
import java.util.Date;

import com.itap.callcenter.entity.apc.acd.AcdCondition;

/**
 * 
 * @author scotomax
 *
 */
public abstract class AcdRouteBean implements Serializable {

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

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRouteDescription() {
		return routeDescription;
	}

	public void setRouteDescription(String routeDescription) {
		this.routeDescription = routeDescription;
	}

	public String getRouteCaller() {
		return routeCaller;
	}

	public void setRouteCaller(String routeCaller) {
		this.routeCaller = routeCaller;
	}

	public String getRouteCalled() {
		return routeCalled;
	}

	public void setRouteCalled(String routeCalled) {
		this.routeCalled = routeCalled;
	}

	public Date getRouteCreateDate() {
		return routeCreateDate;
	}

	public void setRouteCreateDate(Date routeCreateDate) {
		this.routeCreateDate = routeCreateDate;
	}

	public Date getRouteUpdateDate() {
		return routeUpdateDate;
	}

	public void setRouteUpdateDate(Date routeUpdateDate) {
		this.routeUpdateDate = routeUpdateDate;
	}

	public AcdCondition getRouteCondition() {
		return routeCondition;
	}

	public void setRouteCondition(AcdCondition routeCondition) {
		this.routeCondition = routeCondition;
	}

	public Integer getSelectedRouteId() {
		return selectedRouteId;
	}

	public void setSelectedRouteId(Integer selectedRouteId) {
		this.selectedRouteId = selectedRouteId;
	}
	
	
}
