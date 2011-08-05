package com.itap.callcenter.dao.impl.apc.job;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.job.JobTicketDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
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

}
