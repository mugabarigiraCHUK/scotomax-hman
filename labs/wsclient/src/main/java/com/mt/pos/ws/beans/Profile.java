//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.09 at 07:25:26 PM ICT 
//


package com.mt.pos.ws.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for profile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="profile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="availableMemory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="company" type="{http://rm.isl.mt.com/}company" minOccurs="0"/>
 *         &lt;element name="electricalProfile" type="{http://rm.isl.mt.com/}electricalProfile" minOccurs="0"/>
 *         &lt;element name="graphicalProfile" type="{http://rm.isl.mt.com/}graphicalProfile" minOccurs="0"/>
 *         &lt;element name="idProfile" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalMemory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "profile", namespace = "http://rm.isl.mt.com/", propOrder = {
    "availableMemory",
    "company",
    "electricalProfile",
    "graphicalProfile",
    "idProfile",
    "totalMemory"
})
public class Profile {

    protected Long availableMemory;
    protected Company company;
    protected ElectricalProfile electricalProfile;
    protected GraphicalProfile graphicalProfile;
    protected Integer idProfile;
    protected Long totalMemory;

    /**
     * Gets the value of the availableMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAvailableMemory() {
        return availableMemory;
    }

    /**
     * Sets the value of the availableMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAvailableMemory(Long value) {
        this.availableMemory = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    public void setCompany(Company value) {
        this.company = value;
    }

    /**
     * Gets the value of the electricalProfile property.
     * 
     * @return
     *     possible object is
     *     {@link ElectricalProfile }
     *     
     */
    public ElectricalProfile getElectricalProfile() {
        return electricalProfile;
    }

    /**
     * Sets the value of the electricalProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectricalProfile }
     *     
     */
    public void setElectricalProfile(ElectricalProfile value) {
        this.electricalProfile = value;
    }

    /**
     * Gets the value of the graphicalProfile property.
     * 
     * @return
     *     possible object is
     *     {@link GraphicalProfile }
     *     
     */
    public GraphicalProfile getGraphicalProfile() {
        return graphicalProfile;
    }

    /**
     * Sets the value of the graphicalProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphicalProfile }
     *     
     */
    public void setGraphicalProfile(GraphicalProfile value) {
        this.graphicalProfile = value;
    }

    /**
     * Gets the value of the idProfile property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProfile() {
        return idProfile;
    }

    /**
     * Sets the value of the idProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProfile(Integer value) {
        this.idProfile = value;
    }

    /**
     * Gets the value of the totalMemory property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalMemory() {
        return totalMemory;
    }

    /**
     * Sets the value of the totalMemory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalMemory(Long value) {
        this.totalMemory = value;
    }

}
