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
public abstract class DSAKeyValueType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private DSAKeyValueTypeSequence _DSAKeyValueTypeSequence;


      //----------------/
     //- Constructors -/
    //----------------/

    public DSAKeyValueType() {
        super();
    } //-- somapa.ptc.xml.nsw.DSAKeyValueType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'DSAKeyValueTypeSequence'.
     * 
     * @return the value of field 'DSAKeyValueTypeSequence'.
    **/
    public DSAKeyValueTypeSequence getDSAKeyValueTypeSequence()
    {
        return this._DSAKeyValueTypeSequence;
    } //-- DSAKeyValueTypeSequence getDSAKeyValueTypeSequence() 

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
     * Sets the value of field 'DSAKeyValueTypeSequence'.
     * 
     * @param DSAKeyValueTypeSequence the value of field
     * 'DSAKeyValueTypeSequence'.
    **/
    public void setDSAKeyValueTypeSequence(DSAKeyValueTypeSequence DSAKeyValueTypeSequence)
    {
        this._DSAKeyValueTypeSequence = DSAKeyValueTypeSequence;
    } //-- void setDSAKeyValueTypeSequence(DSAKeyValueTypeSequence) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
