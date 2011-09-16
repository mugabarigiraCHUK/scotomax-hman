package com.itap.service;

/**
 * Custom application exception class.
 */
public class JdbcException extends Exception {
    
    /**
     * Internal error number for exception. Value will be -1 if not
     * specified during object creation.
     */
    private int intError;
    
    /**
     * Default constructor used to create a JdbcExampleException exception
     * object.
     */
     JdbcException() {
     }

    /**
     * Constructor used to create a JdbcException exception object
     * specifying only the exception message string.
     * @param strMessage  Message text for the custom application exception.
     */
    public JdbcException(String strMessage) {
        super(strMessage);
    }

    /**
     * Constructor used to create a JdbcException exception object
     * specifying only the internal error number for the exception.
     * @param intErrorNum  Internal error number for the custom application
     *                     exception.
     */
    JdbcException(int intErrorNum) {
        intError = intErrorNum;
    }

    /**
     * Constructor used to create a JdbcException exception object
     * specifying both the exception message string and the internal error 
     * number for the exception.
     * @param strMessage   Message text for the custom application exception.
     * @param intErrorNum  Internal error number for the custom application
     *                     exception.
     */
    JdbcException(String strMessage, int intErrorNum) {
        super(strMessage);
        intError = intErrorNum;
    }

    /**
     * Returns a custom string representation of the object.
     * @return  The string which represents the object.
     */
    public String toString() {
        return "JdbcException ["+intError+"]";
    }

}