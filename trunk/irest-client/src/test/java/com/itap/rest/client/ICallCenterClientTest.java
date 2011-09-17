package com.itap.rest.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itap.rest.client.bean.XmlIvrResponse;

/**
 * 
 * @author scotomax
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class ICallCenterClientTest {
	
	Logger log4j = LoggerFactory.getLogger(ICallCenterClientTest.class);
	
	@Autowired
	ICallCenterClient iCallCenterClient;
	
	@Test
	public void execute(){
		log4j.info("Entering execute method to running unit test-case.");
		XmlIvrResponse response = iCallCenterClient.authService("admin", "adminadmin");
		
		log4j.info("Status->Code->" + response.getStatus().getResponseCode());
		log4j.info("Status->Desc->" + response.getStatus().getResponseDesc());
		
	}
	
}
