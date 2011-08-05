package com.itap.callcenter.dao.impl.apc.acd;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.acd.AcdRouteDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.acd.AcdRoute;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AcdRouteDaoImpl extends GenericDaoImpl<AcdRoute, Integer> implements AcdRouteDao {

	public AcdRouteDaoImpl() {
		super(AcdRoute.class);
	}

}
