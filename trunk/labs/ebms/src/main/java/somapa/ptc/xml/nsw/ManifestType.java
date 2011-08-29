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
public abstract class ManifestType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _id;

    private java.util.ArrayList _referenceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ManifestType() {
        super();
        _referenceList = new ArrayList();
    } //-- somapa.ptc.xml.nsw.ManifestType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vReference
    **/
    public void addReference(Reference vReference)
        throws java.lang.IndexOutOfBoundsException
    {
        _referenceList.add(vReference);
    } //-- void addReference(Reference) 

    /**
     * 
     * 
     * @param index
     * @param vReference
    **/
    public void addReference(int index, Reference vReference)
        throws java.lang.IndexOutOfBoundsException
    {
        _referenceList.add(index, vReference);
    } //-- void addReference(int, Reference) 

    /**
    **/
    public void clearReference()
    {
        _referenceList.clear();
    } //-- void clearReference() 

    /**
    **/
    public java.util.Enumeration enumerateReference()
    {
        return new org.exolab.castor.util.IteratorEnumeration(_referenceList.iterator());
    } //-- java.util.Enumeration enumerateReference() 

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
    public Reference getReference(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _referenceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (Reference) _referenceList.get(index);
    } //-- Reference getReference(int) 

    /**
    **/
    public Reference[] getReference()
    {
        int size = _referenceList.size();
        Reference[] mArray = new Reference[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (Reference) _referenceList.get(index);
        }
        return mArray;
    } //-- Reference[] getReference() 

    /**
    **/
    public int getReferenceCount()
    {
        return _referenceList.size();
    } //-- int getReferenceCount() 

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
     * @param vReference
    **/
    public boolean removeReference(Reference vReference)
    {
        boolean removed = _referenceList.remove(vReference);
        return removed;
    } //-- boolean removeReference(Reference) 

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
     * @param vReference
    **/
    public void setReference(int index, Reference vReference)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _referenceList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _referenceList.set(index, vReference);
    } //-- void setReference(int, Reference) 

    /**
     * 
     * 
     * @param referenceArray
    **/
    public void setReference(Reference[] referenceArray)
    {
        //-- copy array
        _referenceList.clear();
        for (int i = 0; i < referenceArray.length; i++) {
            _referenceList.add(referenceArray[i]);
        }
    } //-- void setReference(Reference) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
