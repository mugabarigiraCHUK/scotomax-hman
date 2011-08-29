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
public abstract class KeyValueType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
    **/
    private java.lang.String _content = "";

    private DSAKeyValue _DSAKeyValue;

    private RSAKeyValue _RSAKeyValue;

    private java.util.ArrayList _anyObject;


      //----------------/
     //- Constructors -/
    //----------------/

    public KeyValueType() {
        super();
        setContent("");
        _anyObject = new ArrayList();
    } //-- somapa.ptc.xml.nsw.KeyValueType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAnyObject
    **/
    public void addAnyObject(java.lang.Object vAnyObject)
        throws java.lang.IndexOutOfBoundsException
    {
        _anyObject.add(vAnyObject);
    } //-- void addAnyObject(java.lang.Object) 

    /**
     * 
     * 
     * @param index
     * @param vAnyObject
    **/
    public void addAnyObject(int index, java.lang.Object vAnyObject)
        throws java.lang.IndexOutOfBoundsException
    {
        _anyObject.add(index, vAnyObject);
    } //-- void addAnyObject(int, java.lang.Object) 

    /**
    **/
    public void clearAnyObject()
    {
        _anyObject.clear();
    } //-- void clearAnyObject() 

    /**
    **/
    public java.util.Enumeration enumerateAnyObject()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_anyObject.iterator());
    } //-- java.util.Enumeration enumerateAnyObject() 

    /**
     * 
     * 
     * @param index
    **/
    public java.lang.Object getAnyObject(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _anyObject.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (java.lang.Object) _anyObject.get(index);
    } //-- java.lang.Object getAnyObject(int) 

    /**
    **/
    public java.lang.Object[] getAnyObject()
    {
        int size = _anyObject.size();
        java.lang.Object[] mArray = new java.lang.Object[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (java.lang.Object) _anyObject.get(index);
        }
        return mArray;
    } //-- java.lang.Object[] getAnyObject() 

    /**
    **/
    public int getAnyObjectCount()
    {
        return _anyObject.size();
    } //-- int getAnyObjectCount() 

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return the value of field 'content'.
    **/
    public java.lang.String getContent()
    {
        return this._content;
    } //-- java.lang.String getContent() 

    /**
     * Returns the value of field 'DSAKeyValue'.
     * 
     * @return the value of field 'DSAKeyValue'.
    **/
    public DSAKeyValue getDSAKeyValue()
    {
        return this._DSAKeyValue;
    } //-- DSAKeyValue getDSAKeyValue() 

    /**
     * Returns the value of field 'RSAKeyValue'.
     * 
     * @return the value of field 'RSAKeyValue'.
    **/
    public RSAKeyValue getRSAKeyValue()
    {
        return this._RSAKeyValue;
    } //-- RSAKeyValue getRSAKeyValue() 

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
     * @param vAnyObject
    **/
    public boolean removeAnyObject(java.lang.Object vAnyObject)
    {
        boolean removed = _anyObject.remove(vAnyObject);
        return removed;
    } //-- boolean removeAnyObject(java.lang.Object) 

    /**
     * 
     * 
     * @param index
     * @param vAnyObject
    **/
    public void setAnyObject(int index, java.lang.Object vAnyObject)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _anyObject.size())) {
            throw new IndexOutOfBoundsException();
        }
        _anyObject.set(index, vAnyObject);
    } //-- void setAnyObject(int, java.lang.Object) 

    /**
     * 
     * 
     * @param anyObjectArray
    **/
    public void setAnyObject(java.lang.Object[] anyObjectArray)
    {
        //-- copy array
        _anyObject.clear();
        for (int i = 0; i < anyObjectArray.length; i++) {
            _anyObject.add(anyObjectArray[i]);
        }
    } //-- void setAnyObject(java.lang.Object) 

    /**
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
    **/
    public void setContent(java.lang.String content)
    {
        this._content = content;
    } //-- void setContent(java.lang.String) 

    /**
     * Sets the value of field 'DSAKeyValue'.
     * 
     * @param DSAKeyValue the value of field 'DSAKeyValue'.
    **/
    public void setDSAKeyValue(DSAKeyValue DSAKeyValue)
    {
        this._DSAKeyValue = DSAKeyValue;
    } //-- void setDSAKeyValue(DSAKeyValue) 

    /**
     * Sets the value of field 'RSAKeyValue'.
     * 
     * @param RSAKeyValue the value of field 'RSAKeyValue'.
    **/
    public void setRSAKeyValue(RSAKeyValue RSAKeyValue)
    {
        this._RSAKeyValue = RSAKeyValue;
    } //-- void setRSAKeyValue(RSAKeyValue) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
