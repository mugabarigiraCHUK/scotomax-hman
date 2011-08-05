package com.itap.callcenter.dao.impl.apc.job;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.job.JobTriggerDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.job.JobTrigger;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class JobTriggerDaoImpl extends GenericDaoImpl<JobTrigger, Integer> implements JobTriggerDao {

	public JobTriggerDaoImpl() {
		super(JobTrigger.class);
	}

}
