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
@Table(name = "knw_solution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KnwSolution.findAll", query = "SELECT k FROM KnwSolution k"),
    @NamedQuery(name = "KnwSolution.findBySolutionId", query = "SELECT k FROM KnwSolution k WHERE k.solutionId = :solutionId"),
    @NamedQuery(name = "KnwSolution.findByTopicId", query = "SELECT k FROM KnwSolution k WHERE k.topicId = :topicId"),
    @NamedQuery(name = "KnwSolution.findByAgentId", query = "SELECT k FROM KnwSolution k WHERE k.agentId = :agentId"),
    @NamedQuery(name = "KnwSolution.findBySupervisorId", query = "SELECT k FROM KnwSolution k WHERE k.supervisorId = :supervisorId"),
    @NamedQuery(name = "KnwSolution.findByStatusId", query = "SELECT k FROM KnwSolution k WHERE k.statusId = :statusId"),
    @NamedQuery(name = "KnwSolution.findBySolutionName", query = "SELECT k FROM KnwSolution k WHERE k.solutionName = :solutionName"),
    @NamedQuery(name = "KnwSolution.findBySolutionDescription", query = "SELECT k FROM KnwSolution k WHERE k.solutionDescription = :solutionDescription"),
    @NamedQuery(name = "KnwSolution.findBySolutionCreateDate", query = "SELECT k FROM KnwSolution k WHERE k.solutionCreateDate = :solutionCreateDate"),
    @NamedQuery(name = "KnwSolution.findBySolutionUpdateDate", query = "SELECT k FROM KnwSolution k WHERE k.solutionUpdateDate = :solutionUpdateDate")})
public class KnwSolution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "solution_id")
    private Integer solutionId;
    @Basic(optional = false)
    @Column(name = "topic_id")
    private int topicId;
    @Basic(optional = false)
    @Column(name = "agent_id")
    private int agentId;
    @Basic(optional = false)
    @Column(name = "supervisor_id")
    private int supervisorId;
    @Basic(optional = false)
    @Column(name = "status_id")
    private int statusId;
    @Basic(optional = false)
    @Column(name = "solution_name")
    private String solutionName;
    @Column(name = "solution_description")
    private String solutionDescription;
    @Basic(optional = false)
    @Column(name = "solution_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solutionCreateDate;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (solutionId != null ? solutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnwSolution)) {
            return false;
        }
        KnwSolution other = (KnwSolution) object;
        if ((this.solutionId == null && other.solutionId != null) || (this.solutionId != null && !this.solutionId.equals(other.solutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.KnwSolution[ solutionId=" + solutionId + " ]";
    }
    
}
