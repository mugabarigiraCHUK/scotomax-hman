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
@Table(name = "agent_script")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentScript.findAll", query = "SELECT a FROM AgentScript a"),
    @NamedQuery(name = "AgentScript.findByScriptId", query = "SELECT a FROM AgentScript a WHERE a.scriptId = :scriptId"),
    @NamedQuery(name = "AgentScript.findByBusinessId", query = "SELECT a FROM AgentScript a WHERE a.businessId = :businessId"),
    @NamedQuery(name = "AgentScript.findByTopicId", query = "SELECT a FROM AgentScript a WHERE a.topicId = :topicId"),
    @NamedQuery(name = "AgentScript.findByScriptName", query = "SELECT a FROM AgentScript a WHERE a.scriptName = :scriptName"),
    @NamedQuery(name = "AgentScript.findByScriptDescription", query = "SELECT a FROM AgentScript a WHERE a.scriptDescription = :scriptDescription"),
    @NamedQuery(name = "AgentScript.findByScriptStep", query = "SELECT a FROM AgentScript a WHERE a.scriptStep = :scriptStep"),
    @NamedQuery(name = "AgentScript.findByScriptMessage", query = "SELECT a FROM AgentScript a WHERE a.scriptMessage = :scriptMessage"),
    @NamedQuery(name = "AgentScript.findByScriptCreateDate", query = "SELECT a FROM AgentScript a WHERE a.scriptCreateDate = :scriptCreateDate"),
    @NamedQuery(name = "AgentScript.findByScriptUpdateDate", query = "SELECT a FROM AgentScript a WHERE a.scriptUpdateDate = :scriptUpdateDate")})
public class AgentScript implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "script_id")
    private Integer scriptId;
    @Basic(optional = false)
    @Column(name = "business_id")
    private int businessId;
    @Basic(optional = false)
    @Column(name = "topic_id")
    private int topicId;
    @Basic(optional = false)
    @Column(name = "script_name")
    private String scriptName;
    @Column(name = "script_description")
    private String scriptDescription;
    @Basic(optional = false)
    @Column(name = "script_step")
    private int scriptStep;
    @Column(name = "script_message")
    private String scriptMessage;
    @Basic(optional = false)
    @Column(name = "script_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scriptCreateDate;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (scriptId != null ? scriptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentScript)) {
            return false;
        }
        AgentScript other = (AgentScript) object;
        if ((this.scriptId == null && other.scriptId != null) || (this.scriptId != null && !this.scriptId.equals(other.scriptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.AgentScript[ scriptId=" + scriptId + " ]";
    }
    
}
