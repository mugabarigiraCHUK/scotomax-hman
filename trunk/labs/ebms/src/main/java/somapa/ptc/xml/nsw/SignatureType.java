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
public abstract class SignatureType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _id;

    private SignedInfo _signedInfo;

    private SignatureValue _signatureValue;

    private KeyInfo _keyInfo;

    private java.util.ArrayList _objectList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SignatureType() {
        super();
        _objectList = new ArrayList();
    } //-- somapa.ptc.xml.nsw.SignatureType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vObject
    **/
    public void addObject(Object vObject)
        throws java.lang.IndexOutOfBoundsException
    {
        _objectList.add(vObject);
    } //-- void addObject(Object) 

    /**
     * 
     * 
     * @param index
     * @param vObject
    **/
    public void addObject(int index, Object vObject)
        throws java.lang.IndexOutOfBoundsException
    {
        _objectList.add(index, vObject);
    } //-- void addObject(int, Object) 

    /**
    **/
    public void clearObject()
    {
        _objectList.clear();
    } //-- void clearObject() 

    /**
    **/
    public java.util.Enumeration enumerateObject()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_objectList.iterator());
    } //-- java.util.Enumeration enumerateObject() 

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
     * Returns the value of field 'keyInfo'.
     * 
     * @return the value of field 'keyInfo'.
    **/
    public KeyInfo getKeyInfo()
    {
        return this._keyInfo;
    } //-- KeyInfo getKeyInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public Object getObject(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _objectList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Object) _objectList.get(index);
    } //-- Object getObject(int) 

    /**
    **/
    public Object[] getObject()
    {
        int size = _objectList.size();
        Object[] mArray = new Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Object) _objectList.get(index);
        }
        return mArray;
    } //-- Object[] getObject() 

    /**
    **/
    public int getObjectCount()
    {
        return _objectList.size();
    } //-- int getObjectCount() 

    /**
     * Returns the value of field 'signatureValue'.
     * 
     * @return the value of field 'signatureValue'.
    **/
    public SignatureValue getSignatureValue()
    {
        return this._signatureValue;
    } //-- SignatureValue getSignatureValue() 

    /**
     * Returns the value of field 'signedInfo'.
     * 
     * @return the value of field 'signedInfo'.
    **/
    public SignedInfo getSignedInfo()
    {
        return this._signedInfo;
    } //-- SignedInfo getSignedInfo() 

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
     * @param vObject
    **/
    public boolean removeObject(Object vObject)
    {
        boolean removed = _objectList.remove(vObject);
        return removed;
    } //-- boolean removeObject(Object) 

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
     * Sets the value of field 'keyInfo'.
     * 
     * @param keyInfo the value of field 'keyInfo'.
    **/
    public void setKeyInfo(KeyInfo keyInfo)
    {
        this._keyInfo = keyInfo;
    } //-- void setKeyInfo(KeyInfo) 

    /**
     * 
     * 
     * @param index
     * @param vObject
    **/
    public void setObject(int index, Object vObject)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _objectList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _objectList.set(index, vObject);
    } //-- void setObject(int, Object) 

    /**
     * 
     * 
     * @param objectArray
    **/
    public void setObject(Object[] objectArray)
    {
        //-- copy array
        _objectList.clear();
        for (int i = 0; i < objectArray.length; i++) {
            _objectList.add(objectArray[i]);
        }
    } //-- void setObject(Object) 

    /**
     * Sets the value of field 'signatureValue'.
     * 
     * @param signatureValue the value of field 'signatureValue'.
    **/
    public void setSignatureValue(SignatureValue signatureValue)
    {
        this._signatureValue = signatureValue;
    } //-- void setSignatureValue(SignatureValue) 

    /**
     * Sets the value of field 'signedInfo'.
     * 
     * @param signedInfo the value of field 'signedInfo'.
    **/
    public void setSignedInfo(SignedInfo signedInfo)
    {
        this._signedInfo = signedInfo;
    } //-- void setSignedInfo(SignedInfo) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
