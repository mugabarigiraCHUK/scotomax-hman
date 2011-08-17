package com.itap.callcenter.dao.impl.apc.job;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itap.callcenter.dao.apc.job.JobTicketDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
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
@Repository
public class JobTicketDaoImpl extends GenericDaoImpl<JobTicket, Integer> implements JobTicketDao {

	public JobTicketDaoImpl() {
		super(JobTicket.class);
	}

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
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<JobTicket> findByCriteria(AgentProfile agentProfile, 
														 AgentLevel agentLevel, 
														 AgentSeat agentSeat, 
														 CrmCustomer customer, 
														 JobStatus status,
														 String jobName) {
		String jpql = "select o from JobTicket o " +
						  " left join o.agentProfile ap " +
						  " left join o.agentLevel al " +
						  " left join o.agentSeat ags " +
						  " left join o.customer crm " +
						  " left join o.status st " +
						  "where (:agentProfile is null or ap = :agentProfile) " +
						  " and (:agentLevel is null or al = :agentLevel) " +
						  " and (:agentSeat is null or ags = :agentSeat) " +
						  " and (:customer is null or crm = :customer) " +
						  " and (:status is null or st = :status) " +
						  " and (:jobName is null or o.jobName like :jobName) " +
						  "order by o.jobCreateDate";
		List<JobTicket> rsList = em.createQuery(jpql)
											   .setParameter("agentProfile", agentProfile)
											   .setParameter("agentLevel", agentLevel)
											   .setParameter("agentSeat", agentSeat)
											   .setParameter("customer", customer)
											   .setParameter("status", status)
											   .setParameter("jobName", "%"+jobName+"%")
											   .getResultList();
		return rsList;
	}
}
