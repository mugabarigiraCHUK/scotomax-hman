package com.itap.callcenter.dao.impl.apc.knw;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.knw.KnwStatusDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.knw.KnwStatus;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class KnwStatusDaoImpl extends GenericDaoImpl<KnwStatus, Integer> implements KnwStatusDao {

	public KnwStatusDaoImpl() {
		super(KnwStatus.class);
	}

}
