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
public abstract class KeyInfoType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _id;

    /**
     * internal content storage
    **/
    private java.lang.String _content = "";

    private java.util.ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public KeyInfoType() {
        super();
        setContent("");
        _items = new ArrayList();
    } //-- somapa.ptc.xml.nsw.KeyInfoType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vKeyInfoTypeItem
    **/
    public void addKeyInfoTypeItem(somapa.ptc.xml.nsw.KeyInfoTypeItem vKeyInfoTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vKeyInfoTypeItem);
    } //-- void addKeyInfoTypeItem(somapa.ptc.xml.nsw.KeyInfoTypeItem) 

    /**
     * 
     * 
     * @param index
     * @param vKeyInfoTypeItem
    **/
    public void addKeyInfoTypeItem(int index, somapa.ptc.xml.nsw.KeyInfoTypeItem vKeyInfoTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vKeyInfoTypeItem);
    } //-- void addKeyInfoTypeItem(int, somapa.ptc.xml.nsw.KeyInfoTypeItem) 

    /**
    **/
    public void clearKeyInfoTypeItem()
    {
        _items.clear();
    } //-- void clearKeyInfoTypeItem() 

    /**
    **/
    public java.util.Enumeration enumerateKeyInfoTypeItem()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_items.iterator());
    } //-- java.util.Enumeration enumerateKeyInfoTypeItem() 

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
    public somapa.ptc.xml.nsw.KeyInfoTypeItem getKeyInfoTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (somapa.ptc.xml.nsw.KeyInfoTypeItem) _items.get(index);
    } //-- somapa.ptc.xml.nsw.KeyInfoTypeItem getKeyInfoTypeItem(int) 

    /**
    **/
    public somapa.ptc.xml.nsw.KeyInfoTypeItem[] getKeyInfoTypeItem()
    {
        int size = _items.size();
        somapa.ptc.xml.nsw.KeyInfoTypeItem[] mArray = new somapa.ptc.xml.nsw.KeyInfoTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (somapa.ptc.xml.nsw.KeyInfoTypeItem) _items.get(index);
        }
        return mArray;
    } //-- somapa.ptc.xml.nsw.KeyInfoTypeItem[] getKeyInfoTypeItem() 

    /**
    **/
    public int getKeyInfoTypeItemCount()
    {
        return _items.size();
    } //-- int getKeyInfoTypeItemCount() 

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
     * @param vKeyInfoTypeItem
    **/
    public boolean removeKeyInfoTypeItem(somapa.ptc.xml.nsw.KeyInfoTypeItem vKeyInfoTypeItem)
    {
        boolean removed = _items.remove(vKeyInfoTypeItem);
        return removed;
    } //-- boolean removeKeyInfoTypeItem(somapa.ptc.xml.nsw.KeyInfoTypeItem) 

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
     * @param vKeyInfoTypeItem
    **/
    public void setKeyInfoTypeItem(int index, somapa.ptc.xml.nsw.KeyInfoTypeItem vKeyInfoTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vKeyInfoTypeItem);
    } //-- void setKeyInfoTypeItem(int, somapa.ptc.xml.nsw.KeyInfoTypeItem) 

    /**
     * 
     * 
     * @param keyInfoTypeItemArray
    **/
    public void setKeyInfoTypeItem(somapa.ptc.xml.nsw.KeyInfoTypeItem[] keyInfoTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < keyInfoTypeItemArray.length; i++) {
            _items.add(keyInfoTypeItemArray[i]);
        }
    } //-- void setKeyInfoTypeItem(somapa.ptc.xml.nsw.KeyInfoTypeItem) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
