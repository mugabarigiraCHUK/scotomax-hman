package com.itap.callcenter.dao.impl.apc.crm;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.crm.CrmStatusDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.crm.CrmStatus;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class CrmStatusDaoImpl extends GenericDaoImpl<CrmStatus, Integer> implements CrmStatusDao {

	public CrmStatusDaoImpl() {
		super(CrmStatus.class);
	}

}
