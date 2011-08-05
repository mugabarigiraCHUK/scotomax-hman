package com.itap.callcenter.dao.impl.apc.wkf;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.wkf.WkfCalendarDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.wkf.WkfCalendar;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class WkfCalendarDaoImpl extends GenericDaoImpl<WkfCalendar, Integer> implements WkfCalendarDao {

	public WkfCalendarDaoImpl() {
		super(WkfCalendar.class);
	}

}
