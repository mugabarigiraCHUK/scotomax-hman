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
import java.math.BigDecimal;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * 
 * 
 * @version $Revision$ $Date$
**/
public abstract class QuantityType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Detail (9) - M - 14 N DE 3 - Quantity -
     * �?ริมาณที�?อ�?ุ�?าต
    **/
    private java.math.BigDecimal _quantity;

    /**
     * Detail (10) - M - 3A - Quantity Unit -
     * ห�?�?วย�?อ�?�?ริมาณ
    **/
    private java.lang.String _unitCode;


      //----------------/
     //- Constructors -/
    //----------------/

    public QuantityType() {
        super();
    } //-- somapa.ptc.xml.nsw.QuantityType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'quantity'. The field 'quantity'
     * has the following description: Detail (9) - M - 14 N DE 3 -
     * Quantity - �?ริมาณที�?อ�?ุ�?าต
     * 
     * @return the value of field 'quantity'.
    **/
    public java.math.BigDecimal getQuantity()
    {
        return this._quantity;
    } //-- java.math.BigDecimal getQuantity() 

    /**
     * Returns the value of field 'unitCode'. The field 'unitCode'
     * has the following description: Detail (10) - M - 3A -
     * Quantity Unit - ห�?�?วย�?อ�?�?ริมาณ
     * 
     * @return the value of field 'unitCode'.
    **/
    public java.lang.String getUnitCode()
    {
        return this._unitCode;
    } //-- java.lang.String getUnitCode() 

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
     * Sets the value of field 'quantity'. The field 'quantity' has
     * the following description: Detail (9) - M - 14 N DE 3 -
     * Quantity - �?ริมาณที�?อ�?ุ�?าต
     * 
     * @param quantity the value of field 'quantity'.
    **/
    public void setQuantity(java.math.BigDecimal quantity)
    {
        this._quantity = quantity;
    } //-- void setQuantity(java.math.BigDecimal) 

    /**
     * Sets the value of field 'unitCode'. The field 'unitCode' has
     * the following description: Detail (10) - M - 3A - Quantity
     * Unit - ห�?�?วย�?อ�?�?ริมาณ
     * 
     * @param unitCode the value of field 'unitCode'.
    **/
    public void setUnitCode(java.lang.String unitCode)
    {
        this._unitCode = unitCode;
    } //-- void setUnitCode(java.lang.String) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
