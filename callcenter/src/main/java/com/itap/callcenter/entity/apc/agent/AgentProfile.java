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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.itap.callcenter.entity.DomainObject;

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
    
    @Column(name = "level_id", length = 11, nullable = false)
    @NotNull
    private int levelId;
    
    @Column(name = "skill_id", length = 11, nullable = false)
    @NotNull
    private int skillId;
    
    @Column(name = "status_id", length = 11, nullable = false)
    @NotNull
    private int statusId;
    
    @Column(name = "workplan_id", length = 11, nullable = false)
    @NotNull
    private int workplanId;
    
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

    public AgentProfile(Integer agentId, int supervisorId, int levelId, int skillId, int statusId, int workplanId, String agentFullname, String agentUsername, int agentMaxCall, int agentAllowOutbound, Date agentCreateDate, Date agentUpdateDate) {
        this.agentId = agentId;
        this.supervisorId = supervisorId;
        this.levelId = levelId;
        this.skillId = skillId;
        this.statusId = statusId;
        this.workplanId = workplanId;
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

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getWorkplanId() {
        return workplanId;
    }

    public void setWorkplanId(int workplanId) {
        this.workplanId = workplanId;
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
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        AgentProfile other = (AgentProfile) o;
        return new EqualsBuilder()
                 .append(agentId, other.agentId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.agentId)
         .toHashCode();
    }
    
}
