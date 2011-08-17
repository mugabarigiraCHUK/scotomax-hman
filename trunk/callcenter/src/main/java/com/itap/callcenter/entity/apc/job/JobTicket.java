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
import com.itap.callcenter.entity.apc.agent.AgentLevel;
import com.itap.callcenter.entity.apc.agent.AgentProfile;
import com.itap.callcenter.entity.apc.agent.AgentSeat;
import com.itap.callcenter.entity.apc.crm.CrmCustomer;
import com.itap.callcenter.entity.apc.knw.KnwSolution;

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
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull
    private CrmCustomer customer;
    
    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    @NotNull
    private AgentProfile agentProfile;
    
    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    @NotNull
    private AgentSeat agentSeat;
    
    @ManyToOne
    @JoinColumn(name = "solution_id", nullable = false)
    @NotNull
    private KnwSolution solution;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    @NotNull
    private JobStatus status;
    
    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    @NotNull
    private AgentLevel agentLevel;
    
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
    private Integer jobAlertEnable;
    
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

    public JobTicket(Integer jobId, 
    					CrmCustomer customer, 
    					AgentProfile agentProfile, 
    					AgentSeat agentSeat, 
    					KnwSolution solution, 
    					JobStatus status, 
    					AgentLevel agentLevel, 
    					String jobName, 
    					Integer 	jobAlertEnable, 
    					Date jobCreateDate,
    					Date jobUpdateDate) {
        this.jobId = jobId;
        this.customer = customer;
        this.agentProfile = agentProfile;
        this.agentSeat = agentSeat;
        this.solution = solution;
        this.status = status;
        this.agentLevel = agentLevel;
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

    public CrmCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(CrmCustomer customer) {
		this.customer = customer;
	}

	public AgentProfile getAgentProfile() {
		return agentProfile;
	}

	public void setAgentProfile(AgentProfile agentProfile) {
		this.agentProfile = agentProfile;
	}

	public AgentSeat getAgentSeat() {
		return agentSeat;
	}

	public void setAgentSeat(AgentSeat agentSeat) {
		this.agentSeat = agentSeat;
	}

	public KnwSolution getSolution() {
		return solution;
	}

	public void setSolution(KnwSolution solution) {
		this.solution = solution;
	}

	public JobStatus getStatus() {
		return status;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}

	public AgentLevel getAgentLevel() {
		return agentLevel;
	}

	public void setAgentLevel(AgentLevel agentLevel) {
		this.agentLevel = agentLevel;
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

    public Integer getJobAlertEnable() {
        return jobAlertEnable;
    }

    public void setJobAlertEnable(Integer jobAlertEnable) {
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
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("jobId", jobId)
				.append("jobName", jobName)
				.toString();
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
