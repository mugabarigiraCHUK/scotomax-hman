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
public abstract class SPKIDataType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public SPKIDataType() {
        super();
        _items = new ArrayList();
    } //-- somapa.ptc.xml.nsw.SPKIDataType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSPKIDataTypeItem
    **/
    public void addSPKIDataTypeItem(somapa.ptc.xml.nsw.SPKIDataTypeItem vSPKIDataTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vSPKIDataTypeItem);
    } //-- void addSPKIDataTypeItem(somapa.ptc.xml.nsw.SPKIDataTypeItem) 

    /**
     * 
     * 
     * @param index
     * @param vSPKIDataTypeItem
    **/
    public void addSPKIDataTypeItem(int index, somapa.ptc.xml.nsw.SPKIDataTypeItem vSPKIDataTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vSPKIDataTypeItem);
    } //-- void addSPKIDataTypeItem(int, somapa.ptc.xml.nsw.SPKIDataTypeItem) 

    /**
    **/
    public void clearSPKIDataTypeItem()
    {
        _items.clear();
    } //-- void clearSPKIDataTypeItem() 

    /**
    **/
    public java.util.Enumeration enumerateSPKIDataTypeItem()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_items.iterator());
    } //-- java.util.Enumeration enumerateSPKIDataTypeItem() 

    /**
     * 
     * 
     * @param index
    **/
    public somapa.ptc.xml.nsw.SPKIDataTypeItem getSPKIDataTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (somapa.ptc.xml.nsw.SPKIDataTypeItem) _items.get(index);
    } //-- somapa.ptc.xml.nsw.SPKIDataTypeItem getSPKIDataTypeItem(int) 

    /**
    **/
    public somapa.ptc.xml.nsw.SPKIDataTypeItem[] getSPKIDataTypeItem()
    {
        int size = _items.size();
        somapa.ptc.xml.nsw.SPKIDataTypeItem[] mArray = new somapa.ptc.xml.nsw.SPKIDataTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (somapa.ptc.xml.nsw.SPKIDataTypeItem) _items.get(index);
        }
        return mArray;
    } //-- somapa.ptc.xml.nsw.SPKIDataTypeItem[] getSPKIDataTypeItem() 

    /**
    **/
    public int getSPKIDataTypeItemCount()
    {
        return _items.size();
    } //-- int getSPKIDataTypeItemCount() 

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
     * @param vSPKIDataTypeItem
    **/
    public boolean removeSPKIDataTypeItem(somapa.ptc.xml.nsw.SPKIDataTypeItem vSPKIDataTypeItem)
    {
        boolean removed = _items.remove(vSPKIDataTypeItem);
        return removed;
    } //-- boolean removeSPKIDataTypeItem(somapa.ptc.xml.nsw.SPKIDataTypeItem) 

    /**
     * 
     * 
     * @param index
     * @param vSPKIDataTypeItem
    **/
    public void setSPKIDataTypeItem(int index, somapa.ptc.xml.nsw.SPKIDataTypeItem vSPKIDataTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vSPKIDataTypeItem);
    } //-- void setSPKIDataTypeItem(int, somapa.ptc.xml.nsw.SPKIDataTypeItem) 

    /**
     * 
     * 
     * @param SPKIDataTypeItemArray
    **/
    public void setSPKIDataTypeItem(somapa.ptc.xml.nsw.SPKIDataTypeItem[] SPKIDataTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < SPKIDataTypeItemArray.length; i++) {
            _items.add(SPKIDataTypeItemArray[i]);
        }
    } //-- void setSPKIDataTypeItem(somapa.ptc.xml.nsw.SPKIDataTypeItem) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
