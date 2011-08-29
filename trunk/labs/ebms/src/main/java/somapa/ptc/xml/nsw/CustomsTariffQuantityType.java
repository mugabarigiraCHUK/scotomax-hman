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
public abstract class CustomsTariffQuantityType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Detail (6) - M - 12N - Tariff Classification -
     * รหัส�?ิ�?ัดศุล�?า�?ร
    **/
    private int _tariffCode;

    /**
     * keeps track of state for field: _tariffCode
    **/
    private boolean _has_tariffCode;

    /**
     * Detail (7) - M - 3N - Tariff Statistical Code -
     * รหัสสถิติสิ�?�?�?า
     * �?อ�?�?รมศุล�?า�?ร
    **/
    private int _statisticalCode;

    /**
     * keeps track of state for field: _statisticalCode
    **/
    private boolean _has_statisticalCode;


      //----------------/
     //- Constructors -/
    //----------------/

    public CustomsTariffQuantityType() {
        super();
    } //-- somapa.ptc.xml.nsw.CustomsTariffQuantityType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public void deleteStatisticalCode()
    {
        this._has_statisticalCode= false;
    } //-- void deleteStatisticalCode() 

    /**
     * Returns the value of field 'statisticalCode'. The field
     * 'statisticalCode' has the following description: Detail (7)
     * - M - 3N - Tariff Statistical Code -
     * รหัสสถิติสิ�?�?�?า
     * �?อ�?�?รมศุล�?า�?ร
     * 
     * @return the value of field 'statisticalCode'.
    **/
    public int getStatisticalCode()
    {
        return this._statisticalCode;
    } //-- int getStatisticalCode() 

    /**
     * Returns the value of field 'tariffCode'. The field
     * 'tariffCode' has the following description: Detail (6) - M -
     * 12N - Tariff Classification -
     * รหัส�?ิ�?ัดศุล�?า�?ร
     * 
     * @return the value of field 'tariffCode'.
    **/
    public int getTariffCode()
    {
        return this._tariffCode;
    } //-- int getTariffCode() 

    /**
    **/
    public boolean hasStatisticalCode()
    {
        return this._has_statisticalCode;
    } //-- boolean hasStatisticalCode() 

    /**
    **/
    public boolean hasTariffCode()
    {
        return this._has_tariffCode;
    } //-- boolean hasTariffCode() 

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
     * Sets the value of field 'statisticalCode'. The field
     * 'statisticalCode' has the following description: Detail (7)
     * - M - 3N - Tariff Statistical Code -
     * รหัสสถิติสิ�?�?�?า
     * �?อ�?�?รมศุล�?า�?ร
     * 
     * @param statisticalCode the value of field 'statisticalCode'.
    **/
    public void setStatisticalCode(int statisticalCode)
    {
        this._statisticalCode = statisticalCode;
        this._has_statisticalCode = true;
    } //-- void setStatisticalCode(int) 

    /**
     * Sets the value of field 'tariffCode'. The field 'tariffCode'
     * has the following description: Detail (6) - M - 12N - Tariff
     * Classification -
     * รหัส�?ิ�?ัดศุล�?า�?ร
     * 
     * @param tariffCode the value of field 'tariffCode'.
    **/
    public void setTariffCode(int tariffCode)
    {
        this._tariffCode = tariffCode;
        this._has_tariffCode = true;
    } //-- void setTariffCode(int) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
