package com.itap.callcenter.beans.job;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.itap.callcenter.entity.apc.agent.AgentLevel;
import com.itap.callcenter.entity.apc.agent.AgentProfile;
import com.itap.callcenter.entity.apc.agent.AgentSeat;
import com.itap.callcenter.entity.apc.crm.CrmCustomer;
import com.itap.callcenter.entity.apc.job.JobStatus;
import com.itap.callcenter.entity.apc.job.JobTicket;
import com.itap.callcenter.entity.apc.knw.KnwSolution;

/**
 * 
 * @author scotomax
 *
 */
public abstract class JobTicketBean implements Serializable {

	private static final long serialVersionUID = 2409010499356470853L;

	protected Integer jobId;
	protected String jobName;
	protected String jobDescription;
	protected String jobVoiceRecordFile;
	protected Integer jobAlertEnable;
	protected Date jobCreateDate;
	protected Date jobUpdateDate;
	protected Date jobCloseDate;
    
	protected CrmCustomer customer;
	protected AgentProfile agentProfile;
	protected AgentSeat agentSeat;
	protected KnwSolution solution;
	protected JobStatus status;
	protected AgentLevel agentLevel;
    
	protected Integer selectedJobId;
	
	protected List<JobTicket> jobTicketList;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
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

	public Integer getSelectedJobId() {
		return selectedJobId;
	}

	public void setSelectedJobId(Integer selectedJobId) {
		this.selectedJobId = selectedJobId;
	}

	public List<JobTicket> getJobTicketList() {
		return jobTicketList;
	}

	public void setJobTicketList(List<JobTicket> jobTicketList) {
		this.jobTicketList = jobTicketList;
	}
	
	
}
