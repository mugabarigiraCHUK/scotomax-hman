//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.01 at 12:47:28 PM ICT 
//


package com.itap.ebms.req;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentDetailsTransportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentDetailsTransportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceInfo" type="{http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0}InvoiceInfoType"/>
 *         &lt;element name="DeclarationLineNo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;totalDigits value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TariffInfo" type="{http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0}CustomsTariffQuantityType" minOccurs="0"/>
 *         &lt;element name="ProductInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WeightInfo" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Weight" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="11"/>
 *                                   &lt;fractionDigits value="3"/>
 *                                   &lt;maxInclusive value="99999999.999"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="UnitCode" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="3"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="QuantityInfo" type="{http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0}QuantityType"/>
 *                   &lt;element name="RegistrationNumber" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="35"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BodyNo" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="35"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="EngineNo" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="35"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Displacement" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;totalDigits value="7"/>
 *                         &lt;fractionDigits value="2"/>
 *                         &lt;maxInclusive value="99999.99"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ModelCode" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="35"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Year" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;totalDigits value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="BrandName" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="35"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CountryCode" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Characteristic" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="256"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CountryCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Remark" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="256"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentDetailsTransportType", namespace = "http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0", propOrder = {
    "invoiceInfo",
    "declarationLineNo",
    "tariffInfo",
    "productInfo",
    "countryCode",
    "remark"
})
public class DocumentDetailsTransportType {

    @XmlElement(name = "InvoiceInfo", required = true)
    protected InvoiceInfoType invoiceInfo;
    @XmlElement(name = "DeclarationLineNo")
    protected BigInteger declarationLineNo;
    @XmlElement(name = "TariffInfo")
    protected CustomsTariffQuantityType tariffInfo;
    @XmlElement(name = "ProductInfo")
    protected DocumentDetailsTransportType.ProductInfo productInfo;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "Remark")
    protected String remark;

    /**
     * Gets the value of the invoiceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceInfoType }
     *     
     */
    public InvoiceInfoType getInvoiceInfo() {
        return invoiceInfo;
    }

    /**
     * Sets the value of the invoiceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceInfoType }
     *     
     */
    public void setInvoiceInfo(InvoiceInfoType value) {
        this.invoiceInfo = value;
    }

    /**
     * Gets the value of the declarationLineNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeclarationLineNo() {
        return declarationLineNo;
    }

    /**
     * Sets the value of the declarationLineNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeclarationLineNo(BigInteger value) {
        this.declarationLineNo = value;
    }

    /**
     * Gets the value of the tariffInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CustomsTariffQuantityType }
     *     
     */
    public CustomsTariffQuantityType getTariffInfo() {
        return tariffInfo;
    }

    /**
     * Sets the value of the tariffInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomsTariffQuantityType }
     *     
     */
    public void setTariffInfo(CustomsTariffQuantityType value) {
        this.tariffInfo = value;
    }

    /**
     * Gets the value of the productInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentDetailsTransportType.ProductInfo }
     *     
     */
    public DocumentDetailsTransportType.ProductInfo getProductInfo() {
        return productInfo;
    }

    /**
     * Sets the value of the productInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentDetailsTransportType.ProductInfo }
     *     
     */
    public void setProductInfo(DocumentDetailsTransportType.ProductInfo value) {
        this.productInfo = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="WeightInfo" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Weight" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="11"/>
     *                         &lt;fractionDigits value="3"/>
     *                         &lt;maxInclusive value="99999999.999"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="UnitCode" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="3"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="QuantityInfo" type="{http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_3_0}QuantityType"/>
     *         &lt;element name="RegistrationNumber" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="35"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BodyNo" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="35"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="EngineNo" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="35"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Displacement" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;totalDigits value="7"/>
     *               &lt;fractionDigits value="2"/>
     *               &lt;maxInclusive value="99999.99"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ModelCode" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="35"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Year" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;totalDigits value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="BrandName" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="35"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CountryCode" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Characteristic" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="256"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "weightInfo",
        "quantityInfo",
        "registrationNumber",
        "bodyNo",
        "engineNo",
        "displacement",
        "modelCode",
        "year",
        "brandName",
        "countryCode",
        "characteristic"
    })
    public static class ProductInfo {

        @XmlElement(name = "WeightInfo")
        protected DocumentDetailsTransportType.ProductInfo.WeightInfo weightInfo;
        @XmlElement(name = "QuantityInfo", required = true)
        protected QuantityType quantityInfo;
        @XmlElement(name = "RegistrationNumber")
        protected String registrationNumber;
        @XmlElement(name = "BodyNo")
        protected String bodyNo;
        @XmlElement(name = "EngineNo")
        protected String engineNo;
        @XmlElement(name = "Displacement")
        protected BigDecimal displacement;
        @XmlElement(name = "ModelCode")
        protected String modelCode;
        @XmlElement(name = "Year")
        protected BigInteger year;
        @XmlElement(name = "BrandName")
        protected String brandName;
        @XmlElement(name = "CountryCode")
        protected String countryCode;
        @XmlElement(name = "Characteristic")
        protected String characteristic;

        /**
         * Gets the value of the weightInfo property.
         * 
         * @return
         *     possible object is
         *     {@link DocumentDetailsTransportType.ProductInfo.WeightInfo }
         *     
         */
        public DocumentDetailsTransportType.ProductInfo.WeightInfo getWeightInfo() {
            return weightInfo;
        }

        /**
         * Sets the value of the weightInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DocumentDetailsTransportType.ProductInfo.WeightInfo }
         *     
         */
        public void setWeightInfo(DocumentDetailsTransportType.ProductInfo.WeightInfo value) {
            this.weightInfo = value;
        }

        /**
         * Gets the value of the quantityInfo property.
         * 
         * @return
         *     possible object is
         *     {@link QuantityType }
         *     
         */
        public QuantityType getQuantityInfo() {
            return quantityInfo;
        }

        /**
         * Sets the value of the quantityInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link QuantityType }
         *     
         */
        public void setQuantityInfo(QuantityType value) {
            this.quantityInfo = value;
        }

        /**
         * Gets the value of the registrationNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegistrationNumber() {
            return registrationNumber;
        }

        /**
         * Sets the value of the registrationNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegistrationNumber(String value) {
            this.registrationNumber = value;
        }

        /**
         * Gets the value of the bodyNo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBodyNo() {
            return bodyNo;
        }

        /**
         * Sets the value of the bodyNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBodyNo(String value) {
            this.bodyNo = value;
        }

        /**
         * Gets the value of the engineNo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEngineNo() {
            return engineNo;
        }

        /**
         * Sets the value of the engineNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEngineNo(String value) {
            this.engineNo = value;
        }

        /**
         * Gets the value of the displacement property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDisplacement() {
            return displacement;
        }

        /**
         * Sets the value of the displacement property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDisplacement(BigDecimal value) {
            this.displacement = value;
        }

        /**
         * Gets the value of the modelCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModelCode() {
            return modelCode;
        }

        /**
         * Sets the value of the modelCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModelCode(String value) {
            this.modelCode = value;
        }

        /**
         * Gets the value of the year property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getYear() {
            return year;
        }

        /**
         * Sets the value of the year property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setYear(BigInteger value) {
            this.year = value;
        }

        /**
         * Gets the value of the brandName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrandName() {
            return brandName;
        }

        /**
         * Sets the value of the brandName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrandName(String value) {
            this.brandName = value;
        }

        /**
         * Gets the value of the countryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryCode() {
            return countryCode;
        }

        /**
         * Sets the value of the countryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryCode(String value) {
            this.countryCode = value;
        }

        /**
         * Gets the value of the characteristic property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharacteristic() {
            return characteristic;
        }

        /**
         * Sets the value of the characteristic property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharacteristic(String value) {
            this.characteristic = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Weight" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="11"/>
         *               &lt;fractionDigits value="3"/>
         *               &lt;maxInclusive value="99999999.999"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="UnitCode" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="3"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "weight",
            "unitCode"
        })
        public static class WeightInfo {

            @XmlElement(name = "Weight")
            protected BigDecimal weight;
            @XmlElement(name = "UnitCode")
            protected String unitCode;

            /**
             * Gets the value of the weight property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getWeight() {
                return weight;
            }

            /**
             * Sets the value of the weight property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setWeight(BigDecimal value) {
                this.weight = value;
            }

            /**
             * Gets the value of the unitCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnitCode() {
                return unitCode;
            }

            /**
             * Sets the value of the unitCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnitCode(String value) {
                this.unitCode = value;
            }

        }

    }

}