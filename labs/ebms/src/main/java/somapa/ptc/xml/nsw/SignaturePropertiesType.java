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
public abstract class SignaturePropertiesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _id;

    private java.util.ArrayList _signaturePropertyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SignaturePropertiesType() {
        super();
        _signaturePropertyList = new ArrayList();
    } //-- somapa.ptc.xml.nsw.SignaturePropertiesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSignatureProperty
    **/
    public void addSignatureProperty(SignatureProperty vSignatureProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _signaturePropertyList.add(vSignatureProperty);
    } //-- void addSignatureProperty(SignatureProperty) 

    /**
     * 
     * 
     * @param index
     * @param vSignatureProperty
    **/
    public void addSignatureProperty(int index, SignatureProperty vSignatureProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _signaturePropertyList.add(index, vSignatureProperty);
    } //-- void addSignatureProperty(int, SignatureProperty) 

    /**
    **/
    public void clearSignatureProperty()
    {
        _signaturePropertyList.clear();
    } //-- void clearSignatureProperty() 

    /**
    **/
    public java.util.Enumeration enumerateSignatureProperty()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_signaturePropertyList.iterator());
    } //-- java.util.Enumeration enumerateSignatureProperty() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'id'.
    **/
    public java.lang.String getId()
    {
        return this._id;
    } //-- java.lang.String getId() 

    /**
     * 
     * 
     * @param index
    **/
    public SignatureProperty getSignatureProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _signaturePropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (SignatureProperty) _signaturePropertyList.get(index);
    } //-- SignatureProperty getSignatureProperty(int) 

    /**
    **/
    public SignatureProperty[] getSignatureProperty()
    {
        int size = _signaturePropertyList.size();
        SignatureProperty[] mArray = new SignatureProperty[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (SignatureProperty) _signaturePropertyList.get(index);
        }
        return mArray;
    } //-- SignatureProperty[] getSignatureProperty() 

    /**
    **/
    public int getSignaturePropertyCount()
    {
        return _signaturePropertyList.size();
    } //-- int getSignaturePropertyCount() 

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
     * @param vSignatureProperty
    **/
    public boolean removeSignatureProperty(SignatureProperty vSignatureProperty)
    {
        boolean removed = _signaturePropertyList.remove(vSignatureProperty);
        return removed;
    } //-- boolean removeSignatureProperty(SignatureProperty) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
    **/
    public void setId(java.lang.String id)
    {
        this._id = id;
    } //-- void setId(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vSignatureProperty
    **/
    public void setSignatureProperty(int index, SignatureProperty vSignatureProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _signaturePropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _signaturePropertyList.set(index, vSignatureProperty);
    } //-- void setSignatureProperty(int, SignatureProperty) 

    /**
     * 
     * 
     * @param signaturePropertyArray
    **/
    public void setSignatureProperty(SignatureProperty[] signaturePropertyArray)
    {
        //-- copy array
        _signaturePropertyList.clear();
        for (int i = 0; i < signaturePropertyArray.length; i++) {
            _signaturePropertyList.add(signaturePropertyArray[i]);
        }
    } //-- void setSignatureProperty(SignatureProperty) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
