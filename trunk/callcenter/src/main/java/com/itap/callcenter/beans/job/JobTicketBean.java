package com.itap.callcenter.beans.job;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

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
public @Data abstract class JobTicketBean implements Serializable {

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
	
}
