package com.itap.callcenter.dao.impl.apc.job;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.job.JobStatusDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.job.JobStatus;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class JobStatusDaoImpl extends GenericDaoImpl<JobStatus, Integer> implements JobStatusDao {

	public JobStatusDaoImpl() {
		super(JobStatus.class);
	}

}
