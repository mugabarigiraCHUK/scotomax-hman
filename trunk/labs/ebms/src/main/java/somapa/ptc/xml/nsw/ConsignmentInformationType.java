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
public abstract class ConsignmentInformationType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Control (6) - M - 17A - Company Tax Number -
     * เล�?�?ระ�?ำตัว�?ู�?เสียภาษีอา�?ร�?อ�?�?ู�?�?ออ�?ุ�?าต
    **/
    private java.lang.String _taxReference;


      //----------------/
     //- Constructors -/
    //----------------/

    public ConsignmentInformationType() {
        super();
    } //-- somapa.ptc.xml.nsw.ConsignmentInformationType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'taxReference'. The field
     * 'taxReference' has the following description: Control (6) -
     * M - 17A - Company Tax Number -
     * เล�?�?ระ�?ำตัว�?ู�?เสียภาษีอา�?ร�?อ�?�?ู�?�?ออ�?ุ�?าต
     * 
     * @return the value of field 'taxReference'.
    **/
    public java.lang.String getTaxReference()
    {
        return this._taxReference;
    } //-- java.lang.String getTaxReference() 

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
     * Sets the value of field 'taxReference'. The field
     * 'taxReference' has the following description: Control (6) -
     * M - 17A - Company Tax Number -
     * เล�?�?ระ�?ำตัว�?ู�?เสียภาษีอา�?ร�?อ�?�?ู�?�?ออ�?ุ�?าต
     * 
     * @param taxReference the value of field 'taxReference'.
    **/
    public void setTaxReference(java.lang.String taxReference)
    {
        this._taxReference = taxReference;
    } //-- void setTaxReference(java.lang.String) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
