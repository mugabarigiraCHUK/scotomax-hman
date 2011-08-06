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
@Table(name = "knw_solution")
@XmlRootElement
public class KnwSolution implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "solution_id", length = 11, nullable = false)
    @NotNull
    private Integer solutionId;
    
    @Column(name = "topic_id", length = 11, nullable = false)
    @NotNull
    private int topicId;
    
    @Column(name = "agent_id", length = 11, nullable = false)
    @NotNull
    private int agentId;
    
    @Column(name = "supervisor_id", length = 11, nullable = false)
    @NotNull
    private int supervisorId;
    
    @Column(name = "status_id", length = 11, nullable = false)
    @NotNull
    private int statusId;
    
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

    public KnwSolution(Integer solutionId, int topicId, int agentId, int supervisorId, int statusId, String solutionName, Date solutionCreateDate, Date solutionUpdateDate) {
        this.solutionId = solutionId;
        this.topicId = topicId;
        this.agentId = agentId;
        this.supervisorId = supervisorId;
        this.statusId = statusId;
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

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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
        return ToStringBuilder.reflectionToString(this);
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
