/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.agent;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.itap.callcenter.entity.DomainObject;
import com.itap.callcenter.entity.apc.wkf.WkfWorkplan;

/**
 * 
 * @author scotomax
 */
@Entity
@Table(name = "agent_profile")
@XmlRootElement
public class AgentProfile implements Serializable, DomainObject {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "agent_id", length = 11, nullable = false)
	@NotNull
	private Integer agentId;

	@Column(name = "supervisor_id", length = 11, nullable = false)
	@NotNull
	private int supervisorId;

	@ManyToOne
	@JoinColumn(name="level_id", nullable = false)
	@NotNull
	private AgentLevel agentLevel;

	@ManyToOne
	@JoinColumn(name="skill_id", nullable = false)
	@NotNull
	private AgentSkill agentSkill;

	@ManyToOne
	@JoinColumn(name="workplan_id", nullable = false)
	@NotNull
	private WkfWorkplan workplan;

	@ManyToOne
	@JoinColumn(name = "status_id",  nullable = false)
    @NotNull
    private AgentStatus agentStatus;

	@Column(name = "agent_fullname", length = 100, nullable = false)
	@NotNull
	private String agentFullname;

	@Column(name = "agent_username", length = 50, nullable = false)
	@NotNull
	private String agentUsername;

	@Column(name = "agent_password", length = 50, nullable = false)
	@NotNull
	private String agentPassword;

	@Column(name = "agent_max_call", length = 11, nullable = false)
	@NotNull
	private int agentMaxCall;

	@Column(name = "agent_allow_outbound", length = 11, nullable = false)
	@NotNull
	private int agentAllowOutbound;

	@Column(name = "agent_create_date", length = 11, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date agentCreateDate;

	@Column(name = "agent_update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date agentUpdateDate;

	public AgentProfile() {
	}

	public AgentProfile(Integer agentId) {
		this.agentId = agentId;
	}

	public AgentProfile(Integer agentId, int supervisorId, AgentLevel agentLevel,
			AgentSkill agentSkill, AgentStatus agentStatus, WkfWorkplan workplan, String agentFullname,
			String agentUsername, int agentMaxCall, int agentAllowOutbound,
			Date agentCreateDate, Date agentUpdateDate) {
		this.agentId = agentId;
		this.supervisorId = supervisorId;
		this.agentLevel = agentLevel;
		this.agentSkill = agentSkill;
		this.agentStatus = agentStatus;
		this.workplan = workplan;
		this.agentFullname = agentFullname;
		this.agentUsername = agentUsername;
		this.agentMaxCall = agentMaxCall;
		this.agentAllowOutbound = agentAllowOutbound;
		this.agentCreateDate = agentCreateDate;
		this.agentUpdateDate = agentUpdateDate;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
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

	public WkfWorkplan getWorkplan() {
		return workplan;
	}

	public void setWorkplan(WkfWorkplan workplan) {
		this.workplan = workplan;
	}
	
	public AgentStatus getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(AgentStatus agentStatus) {
		this.agentStatus = agentStatus;
	}

	public String getAgentFullname() {
		return agentFullname;
	}

	public void setAgentFullname(String agentFullname) {
		this.agentFullname = agentFullname;
	}

	public String getAgentUsername() {
		return agentUsername;
	}

	public void setAgentUsername(String agentUsername) {
		this.agentUsername = agentUsername;
	}

	public String getAgentPassword() {
		return agentPassword;
	}

	public void setAgentPassword(String agentPassword) {
		this.agentPassword = agentPassword;
	}

	public int getAgentMaxCall() {
		return agentMaxCall;
	}

	public void setAgentMaxCall(int agentMaxCall) {
		this.agentMaxCall = agentMaxCall;
	}

	public int getAgentAllowOutbound() {
		return agentAllowOutbound;
	}

	public void setAgentAllowOutbound(int agentAllowOutbound) {
		this.agentAllowOutbound = agentAllowOutbound;
	}

	public Date getAgentCreateDate() {
		return agentCreateDate;
	}

	public void setAgentCreateDate(Date agentCreateDate) {
		this.agentCreateDate = agentCreateDate;
	}

	public Date getAgentUpdateDate() {
		return agentUpdateDate;
	}

	public void setAgentUpdateDate(Date agentUpdateDate) {
		this.agentUpdateDate = agentUpdateDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("agentId", agentId)
				.append("agentFullname", agentFullname)
				.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (o.getClass() != getClass()) {
			return false;
		}
		AgentProfile other = (AgentProfile) o;
		return new EqualsBuilder().append(agentId, other.agentId).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.agentId).toHashCode();
	}

}
