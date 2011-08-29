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
public abstract class DocumentDetailsTransportType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private TariffInfo _tariffInfo;

    private InvoiceInfo _invoiceInfo;


      //----------------/
     //- Constructors -/
    //----------------/

    public DocumentDetailsTransportType() {
        super();
    } //-- somapa.ptc.xml.nsw.DocumentDetailsTransportType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'invoiceInfo'.
     * 
     * @return the value of field 'invoiceInfo'.
    **/
    public InvoiceInfo getInvoiceInfo()
    {
        return this._invoiceInfo;
    } //-- InvoiceInfo getInvoiceInfo() 

    /**
     * Returns the value of field 'tariffInfo'.
     * 
     * @return the value of field 'tariffInfo'.
    **/
    public TariffInfo getTariffInfo()
    {
        return this._tariffInfo;
    } //-- TariffInfo getTariffInfo() 

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
     * Sets the value of field 'invoiceInfo'.
     * 
     * @param invoiceInfo the value of field 'invoiceInfo'.
    **/
    public void setInvoiceInfo(InvoiceInfo invoiceInfo)
    {
        this._invoiceInfo = invoiceInfo;
    } //-- void setInvoiceInfo(InvoiceInfo) 

    /**
     * Sets the value of field 'tariffInfo'.
     * 
     * @param tariffInfo the value of field 'tariffInfo'.
    **/
    public void setTariffInfo(TariffInfo tariffInfo)
    {
        this._tariffInfo = tariffInfo;
    } //-- void setTariffInfo(TariffInfo) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
