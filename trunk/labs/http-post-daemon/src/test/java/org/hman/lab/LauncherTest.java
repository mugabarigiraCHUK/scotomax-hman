package org.hman.lab;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.hman.lab.xml.XmlValidator;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class LauncherTest {
    
	@Test
	@Ignore
    public void testApp() {
    	Launcher launcher = new Launcher();
    	launcher.execute();
    }
	
	@Test
	@Ignore
	public void xmlValidateTest() throws Exception {
		String xsdFile = this.getClass().getClassLoader().getResource("response.xsd").getFile();
		String xmlFile = this.getClass().getClassLoader().getResource("request.xml").getFile();
		XmlValidator validate = XmlValidator.getInstance();
		validate.init(xsdFile);
		System.out.println( validate.valid(FileUtils.readFileToString(new File(xmlFile))) );
	}
}
