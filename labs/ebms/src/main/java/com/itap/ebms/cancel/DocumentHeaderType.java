//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.01 at 12:53:12 PM ICT 
//


package com.itap.ebms.cancel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentReference" type="{http://ebxml.customs.go.th/schema/LicenseCancelMsg_0_1}DocumentReferenceType"/>
 *         &lt;element name="LicenseInfo" type="{http://ebxml.customs.go.th/schema/LicenseCancelMsg_0_1}LicenseInfoType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentHeaderType", namespace = "http://ebxml.customs.go.th/schema/LicenseCancelMsg_0_1", propOrder = {
    "documentReference",
    "licenseInfo"
})
public class DocumentHeaderType {

    @XmlElement(name = "DocumentReference", required = true)
    protected DocumentReferenceType documentReference;
    @XmlElement(name = "LicenseInfo", required = true)
    protected LicenseInfoType licenseInfo;

    /**
     * Gets the value of the documentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getDocumentReference() {
        return documentReference;
    }

    /**
     * Sets the value of the documentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setDocumentReference(DocumentReferenceType value) {
        this.documentReference = value;
    }

    /**
     * Gets the value of the licenseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseInfoType }
     *     
     */
    public LicenseInfoType getLicenseInfo() {
        return licenseInfo;
    }

    /**
     * Sets the value of the licenseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseInfoType }
     *     
     */
    public void setLicenseInfo(LicenseInfoType value) {
        this.licenseInfo = value;
    }

}
