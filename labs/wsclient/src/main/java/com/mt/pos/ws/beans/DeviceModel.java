//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.09 at 07:25:26 PM ICT 
//


package com.mt.pos.ws.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for deviceModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deviceModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createdDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="deviceBrand" type="{http://rm.isl.mt.com/}deviceBrand" minOccurs="0"/>
 *         &lt;element name="deviceModelExtraName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceModelFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceModelMarketingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceModelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idDeviceModel" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="updatedDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deviceModel", namespace = "http://rm.isl.mt.com/", propOrder = {
    "createdDateTime",
    "deviceBrand",
    "deviceModelExtraName",
    "deviceModelFullName",
    "deviceModelMarketingName",
    "deviceModelName",
    "idDeviceModel",
    "isActive",
    "updatedDateTime"
})
public class DeviceModel {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDateTime;
    protected DeviceBrand deviceBrand;
    protected String deviceModelExtraName;
    protected String deviceModelFullName;
    protected String deviceModelMarketingName;
    protected String deviceModelName;
    protected Long idDeviceModel;
    protected short isActive;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedDateTime;

    /**
     * Gets the value of the createdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Sets the value of the createdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDateTime(XMLGregorianCalendar value) {
        this.createdDateTime = value;
    }

    /**
     * Gets the value of the deviceBrand property.
     * 
     * @return
     *     possible object is
     *     {@link DeviceBrand }
     *     
     */
    public DeviceBrand getDeviceBrand() {
        return deviceBrand;
    }

    /**
     * Sets the value of the deviceBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceBrand }
     *     
     */
    public void setDeviceBrand(DeviceBrand value) {
        this.deviceBrand = value;
    }

    /**
     * Gets the value of the deviceModelExtraName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceModelExtraName() {
        return deviceModelExtraName;
    }

    /**
     * Sets the value of the deviceModelExtraName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceModelExtraName(String value) {
        this.deviceModelExtraName = value;
    }

    /**
     * Gets the value of the deviceModelFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceModelFullName() {
        return deviceModelFullName;
    }

    /**
     * Sets the value of the deviceModelFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceModelFullName(String value) {
        this.deviceModelFullName = value;
    }

    /**
     * Gets the value of the deviceModelMarketingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceModelMarketingName() {
        return deviceModelMarketingName;
    }

    /**
     * Sets the value of the deviceModelMarketingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceModelMarketingName(String value) {
        this.deviceModelMarketingName = value;
    }

    /**
     * Gets the value of the deviceModelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceModelName() {
        return deviceModelName;
    }

    /**
     * Sets the value of the deviceModelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceModelName(String value) {
        this.deviceModelName = value;
    }

    /**
     * Gets the value of the idDeviceModel property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDeviceModel() {
        return idDeviceModel;
    }

    /**
     * Sets the value of the idDeviceModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDeviceModel(Long value) {
        this.idDeviceModel = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public short getIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(short value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the updatedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdatedDateTime() {
        return updatedDateTime;
    }

    /**
     * Sets the value of the updatedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdatedDateTime(XMLGregorianCalendar value) {
        this.updatedDateTime = value;
    }

}