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
@Table(name = "agent_trigger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentTrigger.findAll", query = "SELECT a FROM AgentTrigger a"),
    @NamedQuery(name = "AgentTrigger.findByTriggerId", query = "SELECT a FROM AgentTrigger a WHERE a.triggerId = :triggerId"),
    @NamedQuery(name = "AgentTrigger.findByTriggerName", query = "SELECT a FROM AgentTrigger a WHERE a.triggerName = :triggerName"),
    @NamedQuery(name = "AgentTrigger.findByTriggerDescription", query = "SELECT a FROM AgentTrigger a WHERE a.triggerDescription = :triggerDescription"),
    @NamedQuery(name = "AgentTrigger.findByTriggerCommand", query = "SELECT a FROM AgentTrigger a WHERE a.triggerCommand = :triggerCommand"),
    @NamedQuery(name = "AgentTrigger.findByTriggerCreateDate", query = "SELECT a FROM AgentTrigger a WHERE a.triggerCreateDate = :triggerCreateDate"),
    @NamedQuery(name = "AgentTrigger.findByTriggerUpdateDate", query = "SELECT a FROM AgentTrigger a WHERE a.triggerUpdateDate = :triggerUpdateDate")})
public class AgentTrigger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trigger_id")
    private Integer triggerId;
    @Basic(optional = false)
    @Column(name = "trigger_name")
    private String triggerName;
    @Column(name = "trigger_description")
    private String triggerDescription;
    @Column(name = "trigger_command")
    private String triggerCommand;
    @Basic(optional = false)
    @Column(name = "trigger_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date triggerCreateDate;
    @Basic(optional = false)
    @Column(name = "trigger_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date triggerUpdateDate;

    public AgentTrigger() {
    }

    public AgentTrigger(Integer triggerId) {
        this.triggerId = triggerId;
    }

    public AgentTrigger(Integer triggerId, String triggerName, Date triggerCreateDate, Date triggerUpdateDate) {
        this.triggerId = triggerId;
        this.triggerName = triggerName;
        this.triggerCreateDate = triggerCreateDate;
        this.triggerUpdateDate = triggerUpdateDate;
    }

    public Integer getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(Integer triggerId) {
        this.triggerId = triggerId;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerDescription() {
        return triggerDescription;
    }

    public void setTriggerDescription(String triggerDescription) {
        this.triggerDescription = triggerDescription;
    }

    public String getTriggerCommand() {
        return triggerCommand;
    }

    public void setTriggerCommand(String triggerCommand) {
        this.triggerCommand = triggerCommand;
    }

    public Date getTriggerCreateDate() {
        return triggerCreateDate;
    }

    public void setTriggerCreateDate(Date triggerCreateDate) {
        this.triggerCreateDate = triggerCreateDate;
    }

    public Date getTriggerUpdateDate() {
        return triggerUpdateDate;
    }

    public void setTriggerUpdateDate(Date triggerUpdateDate) {
        this.triggerUpdateDate = triggerUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (triggerId != null ? triggerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentTrigger)) {
            return false;
        }
        AgentTrigger other = (AgentTrigger) object;
        if ((this.triggerId == null && other.triggerId != null) || (this.triggerId != null && !this.triggerId.equals(other.triggerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.AgentTrigger[ triggerId=" + triggerId + " ]";
    }
    
}
