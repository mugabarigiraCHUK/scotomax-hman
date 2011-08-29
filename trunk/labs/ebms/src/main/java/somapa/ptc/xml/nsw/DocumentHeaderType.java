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
public abstract class DocumentHeaderType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private DocumentReference _documentReference;

    private LicenseInfo _licenseInfo;

    private ConsignmentInfo _consignmentInfo;


      //----------------/
     //- Constructors -/
    //----------------/

    public DocumentHeaderType() {
        super();
    } //-- somapa.ptc.xml.nsw.DocumentHeaderType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'consignmentInfo'.
     * 
     * @return the value of field 'consignmentInfo'.
    **/
    public ConsignmentInfo getConsignmentInfo()
    {
        return this._consignmentInfo;
    } //-- ConsignmentInfo getConsignmentInfo() 

    /**
     * Returns the value of field 'documentReference'.
     * 
     * @return the value of field 'documentReference'.
    **/
    public DocumentReference getDocumentReference()
    {
        return this._documentReference;
    } //-- DocumentReference getDocumentReference() 

    /**
     * Returns the value of field 'licenseInfo'.
     * 
     * @return the value of field 'licenseInfo'.
    **/
    public LicenseInfo getLicenseInfo()
    {
        return this._licenseInfo;
    } //-- LicenseInfo getLicenseInfo() 

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
     * Sets the value of field 'consignmentInfo'.
     * 
     * @param consignmentInfo the value of field 'consignmentInfo'.
    **/
    public void setConsignmentInfo(ConsignmentInfo consignmentInfo)
    {
        this._consignmentInfo = consignmentInfo;
    } //-- void setConsignmentInfo(ConsignmentInfo) 

    /**
     * Sets the value of field 'documentReference'.
     * 
     * @param documentReference the value of field
     * 'documentReference'.
    **/
    public void setDocumentReference(DocumentReference documentReference)
    {
        this._documentReference = documentReference;
    } //-- void setDocumentReference(DocumentReference) 

    /**
     * Sets the value of field 'licenseInfo'.
     * 
     * @param licenseInfo the value of field 'licenseInfo'.
    **/
    public void setLicenseInfo(LicenseInfo licenseInfo)
    {
        this._licenseInfo = licenseInfo;
    } //-- void setLicenseInfo(LicenseInfo) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
