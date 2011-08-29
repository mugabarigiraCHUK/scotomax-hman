package com.mt.pos.ws.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.mt.pos.ws.beans.DeviceBrand;
import com.mt.pos.ws.beans.GetDeviceBrandsList;
import com.mt.pos.ws.beans.GetDeviceBrandsListResponse;
import com.mt.pos.ws.beans.GetSidTypesList;
import com.mt.pos.ws.beans.GetSidTypesListResponse;
import com.mt.pos.ws.beans.GetTariffPlansList;
import com.mt.pos.ws.beans.GetTariffPlansListResponse;
import com.mt.pos.ws.beans.Logon;
import com.mt.pos.ws.beans.LogonResponse;
import com.mt.pos.ws.beans.ServerResponse;
import com.mt.pos.ws.beans.SidType;
import com.mt.pos.ws.beans.TariffPlan;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class WsTest {

	final Logger logger = LoggerFactory.getLogger(WsTest.class);
	
	@Autowired WebServiceTemplate wsTemplate;
	
	String securityTaken;
	
	@Test
	public void logonTest() {
		
		logger.info(" *** Entering logon.");
		
		Logon logon = new Logon();
		logon.setCompanyId(1);
		logon.setUserId("100000");
		logon.setPinCode("0000");
		LogonResponse resp = (LogonResponse) wsTemplate.marshalSendAndReceive(logon);
		if ( resp != null ) {
			if ( resp.getReturn() != null ) {
				logger.info("Response core: " + resp.getReturn().getResponseCode() );
				logger.info("Response desc: " + resp.getReturn().getResponseDesc() );
				logger.info("Status Info: " + resp.getReturn().getStatusInformation() );
				
				securityTaken = resp.getReturn().getSecurityToken();
				logger.info("Security Toke: " + securityTaken );
				
				
				logger.info(" *** Entering Subscribe ID type with security token: "+securityTaken );
				
				GetSidTypesList sidTypes = new GetSidTypesList();
				sidTypes.setSecurityToken(securityTaken);
				
				GetSidTypesListResponse resp1 = (GetSidTypesListResponse) wsTemplate.marshalSendAndReceive(sidTypes);
				if ( resp1 != null ) {
					if ( resp1.getReturn() != null ) {
						
						ServerResponse sidTypesResp = resp1.getReturn();
						
						logger.info("Response core: " + sidTypesResp.getResponseCode());
						logger.info("Response desc: " + sidTypesResp.getResponseDesc());
						
						if ( sidTypesResp.getSidTypesLists() != null ) {
							for ( SidType sidType : sidTypesResp.getSidTypesLists() ) {
								logger.info("Subscribe ID type: " + sidType.getType() );
							}
						}
						
					} else logger.warn("Return object is null!");
				} else logger.error("Responding result object from WebServices is null!");
				
				
				logger.info(" *** Entering tariff plan with security token: "+securityTaken );
				
				GetTariffPlansList tariffPlan = new GetTariffPlansList();
				tariffPlan.setSecurityToken(securityTaken);
				
				GetTariffPlansListResponse resp2 = (GetTariffPlansListResponse) wsTemplate.marshalSendAndReceive(tariffPlan);
				if ( resp2 != null ) {
					if ( resp2.getReturn() != null ) {
						
						ServerResponse tariffPlanResp = resp2.getReturn();
						
						logger.info("Response core: " + tariffPlanResp.getResponseCode());
						logger.info("Response desc: " + tariffPlanResp.getResponseDesc());
						
						if ( tariffPlanResp.getTariffPlansLists() != null ) {
							for ( TariffPlan tariff : tariffPlanResp.getTariffPlansLists() ) {
								logger.info("Tariff plan ID: " + tariff.getPlanId() );
								logger.info("Tariff plan title: " + tariff.getTitle() );
								logger.info("Tariff plan desc: " + tariff.getDescription() );
							}
						}
						
					} else logger.warn("Return object is null!");
				} else logger.error("Responding result object from WebServices is null!");
				
				
				logger.info(" *** Entering mobile brands with security token: "+securityTaken );
				
				GetDeviceBrandsList mBrands = new GetDeviceBrandsList();
				mBrands.setSecurityToken(securityTaken);
				
				GetDeviceBrandsListResponse resp3 = (GetDeviceBrandsListResponse) wsTemplate.marshalSendAndReceive(mBrands);
				if ( resp3 != null ) {
					if ( resp3.getReturn() != null ) {
						
						ServerResponse mBrandsResp = resp3.getReturn();
						
						logger.info("Response core: " + mBrandsResp.getResponseCode());
						logger.info("Response desc: " + mBrandsResp.getResponseDesc());
						
						if ( mBrandsResp.getDeviceBrandsLists() != null ) {
							for ( DeviceBrand device : mBrandsResp.getDeviceBrandsLists() ) {
								logger.info("Device brands: " + device.getDeviceBrand() );
							}
						}
						
					} else logger.warn("Return object is null!");
				} else logger.error("Responding result object from WebServices is null!");
				
			} else logger.warn("Return object is null!");
		} else logger.error("Responding result object from WebServices is null!");
		
	}
	
}
