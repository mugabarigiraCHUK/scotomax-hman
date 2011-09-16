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
 * <p>Java class for orderLineItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderLineItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="electricalProfile" type="{http://rm.isl.mt.com/}electricalProfile" minOccurs="0"/>
 *         &lt;element name="graphicalProfile" type="{http://rm.isl.mt.com/}graphicalProfile" minOccurs="0"/>
 *         &lt;element name="idOrderLineItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="orderQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="simOrder" type="{http://rm.isl.mt.com/}simOrder" minOccurs="0"/>
 *         &lt;element name="simProduct" type="{http://rm.isl.mt.com/}simProduct" minOccurs="0"/>
 *         &lt;element name="transportKey" type="{http://rm.isl.mt.com/}transportKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderLineItem", namespace = "http://rm.isl.mt.com/", propOrder = {
    "electricalProfile",
    "graphicalProfile",
    "idOrderLineItem",
    "orderQuantity",
    "simOrder",
    "simProduct",
    "transportKey"
})
public class OrderLineItem {

    protected ElectricalProfile electricalProfile;
    protected GraphicalProfile graphicalProfile;
    protected Integer idOrderLineItem;
    protected int orderQuantity;
    protected SimOrder simOrder;
    protected SimProduct simProduct;
    protected TransportKey transportKey;

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
     * Gets the value of the idOrderLineItem property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdOrderLineItem() {
        return idOrderLineItem;
    }

    /**
     * Sets the value of the idOrderLineItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdOrderLineItem(Integer value) {
        this.idOrderLineItem = value;
    }

    /**
     * Gets the value of the orderQuantity property.
     * 
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * Sets the value of the orderQuantity property.
     * 
     */
    public void setOrderQuantity(int value) {
        this.orderQuantity = value;
    }

    /**
     * Gets the value of the simOrder property.
     * 
     * @return
     *     possible object is
     *     {@link SimOrder }
     *     
     */
    public SimOrder getSimOrder() {
        return simOrder;
    }

    /**
     * Sets the value of the simOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimOrder }
     *     
     */
    public void setSimOrder(SimOrder value) {
        this.simOrder = value;
    }

    /**
     * Gets the value of the simProduct property.
     * 
     * @return
     *     possible object is
     *     {@link SimProduct }
     *     
     */
    public SimProduct getSimProduct() {
        return simProduct;
    }

    /**
     * Sets the value of the simProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimProduct }
     *     
     */
    public void setSimProduct(SimProduct value) {
        this.simProduct = value;
    }

    /**
     * Gets the value of the transportKey property.
     * 
     * @return
     *     possible object is
     *     {@link TransportKey }
     *     
     */
    public TransportKey getTransportKey() {
        return transportKey;
    }

    /**
     * Sets the value of the transportKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportKey }
     *     
     */
    public void setTransportKey(TransportKey value) {
        this.transportKey = value;
    }

}