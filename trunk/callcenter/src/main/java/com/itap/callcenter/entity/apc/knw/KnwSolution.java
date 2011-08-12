/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.knw;

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
import com.itap.callcenter.entity.apc.agent.AgentProfile;

/**
 *
 * @author scotomax
 */
@Entity
@Table(name = "knw_solution")
@XmlRootElement
public class KnwSolution implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "solution_id", length = 11, nullable = false)
    @NotNull
    private Integer solutionId;
    
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    @NotNull
    private KnwTopic topic;
    
    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    @NotNull
    private AgentProfile agentProfile;
    
    @ManyToOne
    @JoinColumn(name = "supervisor_id", nullable = false)
    @NotNull
    private AgentProfile supervisor;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    @NotNull
    private KnwStatus status;
    
    @Column(name = "solution_name", length = 50, nullable = false)
    @NotNull
    private String solutionName;
    
    @Column(name = "solution_description", length = 1000)
    private String solutionDescription;
    
    @Column(name = "solution_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date solutionCreateDate;
    
    @Column(name = "solution_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solutionUpdateDate;

    public KnwSolution() {
    }

    public KnwSolution(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public KnwSolution(Integer solutionId, KnwTopic topic, AgentProfile agentProfile, AgentProfile supervisor, KnwStatus status, String solutionName, Date solutionCreateDate, Date solutionUpdateDate) {
        this.solutionId = solutionId;
        this.topic = topic;
        this.agentProfile = agentProfile;
        this.supervisor = supervisor;
        this.status = status;
        this.solutionName = solutionName;
        this.solutionCreateDate = solutionCreateDate;
        this.solutionUpdateDate = solutionUpdateDate;
    }

    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public KnwTopic getTopic() {
		return topic;
	}

	public void setTopic(KnwTopic topic) {
		this.topic = topic;
	}

	public AgentProfile getAgentProfile() {
		return agentProfile;
	}

	public void setAgentProfile(AgentProfile agentProfile) {
		this.agentProfile = agentProfile;
	}

	public AgentProfile getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(AgentProfile supervisor) {
		this.supervisor = supervisor;
	}

	public KnwStatus getStatus() {
		return status;
	}

	public void setStatus(KnwStatus status) {
		this.status = status;
	}

	public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

    public String getSolutionDescription() {
        return solutionDescription;
    }

    public void setSolutionDescription(String solutionDescription) {
        this.solutionDescription = solutionDescription;
    }

    public Date getSolutionCreateDate() {
        return solutionCreateDate;
    }

    public void setSolutionCreateDate(Date solutionCreateDate) {
        this.solutionCreateDate = solutionCreateDate;
    }

    public Date getSolutionUpdateDate() {
        return solutionUpdateDate;
    }

    public void setSolutionUpdateDate(Date solutionUpdateDate) {
        this.solutionUpdateDate = solutionUpdateDate;
    }

    @Override
    public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("solutionId", solutionId)
				.append("solutionName", solutionName)
				.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        KnwSolution other = (KnwSolution) o;
        return new EqualsBuilder()
                 .append(solutionId, other.solutionId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.solutionId)
         .toHashCode();
    }
    
}
