package com.itap.callcenter.dao.impl.apc.ivr;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.ivr.IvrCallflowDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrCallflow;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class IvrCallflowDaoImpl extends GenericDaoImpl<IvrCallflow, Integer> implements IvrCallflowDao {

	public IvrCallflowDaoImpl() {
		super(IvrCallflow.class);
	}

}
