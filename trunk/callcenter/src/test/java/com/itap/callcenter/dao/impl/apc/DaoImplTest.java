package com.itap.callcenter.dao.impl.apc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.itap.callcenter.dao.apc.acd.AcdConditionDao;
import com.itap.callcenter.dao.apc.acd.AcdRouteDao;

/**
 * 
 * @author scotomax
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class DaoImplTest {

	@Autowired AcdConditionDao acdConditionDao;
	@Autowired AcdRouteDao acdRouteDao;
	
	@Test
	@Transactional
	public void acdConditionDaoTest() {
		
	}
}
