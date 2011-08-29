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
public abstract class TransformsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.ArrayList _transformList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransformsType() {
        super();
        _transformList = new ArrayList();
    } //-- somapa.ptc.xml.nsw.TransformsType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTransform
    **/
    public void addTransform(Transform vTransform)
        throws java.lang.IndexOutOfBoundsException
    {
        _transformList.add(vTransform);
    } //-- void addTransform(Transform) 

    /**
     * 
     * 
     * @param index
     * @param vTransform
    **/
    public void addTransform(int index, Transform vTransform)
        throws java.lang.IndexOutOfBoundsException
    {
        _transformList.add(index, vTransform);
    } //-- void addTransform(int, Transform) 

    /**
    **/
    public void clearTransform()
    {
        _transformList.clear();
    } //-- void clearTransform() 

    /**
    **/
    public java.util.Enumeration enumerateTransform()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_transformList.iterator());
    } //-- java.util.Enumeration enumerateTransform() 

    /**
     * 
     * 
     * @param index
    **/
    public Transform getTransform(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _transformList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Transform) _transformList.get(index);
    } //-- Transform getTransform(int) 

    /**
    **/
    public Transform[] getTransform()
    {
        int size = _transformList.size();
        Transform[] mArray = new Transform[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Transform) _transformList.get(index);
        }
        return mArray;
    } //-- Transform[] getTransform() 

    /**
    **/
    public int getTransformCount()
    {
        return _transformList.size();
    } //-- int getTransformCount() 

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
     * @param vTransform
    **/
    public boolean removeTransform(Transform vTransform)
    {
        boolean removed = _transformList.remove(vTransform);
        return removed;
    } //-- boolean removeTransform(Transform) 

    /**
     * 
     * 
     * @param index
     * @param vTransform
    **/
    public void setTransform(int index, Transform vTransform)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _transformList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _transformList.set(index, vTransform);
    } //-- void setTransform(int, Transform) 

    /**
     * 
     * 
     * @param transformArray
    **/
    public void setTransform(Transform[] transformArray)
    {
        //-- copy array
        _transformList.clear();
        for (int i = 0; i < transformArray.length; i++) {
            _transformList.add(transformArray[i]);
        }
    } //-- void setTransform(Transform) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
