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
public class X509DataTypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private X509IssuerSerial _x509IssuerSerial;


      //----------------/
     //- Constructors -/
    //----------------/

    public X509DataTypeChoice() {
        super();
    } //-- somapa.ptc.xml.nsw.X509DataTypeChoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'x509IssuerSerial'.
     * 
     * @return the value of field 'x509IssuerSerial'.
    **/
    public X509IssuerSerial getX509IssuerSerial()
    {
        return this._x509IssuerSerial;
    } //-- X509IssuerSerial getX509IssuerSerial() 

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
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * 
     * @param handler
    **/
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'x509IssuerSerial'.
     * 
     * @param x509IssuerSerial the value of field 'x509IssuerSerial'
    **/
    public void setX509IssuerSerial(X509IssuerSerial x509IssuerSerial)
    {
        this._x509IssuerSerial = x509IssuerSerial;
    } //-- void setX509IssuerSerial(X509IssuerSerial) 

    /**
     * 
     * 
     * @param reader
    **/
    public static somapa.ptc.xml.nsw.X509DataTypeChoice unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (somapa.ptc.xml.nsw.X509DataTypeChoice) Unmarshaller.unmarshal(somapa.ptc.xml.nsw.X509DataTypeChoice.class, reader);
    } //-- somapa.ptc.xml.nsw.X509DataTypeChoice unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
