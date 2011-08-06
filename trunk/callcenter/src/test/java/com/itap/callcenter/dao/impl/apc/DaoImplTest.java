package com.itap.callcenter.dao.impl.apc;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.itap.callcenter.dao.apc.acd.AcdConditionDao;
import com.itap.callcenter.dao.apc.acd.AcdRouteDao;
import com.itap.callcenter.dao.apc.knw.KnwTopicDao;
import com.itap.callcenter.entity.apc.acd.AcdCondition;

/**
 * 
 * @author scotomax
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class DaoImplTest {

	@Autowired
	AcdConditionDao acdConditionDao;
	@Autowired
	AcdRouteDao acdRouteDao;
	@Autowired
	KnwTopicDao knwTopicDao;

	@Test
	public void acdConditionDaoTest() {
		System.out.println("test acdConditionDaoTest");
		System.out.println(acdRouteDao);
		System.out.println(knwTopicDao);
	}

	@Test
	public void validateBean() {
		System.out.println("test validateBean start");
		AcdCondition acdCondition = new AcdCondition();

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<AcdCondition>> constraintViolations = validator.validate(acdCondition);

		Iterator<ConstraintViolation<AcdCondition>> iter = constraintViolations.iterator();
		assertEquals(3, constraintViolations.size());
		assertEquals("may not be null", iter.next().getMessage());
		assertEquals("may not be null", iter.next().getMessage());
		assertEquals("may not be null", iter.next().getMessage());
		
		System.out.println("test validateBean finish");
	}

}
