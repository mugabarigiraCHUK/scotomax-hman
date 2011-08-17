package com.itap.callcenter.dao.apc.job;

import java.util.List;

import com.itap.callcenter.dao.GenericDao;
import com.itap.callcenter.entity.apc.agent.AgentLevel;
import com.itap.callcenter.entity.apc.agent.AgentProfile;
import com.itap.callcenter.entity.apc.agent.AgentSeat;
import com.itap.callcenter.entity.apc.crm.CrmCustomer;
import com.itap.callcenter.entity.apc.job.JobStatus;
import com.itap.callcenter.entity.apc.job.JobTicket;

/**
 * 
 * @author scotomax
 *
 */
public interface JobTicketDao extends GenericDao<JobTicket, Integer> {

	/**
	 * Searching for job ticket data by criteria following parameters
	 * 
	 * @param agentProfile
	 * @param agentLevel
	 * @param agentSeat
	 * @param customer
	 * @param status
	 * @param jobName
	 * @return list of JobTicket entity from the result searching
	 */
	List<JobTicket> findByCriteria(AgentProfile agentProfile, AgentLevel agentLevel, AgentSeat agentSeat, CrmCustomer customer,
			JobStatus status, String jobName);

}
