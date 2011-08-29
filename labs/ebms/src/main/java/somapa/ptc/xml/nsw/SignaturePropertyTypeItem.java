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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import org.exolab.castor.xml.*;

/**
 * 
 * 
 * @version $Revision$ $Date$
**/
public class SignaturePropertyTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.ArrayList _anyObject;


      //----------------/
     //- Constructors -/
    //----------------/

    public SignaturePropertyTypeItem() {
        super();
        _anyObject = new ArrayList();
    } //-- somapa.ptc.xml.nsw.SignaturePropertyTypeItem()


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

}
