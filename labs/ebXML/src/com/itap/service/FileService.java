package com.itap.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileService {

	public static void main(String[] args) {
		FileService fs = new FileService();
		fs.writeToFile("dasdasdfasfgdsgdsgsf", "C:\\");
	}
	
	public void writeToFile(String data, String responsePath){
	    try {
	      DateFormat formatter ; 
	      formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
	      FileWriter fstream = new FileWriter(responsePath+formatter.format(new Date())+".txt");
	      BufferedWriter out = new BufferedWriter(fstream);
	      out.write(data);
	      out.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
}
