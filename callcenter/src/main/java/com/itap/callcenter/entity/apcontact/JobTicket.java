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
@Table(name = "job_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobTicket.findAll", query = "SELECT j FROM JobTicket j"),
    @NamedQuery(name = "JobTicket.findByJobId", query = "SELECT j FROM JobTicket j WHERE j.jobId = :jobId"),
    @NamedQuery(name = "JobTicket.findByCustomerId", query = "SELECT j FROM JobTicket j WHERE j.customerId = :customerId"),
    @NamedQuery(name = "JobTicket.findByAgentId", query = "SELECT j FROM JobTicket j WHERE j.agentId = :agentId"),
    @NamedQuery(name = "JobTicket.findBySeatId", query = "SELECT j FROM JobTicket j WHERE j.seatId = :seatId"),
    @NamedQuery(name = "JobTicket.findBySolutionId", query = "SELECT j FROM JobTicket j WHERE j.solutionId = :solutionId"),
    @NamedQuery(name = "JobTicket.findByStatusId", query = "SELECT j FROM JobTicket j WHERE j.statusId = :statusId"),
    @NamedQuery(name = "JobTicket.findByLevelId", query = "SELECT j FROM JobTicket j WHERE j.levelId = :levelId"),
    @NamedQuery(name = "JobTicket.findByJobName", query = "SELECT j FROM JobTicket j WHERE j.jobName = :jobName"),
    @NamedQuery(name = "JobTicket.findByJobDescription", query = "SELECT j FROM JobTicket j WHERE j.jobDescription = :jobDescription"),
    @NamedQuery(name = "JobTicket.findByJobVoiceRecordFile", query = "SELECT j FROM JobTicket j WHERE j.jobVoiceRecordFile = :jobVoiceRecordFile"),
    @NamedQuery(name = "JobTicket.findByJobAlertEnable", query = "SELECT j FROM JobTicket j WHERE j.jobAlertEnable = :jobAlertEnable"),
    @NamedQuery(name = "JobTicket.findByJobCreateDate", query = "SELECT j FROM JobTicket j WHERE j.jobCreateDate = :jobCreateDate"),
    @NamedQuery(name = "JobTicket.findByJobUpdateDate", query = "SELECT j FROM JobTicket j WHERE j.jobUpdateDate = :jobUpdateDate"),
    @NamedQuery(name = "JobTicket.findByJobCloseDate", query = "SELECT j FROM JobTicket j WHERE j.jobCloseDate = :jobCloseDate")})
public class JobTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "job_id")
    private Integer jobId;
    @Basic(optional = false)
    @Column(name = "customer_id")
    private int customerId;
    @Basic(optional = false)
    @Column(name = "agent_id")
    private int agentId;
    @Basic(optional = false)
    @Column(name = "seat_id")
    private int seatId;
    @Basic(optional = false)
    @Column(name = "solution_id")
    private int solutionId;
    @Basic(optional = false)
    @Column(name = "status_id")
    private int statusId;
    @Basic(optional = false)
    @Column(name = "level_id")
    private int levelId;
    @Basic(optional = false)
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "job_voice_record_file")
    private String jobVoiceRecordFile;
    @Basic(optional = false)
    @Column(name = "job_alert_enable")
    private int jobAlertEnable;
    @Basic(optional = false)
    @Column(name = "job_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jobCreateDate;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobTicket)) {
            return false;
        }
        JobTicket other = (JobTicket) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.JobTicket[ jobId=" + jobId + " ]";
    }
    
}
