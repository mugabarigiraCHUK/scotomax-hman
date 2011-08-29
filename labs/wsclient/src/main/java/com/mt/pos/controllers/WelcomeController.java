package com.mt.pos.controllers;

import com.mt.pos.dto.WelcomeDTO;
import com.mt.pos.ws.beans.DeviceBrand;
import com.mt.pos.ws.beans.DeviceModel;
import com.mt.pos.ws.beans.Profile;
import com.mt.pos.ws.beans.SidType;
import com.mt.pos.ws.beans.SimApp;
import com.mt.pos.ws.beans.SimAppGroup;
import com.mt.pos.ws.beans.TariffPlan;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mt.pos.ws.controller.IWsController;
import com.mt.pos.ws.controller.WsController;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@ViewScoped
public class WelcomeController extends WelcomeDTO {

    /**
     *
     */
    private static final long serialVersionUID = -7404399529608308592L;

    final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    IWsController wsController;

    String securityToken;

    public String getSecurityToken() {
        return securityToken;
    }

    public WelcomeController() {
        HttpServletRequest request =
                (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response =
                (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        wsController = new WsController(request, response);
    }

    
    public void logon() {
        logger.info("Entering into logon()...");
        if (userCode != null && userCode.trim().length() > 0) {
            if (userCode != null && userCode.trim().length() > 0) {
                if (isDigit(companyId)) {
                    try {
                        securityToken = wsController.remoteLogon(userCode, pinCode, Integer.parseInt(companyId));
                        notifyMessage = "Successfully, [" + securityToken + "]";

                        // Getting subscriber ID type available list.
                        subscriberTypes();
                        // Getting  tariff plan available list.
                        tariffPlan();
                        // Getting mobile device brands available list.
                        deviceBrands();
                        // Getting Sim applicaton available group list.
                        simAppGroup();

                    } catch (Exception ex) {
                        notifyMessage = ex.getMessage();
                    }
                } else {
                    notifyMessage = "Please enter/correct your company Id (Digit).";
                }
            } else {
                notifyMessage = "Please enter your PIN code.";
            }
        } else {
            notifyMessage = "Please enter your user code.";
        }
    }

    public void refresh() {
        logger.info("Entering into refresh()...");
        // Getting subscriber ID type available list.
        subscriberTypes();
        // Getting  tariff plan available list.
        tariffPlan();
        // Getting mobile device brands available list.
        deviceBrands();
        // Getting Sim applicaton available group list.
        simAppGroup();

        notifyMessage = "Data refresh successfully.";
    }

    public void logout() {
        logger.info("Entering into logout()...");
        try {
            if ( wsController.remoteLogout(securityToken) ) {
                securityToken = "";
                clear();
                notifyMessage = "Logout successfully.";
            }
        } catch (Exception ex) {
            logger.error("Failed to logout, " + ex.getMessage() );
        }
    }

    public void subscriberTypes() {
        logger.info("Entering into subscriberTypes()...");
        try {
            if (dtSidType == null)
                dtSidType = new ArrayList<SidType>();
            dtSidType.clear();
            logger.info("Security token key: "+securityToken);
            if (StringUtils.isNotEmpty(securityToken)) {
                dtSidType = wsController.remoteSidTypeList(securityToken);
                logger.info("Subscriber type number of rows: " + dtSidType.size() );
            } else logger.info("No security token for communicate with web methods.");
        } catch ( Exception ex ) {
            notifyMessage = ex.getMessage();
            logger.error("Failed to getting subscriber type from web services, " + ex.getMessage() );
        }
    }

    public void tariffPlan() {
        logger.info("Entering into tariifPlan()...");
        try {
            if ( dtTariffPlan == null )
                dtTariffPlan = new ArrayList<TariffPlan>();
            dtTariffPlan.clear();
            logger.info("Security token key: "+securityToken);
            if (StringUtils.isNotEmpty(securityToken)) {
                dtTariffPlan = wsController.remoteTariffPlanList(securityToken);
                logger.info("Tariff plan number of rows: " + dtTariffPlan.size() );
            } else logger.info("No security token for communicate with web methods.");
        } catch ( Exception ex ) {
            notifyMessage = ex.getMessage();
            logger.error("Failed to getting tariff plan from web services, " + ex.getMessage() );
        }
    }

    public void deviceBrands() {
        logger.info("Entering into deviceBrands()...");
        try {
            if ( selectionDeviceBrands == null )
                selectionDeviceBrands = new ArrayList<SelectItem>();
            selectionDeviceBrands.clear();
            logger.info("Security token key: "+securityToken);
            if (StringUtils.isNotEmpty(securityToken)) {
                List<DeviceBrand> result = wsController.remoteMobileDeviceBrandsList(securityToken);
                if ( result != null && result.size() > 0) {
                    logger.info("Device brands number of rows: " + result.size() );
                    for ( DeviceBrand device : result ) {
                        if ( device.isMajorBrand() ) {
                            selectionDeviceBrands.add(new SelectItem(device.getIdDeviceBrand(), device.getDeviceBrand()));
                        }
                    }
                } else logger.warn("No data result return from web services.");
            } else logger.info("No security token for communicate with web methods.");
        } catch ( Exception ex ) {
            notifyMessage = ex.getMessage();
            logger.error("Failed to getting mobile device brands from web services, " + ex.getMessage() );
        }
    }

    public void changeDeviceBrand() {
        logger.info("Entering into changeDeviceBrand(ValueChangeEvent ...)...");
        try {
            if ( selectionDeviceModels == null )
                selectionDeviceModels = new ArrayList<SelectItem>();
            selectionDeviceModels.clear();
            logger.info("Security token key: "+securityToken);
            if (StringUtils.isNotEmpty(securityToken)) {
                logger.info("ID device brand selected: " + selectedDeviceBrand );
                if ( StringUtils.isNotEmpty(selectedDeviceBrand) && StringUtils.isNumeric(selectedDeviceBrand) ) {
                    Long idDeviceBrand = new Long(selectedDeviceBrand);
                    List<DeviceModel> result = wsController.remoteMobileModelList(idDeviceBrand, securityToken);
                    if ( result != null && result.size() > 0) {
                        logger.info("Device brands number of rows: " + result.size() );
                        for ( DeviceModel device : result ) {
                            selectionDeviceModels.add(new SelectItem(device.getIdDeviceModel(), device.getDeviceModelName()));
                        }
                        notifyMessage = "List mobile device model by brand successfully.";
                    } else {
                        notifyMessage = "No data result return from web services.";
                        logger.warn("No data result return from web services.");
                    }
                } else {
                    notifyMessage = "Incompatible data selected for finding mobile device model.";
                    logger.warn("Incompatible data selected for finding mobile device model.");
                }
            } else {
                notifyMessage = "No security token for communicate with web methods.";
                logger.info("No security token for communicate with web methods.");
            }
        } catch ( Exception ex ) {
            notifyMessage = ex.getMessage();
            logger.error("Failed to getting mobile device model by brand from web services, " + ex.getMessage() );
        }
    }


    public void simAppGroup() {
        logger.info("Entering into simAppGroup()...");
        try {
            if ( selectionSimAppGroups == null )
                selectionSimAppGroups = new ArrayList<SelectItem>();
            selectionSimAppGroups.clear();
            logger.info("Security token key: "+securityToken);
            if (StringUtils.isNotEmpty(securityToken)) {
                List<SimAppGroup> result = wsController.remoteSimAppGroupList(securityToken);
                if ( result != null && result.size() > 0) {
                    logger.info("Sim application group number of rows: " + result.size() );
                    for ( SimAppGroup group : result ) {
                        selectionSimAppGroups.add(new SelectItem(group.getIdSimAppGroup(), group.getSimAppGroupName()));
                    }
                } else logger.warn("No data result return from web services.");
            } else logger.info("No security token for communicate with web methods.");
        } catch ( Exception ex ) {
            notifyMessage = ex.getMessage();
            logger.error("Failed to getting Sim app group from web services, " + ex.getMessage() );
        }
    }

    public void simProfile() {
        logger.info("Entering into getterSimProfile()...");
        try {
            logger.info("Security token key: "+securityToken);
            if (StringUtils.isNotEmpty(securityToken)) {
                if ( StringUtils.isNotEmpty(simIccId)) {
                    Profile sim = wsController.remoteSimInfo(simIccId, securityToken);
                    idProfile = sim.getIdProfile();
                    availableMemory = sim.getAvailableMemory();
                    totalMemory = sim.getTotalMemory();
                    notifyMessage = "Getting SIM profile successfully.";
                } else {
                    notifyMessage = "Please enter SIM ICCID first.";
                    logger.warn("Please enter SIM ICCID first.");
                }
            } else {
                notifyMessage = "No security token for communicate with web methods.";
                logger.info("No security token for communicate with web methods.");
            }
        } catch ( Exception ex ) {
            notifyMessage = ex.getMessage();
            logger.error("Failed to getting Sim profile from web services, " + ex.getMessage() );
        }
    }

    public void changeSimAppGroup() {
        logger.info("Entering into changeSimAppGroup(ValueChangeEvent ...)...");
        try {
           if ( selectionSimApplications == null )
                selectionSimApplications = new ArrayList<SelectItem>();
            selectionSimApplications.clear();
            logger.info("Security token key: "+securityToken);
            if (StringUtils.isNotEmpty(securityToken)) {
                logger.info("ID device brand selected: " + selectedSimAppGroup );
                if ( StringUtils.isNotEmpty(selectedSimAppGroup) && StringUtils.isNumeric(selectedSimAppGroup) ) {
                    Integer idSimAppGroup = Integer.parseInt(selectedSimAppGroup);

                    if (idProfile != null) {
                        List<SimApp> result = wsController.remoteSimAppList(idSimAppGroup, idProfile, securityToken);
                        if ( result != null && result.size() > 0) {
                            logger.info("Device brands number of rows: " + result.size() );
                            for ( SimApp app : result ) {
                                selectionSimApplications.add(new SelectItem(app.getIdSimApp(), app.getSimAppName()));
                            }
                            notifyMessage = "List mobile device model by brand successfully.";
                        } else {
                            notifyMessage = "No data result return from web services.";
                            logger.warn("No data result return from web services.");
                        }
                    } else {
                        notifyMessage = "No id SIM profile for processing.";
                        logger.warn("No id SIM profile for processing.");
                    }
                } else {
                    notifyMessage = "Incompatible data selected for finding mobile device model.";
                    logger.warn("Incompatible data selected for finding mobile device model.");
                }
            } else {
                notifyMessage = "No security token for communicate with web methods.";
                logger.info("No security token for communicate with web methods.");
            }
        } catch ( Exception ex ) {
            notifyMessage = ex.getMessage();
            logger.error("Failed to getting Sim apps by group from web services, " + ex.getMessage() );
        }
    }


    /**
     * Internal method for validate input is only digit.
     *
     * @param obj
     * @return result of validate
     */
    private boolean isDigit(String obj) {
        if (obj == null) {
            return false;
        }
        if (obj.trim().length() == 0) {
            return false;
        }
        for (char ch : obj.trim().toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

}
