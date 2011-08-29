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
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * 
 * 
 * @version $Revision$ $Date$
**/
public abstract class ReferenceType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _id;

    private java.lang.String _URI;

    private java.lang.String _type;

    private Transforms _transforms;

    private DigestMethod _digestMethod;


      //----------------/
     //- Constructors -/
    //----------------/

    public ReferenceType() {
        super();
    } //-- somapa.ptc.xml.nsw.ReferenceType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'digestMethod'.
     * 
     * @return the value of field 'digestMethod'.
    **/
    public DigestMethod getDigestMethod()
    {
        return this._digestMethod;
    } //-- DigestMethod getDigestMethod() 

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
     * Returns the value of field 'transforms'.
     * 
     * @return the value of field 'transforms'.
    **/
    public Transforms getTransforms()
    {
        return this._transforms;
    } //-- Transforms getTransforms() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'type'.
    **/
    public java.lang.String getType()
    {
        return this._type;
    } //-- java.lang.String getType() 

    /**
     * Returns the value of field 'URI'.
     * 
     * @return the value of field 'URI'.
    **/
    public java.lang.String getURI()
    {
        return this._URI;
    } //-- java.lang.String getURI() 

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
     * Sets the value of field 'digestMethod'.
     * 
     * @param digestMethod the value of field 'digestMethod'.
    **/
    public void setDigestMethod(DigestMethod digestMethod)
    {
        this._digestMethod = digestMethod;
    } //-- void setDigestMethod(DigestMethod) 

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
     * Sets the value of field 'transforms'.
     * 
     * @param transforms the value of field 'transforms'.
    **/
    public void setTransforms(Transforms transforms)
    {
        this._transforms = transforms;
    } //-- void setTransforms(Transforms) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
    **/
    public void setType(java.lang.String type)
    {
        this._type = type;
    } //-- void setType(java.lang.String) 

    /**
     * Sets the value of field 'URI'.
     * 
     * @param URI the value of field 'URI'.
    **/
    public void setURI(java.lang.String URI)
    {
        this._URI = URI;
    } //-- void setURI(java.lang.String) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
