package com.itap.callcenter.dao.impl.apc.crm;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.crm.CrmCustomerDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.crm.CrmCustomer;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class CrmCustomerDaoImpl extends GenericDaoImpl<CrmCustomer, Integer> implements CrmCustomerDao {

	public CrmCustomerDaoImpl() {
		super(CrmCustomer.class);
	}

}
