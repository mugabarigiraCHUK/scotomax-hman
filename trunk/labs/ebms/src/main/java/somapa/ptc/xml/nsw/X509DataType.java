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
public abstract class X509DataType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public X509DataType() {
        super();
        _items = new ArrayList();
    } //-- somapa.ptc.xml.nsw.X509DataType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vX509DataTypeItem
    **/
    public void addX509DataTypeItem(somapa.ptc.xml.nsw.X509DataTypeItem vX509DataTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vX509DataTypeItem);
    } //-- void addX509DataTypeItem(somapa.ptc.xml.nsw.X509DataTypeItem) 

    /**
     * 
     * 
     * @param index
     * @param vX509DataTypeItem
    **/
    public void addX509DataTypeItem(int index, somapa.ptc.xml.nsw.X509DataTypeItem vX509DataTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vX509DataTypeItem);
    } //-- void addX509DataTypeItem(int, somapa.ptc.xml.nsw.X509DataTypeItem) 

    /**
    **/
    public void clearX509DataTypeItem()
    {
        _items.clear();
    } //-- void clearX509DataTypeItem() 

    /**
    **/
    public java.util.Enumeration enumerateX509DataTypeItem()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_items.iterator());
    } //-- java.util.Enumeration enumerateX509DataTypeItem() 

    /**
     * 
     * 
     * @param index
    **/
    public somapa.ptc.xml.nsw.X509DataTypeItem getX509DataTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (somapa.ptc.xml.nsw.X509DataTypeItem) _items.get(index);
    } //-- somapa.ptc.xml.nsw.X509DataTypeItem getX509DataTypeItem(int) 

    /**
    **/
    public somapa.ptc.xml.nsw.X509DataTypeItem[] getX509DataTypeItem()
    {
        int size = _items.size();
        somapa.ptc.xml.nsw.X509DataTypeItem[] mArray = new somapa.ptc.xml.nsw.X509DataTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (somapa.ptc.xml.nsw.X509DataTypeItem) _items.get(index);
        }
        return mArray;
    } //-- somapa.ptc.xml.nsw.X509DataTypeItem[] getX509DataTypeItem() 

    /**
    **/
    public int getX509DataTypeItemCount()
    {
        return _items.size();
    } //-- int getX509DataTypeItemCount() 

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
     * @param vX509DataTypeItem
    **/
    public boolean removeX509DataTypeItem(somapa.ptc.xml.nsw.X509DataTypeItem vX509DataTypeItem)
    {
        boolean removed = _items.remove(vX509DataTypeItem);
        return removed;
    } //-- boolean removeX509DataTypeItem(somapa.ptc.xml.nsw.X509DataTypeItem) 

    /**
     * 
     * 
     * @param index
     * @param vX509DataTypeItem
    **/
    public void setX509DataTypeItem(int index, somapa.ptc.xml.nsw.X509DataTypeItem vX509DataTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vX509DataTypeItem);
    } //-- void setX509DataTypeItem(int, somapa.ptc.xml.nsw.X509DataTypeItem) 

    /**
     * 
     * 
     * @param x509DataTypeItemArray
    **/
    public void setX509DataTypeItem(somapa.ptc.xml.nsw.X509DataTypeItem[] x509DataTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < x509DataTypeItemArray.length; i++) {
            _items.add(x509DataTypeItemArray[i]);
        }
    } //-- void setX509DataTypeItem(somapa.ptc.xml.nsw.X509DataTypeItem) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
