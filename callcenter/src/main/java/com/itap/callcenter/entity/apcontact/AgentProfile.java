/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apcontact;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author scotomax
 */
@Entity
@Table(name = "agent_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentProfile.findAll", query = "SELECT a FROM AgentProfile a"),
    @NamedQuery(name = "AgentProfile.findByAgentId", query = "SELECT a FROM AgentProfile a WHERE a.agentId = :agentId"),
    @NamedQuery(name = "AgentProfile.findBySupervisorId", query = "SELECT a FROM AgentProfile a WHERE a.supervisorId = :supervisorId"),
    @NamedQuery(name = "AgentProfile.findByLevelId", query = "SELECT a FROM AgentProfile a WHERE a.levelId = :levelId"),
    @NamedQuery(name = "AgentProfile.findBySkillId", query = "SELECT a FROM AgentProfile a WHERE a.skillId = :skillId"),
    @NamedQuery(name = "AgentProfile.findByStatusId", query = "SELECT a FROM AgentProfile a WHERE a.statusId = :statusId"),
    @NamedQuery(name = "AgentProfile.findByWorkplanId", query = "SELECT a FROM AgentProfile a WHERE a.workplanId = :workplanId"),
    @NamedQuery(name = "AgentProfile.findByAgentFullname", query = "SELECT a FROM AgentProfile a WHERE a.agentFullname = :agentFullname"),
    @NamedQuery(name = "AgentProfile.findByAgentUsername", query = "SELECT a FROM AgentProfile a WHERE a.agentUsername = :agentUsername"),
    @NamedQuery(name = "AgentProfile.findByAgentPassword", query = "SELECT a FROM AgentProfile a WHERE a.agentPassword = :agentPassword"),
    @NamedQuery(name = "AgentProfile.findByAgentMaxCall", query = "SELECT a FROM AgentProfile a WHERE a.agentMaxCall = :agentMaxCall"),
    @NamedQuery(name = "AgentProfile.findByAgentAllowOutbound", query = "SELECT a FROM AgentProfile a WHERE a.agentAllowOutbound = :agentAllowOutbound"),
    @NamedQuery(name = "AgentProfile.findByAgentCreateDate", query = "SELECT a FROM AgentProfile a WHERE a.agentCreateDate = :agentCreateDate"),
    @NamedQuery(name = "AgentProfile.findByAgentUpdateDate", query = "SELECT a FROM AgentProfile a WHERE a.agentUpdateDate = :agentUpdateDate")})
public class AgentProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "agent_id")
    private Integer agentId;
    @Basic(optional = false)
    @Column(name = "supervisor_id")
    private int supervisorId;
    @Basic(optional = false)
    @Column(name = "level_id")
    private int levelId;
    @Basic(optional = false)
    @Column(name = "skill_id")
    private int skillId;
    @Basic(optional = false)
    @Column(name = "status_id")
    private int statusId;
    @Basic(optional = false)
    @Column(name = "workplan_id")
    private int workplanId;
    @Basic(optional = false)
    @Column(name = "agent_fullname")
    private String agentFullname;
    @Basic(optional = false)
    @Column(name = "agent_username")
    private String agentUsername;
    @Column(name = "agent_password")
    private String agentPassword;
    @Basic(optional = false)
    @Column(name = "agent_max_call")
    private int agentMaxCall;
    @Basic(optional = false)
    @Column(name = "agent_allow_outbound")
    private int agentAllowOutbound;
    @Basic(optional = false)
    @Column(name = "agent_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date agentCreateDate;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (agentId != null ? agentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentProfile)) {
            return false;
        }
        AgentProfile other = (AgentProfile) object;
        if ((this.agentId == null && other.agentId != null) || (this.agentId != null && !this.agentId.equals(other.agentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.AgentProfile[ agentId=" + agentId + " ]";
    }
    
}
