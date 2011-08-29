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

import java.io.Serializable;
import org.exolab.castor.xml.*;

/**
 * 
 * 
 * @version $Revision$ $Date$
**/
public class X509DataTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private X509DataTypeChoice _x509DataTypeChoice;


      //----------------/
     //- Constructors -/
    //----------------/

    public X509DataTypeItem() {
        super();
    } //-- somapa.ptc.xml.nsw.X509DataTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'x509DataTypeChoice'.
     * 
     * @return the value of field 'x509DataTypeChoice'.
    **/
    public X509DataTypeChoice getX509DataTypeChoice()
    {
        return this._x509DataTypeChoice;
    } //-- X509DataTypeChoice getX509DataTypeChoice() 

    /**
     * Sets the value of field 'x509DataTypeChoice'.
     * 
     * @param x509DataTypeChoice the value of field
     * 'x509DataTypeChoice'.
    **/
    public void setX509DataTypeChoice(X509DataTypeChoice x509DataTypeChoice)
    {
        this._x509DataTypeChoice = x509DataTypeChoice;
    } //-- void setX509DataTypeChoice(X509DataTypeChoice) 

}
