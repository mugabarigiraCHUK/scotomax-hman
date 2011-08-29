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
     * à¹€à¸¥à¸?à¸—à¸µà¹?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
    **/
    private java.lang.String _licenseNo;

    /**
     * Control (2) - M - 17A - License Issue Authority -
     * à¹€à¸¥à¸?à¸?à¸£à¸°à¸?à¸³à¸•à¸±à¸§à¸?à¸¹à¹?à¹€à¸ªà¸µà¸¢à¸ à¸²à¸©à¸µà¸­à¸²à¸?à¸£à¸?à¸­à¸?à¸«à¸?à¹?à¸§à¸¢à¸?à¸²à¸?à¸?à¸¹à¹?à¸­à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
    **/
    private java.lang.String _taxReference;

    /**
     * Control (3) - M - 1A - License Type -
     * à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•à¸ªà¸³à¸«à¸£à¸±à¸?
     * 0-à¸?à¸³à¹€à¸?à¹?à¸², 1-à¸ªà¹?à¸?à¸­à¸­à¸?
    **/
    private java.lang.String _type;

    /**
     * Control (4) - M - 8N - Issue Date -
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸­à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸• (CCYYMMDD
    **/
    private org.exolab.castor.types.Date _issueDate;

    /**
     * Control (5) - O - 2A - Country Code -
     * à¸£à¸«à¸±à¸ªà¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹?à¸«à¹?à¸ªà¹?à¸?à¸­à¸­à¸?/à¹?à¸«à¹?à¸?à¸³à¹€à¸?à¹?à¸²
     * (à¸?à¸£à¸“à¸µà¹€à¸?à¹?à¸?à¸?à¸¥à¸¸à¹?à¸¡à¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹€à¸?à¹?à¸? EU, ASEAN
     * à¸?à¸°à¸•à¹?à¸­à¸?à¹?à¸ªà¹?à¸£à¸«à¸±à¸ªà¸?à¸¥à¸¸à¹?à¸¡à¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹?à¸”à¸¢à¸—à¸³à¸?à¸§à¸²à¸¡à¸•à¸?à¸¥à¸?à¸?à¸±à¸?à¹?à¸§à¹?à¸?à¹?à¸­à¸?)
    **/
    private java.lang.String _countryCode;

    /**
     * Control (7) - O - 256A - Description -
     * à¸£à¸²à¸¢à¸¥à¸°à¹€à¸­à¸µà¸¢à¸”à¸?à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
    **/
    private java.lang.String _description;

    /**
     * Control (8) - M - 8N - Start Date -
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸¡à¸µà¸?à¸¥à¸?à¸±à¸?à¸?à¸±à¸?à¹?à¸?à¹?
     * (CCYYMMDD)
    **/
    private org.exolab.castor.types.Date _startDate;

    /**
     * Control (9) - M - 8N - Expire Date -
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸«à¸¡à¸”à¸­à¸²à¸¢à¸¸ (CCYYMMDD)
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
     * - 2A - Country Code - à¸£à¸«à¸±à¸ªà¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹?à¸«à¹?à¸ªà¹?à¸?à¸­à¸­à¸?/à¹?à¸«à¹?à¸?à¸³à¹€à¸?à¹?à¸²
     * (à¸?à¸£à¸“à¸µà¹€à¸?à¹?à¸?à¸?à¸¥à¸¸à¹?à¸¡à¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹€à¸?à¹?à¸? EU, ASEAN
     * à¸?à¸°à¸•à¹?à¸­à¸?à¹?à¸ªà¹?à¸£à¸«à¸±à¸ªà¸?à¸¥à¸¸à¹?à¸¡à¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹?à¸”à¸¢à¸—à¸³à¸?à¸§à¸²à¸¡à¸•à¸?à¸¥à¸?à¸?à¸±à¸?à¹?à¸§à¹?à¸?à¹?à¸­à¸?)
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
     * à¸£à¸²à¸¢à¸¥à¸°à¹€à¸­à¸µà¸¢à¸”à¸?à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
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
     * - 8N - Expire Date - à¸§à¸±à¸?à¸—à¸µà¹?à¸«à¸¡à¸”à¸­à¸²à¸¢à¸¸
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
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸­à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
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
     * à¹€à¸¥à¸?à¸—à¸µà¹?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
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
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸¡à¸µà¸?à¸¥à¸?à¸±à¸?à¸?à¸±à¸?à¹?à¸?à¹?
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
     * à¹€à¸¥à¸?à¸?à¸£à¸°à¸?à¸³à¸•à¸±à¸§à¸?à¸¹à¹?à¹€à¸ªà¸µà¸¢à¸ à¸²à¸©à¸µà¸­à¸²à¸?à¸£à¸?à¸­à¸?à¸«à¸?à¹?à¸§à¸¢à¸?à¸²à¸?à¸?à¸¹à¹?à¸­à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
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
     * à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•à¸ªà¸³à¸«à¸£à¸±à¸?
     * 0-à¸?à¸³à¹€à¸?à¹?à¸², 1-à¸ªà¹?à¸?à¸­à¸­à¸?
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
     * - 2A - Country Code - à¸£à¸«à¸±à¸ªà¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹?à¸«à¹?à¸ªà¹?à¸?à¸­à¸­à¸?/à¹?à¸«à¹?à¸?à¸³à¹€à¸?à¹?à¸²
     * (à¸?à¸£à¸“à¸µà¹€à¸?à¹?à¸?à¸?à¸¥à¸¸à¹?à¸¡à¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹€à¸?à¹?à¸? EU, ASEAN
     * à¸?à¸°à¸•à¹?à¸­à¸?à¹?à¸ªà¹?à¸£à¸«à¸±à¸ªà¸?à¸¥à¸¸à¹?à¸¡à¸?à¸£à¸°à¹€à¸—à¸¨
     * à¹?à¸”à¸¢à¸—à¸³à¸?à¸§à¸²à¸¡à¸•à¸?à¸¥à¸?à¸?à¸±à¸?à¹?à¸§à¹?à¸?à¹?à¸­à¸?)
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
     * à¸£à¸²à¸¢à¸¥à¸°à¹€à¸­à¸µà¸¢à¸”à¸?à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
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
     * Date - à¸§à¸±à¸?à¸—à¸µà¹?à¸«à¸¡à¸”à¸­à¸²à¸¢à¸¸ (CCYYMMDD)
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
     * Date - à¸§à¸±à¸?à¸—à¸µà¹?à¸­à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
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
     * License No - à¹€à¸¥à¸?à¸—à¸µà¹?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
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
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸¡à¸µà¸?à¸¥à¸?à¸±à¸?à¸?à¸±à¸?à¹?à¸?à¹?
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
     * à¹€à¸¥à¸?à¸?à¸£à¸°à¸?à¸³à¸•à¸±à¸§à¸?à¸¹à¹?à¹€à¸ªà¸µà¸¢à¸ à¸²à¸©à¸µà¸­à¸²à¸?à¸£à¸?à¸­à¸?à¸«à¸?à¹?à¸§à¸¢à¸?à¸²à¸?à¸?à¸¹à¹?à¸­à¸­à¸?à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
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
     * à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•à¸ªà¸³à¸«à¸£à¸±à¸?
     * 0-à¸?à¸³à¹€à¸?à¹?à¸², 1-à¸ªà¹?à¸?à¸­à¸­à¸?
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
