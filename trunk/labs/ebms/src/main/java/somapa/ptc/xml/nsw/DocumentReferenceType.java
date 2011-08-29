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
public abstract class DocumentReferenceType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Control (10) - O - 70A - Authority Name -
     * à¸?à¸·à¹?à¸­à¹€à¸?à¹?à¸²à¸«à¸?à¹?à¸²à¸—à¸µà¹?à¸—à¸µà¹?à¸¡à¸µà¸­à¸³à¸?à¸²à¸?à¸¥à¸?à¸?à¸²à¸¡à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
    **/
    private java.lang.String _name;

    /**
     * Control (11) - M - 17A - UID Transmit -
     * à¸£à¸«à¸±à¸ªà¸?à¸¹à¹?à¸ªà¹?à¸?à¸?à¹?à¸­à¸¡à¸¹à¸¥
    **/
    private java.lang.String _userID;


      //----------------/
     //- Constructors -/
    //----------------/

    public DocumentReferenceType() {
        super();
    } //-- somapa.ptc.xml.nsw.DocumentReferenceType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'name'. The field 'name' has the
     * following description: Control (10) - O - 70A - Authority
     * Name -
     * à¸?à¸·à¹?à¸­à¹€à¸?à¹?à¸²à¸«à¸?à¹?à¸²à¸—à¸µà¹?à¸—à¸µà¹?à¸¡à¸µà¸­à¸³à¸?à¸²à¸?à¸¥à¸?à¸?à¸²à¸¡à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
     * 
     * @return the value of field 'name'.
    **/
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'userID'. The field 'userID' has
     * the following description: Control (11) - M - 17A - UID
     * Transmit - à¸£à¸«à¸±à¸ªà¸?à¸¹à¹?à¸ªà¹?à¸?à¸?à¹?à¸­à¸¡à¸¹à¸¥
     * 
     * @return the value of field 'userID'.
    **/
    public java.lang.String getUserID()
    {
        return this._userID;
    } //-- java.lang.String getUserID() 

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
     * Sets the value of field 'name'. The field 'name' has the
     * following description: Control (10) - O - 70A - Authority
     * Name -
     * à¸?à¸·à¹?à¸­à¹€à¸?à¹?à¸²à¸«à¸?à¹?à¸²à¸—à¸µà¹?à¸—à¸µà¹?à¸¡à¸µà¸­à¸³à¸?à¸²à¸?à¸¥à¸?à¸?à¸²à¸¡à¹?à¸?à¸­à¸?à¸¸à¸?à¸²à¸•
     * 
     * @param name the value of field 'name'.
    **/
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'userID'. The field 'userID' has the
     * following description: Control (11) - M - 17A - UID Transmit
     * - à¸£à¸«à¸±à¸ªà¸?à¸¹à¹?à¸ªà¹?à¸?à¸?à¹?à¸­à¸¡à¸¹à¸¥
     * 
     * @param userID the value of field 'userID'.
    **/
    public void setUserID(java.lang.String userID)
    {
        this._userID = userID;
    } //-- void setUserID(java.lang.String) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
