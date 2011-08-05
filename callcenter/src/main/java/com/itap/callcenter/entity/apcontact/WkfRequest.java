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
@Table(name = "wkf_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WkfRequest.findAll", query = "SELECT w FROM WkfRequest w"),
    @NamedQuery(name = "WkfRequest.findByRequestId", query = "SELECT w FROM WkfRequest w WHERE w.requestId = :requestId"),
    @NamedQuery(name = "WkfRequest.findByAgentId", query = "SELECT w FROM WkfRequest w WHERE w.agentId = :agentId"),
    @NamedQuery(name = "WkfRequest.findBySupervisorId", query = "SELECT w FROM WkfRequest w WHERE w.supervisorId = :supervisorId"),
    @NamedQuery(name = "WkfRequest.findByStatusId", query = "SELECT w FROM WkfRequest w WHERE w.statusId = :statusId"),
    @NamedQuery(name = "WkfRequest.findByRequestName", query = "SELECT w FROM WkfRequest w WHERE w.requestName = :requestName"),
    @NamedQuery(name = "WkfRequest.findByRequestDescription", query = "SELECT w FROM WkfRequest w WHERE w.requestDescription = :requestDescription"),
    @NamedQuery(name = "WkfRequest.findByRequestStartTime", query = "SELECT w FROM WkfRequest w WHERE w.requestStartTime = :requestStartTime"),
    @NamedQuery(name = "WkfRequest.findByRequestEndTime", query = "SELECT w FROM WkfRequest w WHERE w.requestEndTime = :requestEndTime"),
    @NamedQuery(name = "WkfRequest.findByRequestCreateDate", query = "SELECT w FROM WkfRequest w WHERE w.requestCreateDate = :requestCreateDate"),
    @NamedQuery(name = "WkfRequest.findByRequestUpdateDate", query = "SELECT w FROM WkfRequest w WHERE w.requestUpdateDate = :requestUpdateDate")})
public class WkfRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "request_id")
    private Integer requestId;
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
    @Column(name = "request_name")
    private String requestName;
    @Column(name = "request_description")
    private String requestDescription;
    @Basic(optional = false)
    @Column(name = "request_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestStartTime;
    @Basic(optional = false)
    @Column(name = "request_end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestEndTime;
    @Basic(optional = false)
    @Column(name = "request_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestCreateDate;
    @Basic(optional = false)
    @Column(name = "request_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestUpdateDate;

    public WkfRequest() {
    }

    public WkfRequest(Integer requestId) {
        this.requestId = requestId;
    }

    public WkfRequest(Integer requestId, int agentId, int supervisorId, int statusId, String requestName, Date requestStartTime, Date requestEndTime, Date requestCreateDate, Date requestUpdateDate) {
        this.requestId = requestId;
        this.agentId = agentId;
        this.supervisorId = supervisorId;
        this.statusId = statusId;
        this.requestName = requestName;
        this.requestStartTime = requestStartTime;
        this.requestEndTime = requestEndTime;
        this.requestCreateDate = requestCreateDate;
        this.requestUpdateDate = requestUpdateDate;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
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

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public Date getRequestStartTime() {
        return requestStartTime;
    }

    public void setRequestStartTime(Date requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    public Date getRequestEndTime() {
        return requestEndTime;
    }

    public void setRequestEndTime(Date requestEndTime) {
        this.requestEndTime = requestEndTime;
    }

    public Date getRequestCreateDate() {
        return requestCreateDate;
    }

    public void setRequestCreateDate(Date requestCreateDate) {
        this.requestCreateDate = requestCreateDate;
    }

    public Date getRequestUpdateDate() {
        return requestUpdateDate;
    }

    public void setRequestUpdateDate(Date requestUpdateDate) {
        this.requestUpdateDate = requestUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestId != null ? requestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WkfRequest)) {
            return false;
        }
        WkfRequest other = (WkfRequest) object;
        if ((this.requestId == null && other.requestId != null) || (this.requestId != null && !this.requestId.equals(other.requestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.WkfRequest[ requestId=" + requestId + " ]";
    }
    
}
