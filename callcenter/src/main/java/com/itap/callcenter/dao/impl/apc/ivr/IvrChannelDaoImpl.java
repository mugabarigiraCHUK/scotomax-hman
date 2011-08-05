package com.itap.callcenter.dao.impl.apc.ivr;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.ivr.IvrChannelDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.ivr.IvrChannel;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class IvrChannelDaoImpl extends GenericDaoImpl<IvrChannel, Integer> implements IvrChannelDao {

	public IvrChannelDaoImpl() {
		super(IvrChannel.class);
	}

}
