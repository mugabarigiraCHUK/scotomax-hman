package com.itap.callcenter.dao.impl.apc.ivr;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.ivr.IvrScheduleDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrSchedule;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class IvrScheduleDaoImpl extends GenericDaoImpl<IvrSchedule, Integer> implements IvrScheduleDao {

	public IvrScheduleDaoImpl() {
		super(IvrSchedule.class);
	}

}
