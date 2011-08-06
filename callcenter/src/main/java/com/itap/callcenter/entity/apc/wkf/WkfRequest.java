/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.wkf;

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
@Table(name = "wkf_request")
@XmlRootElement
public class WkfRequest implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "request_id", length = 11, nullable = false)
    private Integer requestId;
    
    @Column(name = "agent_id", length = 11, nullable = false)
    private int agentId;
    
    @Column(name = "supervisor_id", length = 11, nullable = false)
    private int supervisorId;
    
    @Column(name = "status_id", length = 11, nullable = false)
    private int statusId;
    
    @Column(name = "request_name", length = 50, nullable = false)
    private String requestName;
    
    @Column(name = "request_description", length = 100)
    private String requestDescription;
    
    @Column(name = "request_start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestStartTime;
    
    @Column(name = "request_end_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestEndTime;
    
    @Column(name = "request_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestCreateDate;
    
    @Column(name = "request_update_date", nullable = false)
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
        WkfRequest other = (WkfRequest) o;
        return new EqualsBuilder()
                 .append(requestId, other.requestId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.requestId)
         .toHashCode();
    }
    
}
