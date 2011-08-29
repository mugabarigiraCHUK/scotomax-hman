package com.mt.pos.ws.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.mt.pos.ws.beans.DeviceBrand;
import com.mt.pos.ws.beans.DeviceModel;
import com.mt.pos.ws.beans.GetDeviceBrandsList;
import com.mt.pos.ws.beans.GetDeviceBrandsListResponse;
import com.mt.pos.ws.beans.GetDeviceModelsListByIdDeviceBrand;
import com.mt.pos.ws.beans.GetDeviceModelsListByIdDeviceBrandResponse;
import com.mt.pos.ws.beans.GetNumberInventory;
import com.mt.pos.ws.beans.GetNumberInventoryResponse;
import com.mt.pos.ws.beans.GetSidTypesList;
import com.mt.pos.ws.beans.GetSidTypesListResponse;
import com.mt.pos.ws.beans.GetSimAppGroupsList;
import com.mt.pos.ws.beans.GetSimAppGroupsListResponse;
import com.mt.pos.ws.beans.GetSimAppsList;
import com.mt.pos.ws.beans.GetSimAppsListResponse;
import com.mt.pos.ws.beans.GetSimInfo;
import com.mt.pos.ws.beans.GetSimInfoResponse;
import com.mt.pos.ws.beans.GetTariffPlansList;
import com.mt.pos.ws.beans.GetTariffPlansListResponse;
import com.mt.pos.ws.beans.Logon;
import com.mt.pos.ws.beans.LogonResponse;
import com.mt.pos.ws.beans.Logout;
import com.mt.pos.ws.beans.LogoutResponse;
import com.mt.pos.ws.beans.NewRegistrationByIccId;
import com.mt.pos.ws.beans.NewRegistrationByIccIdResponse;
import com.mt.pos.ws.beans.Profile;
import com.mt.pos.ws.beans.ServerResponse;
import com.mt.pos.ws.beans.SidType;
import com.mt.pos.ws.beans.SimApp;
import com.mt.pos.ws.beans.SimAppGroup;
import com.mt.pos.ws.beans.SimOutputData;
import com.mt.pos.ws.beans.TariffPlan;

public class WsController implements IWsController {
	
	final Logger logger = LoggerFactory.getLogger(WsController.class);
	
	// Http Servlet attributes
	HttpServletRequest request;
	HttpServletResponse response;
	
	// Spring application context
	ApplicationContext context;
	
	// Spring web services caller.
	WebServiceTemplate wsTemplate;
	
	/**
	 * Constructor method request HttpServlet fro initial
	 * 
	 * @param req : HttpServletRequest
	 * @param resp : HttpServletResponse
	 */
	public WsController(HttpServletRequest req, 
						HttpServletResponse resp) {
		try {
			// Setter required value
			this.request = req;
			this.response = resp;
			
			// Getting ServletContext from HttpServletRequest session
			ServletContext servletCtx = req.getSession(true).getServletContext();
			
			// Getting Spring Application Context from Web Application Context
			context = WebApplicationContextUtils.getWebApplicationContext(servletCtx);
		
			// Initial WebServiceTemplate
			wsTemplate = context.getBean(WebServiceTemplate.class);
			
		} catch ( Exception ex ) {
			logger.error("Failed to initial WebServiceTemplate from WebApplicationContext, " + ex.getMessage() );
		}
	}
	
	/**
	 * Logon into registration module and getting security token for
	 * keep communication
	 * 
	 * @param userid
	 * @param pincode
	 * @return (String) SecurityToken
	 * @throws Exception
	 */
	@Override
	public String remoteLogon( String userid, String pincode, Integer companyId ) throws Exception {
		logger.debug(" --> Call web method..");
		String securityToken = null;
		
		Logon logon = new Logon();
		logon.setCompanyId(1);
		
		if ( StringUtils.isNotEmpty(userid) &&  StringUtils.isNotEmpty(pincode) ) {
			logon.setUserId(userid);
			logon.setPinCode(pincode);
			logon.setCompanyId(companyId);
		}
		
		logger.debug(" --> Call Logon web method..");
		LogonResponse resp = (LogonResponse) wsTemplate.marshalSendAndReceive(logon);
		
		if ( resp != null && resp.getReturn() != null ) {
			ServerResponse logonResp = resp.getReturn();
			Integer respCode = logonResp.getResponseCode();
			String respDesc = logonResp.getResponseDesc();
			
			logger.debug(" --> Logon response code: " + respCode);
			logger.debug(" --> Logon response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {

				securityToken = logonResp.getSecurityToken();
				logger.debug(" --> Logon security token: " + securityToken );
				
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from Logon web method...");
		
		return securityToken;
	}

    @Override
    public Boolean remoteLogout(String securityToken) throws Exception {
        Boolean result = false;

        Logout logout = new Logout();
        logout.setSecurityToken(securityToken);

        logger.debug(" --> Call Logout web method..");
		LogoutResponse resp = (LogoutResponse) wsTemplate.marshalSendAndReceive(logout);

        if ( resp != null && resp.getReturn() != null ) {
			ServerResponse serverResponse = resp.getReturn();

			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();

			logger.debug(" --> Logout response code: " + respCode);
			logger.debug(" --> Logout response desc: " + respDesc);

			if ( respCode != null && respCode.intValue() == 0 ) {
                result = true;
				logger.debug(" --> Logout successfully.");
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );

		} else throw new Exception("No response from Logout web method...");

        return result;
    }
	
	/**
	 * Remote web method for getting Subscriber ID type
	 * available for customer selection.
	 * 
	 * @param (String) securityToken
	 * @return List of SidType.class
	 * @throws Exception
	 */
	@Override
	public List<SidType> remoteSidTypeList(String securityToken) throws Exception {
		List<SidType> listSidType = new ArrayList<SidType>();
		
		logger.debug(" --> Call GetSidTypesList web method..");
		GetSidTypesList getSidTypeList = new GetSidTypesList();
		// Setting required attributes data
		getSidTypeList.setSecurityToken(securityToken);
		
		GetSidTypesListResponse resp = (GetSidTypesListResponse) wsTemplate.marshalSendAndReceive(getSidTypeList);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> GetSidTypesList response code: " + respCode);
			logger.debug(" --> GetSidTypesList response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting Subscriber ID type list
				 */
				listSidType = serverResponse.getSidTypesLists();
				
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from GetSidTypesList web method...");
		
		return listSidType;
	}
	
	/**
	 * Remote web method for getting Mobile Operator tariff plan 
	 * available list
	 * 
	 * @param (String) securityToken
	 * @return List of TariffPlan.class
	 * @throws Exception
	 */
	@Override
	public List<TariffPlan> remoteTariffPlanList(String securityToken) throws Exception {
		List<TariffPlan> listTariffPlan = new ArrayList<TariffPlan>();
		
		logger.debug(" --> Call GetTariffPlansList web method..");
		GetTariffPlansList getTariffplanList = new GetTariffPlansList();
		// Setting required attributes data
		getTariffplanList.setSecurityToken(securityToken);
		
		GetTariffPlansListResponse resp = 
			(GetTariffPlansListResponse) wsTemplate.marshalSendAndReceive(getTariffplanList);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> GetTariffPlansList response code: " + respCode);
			logger.debug(" --> GetTariffPlansList response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting tariff plan available for selection
				 */
				listTariffPlan = serverResponse.getTariffPlansLists();
				
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from GetTariffPlansList web method...");
		
		return listTariffPlan;
	}
	
	/**
	 * Remote web method for getting mobile device brand list
	 * 
	 * @param (String) securityToken
	 * @return List of DeviceBrand.class
	 * @throws Exception
	 */
	@Override
	public List<DeviceBrand> remoteMobileDeviceBrandsList(String securityToken) 
			throws Exception {
		
		List<DeviceBrand> listDeviceBrand = new ArrayList<DeviceBrand>();
		
		logger.debug(" --> Call GetDeviceBrandsList web method..");
		GetDeviceBrandsList getDeviceBrandsList = new GetDeviceBrandsList();
		// Setting required attributes data
		getDeviceBrandsList.setSecurityToken(securityToken);
		
		GetDeviceBrandsListResponse resp = 
			(GetDeviceBrandsListResponse) wsTemplate.marshalSendAndReceive(getDeviceBrandsList);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> GetDeviceBrandsList response code: " + respCode);
			logger.debug(" --> GetDeviceBrandsList response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting mobile device brands list
				 */
				listDeviceBrand = serverResponse.getDeviceBrandsLists();
				
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from GetDeviceBrandsList web method...");
		
		return listDeviceBrand;
	}
	
	/**
	 * Remote web method for getting mobile device brand
	 * available for selection
	 * 
	 * @param IdDeviceBrad
	 * @param securityToken
	 * @return List of DeviceModel.class
	 * @throws Exception
	 */
	@Override
	public List<DeviceModel> remoteMobileModelList(Long IdDeviceBrad, 
												String securityToken) 
				throws Exception {
		List<DeviceModel> listDeviceModel = new ArrayList<DeviceModel>();
		
		logger.debug(" --> Call GetDeviceModelsListByDeviceBrand web method..");
		GetDeviceModelsListByIdDeviceBrand getDeviceModelsListByIdDeviceBrand = 
			new GetDeviceModelsListByIdDeviceBrand();
		// Setting required attributes data
		getDeviceModelsListByIdDeviceBrand.setIdDeviceBrand(IdDeviceBrad);
		getDeviceModelsListByIdDeviceBrand.setSecurityToken(securityToken);
		
		GetDeviceModelsListByIdDeviceBrandResponse resp = 
			(GetDeviceModelsListByIdDeviceBrandResponse) wsTemplate
				.marshalSendAndReceive(getDeviceModelsListByIdDeviceBrand);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> GetDeviceModelsListByIdDeviceBrand response code: " + respCode);
			logger.debug(" --> GetDeviceModelsListByIdDeviceBrand response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting mobile device model list
				 */
				listDeviceModel = serverResponse.getDeviceModelsLists();
				
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from GetDeviceModelsListByDeviceBrand web method...");
		
		return listDeviceModel;
	}
	
	/**
	 * Remote web method for getting SIM application group available 
	 * for download.
	 * 
	 * @param (String) securityToken
	 * @return List of SimAppGroup.class
	 * @throws Exception
	 */
	@Override
	public List<SimAppGroup> remoteSimAppGroupList(String securityToken) throws Exception {
		List<SimAppGroup> listSimAppGroups = new ArrayList<SimAppGroup>();
		
		logger.debug(" --> Call GetSimAppGroupsList web method..");
		GetSimAppGroupsList getSimAppGroupsList = new GetSimAppGroupsList();
		// Setting required attributes data
		getSimAppGroupsList.setSecurityToken(securityToken);
		
		GetSimAppGroupsListResponse resp = 
			(GetSimAppGroupsListResponse) wsTemplate.marshalSendAndReceive(getSimAppGroupsList);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> GetSimAppGroupsList response code: " + respCode);
			logger.debug(" --> GetSimAppGroupsList response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting SIM application group available for download.
				 */
				listSimAppGroups = serverResponse.getSimAppGroupsLists();
				
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from GetSimAppGroupsList web method...");
		
		return listSimAppGroups;
	}
	
	/**
	 * Remote web method for getting SIM application 
	 * available list for download.
	 * 
	 * @param (Integer) idSimAppGroup
	 * @param (Integer) idProfile
	 * @param (String) securityToken
	 * @return List of SimApp.class
	 * @throws Exception
	 */
	@Override
	public List<SimApp> remoteSimAppList(Integer idSimAppGroup, 
										 Integer idProfile,
										 String securityToken) 
				throws Exception {
		
		List<SimApp> listSimApp = new ArrayList<SimApp>();
		
		logger.debug(" --> Call GetSimAppsList web method..");
		
		GetSimAppsList getSimAppsList = new GetSimAppsList();
		// Setting required attributes data
		getSimAppsList.setIdSimAppGroup(idSimAppGroup);
		getSimAppsList.setIdProfile(idProfile);
		getSimAppsList.setSecurityToken(securityToken);
		
		GetSimAppsListResponse resp = 
			(GetSimAppsListResponse) wsTemplate.marshalSendAndReceive(getSimAppsList);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> GetSimAppsList response code: " + respCode);
			logger.debug(" --> GetSimAppsList response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting SIM application list
				 * available for download.
				 */
				listSimApp = serverResponse.getSimAppsLists();
				
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from GetSimAppsList web method...");
		
		return listSimApp;
	}
	
	/**
	 * Remote web method for getting SIM profile information
	 * 
	 * @param (String) simIccId
	 * @param (String) securityToken
	 * @return SIM information in Profile.class
	 * @throws Exception
	 */
	@Override
	public Profile remoteSimInfo(String simIccId,
								String securityToken) throws Exception {
		Profile profile = new Profile();
		
		logger.debug(" --> Call GetSimInfo web method..");
		
		GetSimInfo getSimInfo = new GetSimInfo();
		// Setting required attributes data
		getSimInfo.setIccId(simIccId);
		getSimInfo.setSecurityToken(securityToken);
		GetSimInfoResponse resp = 
			(GetSimInfoResponse) wsTemplate.marshalSendAndReceive(getSimInfo);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> GetSimInfo response code: " + respCode);
			logger.debug(" --> GetSimInfo response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting Sim information
				 */
				SimOutputData simOutputData = serverResponse.getSimOutputData();
				profile = simOutputData
						.getSimRecordData()
						.getOrderInputFile()
						.getOrderLineItem()
						.getSimProduct()
						.getProfile();
			
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from GetSimInfo web method...");
		
		return profile;
	}
	
	/**
	 * Remote web method for SIM registration new.
	 * 
	 * @param (String) firstName
	 * @param (String) familyName
	 * @param (String) gender
	 * @param (String) birthdate
	 * @param (Integer) idSidType
	 * @param (String) sid
	 * @param (String) address
	 * @param (String) simIccId
	 * @param (String) pMSISDN
	 * @param (Integer) idTariffPlan
	 * @param (String) securityToken
	 * @return true is the SIM registration success. otherwise is failed.
	 * @throws Exception
	 */
	@Override
	public Boolean remoteSimRegistration(String firstName,
									String familyName,
									String gender,
									String birthdate,
									Integer idSidType,
									String sid,
									String address,
									String simIccId,
									String pMSISDN,
									Integer idTariffPlan,
									String securityToken) throws Exception {
		
		logger.debug(" --> Call NewRegistrationByIccId web method..");
		
		NewRegistrationByIccId newRegistrationByIccId = new NewRegistrationByIccId();
		// Setting required attributes data
		newRegistrationByIccId.setFirstName(firstName);
		newRegistrationByIccId.setFamilyName(familyName);
		newRegistrationByIccId.setGender(gender);
		newRegistrationByIccId.setBirthDate(birthdate);
		SidType sidType = new SidType();
		sidType.setStype(new BigDecimal(idSidType));
		newRegistrationByIccId.setSidType(sidType);
		newRegistrationByIccId.setSid(sid);
		newRegistrationByIccId.setAddress(address);
		newRegistrationByIccId.setIccId(simIccId);
		newRegistrationByIccId.setMsisdn(pMSISDN);
		TariffPlan tariffPlan = new TariffPlan();
		newRegistrationByIccId.setTariffPlan(tariffPlan);
		newRegistrationByIccId.setSecurityToken(securityToken);
		
		NewRegistrationByIccIdResponse resp = 
			(NewRegistrationByIccIdResponse) wsTemplate.marshalSendAndReceive(newRegistrationByIccId);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> NewRegistrationByIccId response code: " + respCode);
			logger.debug(" --> NewRegistrationByIccId response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting SIM registration result
				 */
				logger.info("SIM registration successfully.");
			
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from NewRegistrationByIccId web method...");
		
		return true;
	}
	
	/**
	 * Remote web method for getting numbering from inventory
	 * 
	 * @param terminalId
	 * @param IdType
	 * @param KeyNumber
	 * @param booking
	 * @param maxExtract
	 * @param maxMsisdnLenght
	 * @param securityToken
	 * @return List of string of numbering from inventory
	 * @throws Exception
	 */
	@Override
	public List<String> remoteNumberInventory(Integer terminalId,
									Integer IdType,
									String KeyNumber,
									Boolean booking,
									Integer maxExtract,
									Integer maxMsisdnLenght,
									String securityToken) throws Exception {
		
		List<String> listNumberInventory = new ArrayList<String>();
		
		logger.debug(" --> Call GetNumberInventory web method..");
		
		GetNumberInventory getNumberInventory = new GetNumberInventory();
		// Setting required attributes data
		getNumberInventory.setTerminalId(terminalId);
		getNumberInventory.setIdType(IdType);
		getNumberInventory.setKeyNumb(KeyNumber);
		getNumberInventory.setBooking(booking);
		getNumberInventory.setMaxEctract(maxExtract);
		getNumberInventory.setMaxMsisdnLenght(maxMsisdnLenght);
		getNumberInventory.setSecurityToken(securityToken);
		
		GetNumberInventoryResponse resp = 
			(GetNumberInventoryResponse) wsTemplate.marshalSendAndReceive(getNumberInventory);
		
		if ( resp != null && resp.getReturn() != null ) {
			
			ServerResponse serverResponse = resp.getReturn();
			
			Integer respCode = serverResponse.getResponseCode();
			String respDesc = serverResponse.getResponseDesc();
			
			logger.debug(" --> GetNumberInventory response code: " + respCode);
			logger.debug(" --> GetNumberInventory response desc: " + respDesc);
			
			if ( respCode != null && respCode.intValue() == 0 ) {
				/*
				 * Getting SIM registration result
				 */
				listNumberInventory = serverResponse.getNumberInventories();
			
			} else throw new Exception("Code: "+respCode+", Message: " + respDesc );
			
		} else throw new Exception("No response from GetNumberInventory web method...");
		
		return listNumberInventory;
	}


}
