package com.itap.callcenter.dao.impl.apc.acd;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apc.acd.AcdConditionDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apc.acd.AcdCondition;

/**
 * 
 * @author scotomax
 *
 */
@Repository
public class AcdConditionDaoImpl extends GenericDaoImpl<AcdCondition, Integer> implements AcdConditionDao {

	public AcdConditionDaoImpl() {
		super(AcdCondition.class);
	}

}
