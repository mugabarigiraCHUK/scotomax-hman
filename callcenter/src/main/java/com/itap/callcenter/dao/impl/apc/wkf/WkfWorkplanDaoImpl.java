package com.itap.callcenter.dao.impl.apc.wkf;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.wkf.WkfWorkplanDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.wkf.WkfWorkplan;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class WkfWorkplanDaoImpl extends GenericDaoImpl<WkfWorkplan, Integer> implements WkfWorkplanDao {

	public WkfWorkplanDaoImpl() {
		super(WkfWorkplan.class);
	}

}
