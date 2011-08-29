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
public abstract class PGPDataType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private PGPDataTypeSequence _PGPDataTypeSequence;

    private PGPDataTypeSequence2 _PGPDataTypeSequence2;


      //----------------/
     //- Constructors -/
    //----------------/

    public PGPDataType() {
        super();
    } //-- somapa.ptc.xml.nsw.PGPDataType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'PGPDataTypeSequence'.
     * 
     * @return the value of field 'PGPDataTypeSequence'.
    **/
    public PGPDataTypeSequence getPGPDataTypeSequence()
    {
        return this._PGPDataTypeSequence;
    } //-- PGPDataTypeSequence getPGPDataTypeSequence() 

    /**
     * Returns the value of field 'PGPDataTypeSequence2'.
     * 
     * @return the value of field 'PGPDataTypeSequence2'.
    **/
    public PGPDataTypeSequence2 getPGPDataTypeSequence2()
    {
        return this._PGPDataTypeSequence2;
    } //-- PGPDataTypeSequence2 getPGPDataTypeSequence2() 

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
     * Sets the value of field 'PGPDataTypeSequence'.
     * 
     * @param PGPDataTypeSequence the value of field
     * 'PGPDataTypeSequence'.
    **/
    public void setPGPDataTypeSequence(PGPDataTypeSequence PGPDataTypeSequence)
    {
        this._PGPDataTypeSequence = PGPDataTypeSequence;
    } //-- void setPGPDataTypeSequence(PGPDataTypeSequence) 

    /**
     * Sets the value of field 'PGPDataTypeSequence2'.
     * 
     * @param PGPDataTypeSequence2 the value of field
     * 'PGPDataTypeSequence2'.
    **/
    public void setPGPDataTypeSequence2(PGPDataTypeSequence2 PGPDataTypeSequence2)
    {
        this._PGPDataTypeSequence2 = PGPDataTypeSequence2;
    } //-- void setPGPDataTypeSequence2(PGPDataTypeSequence2) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
