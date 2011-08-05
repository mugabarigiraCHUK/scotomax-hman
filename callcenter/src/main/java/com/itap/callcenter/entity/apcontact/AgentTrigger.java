/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apcontact;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "agent_trigger")
@XmlRootElement
public class AgentTrigger implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "trigger_id")
    private Integer triggerId;
    
    @Column(name = "trigger_name")
    private String triggerName;
    
    @Column(name = "trigger_description")
    private String triggerDescription;
    
    @Column(name = "trigger_command")
    private String triggerCommand;
    
    @Column(name = "trigger_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date triggerCreateDate;
    
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
        AgentTrigger other = (AgentTrigger) o;
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
