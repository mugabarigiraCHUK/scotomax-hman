package com.itap.rest.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itap.rest.client.bean.XmlIvrParam;
import com.itap.rest.client.bean.XmlIvrParams;
import com.itap.rest.client.bean.XmlIvrRequest;
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
		log4j.info(" *** Entering execute Authenticate REST services.");
		XmlIvrResponse response = iCallCenterClient.authService("admin", "adminadmin");
		
		log4j.info("Status->Code->" + response.getStatus().getResponseCode());
		log4j.info("Status->Desc->" + response.getStatus().getResponseDesc());
		
	}
	
	@Test
	public void callback(){
		log4j.info(" *** Entering execute Call-back REST services.");
		
		XmlIvrRequest request = new XmlIvrRequest();
		XmlIvrParams params = new XmlIvrParams();
		List<XmlIvrParam> paramList = new ArrayList<XmlIvrParam>();
		
		XmlIvrParam param = new XmlIvrParam();
		param.setName("fullname");
		param.setValue("Mr. Steve Job");
		paramList.add(param);
		
		param = new XmlIvrParam();
		param.setName("mobile");
		param.setValue("99813747473");
		paramList.add(param);
		
		param = new XmlIvrParam();
		param.setName("dollar");
		param.setValue("120");
		paramList.add(param);
		
		params.setParam(paramList);
		request.setParams(params);
		
		XmlIvrResponse response = iCallCenterClient.callback(request);
		
		log4j.info("Status->Code->" + response.getStatus().getResponseCode());
		log4j.info("Status->Desc->" + response.getStatus().getResponseDesc());
	
	}
	
}
