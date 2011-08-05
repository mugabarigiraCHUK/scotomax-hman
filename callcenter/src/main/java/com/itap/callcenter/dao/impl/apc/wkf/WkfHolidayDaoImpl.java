package com.itap.callcenter.dao.impl.apc.wkf;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.wkf.WkfHolidayDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.wkf.WkfHoliday;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class WkfHolidayDaoImpl extends GenericDaoImpl<WkfHoliday, Integer> implements WkfHolidayDao {

	public WkfHolidayDaoImpl() {
		super(WkfHoliday.class);
	}

}
