package org.hman.lab.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 
 * @author Sarayut Utsakoo
 * @version 1.0.0
 * 
 */
public class XmlValidator {
	
	// Logging
	private static Logger logger = LoggerFactory.getLogger(XmlValidator.class);
	
	private SchemaFactory factory;
	private Schema schema;
	private Validator validator;
	private DocumentBuilder parser;
	
	/**
     * Inner-class implement for Fixing Double-Checked Locking for Singleton class
     * @author Sarayut Utsakoo
     *
     */
    private static class LazyHolder {
        private static final XmlValidator xmlValidator = new XmlValidator();
    }
    
    /**
     * Getting instance class
     * 
     * @return XmlValidator instance
     */
    public static XmlValidator getInstance() {
    	return LazyHolder.xmlValidator;
    }
    
    /**
     * Initial XML validation
     * 
     * @param xsdFile
     */
    public void init(String xsdSchema) throws Exception {
    	// 1. Lookup a factory for the W3C XML Schema language
    	factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    	parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // 2. Compile the schema. 
        // Here the schema is loaded from a java.io.File, but you could use 
        // a java.net.URL or a javax.xml.transform.Source instead.
        schema = factory.newSchema(new SAXSource(new InputSource(new StringReader(xsdSchema))));
        // 3. Get a validator from the schema.
        validator = schema.newValidator();
    }

    /**
     * Validate XML
     * 
     * @param sourceXML
     * @return true when XML is valid, otherwise is false
     */
	public Boolean valid(String sourceXML) {
        try {
        	// 4. Parse the document you want to check.
            Document document = parser.parse(IOUtils.toInputStream(sourceXML));
            // 5. Check the document
            validator.validate(new DOMSource(document));
        	return true;
        } catch (SAXException ex) {
        	logger.error(ex.getMessage(), ex);
            return false;
        } catch (IOException e) {
        	logger.error(e.getMessage(), e);
            return false;
		}  
	}
}
