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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.itap.callcenter.entity.DomainObject;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;
import com.itap.callcenter.entity.apc.knw.KnwTopic;

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
    @NotNull
    private Integer scriptId;
    
    @ManyToOne
    @JoinColumn(name="business_id", nullable = false)
    @NotNull
    private CrmBusiness business;
    
    @ManyToOne
    @JoinColumn(name="topic_id", nullable = false)
    @NotNull
    private KnwTopic topic;
    
    @Column(name = "script_name", length = 50, nullable = false)
    @NotNull
    private String scriptName;
    
    @Column(name = "script_description", length = 100)
    private String scriptDescription;
    
    @Column(name = "script_step", length = 11, nullable = false)
    @NotNull
    private Integer scriptStep;
    
    @Column(name = "script_message", length = 1000)
    private String scriptMessage;
    
    @Column(name = "script_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date scriptCreateDate;
    
    @Column(name = "script_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scriptUpdateDate;

    public AgentScript() {
    }

    public AgentScript(Integer scriptId) {
        this.scriptId = scriptId;
    }

    public AgentScript(Integer scriptId, CrmBusiness business, KnwTopic topic, String scriptName, int scriptStep, Date scriptCreateDate, Date scriptUpdateDate) {
        this.scriptId = scriptId;
        this.business = business;
        this.topic = topic;
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

    public CrmBusiness getBusiness() {
		return business;
	}

	public void setBusiness(CrmBusiness business) {
		this.business = business;
	}

	public KnwTopic getTopic() {
		return topic;
	}

	public void setTopic(KnwTopic topic) {
		this.topic = topic;
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

    public Integer getScriptStep() {
        return scriptStep;
    }

    public void setScriptStep(Integer scriptStep) {
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
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("scriptId", scriptId)
				.append("scriptName", scriptName)
				.toString();
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
