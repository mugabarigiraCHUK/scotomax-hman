package com.itap.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	public static Properties load(String fileName)throws IOException{
		Properties resultProperties = null;
		File file = null;
		FileInputStream input = null;
		try{
			resultProperties = new Properties();
			file = new File(fileName);
			input = new FileInputStream(file);
			resultProperties.load(input);
			input.close();
			input = null;
		}catch(IOException ioEx){
			throw ioEx;
		}finally{
			try{
				if(input != null){
					input.close();
				}
			}catch(IOException ioEx){
				throw ioEx;
			}
		}
		return resultProperties;
	}
}
