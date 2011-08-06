/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.job;

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
@Table(name = "job_trigger")
@XmlRootElement
public class JobTrigger implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "trigger_id", length = 11, nullable = false)
    @NotNull
    private Integer triggerId;
    
    @Column(name = "trigger_name", length = 50, nullable = false)
    @NotNull
    private String triggerName;
    
    @Column(name = "trigger_description", length = 100)
    private String triggerDescription;
    
    @Column(name = "trigger_command", length = 500)
    private String triggerCommand;
    
    @Column(name = "trigger_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date triggerCreateDate;
    
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
        JobTrigger other = (JobTrigger) o;
        return new EqualsBuilder()
                 .append(triggerId, other.triggerId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.triggerId)
         .toHashCode();
    }
    
}
