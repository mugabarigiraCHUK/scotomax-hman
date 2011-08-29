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
public abstract class InvoiceInfoType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Detail (3) - M - 35A - Invoice Number -
     * à¹€à¸¥à¸?à¸—à¸µà¹?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
    **/
    private java.lang.String _invoiceNo;

    /**
     * Detail (4) - M - 8N - Invoice Date -
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
     * (CCYYMMDD)
    **/
    private org.exolab.castor.types.Date _invoiceDate;

    /**
     * Detail (5) - O - 4N - Item -
     * à¸¥à¸³à¸”à¸±à¸?à¸£à¸²à¸¢à¸?à¸²à¸£à¹?à¸?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²à¸—à¸µà¹?à¸­à¸?à¸¸à¸?à¸²à¸•
    **/
    private int _itemID;

    /**
     * keeps track of state for field: _itemID
    **/
    private boolean _has_itemID;

    /**
     * Detail (8) - M - 512A - English Description of Goods -
     * à¸?à¸?à¸´à¸”à¸?à¸­à¸? à¸ à¸²à¸©à¸²à¸­à¸±à¸?à¸?à¸¤à¸©
     * à¸•à¸²à¸¡à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
    **/
    private java.lang.String _description;

    private QuantityInfo _quantityInfo;


      //----------------/
     //- Constructors -/
    //----------------/

    public InvoiceInfoType() {
        super();
    } //-- somapa.ptc.xml.nsw.InvoiceInfoType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'description'. The field
     * 'description' has the following description: Detail (8) - M
     * - 512A - English Description of Goods -
     * à¸?à¸?à¸´à¸”à¸?à¸­à¸? à¸ à¸²à¸©à¸²à¸­à¸±à¸?à¸?à¸¤à¸©
     * à¸•à¸²à¸¡à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
     * 
     * @return the value of field 'description'.
    **/
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
     * Returns the value of field 'invoiceDate'. The field
     * 'invoiceDate' has the following description: Detail (4) - M
     * - 8N - Invoice Date -
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
     * (CCYYMMDD)
     * 
     * @return the value of field 'invoiceDate'.
    **/
    public org.exolab.castor.types.Date getInvoiceDate()
    {
        return this._invoiceDate;
    } //-- org.exolab.castor.types.Date getInvoiceDate() 

    /**
     * Returns the value of field 'invoiceNo'. The field
     * 'invoiceNo' has the following description: Detail (3) - M -
     * 35A - Invoice Number -
     * à¹€à¸¥à¸?à¸—à¸µà¹?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
     * 
     * @return the value of field 'invoiceNo'.
    **/
    public java.lang.String getInvoiceNo()
    {
        return this._invoiceNo;
    } //-- java.lang.String getInvoiceNo() 

    /**
     * Returns the value of field 'itemID'. The field 'itemID' has
     * the following description: Detail (5) - O - 4N - Item -
     * à¸¥à¸³à¸”à¸±à¸?à¸£à¸²à¸¢à¸?à¸²à¸£à¹?à¸?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²à¸—à¸µà¹?à¸­à¸?à¸¸à¸?à¸²à¸•
     * 
     * @return the value of field 'itemID'.
    **/
    public int getItemID()
    {
        return this._itemID;
    } //-- int getItemID() 

    /**
     * Returns the value of field 'quantityInfo'.
     * 
     * @return the value of field 'quantityInfo'.
    **/
    public QuantityInfo getQuantityInfo()
    {
        return this._quantityInfo;
    } //-- QuantityInfo getQuantityInfo() 

    /**
    **/
    public boolean hasItemID()
    {
        return this._has_itemID;
    } //-- boolean hasItemID() 

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
     * Sets the value of field 'description'. The field
     * 'description' has the following description: Detail (8) - M
     * - 512A - English Description of Goods -
     * à¸?à¸?à¸´à¸”à¸?à¸­à¸? à¸ à¸²à¸©à¸²à¸­à¸±à¸?à¸?à¸¤à¸©
     * à¸•à¸²à¸¡à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
     * 
     * @param description the value of field 'description'.
    **/
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Sets the value of field 'invoiceDate'. The field
     * 'invoiceDate' has the following description: Detail (4) - M
     * - 8N - Invoice Date -
     * à¸§à¸±à¸?à¸—à¸µà¹?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
     * (CCYYMMDD)
     * 
     * @param invoiceDate the value of field 'invoiceDate'.
    **/
    public void setInvoiceDate(org.exolab.castor.types.Date invoiceDate)
    {
        this._invoiceDate = invoiceDate;
    } //-- void setInvoiceDate(org.exolab.castor.types.Date) 

    /**
     * Sets the value of field 'invoiceNo'. The field 'invoiceNo'
     * has the following description: Detail (3) - M - 35A -
     * Invoice Number -
     * à¹€à¸¥à¸?à¸—à¸µà¹?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²
     * 
     * @param invoiceNo the value of field 'invoiceNo'.
    **/
    public void setInvoiceNo(java.lang.String invoiceNo)
    {
        this._invoiceNo = invoiceNo;
    } //-- void setInvoiceNo(java.lang.String) 

    /**
     * Sets the value of field 'itemID'. The field 'itemID' has the
     * following description: Detail (5) - O - 4N - Item -
     * à¸¥à¸³à¸”à¸±à¸?à¸£à¸²à¸¢à¸?à¸²à¸£à¹?à¸?à¸?à¸±à¸?à¸?à¸µà¸£à¸²à¸?à¸²à¸ªà¸´à¸?à¸?à¹?à¸²à¸—à¸µà¹?à¸­à¸?à¸¸à¸?à¸²à¸•
     * 
     * @param itemID the value of field 'itemID'.
    **/
    public void setItemID(int itemID)
    {
        this._itemID = itemID;
        this._has_itemID = true;
    } //-- void setItemID(int) 

    /**
     * Sets the value of field 'quantityInfo'.
     * 
     * @param quantityInfo the value of field 'quantityInfo'.
    **/
    public void setQuantityInfo(QuantityInfo quantityInfo)
    {
        this._quantityInfo = quantityInfo;
    } //-- void setQuantityInfo(QuantityInfo) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
