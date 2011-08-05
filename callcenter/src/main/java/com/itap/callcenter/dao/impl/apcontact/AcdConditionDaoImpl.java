package com.itap.callcenter.dao.impl.apcontact;

import org.springframework.stereotype.Repository;

import com.itap.callcenter.dao.apcontact.AcdConditionDao;
import com.itap.callcenter.dao.impl.GenericDaoImpl;
import com.itap.callcenter.entity.apcontact.AcdCondition;

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
