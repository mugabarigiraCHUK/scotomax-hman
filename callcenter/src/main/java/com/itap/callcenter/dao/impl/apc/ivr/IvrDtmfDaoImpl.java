package com.itap.callcenter.dao.impl.apc.ivr;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.ivr.IvrDtmfDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrDtmf;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class IvrDtmfDaoImpl extends GenericDaoImpl<IvrDtmf, Integer> implements IvrDtmfDao {

	public IvrDtmfDaoImpl() {
		super(IvrDtmf.class);
	}

}
