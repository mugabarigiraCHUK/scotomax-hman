//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.09 at 07:25:26 PM ICT 
//


package com.mt.pos.ws.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serverResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serverResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceBrandsList" type="{http://rm.isl.mt.com/}deviceBrand" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deviceModelsList" type="{http://rm.isl.mt.com/}deviceModel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numberInventory" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="regionsList" type="{http://rm.isl.mt.com/}region" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="responseDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="securityToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sidTypesList" type="{http://rm.isl.mt.com/}sidType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="simAppGroupsList" type="{http://rm.isl.mt.com/}simAppGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="simAppsList" type="{http://rm.isl.mt.com/}simApp" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="simOutputData" type="{http://rm.isl.mt.com/}simOutputData" minOccurs="0"/>
 *         &lt;element name="simPhoneBooksList" type="{http://rm.isl.mt.com/}simPhoneBook" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="simSmsList" type="{http://rm.isl.mt.com/}simSms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statusInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tariffPlansList" type="{http://rm.isl.mt.com/}tariffPlan" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serverResponse", namespace = "http://rm.isl.mt.com/", propOrder = {
    "deviceBrandsLists",
    "deviceModelsLists",
    "numberInventories",
    "regionsLists",
    "responseCode",
    "responseDesc",
    "securityToken",
    "sidTypesLists",
    "simAppGroupsLists",
    "simAppsLists",
    "simOutputData",
    "simPhoneBooksLists",
    "simSmsLists",
    "statusInformation",
    "tariffPlansLists"
})
public class ServerResponse {

    @XmlElement(name = "deviceBrandsList", nillable = true)
    protected List<DeviceBrand> deviceBrandsLists;
    @XmlElement(name = "deviceModelsList", nillable = true)
    protected List<DeviceModel> deviceModelsLists;
    @XmlElement(name = "numberInventory", nillable = true)
    protected List<String> numberInventories;
    @XmlElement(name = "regionsList", nillable = true)
    protected List<Region> regionsLists;
    protected int responseCode;
    protected String responseDesc;
    protected String securityToken;
    @XmlElement(name = "sidTypesList", nillable = true)
    protected List<SidType> sidTypesLists;
    @XmlElement(name = "simAppGroupsList", nillable = true)
    protected List<SimAppGroup> simAppGroupsLists;
    @XmlElement(name = "simAppsList", nillable = true)
    protected List<SimApp> simAppsLists;
    protected SimOutputData simOutputData;
    @XmlElement(name = "simPhoneBooksList", nillable = true)
    protected List<SimPhoneBook> simPhoneBooksLists;
    @XmlElement(name = "simSmsList", nillable = true)
    protected List<SimSms> simSmsLists;
    protected String statusInformation;
    @XmlElement(name = "tariffPlansList", nillable = true)
    protected List<TariffPlan> tariffPlansLists;

    /**
     * Gets the value of the deviceBrandsLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceBrandsLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceBrandsLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceBrand }
     * 
     * 
     */
    public List<DeviceBrand> getDeviceBrandsLists() {
        if (deviceBrandsLists == null) {
            deviceBrandsLists = new ArrayList<DeviceBrand>();
        }
        return this.deviceBrandsLists;
    }

    /**
     * Gets the value of the deviceModelsLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceModelsLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceModelsLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceModel }
     * 
     * 
     */
    public List<DeviceModel> getDeviceModelsLists() {
        if (deviceModelsLists == null) {
            deviceModelsLists = new ArrayList<DeviceModel>();
        }
        return this.deviceModelsLists;
    }

    /**
     * Gets the value of the numberInventories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the numberInventories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNumberInventories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNumberInventories() {
        if (numberInventories == null) {
            numberInventories = new ArrayList<String>();
        }
        return this.numberInventories;
    }

    /**
     * Gets the value of the regionsLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionsLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionsLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Region }
     * 
     * 
     */
    public List<Region> getRegionsLists() {
        if (regionsLists == null) {
            regionsLists = new ArrayList<Region>();
        }
        return this.regionsLists;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     */
    public void setResponseCode(int value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseDesc() {
        return responseDesc;
    }

    /**
     * Sets the value of the responseDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseDesc(String value) {
        this.responseDesc = value;
    }

    /**
     * Gets the value of the securityToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityToken() {
        return securityToken;
    }

    /**
     * Sets the value of the securityToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityToken(String value) {
        this.securityToken = value;
    }

    /**
     * Gets the value of the sidTypesLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sidTypesLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSidTypesLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SidType }
     * 
     * 
     */
    public List<SidType> getSidTypesLists() {
        if (sidTypesLists == null) {
            sidTypesLists = new ArrayList<SidType>();
        }
        return this.sidTypesLists;
    }

    /**
     * Gets the value of the simAppGroupsLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simAppGroupsLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimAppGroupsLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimAppGroup }
     * 
     * 
     */
    public List<SimAppGroup> getSimAppGroupsLists() {
        if (simAppGroupsLists == null) {
            simAppGroupsLists = new ArrayList<SimAppGroup>();
        }
        return this.simAppGroupsLists;
    }

    /**
     * Gets the value of the simAppsLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simAppsLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimAppsLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimApp }
     * 
     * 
     */
    public List<SimApp> getSimAppsLists() {
        if (simAppsLists == null) {
            simAppsLists = new ArrayList<SimApp>();
        }
        return this.simAppsLists;
    }

    /**
     * Gets the value of the simOutputData property.
     * 
     * @return
     *     possible object is
     *     {@link SimOutputData }
     *     
     */
    public SimOutputData getSimOutputData() {
        return simOutputData;
    }

    /**
     * Sets the value of the simOutputData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimOutputData }
     *     
     */
    public void setSimOutputData(SimOutputData value) {
        this.simOutputData = value;
    }

    /**
     * Gets the value of the simPhoneBooksLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simPhoneBooksLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimPhoneBooksLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimPhoneBook }
     * 
     * 
     */
    public List<SimPhoneBook> getSimPhoneBooksLists() {
        if (simPhoneBooksLists == null) {
            simPhoneBooksLists = new ArrayList<SimPhoneBook>();
        }
        return this.simPhoneBooksLists;
    }

    /**
     * Gets the value of the simSmsLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simSmsLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimSmsLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimSms }
     * 
     * 
     */
    public List<SimSms> getSimSmsLists() {
        if (simSmsLists == null) {
            simSmsLists = new ArrayList<SimSms>();
        }
        return this.simSmsLists;
    }

    /**
     * Gets the value of the statusInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusInformation() {
        return statusInformation;
    }

    /**
     * Sets the value of the statusInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusInformation(String value) {
        this.statusInformation = value;
    }

    /**
     * Gets the value of the tariffPlansLists property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariffPlansLists property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariffPlansLists().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TariffPlan }
     * 
     * 
     */
    public List<TariffPlan> getTariffPlansLists() {
        if (tariffPlansLists == null) {
            tariffPlansLists = new ArrayList<TariffPlan>();
        }
        return this.tariffPlansLists;
    }

}
