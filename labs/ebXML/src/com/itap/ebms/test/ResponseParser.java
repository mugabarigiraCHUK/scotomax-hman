package com.itap.ebms.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

public class ResponseParser {

	@Test
	public void responseParsing() throws Exception {
		File file = new File( getClass().getClassLoader().getResource("response.out").getPath() );
		StringBuffer contents = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String text = null;
        while ((text = reader.readLine()) != null) {
            contents.append(text).append(System.getProperty("line.separator"));
        }
        
        String strXML = contents.substring(contents.indexOf("<soap:Envelope")).toString();
        System.out.println( strXML );
        
        String body = strXML.substring(strXML.indexOf("<eb:MessageHeader"), strXML.indexOf("</eb:MessageHeader"));
        System.out.println( "Body: "+body );
        
        String action = body.substring(body.indexOf("<eb:Action"), body.indexOf("</eb:Action>"));
        String valAction = action.substring(action.indexOf('>')+1);
        System.out.println( "Action: "+valAction );
        
        String errorList = strXML.substring(strXML.indexOf("<eb:ErrorList"), strXML.indexOf("</eb:ErrorList>"));
        String error = errorList.substring(errorList.indexOf("<eb:Error"), errorList.indexOf("</eb:Error>"));
        String valError = error.substring(error.indexOf('>')+1);
        
        String description = valError.substring(valError.indexOf("<eb:Description"), valError.indexOf("</eb:Description>"));
        String valDesc = description.substring(description.indexOf('>')+1);
        System.out.println( "Error Description: "+valDesc );
        
	}
}
