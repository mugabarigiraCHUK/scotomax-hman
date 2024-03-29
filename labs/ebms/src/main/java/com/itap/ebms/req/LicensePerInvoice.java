//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.01 at 12:47:28 PM ICT 
//


package com.itap.ebms.req;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LicenseTypeInvoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicenseTypeInvoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentHeader" type="{http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0}DocumentHeaderType"/>
 *         &lt;element name="DocumentDetails" type="{http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0}DocumentDetailsTransportType" maxOccurs="5000"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseTypeInvoice", namespace = "http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0", propOrder = {
    "documentHeader",
    "documentDetails",
    "signatures"
})
@XmlRootElement(name = "LicensePerInvoice", namespace = "http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0")
public class LicensePerInvoice {

    @XmlElement(name = "DocumentHeader", required = true)
    protected DocumentHeaderType documentHeader;
    @XmlElement(name = "DocumentDetails", required = true)
    protected List<DocumentDetailsTransportType> documentDetails;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected List<Signature> signatures;

    /**
     * Gets the value of the documentHeader property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentHeaderType }
     *     
     */
    public DocumentHeaderType getDocumentHeader() {
        return documentHeader;
    }

    /**
     * Sets the value of the documentHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentHeaderType }
     *     
     */
    public void setDocumentHeader(DocumentHeaderType value) {
        this.documentHeader = value;
    }

    /**
     * Gets the value of the documentDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentDetailsTransportType }
     * 
     * 
     */
    public List<DocumentDetailsTransportType> getDocumentDetails() {
        if (documentDetails == null) {
            documentDetails = new ArrayList<DocumentDetailsTransportType>();
        }
        return this.documentDetails;
    }

    /**
     * Gets the value of the signatures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signatures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignatures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Signature }
     * 
     * 
     */
    public List<Signature> getSignatures() {
        if (signatures == null) {
            signatures = new ArrayList<Signature>();
        }
        return this.signatures;
    }

}
