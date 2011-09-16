package com.itap.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.ebms.MsgHeader;
import com.itap.ebms.SoapProducer;
import com.itap.ebms.resp.LicenseResponse;
import com.itap.service.FileService;

/**
 * Servlet implementation class LicensePerInvoiceResponseServlet
 */
public class LicensePerInvoiceResponseServlet extends HttpServlet {

	private static final long serialVersionUID = 6960399047906568747L;
	
	// Logger
	final Logger logger = LoggerFactory.getLogger(MessageServices.class);
	// String line separator
	final String cr = System.getProperty("line.separator");
	
	String pidFrom;
	String pidTo;
	String idCPA;
	String idConversation;
	String services;
	String action;
	
	/**
	 * HttpServlet get action from client
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response)
		throws ServletException, IOException {
		logger.info(" *** HttpServlet doGet(..) entering.");
		proceed(request, response);
	}
	
	/**
	 * HttpServlet post action from client
	 * 
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void doPost(HttpServletRequest request, 
					   HttpServletResponse response)
		throws ServletException, IOException {
		logger.info(" *** HttpServlet doPost(..) entering.");
		proceed(request, response);
	}
	
	/**
	 * Process Handling
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws DatatypeConfigurationException 
	 */
	private void proceed(HttpServletRequest request, 
			   			 HttpServletResponse response) 
		throws ServletException, IOException {
		logger.info(" *** HttpServlet action handling.");
		
		logger.info(" *** AuthType: "+request.getAuthType());
		logger.info(" *** ContentType: "+request.getContentType());
		logger.info(" *** ContentLength: "+request.getContentLength());
		logger.info(" *** Method: "+request.getMethod());
		
		ServletContext context = getServletContext();
		String OUTPUT_PATH = context.getInitParameter("OUTPUT_PATH");
		
		StringBuffer MIME1 = new StringBuffer();
		StringBuffer MIME2 = new StringBuffer();
		
		StringBuffer reqXML = new StringBuffer();
		StringBuffer respStr = new StringBuffer();
		
		try {
			SoapProducer soapProducer = new SoapProducer();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			
			String line;
			String boundaryValue = null;
			int mimeidx = 0;
			
			while((line = reader.readLine()) != null ) {
				reqXML.append( line + cr );
				if ( boundaryValue == null ) {
					if ( line.trim().startsWith("Content-Type:") ) {
						String[] sp = line.trim().split(";");
						if ( sp != null && sp.length > 0 ) {
							for ( String str : sp ) {
								if ( str.indexOf("=") != -1 ) {
									if ( "boundary".equals(str.trim().split("=")[0].toLowerCase()) ){
										boundaryValue = str.trim().split("=")[1];
									}
								}
							}
						}
					} 
				} else {
					if ( mimeidx == 0 ) {
						if ( line.trim().startsWith("--"+boundaryValue) ) mimeidx++;
					} else if ( mimeidx == 1 ) {
						MIME1.append( line + cr );
					} else {
						MIME2.append( line + cr );
					}
				}
			}
			
			logger.info(" *** Data content *** ");
			logger.info( reqXML.toString() );
			
			FileService fs = new FileService();
			fs.writeToFile(reqXML.toString(), OUTPUT_PATH);
			
			
			// Time stamp XML format
			DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(new Date());
			XMLGregorianCalendar timestamp = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
			
			try {
				
				if ( MIME1.toString().length() > 0 ) 
					throw new Exception("No found ebXML message header");
				if ( MIME2.toString().length() > 0 )
					throw new Exception("No fond ebXML message payload");
				
				// Parsing ebXML Header
				MsgHeader header = soapProducer.parsMessageHeader(MIME1.toString());
				if (header == null) throw new Exception("Unable parsing ebXML message header");
				
				// Parsing ebXML Payload LicenseResponse
				LicenseResponse licenseResp = soapProducer.parsLicenseResponseMsg(MIME2.toString());
				if (licenseResp == null) throw new Exception("Unable parsing ebXML message payload");
				
				
				/* ******************************************************
				 * 
				 * 
				 * A part of processing License response data from TDCNSW
				 * then update data into database system
				 * ------------------------------------------------------
				 * 
				 * 
				 * *******************************************************
				 */
				
				respStr.append("HTTP/1.1 200 OK"+cr);
				respStr.append("MIME-Version: 1.0"+cr);
				respStr.append("Content-Type: text/xml"+cr);
				respStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+cr);
				respStr.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+cr);
				respStr.append("			   xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\""+cr);
				respStr.append("			   xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/"+cr);
				respStr.append("								   http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">"+cr);
				respStr.append("	<soap:Header xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\""+cr);
				respStr.append("				 xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd"+cr);
				respStr.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">"+cr);
				respStr.append("		<eb:MessageHeader eb:version=\"2.0\" soap:mustUnderstand=\"1\">"+cr);
				respStr.append("			<eb:From>"+cr);
				respStr.append("				<eb:PartyId>"+pidFrom+"</eb:PartyId>"+cr);
				respStr.append("				<eb:Role>DOBE</eb:Role>"+cr);
				respStr.append("			</eb:From>"+cr);
				respStr.append("			<eb:To>"+cr);
				respStr.append("				<eb:PartyId>"+header.getFromPartyId()+"</eb:PartyId>"+cr);
				respStr.append("				<eb:Role>"+header.getFromRole()+"</eb:Role>"+cr);
				respStr.append("			</eb:To>"+cr);
				respStr.append("			<eb:CPAId>"+idCPA+"</eb:CPAId>"+cr);
				respStr.append("			<eb:ConversationId>"+header.getMessageId()+"</eb:ConversationId>"+cr);
				respStr.append("			<eb:Service>"+services+"</eb:Service>"+cr);
				respStr.append("			<eb:Action>"+action+"</eb:Action>"+cr);
				respStr.append("			<eb:MessageData>"+cr);
				respStr.append("				<eb:MessageId>"+header.getMessageId()+"</eb:MessageId>"+cr);
				respStr.append("				<eb:Timestamp>"+timestamp.toXMLFormat()+"</eb:Timestamp>"+cr);
				respStr.append("				<eb:RefToMessageId>"+header.getMessageId()+"</eb:RefToMessageId>"+cr);
				respStr.append("			</eb:MessageData>"+cr);
				respStr.append("		</eb:MessageHeader>"+cr);
				respStr.append("		<eb:Acknowledgment eb:id=\""+header.getMessageId()+"\" eb:version=\"2.0\" soap:actor=\"...\" soap:mustUnderstand=\"1\">"+cr);
				respStr.append("			<eb:Timestamp>"+timestamp.toXMLFormat()+"</eb:Timestamp>"+cr);
				respStr.append("			<eb:RefToMessageId>"+header.getMessageId()+"</eb:RefToMessageId>"+cr);
				respStr.append("			<eb:From>"+cr);
				respStr.append("				<eb:PartyId eb:type=\"string\">"+header.getFromPartyId()+"</eb:PartyId>"+cr);
				respStr.append("				<eb:Role>"+header.getFromRole()+"</eb:Role>"+cr);
				respStr.append("			</eb:From>"+cr);
				respStr.append("		</eb:Acknowledgment>"+cr);
				respStr.append("	</soap:Header>"+cr);
				respStr.append("	<soap:Body xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + cr);
				respStr.append("			   xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + cr);
				respStr.append("									http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"/>"+cr);
				respStr.append("</soap:Envelope>"+cr);
			} catch ( Exception ex ) {
				respStr = new StringBuffer();
				respStr.append("HTTP/1.1 500 Internal Server Error"+cr);
				respStr.append("MIME-Version: 1.0"+cr);
				respStr.append("Content-Type: text/xml"+cr);
				respStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+cr);
				respStr.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+cr);
				respStr.append("			   xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\""+cr);
				respStr.append("			   xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/"+cr);
				respStr.append("								   http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">"+cr);
				respStr.append("	<soap:Header xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\""+cr);
				respStr.append("				 xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd"+cr);
				respStr.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">"+cr);
				respStr.append("		<eb:MessageHeader eb:version=\"2.0\" soap:mustUnderstand=\"1\">"+cr);
				respStr.append("			<eb:From>"+cr);
				respStr.append("				<eb:PartyId>"+pidFrom+"</eb:PartyId>"+cr);
				respStr.append("				<eb:Role>DOBE</eb:Role>"+cr);
				respStr.append("			</eb:From>"+cr);
				respStr.append("			<eb:To>"+cr);
				respStr.append("				<eb:PartyId>"+pidTo+"</eb:PartyId>"+cr);
				respStr.append("				<eb:Role>NSW</eb:Role>"+cr);
				respStr.append("			</eb:To>"+cr);
				respStr.append("			<eb:CPAId>"+idCPA+"</eb:CPAId>"+cr);
				respStr.append("			<eb:ConversationId>"+idConversation+"</eb:ConversationId>"+cr);
				respStr.append("			<eb:Service>"+services+"</eb:Service>"+cr);
				respStr.append("			<eb:Action>"+action+"</eb:Action>"+cr);
				respStr.append("			<eb:MessageData>"+cr);
				respStr.append("				<eb:MessageId>"+idConversation+"</eb:MessageId>"+cr);
				respStr.append("				<eb:Timestamp>"+timestamp.toXMLFormat()+"</eb:Timestamp>"+cr);
				respStr.append("				<eb:RefToMessageId>"+idConversation+"</eb:RefToMessageId>"+cr);
				respStr.append("			</eb:MessageData>"+cr);
				respStr.append("		</eb:MessageHeader>"+cr);
				respStr.append("		<eb:ErrorList>"+cr);
				respStr.append("			<eb:Error eb:id=\"\" eb:codeContext=\"\" eb:errorCode=\"\" eb:severity=\"Warning\" eb:location=\"\">"+cr);
				respStr.append("				<eb:Description></eb:Description>"+cr);;
				respStr.append("			</eb:Error>"+cr);
				respStr.append("		</eb:ErrorList>"+cr);
				respStr.append("	</soap:Header>"+cr);
				respStr.append("	<soap:Body xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + cr);
				respStr.append("			   xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + cr);
				respStr.append("									http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"/>"+cr);
				respStr.append("</soap:Envelope>"+cr);
			}
		} catch ( Exception ex ) {
			logger.error("Failed to read stream from servlet request, " + ex.getMessage() );
			respStr = new StringBuffer();
			respStr.append("HTTP/1.1 500 Internal Server Error"+cr);
			respStr.append("MIME-Version: 1.0"+cr);
			respStr.append("Content-Type: text/xml"+cr);
			respStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+cr);
			respStr.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+cr);
			respStr.append("			   xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\""+cr);
			respStr.append("			   xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/"+cr);
			respStr.append("								    http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">"+cr);
			respStr.append("	<soap:Fault>"+cr);
			respStr.append("		<faultcode>soap:Server</faultcode>"+cr);
			respStr.append("		<faultstring>"+ex.getMessage()+"</faultstring>"+cr);
			respStr.append("	</soap:Fault>"+cr);
			respStr.append("</soap:Envelope>"+cr);
		} finally {
			PrintWriter out = response.getWriter();
		    out.print(respStr.toString());
		}
	}

}
