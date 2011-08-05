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
@Table(name = "job_trigger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobTrigger.findAll", query = "SELECT j FROM JobTrigger j"),
    @NamedQuery(name = "JobTrigger.findByTriggerId", query = "SELECT j FROM JobTrigger j WHERE j.triggerId = :triggerId"),
    @NamedQuery(name = "JobTrigger.findByTriggerName", query = "SELECT j FROM JobTrigger j WHERE j.triggerName = :triggerName"),
    @NamedQuery(name = "JobTrigger.findByTriggerDescription", query = "SELECT j FROM JobTrigger j WHERE j.triggerDescription = :triggerDescription"),
    @NamedQuery(name = "JobTrigger.findByTriggerCommand", query = "SELECT j FROM JobTrigger j WHERE j.triggerCommand = :triggerCommand"),
    @NamedQuery(name = "JobTrigger.findByTriggerCreateDate", query = "SELECT j FROM JobTrigger j WHERE j.triggerCreateDate = :triggerCreateDate"),
    @NamedQuery(name = "JobTrigger.findByTriggerUpdateDate", query = "SELECT j FROM JobTrigger j WHERE j.triggerUpdateDate = :triggerUpdateDate")})
public class JobTrigger implements Serializable {
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

    public JobTrigger() {
    }

    public JobTrigger(Integer triggerId) {
        this.triggerId = triggerId;
    }

    public JobTrigger(Integer triggerId, String triggerName, Date triggerCreateDate, Date triggerUpdateDate) {
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
        if (!(object instanceof JobTrigger)) {
            return false;
        }
        JobTrigger other = (JobTrigger) object;
        if ((this.triggerId == null && other.triggerId != null) || (this.triggerId != null && !this.triggerId.equals(other.triggerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.JobTrigger[ triggerId=" + triggerId + " ]";
    }
    
}
