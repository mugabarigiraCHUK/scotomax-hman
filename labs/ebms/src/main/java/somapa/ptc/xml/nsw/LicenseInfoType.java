/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package somapa.ptc.xml.nsw;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * 
 * 
 * @version $Revision$ $Date$
**/
public abstract class LicenseInfoType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Control (1) - M - 35A - License No -
     * เล�?ที�?�?�?อ�?ุ�?าต
    **/
    private java.lang.String _licenseNo;

    /**
     * Control (2) - M - 17A - License Issue Authority -
     * เล�?�?ระ�?ำตัว�?ู�?เสียภาษีอา�?ร�?อ�?ห�?�?วย�?า�?�?ู�?ออ�?�?�?อ�?ุ�?าต
    **/
    private java.lang.String _taxReference;

    /**
     * Control (3) - M - 1A - License Type -
     * �?�?อ�?ุ�?าตสำหรั�?
     * 0-�?ำเ�?�?า, 1-ส�?�?ออ�?
    **/
    private java.lang.String _type;

    /**
     * Control (4) - M - 8N - Issue Date -
     * วั�?ที�?ออ�?�?�?อ�?ุ�?าต (CCYYMMDD
    **/
    private org.exolab.castor.types.Date _issueDate;

    /**
     * Control (5) - O - 2A - Country Code -
     * รหัส�?ระเทศ
     * �?ห�?ส�?�?ออ�?/�?ห�?�?ำเ�?�?า
     * (�?รณีเ�?�?�?�?ลุ�?ม�?ระเทศ
     * เ�?�?�? EU, ASEAN
     * �?ะต�?อ�?�?ส�?รหัส�?ลุ�?ม�?ระเทศ
     * �?ดยทำ�?วามต�?ล�?�?ั�?�?ว�?�?�?อ�?)
    **/
    private java.lang.String _countryCode;

    /**
     * Control (7) - O - 256A - Description -
     * รายละเอียด�?อ�?�?�?อ�?ุ�?าต
    **/
    private java.lang.String _description;

    /**
     * Control (8) - M - 8N - Start Date -
     * วั�?ที�?มี�?ล�?ั�?�?ั�?�?�?�?
     * (CCYYMMDD)
    **/
    private org.exolab.castor.types.Date _startDate;

    /**
     * Control (9) - M - 8N - Expire Date -
     * วั�?ที�?หมดอายุ (CCYYMMDD)
    **/
    private org.exolab.castor.types.Date _expireDate;


      //----------------/
     //- Constructors -/
    //----------------/

    public LicenseInfoType() {
        super();
    } //-- somapa.ptc.xml.nsw.LicenseInfoType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'countryCode'. The field
     * 'countryCode' has the following description: Control (5) - O
     * - 2A - Country Code - รหัส�?ระเทศ
     * �?ห�?ส�?�?ออ�?/�?ห�?�?ำเ�?�?า
     * (�?รณีเ�?�?�?�?ลุ�?ม�?ระเทศ
     * เ�?�?�? EU, ASEAN
     * �?ะต�?อ�?�?ส�?รหัส�?ลุ�?ม�?ระเทศ
     * �?ดยทำ�?วามต�?ล�?�?ั�?�?ว�?�?�?อ�?)
     * 
     * @return the value of field 'countryCode'.
    **/
    public java.lang.String getCountryCode()
    {
        return this._countryCode;
    } //-- java.lang.String getCountryCode() 

    /**
     * Returns the value of field 'description'. The field
     * 'description' has the following description: Control (7) - O
     * - 256A - Description -
     * รายละเอียด�?อ�?�?�?อ�?ุ�?าต
     * 
     * @return the value of field 'description'.
    **/
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
     * Returns the value of field 'expireDate'. The field
     * 'expireDate' has the following description: Control (9) - M
     * - 8N - Expire Date - วั�?ที�?หมดอายุ
     * (CCYYMMDD)
     * 
     * @return the value of field 'expireDate'.
    **/
    public org.exolab.castor.types.Date getExpireDate()
    {
        return this._expireDate;
    } //-- org.exolab.castor.types.Date getExpireDate() 

    /**
     * Returns the value of field 'issueDate'. The field
     * 'issueDate' has the following description: Control (4) - M -
     * 8N - Issue Date -
     * วั�?ที�?ออ�?�?�?อ�?ุ�?าต
     * (CCYYMMDD)
     * 
     * @return the value of field 'issueDate'.
    **/
    public org.exolab.castor.types.Date getIssueDate()
    {
        return this._issueDate;
    } //-- org.exolab.castor.types.Date getIssueDate() 

    /**
     * Returns the value of field 'licenseNo'. The field
     * 'licenseNo' has the following description: Control (1) - M -
     * 35A - License No -
     * เล�?ที�?�?�?อ�?ุ�?าต
     * 
     * @return the value of field 'licenseNo'.
    **/
    public java.lang.String getLicenseNo()
    {
        return this._licenseNo;
    } //-- java.lang.String getLicenseNo() 

    /**
     * Returns the value of field 'startDate'. The field
     * 'startDate' has the following description: Control (8) - M -
     * 8N - Start Date -
     * วั�?ที�?มี�?ล�?ั�?�?ั�?�?�?�?
     * (CCYYMMDD)
     * 
     * @return the value of field 'startDate'.
    **/
    public org.exolab.castor.types.Date getStartDate()
    {
        return this._startDate;
    } //-- org.exolab.castor.types.Date getStartDate() 

    /**
     * Returns the value of field 'taxReference'. The field
     * 'taxReference' has the following description: Control (2) -
     * M - 17A - License Issue Authority -
     * เล�?�?ระ�?ำตัว�?ู�?เสียภาษีอา�?ร�?อ�?ห�?�?วย�?า�?�?ู�?ออ�?�?�?อ�?ุ�?าต
     * 
     * @return the value of field 'taxReference'.
    **/
    public java.lang.String getTaxReference()
    {
        return this._taxReference;
    } //-- java.lang.String getTaxReference() 

    /**
     * Returns the value of field 'type'. The field 'type' has the
     * following description: Control (3) - M - 1A - License Type -
     * �?�?อ�?ุ�?าตสำหรั�?
     * 0-�?ำเ�?�?า, 1-ส�?�?ออ�?
     * 
     * @return the value of field 'type'.
    **/
    public java.lang.String getType()
    {
        return this._type;
    } //-- java.lang.String getType() 

    /**
    **/
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * 
     * @param out
    **/
    public abstract void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException;

    /**
     * 
     * 
     * @param handler
    **/
    public abstract void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException;

    /**
     * Sets the value of field 'countryCode'. The field
     * 'countryCode' has the following description: Control (5) - O
     * - 2A - Country Code - รหัส�?ระเทศ
     * �?ห�?ส�?�?ออ�?/�?ห�?�?ำเ�?�?า
     * (�?รณีเ�?�?�?�?ลุ�?ม�?ระเทศ
     * เ�?�?�? EU, ASEAN
     * �?ะต�?อ�?�?ส�?รหัส�?ลุ�?ม�?ระเทศ
     * �?ดยทำ�?วามต�?ล�?�?ั�?�?ว�?�?�?อ�?)
     * 
     * @param countryCode the value of field 'countryCode'.
    **/
    public void setCountryCode(java.lang.String countryCode)
    {
        this._countryCode = countryCode;
    } //-- void setCountryCode(java.lang.String) 

    /**
     * Sets the value of field 'description'. The field
     * 'description' has the following description: Control (7) - O
     * - 256A - Description -
     * รายละเอียด�?อ�?�?�?อ�?ุ�?าต
     * 
     * @param description the value of field 'description'.
    **/
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Sets the value of field 'expireDate'. The field 'expireDate'
     * has the following description: Control (9) - M - 8N - Expire
     * Date - วั�?ที�?หมดอายุ (CCYYMMDD)
     * 
     * @param expireDate the value of field 'expireDate'.
    **/
    public void setExpireDate(org.exolab.castor.types.Date expireDate)
    {
        this._expireDate = expireDate;
    } //-- void setExpireDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'issueDate'. The field 'issueDate'
     * has the following description: Control (4) - M - 8N - Issue
     * Date - วั�?ที�?ออ�?�?�?อ�?ุ�?าต
     * (CCYYMMDD)
     * 
     * @param issueDate the value of field 'issueDate'.
    **/
    public void setIssueDate(org.exolab.castor.types.Date issueDate)
    {
        this._issueDate = issueDate;
    } //-- void setIssueDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'licenseNo'. The field 'licenseNo'
     * has the following description: Control (1) - M - 35A -
     * License No - เล�?ที�?�?�?อ�?ุ�?าต
     * 
     * @param licenseNo the value of field 'licenseNo'.
    **/
    public void setLicenseNo(java.lang.String licenseNo)
    {
        this._licenseNo = licenseNo;
    } //-- void setLicenseNo(java.lang.String) 

    /**
     * Sets the value of field 'startDate'. The field 'startDate'
     * has the following description: Control (8) - M - 8N - Start
     * Date -
     * วั�?ที�?มี�?ล�?ั�?�?ั�?�?�?�?
     * (CCYYMMDD)
     * 
     * @param startDate the value of field 'startDate'.
    **/
    public void setStartDate(org.exolab.castor.types.Date startDate)
    {
        this._startDate = startDate;
    } //-- void setStartDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'taxReference'. The field
     * 'taxReference' has the following description: Control (2) -
     * M - 17A - License Issue Authority -
     * เล�?�?ระ�?ำตัว�?ู�?เสียภาษีอา�?ร�?อ�?ห�?�?วย�?า�?�?ู�?ออ�?�?�?อ�?ุ�?าต
     * 
     * @param taxReference the value of field 'taxReference'.
    **/
    public void setTaxReference(java.lang.String taxReference)
    {
        this._taxReference = taxReference;
    } //-- void setTaxReference(java.lang.String) 

    /**
     * Sets the value of field 'type'. The field 'type' has the
     * following description: Control (3) - M - 1A - License Type -
     * �?�?อ�?ุ�?าตสำหรั�?
     * 0-�?ำเ�?�?า, 1-ส�?�?ออ�?
     * 
     * @param type the value of field 'type'.
    **/
    public void setType(java.lang.String type)
    {
        this._type = type;
    } //-- void setType(java.lang.String) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
