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
@Table(name = "ivr_callflow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrCallflow.findAll", query = "SELECT i FROM IvrCallflow i"),
    @NamedQuery(name = "IvrCallflow.findByCallflowId", query = "SELECT i FROM IvrCallflow i WHERE i.callflowId = :callflowId"),
    @NamedQuery(name = "IvrCallflow.findByVoiceId", query = "SELECT i FROM IvrCallflow i WHERE i.voiceId = :voiceId"),
    @NamedQuery(name = "IvrCallflow.findByCallflowName", query = "SELECT i FROM IvrCallflow i WHERE i.callflowName = :callflowName"),
    @NamedQuery(name = "IvrCallflow.findByCallflowDescription", query = "SELECT i FROM IvrCallflow i WHERE i.callflowDescription = :callflowDescription"),
    @NamedQuery(name = "IvrCallflow.findByCallflowStep", query = "SELECT i FROM IvrCallflow i WHERE i.callflowStep = :callflowStep"),
    @NamedQuery(name = "IvrCallflow.findByCallflowTimeout", query = "SELECT i FROM IvrCallflow i WHERE i.callflowTimeout = :callflowTimeout"),
    @NamedQuery(name = "IvrCallflow.findByCallflowNextId", query = "SELECT i FROM IvrCallflow i WHERE i.callflowNextId = :callflowNextId"),
    @NamedQuery(name = "IvrCallflow.findByCallflowBackId", query = "SELECT i FROM IvrCallflow i WHERE i.callflowBackId = :callflowBackId"),
    @NamedQuery(name = "IvrCallflow.findByCallflowVoiceRepeatEnable", query = "SELECT i FROM IvrCallflow i WHERE i.callflowVoiceRepeatEnable = :callflowVoiceRepeatEnable"),
    @NamedQuery(name = "IvrCallflow.findByCallflowCreateDate", query = "SELECT i FROM IvrCallflow i WHERE i.callflowCreateDate = :callflowCreateDate"),
    @NamedQuery(name = "IvrCallflow.findByCallflowUpdateDate", query = "SELECT i FROM IvrCallflow i WHERE i.callflowUpdateDate = :callflowUpdateDate")})
public class IvrCallflow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "callflow_id")
    private Integer callflowId;
    @Basic(optional = false)
    @Column(name = "voice_id")
    private int voiceId;
    @Basic(optional = false)
    @Column(name = "callflow_name")
    private String callflowName;
    @Column(name = "callflow_description")
    private String callflowDescription;
    @Basic(optional = false)
    @Column(name = "callflow_step")
    private int callflowStep;
    @Basic(optional = false)
    @Column(name = "callflow_timeout")
    private int callflowTimeout;
    @Basic(optional = false)
    @Column(name = "callflow_next_id")
    private int callflowNextId;
    @Basic(optional = false)
    @Column(name = "callflow_back_id")
    private int callflowBackId;
    @Basic(optional = false)
    @Column(name = "callflow_voice_repeat_enable")
    private int callflowVoiceRepeatEnable;
    @Basic(optional = false)
    @Column(name = "callflow_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callflowCreateDate;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (callflowId != null ? callflowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrCallflow)) {
            return false;
        }
        IvrCallflow other = (IvrCallflow) object;
        if ((this.callflowId == null && other.callflowId != null) || (this.callflowId != null && !this.callflowId.equals(other.callflowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.IvrCallflow[ callflowId=" + callflowId + " ]";
    }
    
}
