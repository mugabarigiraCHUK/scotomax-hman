package com.itap.callcenter.dao.impl.apc.crm;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.crm.CrmBusinessDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class CrmBusinessDaoImpl extends GenericDaoImpl<CrmBusiness, Integer> implements CrmBusinessDao {

	public CrmBusinessDaoImpl() {
		super(CrmBusiness.class);
	}

}
