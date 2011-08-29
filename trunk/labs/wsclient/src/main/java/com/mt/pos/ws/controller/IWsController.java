package com.mt.pos.ws.controller;

import java.util.List;

import com.mt.pos.ws.beans.DeviceBrand;
import com.mt.pos.ws.beans.DeviceModel;
import com.mt.pos.ws.beans.Profile;
import com.mt.pos.ws.beans.SidType;
import com.mt.pos.ws.beans.SimApp;
import com.mt.pos.ws.beans.SimAppGroup;
import com.mt.pos.ws.beans.TariffPlan;

public interface IWsController {

	public String remoteLogon(String userid, String pincode, Integer companyId ) throws Exception;
    public Boolean remoteLogout(String securityToken ) throws Exception;
	public List<SidType> remoteSidTypeList(String securityToken) throws Exception;
	public List<TariffPlan> remoteTariffPlanList(String securityToken) throws Exception;
	public List<DeviceBrand> remoteMobileDeviceBrandsList(String securityToken) throws Exception;
	public List<DeviceModel> remoteMobileModelList(Long IdDeviceBrad,String securityToken) throws Exception;
	public List<SimAppGroup> remoteSimAppGroupList(String securityToken) throws Exception;
	public List<SimApp> remoteSimAppList(Integer idSimAppGroup, Integer idProfile, String securityToken) throws Exception;
	public Profile remoteSimInfo(String simIccId, String securityToken) throws Exception;
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
										String securityToken) throws Exception;
	public List<String> remoteNumberInventory(Integer terminalId,
											Integer IdType,
											String KeyNumber,
											Boolean booking,
											Integer maxExtract,
											Integer maxMsisdnLenght,
											String securityToken) throws Exception;
}
