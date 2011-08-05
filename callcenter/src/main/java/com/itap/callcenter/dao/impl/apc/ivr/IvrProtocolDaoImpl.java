package com.itap.callcenter.dao.impl.apc.ivr;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.ivr.IvrProtocolDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrProtocol;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class IvrProtocolDaoImpl extends GenericDaoImpl<IvrProtocol, Integer> implements IvrProtocolDao {

	public IvrProtocolDaoImpl() {
		super(IvrProtocol.class);
	}

}
