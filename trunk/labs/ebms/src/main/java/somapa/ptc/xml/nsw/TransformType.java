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
public abstract class TransformType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _algorithm;

    /**
     * internal content storage
    **/
    private java.lang.String _content = "";

    private java.util.ArrayList _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransformType() {
        super();
        setContent("");
        _items = new ArrayList();
    } //-- somapa.ptc.xml.nsw.TransformType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTransformTypeItem
    **/
    public void addTransformTypeItem(somapa.ptc.xml.nsw.TransformTypeItem vTransformTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(vTransformTypeItem);
    } //-- void addTransformTypeItem(somapa.ptc.xml.nsw.TransformTypeItem) 

    /**
     * 
     * 
     * @param index
     * @param vTransformTypeItem
    **/
    public void addTransformTypeItem(int index, somapa.ptc.xml.nsw.TransformTypeItem vTransformTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.add(index, vTransformTypeItem);
    } //-- void addTransformTypeItem(int, somapa.ptc.xml.nsw.TransformTypeItem) 

    /**
    **/
    public void clearTransformTypeItem()
    {
        _items.clear();
    } //-- void clearTransformTypeItem() 

    /**
    **/
    public java.util.Enumeration enumerateTransformTypeItem()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_items.iterator());
    } //-- java.util.Enumeration enumerateTransformTypeItem() 

    /**
     * Returns the value of field 'algorithm'.
     * 
     * @return the value of field 'algorithm'.
    **/
    public java.lang.String getAlgorithm()
    {
        return this._algorithm;
    } //-- java.lang.String getAlgorithm() 

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
     * 
     * 
     * @param index
    **/
    public somapa.ptc.xml.nsw.TransformTypeItem getTransformTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (somapa.ptc.xml.nsw.TransformTypeItem) _items.get(index);
    } //-- somapa.ptc.xml.nsw.TransformTypeItem getTransformTypeItem(int) 

    /**
    **/
    public somapa.ptc.xml.nsw.TransformTypeItem[] getTransformTypeItem()
    {
        int size = _items.size();
        somapa.ptc.xml.nsw.TransformTypeItem[] mArray = new somapa.ptc.xml.nsw.TransformTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (somapa.ptc.xml.nsw.TransformTypeItem) _items.get(index);
        }
        return mArray;
    } //-- somapa.ptc.xml.nsw.TransformTypeItem[] getTransformTypeItem() 

    /**
    **/
    public int getTransformTypeItemCount()
    {
        return _items.size();
    } //-- int getTransformTypeItemCount() 

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
     * @param vTransformTypeItem
    **/
    public boolean removeTransformTypeItem(somapa.ptc.xml.nsw.TransformTypeItem vTransformTypeItem)
    {
        boolean removed = _items.remove(vTransformTypeItem);
        return removed;
    } //-- boolean removeTransformTypeItem(somapa.ptc.xml.nsw.TransformTypeItem) 

    /**
     * Sets the value of field 'algorithm'.
     * 
     * @param algorithm the value of field 'algorithm'.
    **/
    public void setAlgorithm(java.lang.String algorithm)
    {
        this._algorithm = algorithm;
    } //-- void setAlgorithm(java.lang.String) 

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
     * 
     * 
     * @param index
     * @param vTransformTypeItem
    **/
    public void setTransformTypeItem(int index, somapa.ptc.xml.nsw.TransformTypeItem vTransformTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.set(index, vTransformTypeItem);
    } //-- void setTransformTypeItem(int, somapa.ptc.xml.nsw.TransformTypeItem) 

    /**
     * 
     * 
     * @param transformTypeItemArray
    **/
    public void setTransformTypeItem(somapa.ptc.xml.nsw.TransformTypeItem[] transformTypeItemArray)
    {
        //-- copy array
        _items.clear();
        for (int i = 0; i < transformTypeItemArray.length; i++) {
            _items.add(transformTypeItemArray[i]);
        }
    } //-- void setTransformTypeItem(somapa.ptc.xml.nsw.TransformTypeItem) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
