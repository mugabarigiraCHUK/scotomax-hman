package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

import com.itap.callcenter.entity.apc.agent.AgentLevel;
import com.itap.callcenter.entity.apc.agent.AgentSkill;
import com.itap.callcenter.entity.apc.agent.AgentStatus;

/**
 * 
 * @author scotomax
 *
 */
public abstract class AgentSeatBean implements Serializable {

	private static final long serialVersionUID = -8661841351476478658L;

	protected Integer seatId;
    
	protected AgentLevel agentLevel;
	protected AgentSkill agentSkill;
	protected AgentStatus agentStatus;
    
	protected String seatName;
	protected String seatDescription;
	protected Date seatStartPeriod;
	protected Date seatEndPeriod;
	protected Integer seatMaxCall;
	protected Integer seatAllowOutbound;
	protected Date seatCreateDate;
	protected Date seatUpdateDate;
	
	protected Integer selectedSeatId;
	
	protected final int numberOfColumn = 6;
	protected int numberOfRow = 0;
	
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public AgentLevel getAgentLevel() {
		return agentLevel;
	}
	public void setAgentLevel(AgentLevel agentLevel) {
		this.agentLevel = agentLevel;
	}
	public AgentSkill getAgentSkill() {
		return agentSkill;
	}
	public void setAgentSkill(AgentSkill agentSkill) {
		this.agentSkill = agentSkill;
	}
	public AgentStatus getAgentStatus() {
		return agentStatus;
	}
	public void setAgentStatus(AgentStatus agentStatus) {
		this.agentStatus = agentStatus;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public String getSeatDescription() {
		return seatDescription;
	}
	public void setSeatDescription(String seatDescription) {
		this.seatDescription = seatDescription;
	}
	public Date getSeatStartPeriod() {
		return seatStartPeriod;
	}
	public void setSeatStartPeriod(Date seatStartPeriod) {
		this.seatStartPeriod = seatStartPeriod;
	}
	public Date getSeatEndPeriod() {
		return seatEndPeriod;
	}
	public void setSeatEndPeriod(Date seatEndPeriod) {
		this.seatEndPeriod = seatEndPeriod;
	}
	public Integer getSeatMaxCall() {
		return seatMaxCall;
	}
	public void setSeatMaxCall(Integer seatMaxCall) {
		this.seatMaxCall = seatMaxCall;
	}
	public Integer getSeatAllowOutbound() {
		return seatAllowOutbound;
	}
	public void setSeatAllowOutbound(Integer seatAllowOutbound) {
		this.seatAllowOutbound = seatAllowOutbound;
	}
	public Date getSeatCreateDate() {
		return seatCreateDate;
	}
	public void setSeatCreateDate(Date seatCreateDate) {
		this.seatCreateDate = seatCreateDate;
	}
	public Date getSeatUpdateDate() {
		return seatUpdateDate;
	}
	public void setSeatUpdateDate(Date seatUpdateDate) {
		this.seatUpdateDate = seatUpdateDate;
	}
	public Integer getSelectedSeatId() {
		return selectedSeatId;
	}
	public void setSelectedSeatId(Integer selectedSeatId) {
		this.selectedSeatId = selectedSeatId;
	}
	public int getNumberOfRow() {
		return numberOfRow;
	}
	public void setNumberOfRow(int numberOfRow) {
		this.numberOfRow = numberOfRow;
	}
	public int getNumberOfColumn() {
		return numberOfColumn;
	}
	
	
}
