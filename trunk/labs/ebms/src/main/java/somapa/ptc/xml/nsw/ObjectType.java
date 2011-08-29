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
public abstract class ObjectType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _id;

    private java.lang.String _mimeType;

    private java.lang.String _encoding;

    /**
     * internal content storage
    **/
    private java.lang.String _content = "";

    private java.util.ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ObjectType() {
        super();
        setContent("");
        _items = new ArrayList();
    } //-- somapa.ptc.xml.nsw.ObjectType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vObjectTypeItem
    **/
    public void addObjectTypeItem(somapa.ptc.xml.nsw.ObjectTypeItem vObjectTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vObjectTypeItem);
    } //-- void addObjectTypeItem(somapa.ptc.xml.nsw.ObjectTypeItem) 

    /**
     * 
     * 
     * @param index
     * @param vObjectTypeItem
    **/
    public void addObjectTypeItem(int index, somapa.ptc.xml.nsw.ObjectTypeItem vObjectTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vObjectTypeItem);
    } //-- void addObjectTypeItem(int, somapa.ptc.xml.nsw.ObjectTypeItem) 

    /**
    **/
    public void clearObjectTypeItem()
    {
        _items.clear();
    } //-- void clearObjectTypeItem() 

    /**
    **/
    public java.util.Enumeration enumerateObjectTypeItem()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_items.iterator());
    } //-- java.util.Enumeration enumerateObjectTypeItem() 

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
     * Returns the value of field 'encoding'.
     * 
     * @return the value of field 'encoding'.
    **/
    public java.lang.String getEncoding()
    {
        return this._encoding;
    } //-- java.lang.String getEncoding() 

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
     * Returns the value of field 'mimeType'.
     * 
     * @return the value of field 'mimeType'.
    **/
    public java.lang.String getMimeType()
    {
        return this._mimeType;
    } //-- java.lang.String getMimeType() 

    /**
     * 
     * 
     * @param index
    **/
    public somapa.ptc.xml.nsw.ObjectTypeItem getObjectTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (somapa.ptc.xml.nsw.ObjectTypeItem) _items.get(index);
    } //-- somapa.ptc.xml.nsw.ObjectTypeItem getObjectTypeItem(int) 

    /**
    **/
    public somapa.ptc.xml.nsw.ObjectTypeItem[] getObjectTypeItem()
    {
        int size = _items.size();
        somapa.ptc.xml.nsw.ObjectTypeItem[] mArray = new somapa.ptc.xml.nsw.ObjectTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (somapa.ptc.xml.nsw.ObjectTypeItem) _items.get(index);
        }
        return mArray;
    } //-- somapa.ptc.xml.nsw.ObjectTypeItem[] getObjectTypeItem() 

    /**
    **/
    public int getObjectTypeItemCount()
    {
        return _items.size();
    } //-- int getObjectTypeItemCount() 

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
     * @param vObjectTypeItem
    **/
    public boolean removeObjectTypeItem(somapa.ptc.xml.nsw.ObjectTypeItem vObjectTypeItem)
    {
        boolean removed = _items.remove(vObjectTypeItem);
        return removed;
    } //-- boolean removeObjectTypeItem(somapa.ptc.xml.nsw.ObjectTypeItem) 

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
     * Sets the value of field 'encoding'.
     * 
     * @param encoding the value of field 'encoding'.
    **/
    public void setEncoding(java.lang.String encoding)
    {
        this._encoding = encoding;
    } //-- void setEncoding(java.lang.String) 

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
     * Sets the value of field 'mimeType'.
     * 
     * @param mimeType the value of field 'mimeType'.
    **/
    public void setMimeType(java.lang.String mimeType)
    {
        this._mimeType = mimeType;
    } //-- void setMimeType(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vObjectTypeItem
    **/
    public void setObjectTypeItem(int index, somapa.ptc.xml.nsw.ObjectTypeItem vObjectTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vObjectTypeItem);
    } //-- void setObjectTypeItem(int, somapa.ptc.xml.nsw.ObjectTypeItem) 

    /**
     * 
     * 
     * @param objectTypeItemArray
    **/
    public void setObjectTypeItem(somapa.ptc.xml.nsw.ObjectTypeItem[] objectTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < objectTypeItemArray.length; i++) {
            _items.add(objectTypeItemArray[i]);
        }
    } //-- void setObjectTypeItem(somapa.ptc.xml.nsw.ObjectTypeItem) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
