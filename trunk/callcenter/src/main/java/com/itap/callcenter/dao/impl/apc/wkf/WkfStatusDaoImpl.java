package com.itap.callcenter.dao.impl.apc.wkf;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.wkf.WkfStatusDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.wkf.WkfStatus;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class WkfStatusDaoImpl extends GenericDaoImpl<WkfStatus, Integer> implements WkfStatusDao {

	public WkfStatusDaoImpl() {
		super(WkfStatus.class);
	}

}
