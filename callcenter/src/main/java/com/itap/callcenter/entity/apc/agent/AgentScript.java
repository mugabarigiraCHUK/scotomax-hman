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
@Table(name = "agent_script")
@XmlRootElement
public class AgentScript implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "script_id", length = 11, nullable = false)
    private Integer scriptId;
    
    @Column(name = "business_id", length = 11, nullable = false)
    private int businessId;
    
    @Column(name = "topic_id", length = 11, nullable = false)
    private int topicId;
    
    @Column(name = "script_name", length = 50, nullable = false)
    private String scriptName;
    
    @Column(name = "script_description", length = 100, nullable = false)
    private String scriptDescription;
    
    @Column(name = "script_step", length = 11, nullable = false)
    private int scriptStep;
    
    @Column(name = "script_message", length = 1000, nullable = false)
    private String scriptMessage;
    
    @Column(name = "script_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date scriptCreateDate;
    
    @Column(name = "script_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scriptUpdateDate;

    public AgentScript() {
    }

    public AgentScript(Integer scriptId) {
        this.scriptId = scriptId;
    }

    public AgentScript(Integer scriptId, int businessId, int topicId, String scriptName, int scriptStep, Date scriptCreateDate, Date scriptUpdateDate) {
        this.scriptId = scriptId;
        this.businessId = businessId;
        this.topicId = topicId;
        this.scriptName = scriptName;
        this.scriptStep = scriptStep;
        this.scriptCreateDate = scriptCreateDate;
        this.scriptUpdateDate = scriptUpdateDate;
    }

    public Integer getScriptId() {
        return scriptId;
    }

    public void setScriptId(Integer scriptId) {
        this.scriptId = scriptId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getScriptDescription() {
        return scriptDescription;
    }

    public void setScriptDescription(String scriptDescription) {
        this.scriptDescription = scriptDescription;
    }

    public int getScriptStep() {
        return scriptStep;
    }

    public void setScriptStep(int scriptStep) {
        this.scriptStep = scriptStep;
    }

    public String getScriptMessage() {
        return scriptMessage;
    }

    public void setScriptMessage(String scriptMessage) {
        this.scriptMessage = scriptMessage;
    }

    public Date getScriptCreateDate() {
        return scriptCreateDate;
    }

    public void setScriptCreateDate(Date scriptCreateDate) {
        this.scriptCreateDate = scriptCreateDate;
    }

    public Date getScriptUpdateDate() {
        return scriptUpdateDate;
    }

    public void setScriptUpdateDate(Date scriptUpdateDate) {
        this.scriptUpdateDate = scriptUpdateDate;
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
        AgentScript other = (AgentScript) o;
        return new EqualsBuilder()
                 .append(scriptId, other.scriptId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.scriptId)
         .toHashCode();
    }
    
}
