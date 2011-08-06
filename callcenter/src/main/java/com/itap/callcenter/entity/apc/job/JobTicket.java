/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.job;

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
@Table(name = "job_ticket")
@XmlRootElement
public class JobTicket implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "job_id", length = 11, nullable = false)
    @NotNull
    private Integer jobId;
    
    @Column(name = "customer_id", length = 11, nullable = false)
    @NotNull
    private int customerId;
    
    @Column(name = "agent_id", length = 11, nullable = false)
    @NotNull
    private int agentId;
    
    @Column(name = "seat_id", length = 11, nullable = false)
    @NotNull
    private int seatId;
    
    @Column(name = "solution_id", length = 11, nullable = false)
    @NotNull
    private int solutionId;
    
    @Column(name = "status_id", length = 11, nullable = false)
    @NotNull
    private int statusId;
    
    @Column(name = "level_id", length = 11, nullable = false)
    @NotNull
    private int levelId;
    
    @Column(name = "job_name", length = 50, nullable = false)
    @NotNull
    private String jobName;
    
    @Column(name = "job_description", length = 100)
    private String jobDescription;
    
    @Column(name = "job_voice_record_file", length = 500, nullable = false)
    @NotNull
    private String jobVoiceRecordFile;
    
    @Column(name = "job_alert_enable", length = 11, nullable = false)
    @NotNull
    private int jobAlertEnable;
    
    @Column(name = "job_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date jobCreateDate;
    
    @Column(name = "job_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jobUpdateDate;
    
    @Column(name = "job_close_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jobCloseDate;

    public JobTicket() {
    }

    public JobTicket(Integer jobId) {
        this.jobId = jobId;
    }

    public JobTicket(Integer jobId, int customerId, int agentId, int seatId, int solutionId, int statusId, int levelId, String jobName, int jobAlertEnable, Date jobCreateDate, Date jobUpdateDate) {
        this.jobId = jobId;
        this.customerId = customerId;
        this.agentId = agentId;
        this.seatId = seatId;
        this.solutionId = solutionId;
        this.statusId = statusId;
        this.levelId = levelId;
        this.jobName = jobName;
        this.jobAlertEnable = jobAlertEnable;
        this.jobCreateDate = jobCreateDate;
        this.jobUpdateDate = jobUpdateDate;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobVoiceRecordFile() {
        return jobVoiceRecordFile;
    }

    public void setJobVoiceRecordFile(String jobVoiceRecordFile) {
        this.jobVoiceRecordFile = jobVoiceRecordFile;
    }

    public int getJobAlertEnable() {
        return jobAlertEnable;
    }

    public void setJobAlertEnable(int jobAlertEnable) {
        this.jobAlertEnable = jobAlertEnable;
    }

    public Date getJobCreateDate() {
        return jobCreateDate;
    }

    public void setJobCreateDate(Date jobCreateDate) {
        this.jobCreateDate = jobCreateDate;
    }

    public Date getJobUpdateDate() {
        return jobUpdateDate;
    }

    public void setJobUpdateDate(Date jobUpdateDate) {
        this.jobUpdateDate = jobUpdateDate;
    }

    public Date getJobCloseDate() {
        return jobCloseDate;
    }

    public void setJobCloseDate(Date jobCloseDate) {
        this.jobCloseDate = jobCloseDate;
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
        JobTicket other = (JobTicket) o;
        return new EqualsBuilder()
                 .append(jobId, other.jobId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.jobId)
         .toHashCode();
    }
    
}
