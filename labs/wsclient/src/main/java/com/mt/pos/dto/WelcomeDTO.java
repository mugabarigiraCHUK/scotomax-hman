package com.mt.pos.dto;

import com.mt.pos.ws.beans.SidType;
import com.mt.pos.ws.beans.TariffPlan;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;

public abstract class WelcomeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4859041937108523747L;

	protected String userCode;
	protected String pinCode;
	protected String companyId;
	protected String notifyMessage;

    protected List<SidType> dtSidType;
    protected List<TariffPlan> dtTariffPlan;

    protected List<SelectItem> selectionDeviceBrands;
    protected String selectedDeviceBrand;
    protected List<SelectItem> selectionDeviceModels;

    protected List<SelectItem> selectionSimAppGroups;
    protected String selectedSimAppGroup;
    protected List<SelectItem> selectionSimApplications;

    protected String simIccId;
    protected Integer idProfile;
    protected Long availableMemory;
    protected Long totalMemory;

    protected void clear() {
        userCode = null;
        pinCode = null;
        companyId = null;
        notifyMessage = null;
        selectionDeviceBrands = null;
        selectionDeviceModels = null;
        selectionSimAppGroups = null;
        selectionSimApplications = null;
    }
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getNotifyMessage() {
		return notifyMessage;
	}

	public void setNotifyMessage(String notifyMessage) {
		this.notifyMessage = notifyMessage;
	}

    public List<SelectItem> getSelectionDeviceBrands() {
        return selectionDeviceBrands;
    }

    public void setSelectionDeviceBrands(List<SelectItem> selectionDeviceBrands) {
        this.selectionDeviceBrands = selectionDeviceBrands;
    }

    public List<SelectItem> getSelectionDeviceModels() {
        return selectionDeviceModels;
    }

    public void setSelectionDeviceModels(List<SelectItem> selectionDeviceModels) {
        this.selectionDeviceModels = selectionDeviceModels;
    }

    public List<SelectItem> getSelectionSimAppGroups() {
        return selectionSimAppGroups;
    }

    public void setSelectionSimAppGroups(List<SelectItem> selectionSimAppGroups) {
        this.selectionSimAppGroups = selectionSimAppGroups;
    }

    public List<SelectItem> getSelectionSimApplications() {
        return selectionSimApplications;
    }

    public void setSelectionSimApplications(List<SelectItem> selectionSimApplications) {
        this.selectionSimApplications = selectionSimApplications;
    }

    public List<SidType> getDtSidType() {
        return dtSidType;
    }

    public void setDtSidType(List<SidType> dtSidType) {
        this.dtSidType = dtSidType;
    }

    public List<TariffPlan> getDtTariffPlan() {
        return dtTariffPlan;
    }

    public void setDtTariffPlan(List<TariffPlan> dtTariffPlan) {
        this.dtTariffPlan = dtTariffPlan;
    }

    public String getSelectedDeviceBrand() {
        return selectedDeviceBrand;
    }

    public void setSelectedDeviceBrand(String selectedDeviceBrand) {
        this.selectedDeviceBrand = selectedDeviceBrand;
    }

    public String getSelectedSimAppGroup() {
        return selectedSimAppGroup;
    }

    public void setSelectedSimAppGroup(String selectedSimAppGroup) {
        this.selectedSimAppGroup = selectedSimAppGroup;
    }

    public Long getAvailableMemory() {
        return availableMemory;
    }

    public void setAvailableMemory(Long availableMemory) {
        this.availableMemory = availableMemory;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public String getSimIccId() {
        return simIccId;
    }

    public void setSimIccId(String simIccId) {
        this.simIccId = simIccId;
    }

    public Long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(Long totalMemory) {
        this.totalMemory = totalMemory;
    }

}
