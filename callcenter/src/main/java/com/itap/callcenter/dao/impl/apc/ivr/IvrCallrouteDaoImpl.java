package com.itap.callcenter.dao.impl.apc.ivr;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.ivr.IvrCallrouteDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrCallroute;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class IvrCallrouteDaoImpl extends GenericDaoImpl<IvrCallroute, Integer> implements IvrCallrouteDao {

	public IvrCallrouteDaoImpl() {
		super(IvrCallroute.class);
	}

}
