/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.ivr;

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
@Table(name = "ivr_callflow")
@XmlRootElement
public class IvrCallflow implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "callflow_id", length = 11, nullable = false)
    @NotNull
    private Integer callflowId;
    
    @Column(name = "voice_id", length = 11, nullable = false)
    @NotNull
    private int voiceId;
    
    @Column(name = "callflow_name", length = 50, nullable = false)
    @NotNull
    private String callflowName;
    
    @Column(name = "callflow_description", length = 100)
    private String callflowDescription;
    
    @Column(name = "callflow_step", length = 11, nullable = false)
    @NotNull
    private int callflowStep;
    
    @Column(name = "callflow_timeout", length = 11, nullable = false)
    @NotNull
    private int callflowTimeout;
    
    @Column(name = "callflow_next_id", length = 11, nullable = false)
    @NotNull
    private int callflowNextId;
    
    @Column(name = "callflow_back_id", length = 11, nullable = false)
    @NotNull
    private int callflowBackId;
    
    @Column(name = "callflow_voice_repeat_enable", length = 11, nullable = false)
    @NotNull
    private int callflowVoiceRepeatEnable;
    
    @Column(name = "callflow_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date callflowCreateDate;
    
    @Column(name = "callflow_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callflowUpdateDate;

    public IvrCallflow() {
    }

    public IvrCallflow(Integer callflowId) {
        this.callflowId = callflowId;
    }

    public IvrCallflow(Integer callflowId, int voiceId, String callflowName, int callflowStep, int callflowTimeout, int callflowNextId, int callflowBackId, int callflowVoiceRepeatEnable, Date callflowCreateDate, Date callflowUpdateDate) {
        this.callflowId = callflowId;
        this.voiceId = voiceId;
        this.callflowName = callflowName;
        this.callflowStep = callflowStep;
        this.callflowTimeout = callflowTimeout;
        this.callflowNextId = callflowNextId;
        this.callflowBackId = callflowBackId;
        this.callflowVoiceRepeatEnable = callflowVoiceRepeatEnable;
        this.callflowCreateDate = callflowCreateDate;
        this.callflowUpdateDate = callflowUpdateDate;
    }

    public Integer getCallflowId() {
        return callflowId;
    }

    public void setCallflowId(Integer callflowId) {
        this.callflowId = callflowId;
    }

    public int getVoiceId() {
        return voiceId;
    }

    public void setVoiceId(int voiceId) {
        this.voiceId = voiceId;
    }

    public String getCallflowName() {
        return callflowName;
    }

    public void setCallflowName(String callflowName) {
        this.callflowName = callflowName;
    }

    public String getCallflowDescription() {
        return callflowDescription;
    }

    public void setCallflowDescription(String callflowDescription) {
        this.callflowDescription = callflowDescription;
    }

    public int getCallflowStep() {
        return callflowStep;
    }

    public void setCallflowStep(int callflowStep) {
        this.callflowStep = callflowStep;
    }

    public int getCallflowTimeout() {
        return callflowTimeout;
    }

    public void setCallflowTimeout(int callflowTimeout) {
        this.callflowTimeout = callflowTimeout;
    }

    public int getCallflowNextId() {
        return callflowNextId;
    }

    public void setCallflowNextId(int callflowNextId) {
        this.callflowNextId = callflowNextId;
    }

    public int getCallflowBackId() {
        return callflowBackId;
    }

    public void setCallflowBackId(int callflowBackId) {
        this.callflowBackId = callflowBackId;
    }

    public int getCallflowVoiceRepeatEnable() {
        return callflowVoiceRepeatEnable;
    }

    public void setCallflowVoiceRepeatEnable(int callflowVoiceRepeatEnable) {
        this.callflowVoiceRepeatEnable = callflowVoiceRepeatEnable;
    }

    public Date getCallflowCreateDate() {
        return callflowCreateDate;
    }

    public void setCallflowCreateDate(Date callflowCreateDate) {
        this.callflowCreateDate = callflowCreateDate;
    }

    public Date getCallflowUpdateDate() {
        return callflowUpdateDate;
    }

    public void setCallflowUpdateDate(Date callflowUpdateDate) {
        this.callflowUpdateDate = callflowUpdateDate;
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
        IvrCallflow other = (IvrCallflow) o;
        return new EqualsBuilder()
                 .append(callflowId, other.callflowId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.callflowId)
         .toHashCode();
    }
    
}
