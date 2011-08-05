package com.itap.callcenter.dao.impl.apc.ivr;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.ivr.IvrPabxDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrPabx;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class IvrPabxDaoImpl extends GenericDaoImpl<IvrPabx, Integer> implements IvrPabxDao {

	public IvrPabxDaoImpl() {
		super(IvrPabx.class);
	}

}
