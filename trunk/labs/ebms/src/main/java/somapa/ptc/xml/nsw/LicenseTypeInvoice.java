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
import java.util.ArrayList;
import java.util.Enumeration;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * 
 * 
 * @version $Revision$ $Date$
**/
public abstract class LicenseTypeInvoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private DocumentHeader _documentHeader;

    private java.util.ArrayList _documentDetailsTransportList;

    private java.util.ArrayList _signatureList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LicenseTypeInvoice() {
        super();
        _documentDetailsTransportList = new ArrayList();
        _signatureList = new ArrayList();
    } //-- somapa.ptc.xml.nsw.LicenseTypeInvoice()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDocumentDetailsTransport
    **/
    public void addDocumentDetailsTransport(DocumentDetailsTransport vDocumentDetailsTransport)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_documentDetailsTransportList.size() < 999)) {
            throw new IndexOutOfBoundsException();
        }
        _documentDetailsTransportList.add(vDocumentDetailsTransport);
    } //-- void addDocumentDetailsTransport(DocumentDetailsTransport) 

    /**
     * 
     * 
     * @param index
     * @param vDocumentDetailsTransport
    **/
    public void addDocumentDetailsTransport(int index, DocumentDetailsTransport vDocumentDetailsTransport)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_documentDetailsTransportList.size() < 999)) {
            throw new IndexOutOfBoundsException();
        }
        _documentDetailsTransportList.add(index, vDocumentDetailsTransport);
    } //-- void addDocumentDetailsTransport(int, DocumentDetailsTransport) 

    /**
     * 
     * 
     * @param vSignature
    **/
    public void addSignature(Signature vSignature)
        throws java.lang.IndexOutOfBoundsException
    {
        _signatureList.add(vSignature);
    } //-- void addSignature(Signature) 

    /**
     * 
     * 
     * @param index
     * @param vSignature
    **/
    public void addSignature(int index, Signature vSignature)
        throws java.lang.IndexOutOfBoundsException
    {
        _signatureList.add(index, vSignature);
    } //-- void addSignature(int, Signature) 

    /**
    **/
    public void clearDocumentDetailsTransport()
    {
        _documentDetailsTransportList.clear();
    } //-- void clearDocumentDetailsTransport() 

    /**
    **/
    public void clearSignature()
    {
        _signatureList.clear();
    } //-- void clearSignature() 

    /**
    **/
    public java.util.Enumeration enumerateDocumentDetailsTransport()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_documentDetailsTransportList.iterator());
    } //-- java.util.Enumeration enumerateDocumentDetailsTransport() 

    /**
    **/
    public java.util.Enumeration enumerateSignature()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_signatureList.iterator());
    } //-- java.util.Enumeration enumerateSignature() 

    /**
     * 
     * 
     * @param index
    **/
    public DocumentDetailsTransport getDocumentDetailsTransport(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _documentDetailsTransportList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (DocumentDetailsTransport) _documentDetailsTransportList.get(index);
    } //-- DocumentDetailsTransport getDocumentDetailsTransport(int) 

    /**
    **/
    public DocumentDetailsTransport[] getDocumentDetailsTransport()
    {
        int size = _documentDetailsTransportList.size();
        DocumentDetailsTransport[] mArray = new DocumentDetailsTransport[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (DocumentDetailsTransport) _documentDetailsTransportList.get(index);
        }
        return mArray;
    } //-- DocumentDetailsTransport[] getDocumentDetailsTransport() 

    /**
    **/
    public int getDocumentDetailsTransportCount()
    {
        return _documentDetailsTransportList.size();
    } //-- int getDocumentDetailsTransportCount() 

    /**
     * Returns the value of field 'documentHeader'.
     * 
     * @return the value of field 'documentHeader'.
    **/
    public DocumentHeader getDocumentHeader()
    {
        return this._documentHeader;
    } //-- DocumentHeader getDocumentHeader() 

    /**
     * 
     * 
     * @param index
    **/
    public Signature getSignature(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _signatureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Signature) _signatureList.get(index);
    } //-- Signature getSignature(int) 

    /**
    **/
    public Signature[] getSignature()
    {
        int size = _signatureList.size();
        Signature[] mArray = new Signature[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Signature) _signatureList.get(index);
        }
        return mArray;
    } //-- Signature[] getSignature() 

    /**
    **/
    public int getSignatureCount()
    {
        return _signatureList.size();
    } //-- int getSignatureCount() 

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
     * 
     * 
     * @param vDocumentDetailsTransport
    **/
    public boolean removeDocumentDetailsTransport(DocumentDetailsTransport vDocumentDetailsTransport)
    {
        boolean removed = _documentDetailsTransportList.remove(vDocumentDetailsTransport);
        return removed;
    } //-- boolean removeDocumentDetailsTransport(DocumentDetailsTransport) 

    /**
     * 
     * 
     * @param vSignature
    **/
    public boolean removeSignature(Signature vSignature)
    {
        boolean removed = _signatureList.remove(vSignature);
        return removed;
    } //-- boolean removeSignature(Signature) 

    /**
     * 
     * 
     * @param index
     * @param vDocumentDetailsTransport
    **/
    public void setDocumentDetailsTransport(int index, DocumentDetailsTransport vDocumentDetailsTransport)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _documentDetailsTransportList.size())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(index < 999)) {
            throw new IndexOutOfBoundsException();
        }
        _documentDetailsTransportList.set(index, vDocumentDetailsTransport);
    } //-- void setDocumentDetailsTransport(int, DocumentDetailsTransport) 

    /**
     * 
     * 
     * @param documentDetailsTransportArray
    **/
    public void setDocumentDetailsTransport(DocumentDetailsTransport[] documentDetailsTransportArray)
    {
        //-- copy array
        _documentDetailsTransportList.clear();
        for (int i = 0; i < documentDetailsTransportArray.length; i++) {
            _documentDetailsTransportList.add(documentDetailsTransportArray[i]);
        }
    } //-- void setDocumentDetailsTransport(DocumentDetailsTransport) 

    /**
     * Sets the value of field 'documentHeader'.
     * 
     * @param documentHeader the value of field 'documentHeader'.
    **/
    public void setDocumentHeader(DocumentHeader documentHeader)
    {
        this._documentHeader = documentHeader;
    } //-- void setDocumentHeader(DocumentHeader) 

    /**
     * 
     * 
     * @param index
     * @param vSignature
    **/
    public void setSignature(int index, Signature vSignature)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _signatureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _signatureList.set(index, vSignature);
    } //-- void setSignature(int, Signature) 

    /**
     * 
     * 
     * @param signatureArray
    **/
    public void setSignature(Signature[] signatureArray)
    {
        //-- copy array
        _signatureList.clear();
        for (int i = 0; i < signatureArray.length; i++) {
            _signatureList.add(signatureArray[i]);
        }
    } //-- void setSignature(Signature) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
