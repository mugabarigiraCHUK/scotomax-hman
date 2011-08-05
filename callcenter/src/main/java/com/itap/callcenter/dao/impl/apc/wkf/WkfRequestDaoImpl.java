package com.itap.callcenter.dao.impl.apc.wkf;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.wkf.WkfRequestDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.wkf.WkfRequest;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class WkfRequestDaoImpl extends GenericDaoImpl<WkfRequest, Integer> implements WkfRequestDao {

	public WkfRequestDaoImpl() {
		super(WkfRequest.class);
	}

}
