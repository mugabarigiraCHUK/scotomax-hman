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
public abstract class SignaturePropertyType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _target;

    private java.lang.String _id;

    /**
     * internal content storage
    **/
    private java.lang.String _content = "";

    private java.util.ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public SignaturePropertyType() {
        super();
        setContent("");
        _items = new ArrayList();
    } //-- somapa.ptc.xml.nsw.SignaturePropertyType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSignaturePropertyTypeItem
    **/
    public void addSignaturePropertyTypeItem(somapa.ptc.xml.nsw.SignaturePropertyTypeItem vSignaturePropertyTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vSignaturePropertyTypeItem);
    } //-- void addSignaturePropertyTypeItem(somapa.ptc.xml.nsw.SignaturePropertyTypeItem) 

    /**
     * 
     * 
     * @param index
     * @param vSignaturePropertyTypeItem
    **/
    public void addSignaturePropertyTypeItem(int index, somapa.ptc.xml.nsw.SignaturePropertyTypeItem vSignaturePropertyTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vSignaturePropertyTypeItem);
    } //-- void addSignaturePropertyTypeItem(int, somapa.ptc.xml.nsw.SignaturePropertyTypeItem) 

    /**
    **/
    public void clearSignaturePropertyTypeItem()
    {
        _items.clear();
    } //-- void clearSignaturePropertyTypeItem() 

    /**
    **/
    public java.util.Enumeration enumerateSignaturePropertyTypeItem()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_items.iterator());
    } //-- java.util.Enumeration enumerateSignaturePropertyTypeItem() 

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
    public somapa.ptc.xml.nsw.SignaturePropertyTypeItem getSignaturePropertyTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (somapa.ptc.xml.nsw.SignaturePropertyTypeItem) _items.get(index);
    } //-- somapa.ptc.xml.nsw.SignaturePropertyTypeItem getSignaturePropertyTypeItem(int) 

    /**
    **/
    public somapa.ptc.xml.nsw.SignaturePropertyTypeItem[] getSignaturePropertyTypeItem()
    {
        int size = _items.size();
        somapa.ptc.xml.nsw.SignaturePropertyTypeItem[] mArray = new somapa.ptc.xml.nsw.SignaturePropertyTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (somapa.ptc.xml.nsw.SignaturePropertyTypeItem) _items.get(index);
        }
        return mArray;
    } //-- somapa.ptc.xml.nsw.SignaturePropertyTypeItem[] getSignaturePropertyTypeItem() 

    /**
    **/
    public int getSignaturePropertyTypeItemCount()
    {
        return _items.size();
    } //-- int getSignaturePropertyTypeItemCount() 

    /**
     * Returns the value of field 'target'.
     * 
     * @return the value of field 'target'.
    **/
    public java.lang.String getTarget()
    {
        return this._target;
    } //-- java.lang.String getTarget() 

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
     * @param vSignaturePropertyTypeItem
    **/
    public boolean removeSignaturePropertyTypeItem(somapa.ptc.xml.nsw.SignaturePropertyTypeItem vSignaturePropertyTypeItem)
    {
        boolean removed = _items.remove(vSignaturePropertyTypeItem);
        return removed;
    } //-- boolean removeSignaturePropertyTypeItem(somapa.ptc.xml.nsw.SignaturePropertyTypeItem) 

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
     * @param vSignaturePropertyTypeItem
    **/
    public void setSignaturePropertyTypeItem(int index, somapa.ptc.xml.nsw.SignaturePropertyTypeItem vSignaturePropertyTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vSignaturePropertyTypeItem);
    } //-- void setSignaturePropertyTypeItem(int, somapa.ptc.xml.nsw.SignaturePropertyTypeItem) 

    /**
     * 
     * 
     * @param signaturePropertyTypeItemArray
    **/
    public void setSignaturePropertyTypeItem(somapa.ptc.xml.nsw.SignaturePropertyTypeItem[] signaturePropertyTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < signaturePropertyTypeItemArray.length; i++) {
            _items.add(signaturePropertyTypeItemArray[i]);
        }
    } //-- void setSignaturePropertyTypeItem(somapa.ptc.xml.nsw.SignaturePropertyTypeItem) 

    /**
     * Sets the value of field 'target'.
     * 
     * @param target the value of field 'target'.
    **/
    public void setTarget(java.lang.String target)
    {
        this._target = target;
    } //-- void setTarget(java.lang.String) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
