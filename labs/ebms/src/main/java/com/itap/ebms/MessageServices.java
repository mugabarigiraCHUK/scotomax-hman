package com.itap.ebms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.ebms.resp.LicenseResponse;

/**
 * 
 * @author ITAP
 * @version 1.0.0
 * @web.servlet
 *   name=MessageServices
 * @web.servlet-init-param
 *   name=pidFrom
 *   value=From : Party ID
 * @web.servlet-init-param
 *   name=pidTo
 *   value=To : Party ID
 * @web.servlet-init-param
 *   name=idCPA
 *   value=CPA ID
 * @web.servlet-init-param
 *   name=idConversation
 *   value=Message ID
 * @web.servlet-init-param
 *   name=services
 *   value=CPA : Services Name
 * @web.servlet-init-param
 *   name=action
 *   value=CPA : Services Action
 * @web.servlet-mapping
 *   url-pattern=/DOBE/LicenseResponse
 *
 */
public class MessageServices extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6960399047906568747L;
	
	// Logger
	final Logger logger = LoggerFactory.getLogger(MessageServices.class);
	// String line separator
	final String CR = System.getProperty("line.separator");
	
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
				reqXML.append( line + CR );
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
						MIME1.append( line + CR );
					} else {
						MIME2.append( line + CR );
					}
				}
			}
			
			logger.info(" *** Data content *** ");
			logger.info( reqXML.toString() );
			
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
				
				respStr.append("HTTP/1.1 200 OK"+CR);
				respStr.append("MIME-Version: 1.0"+CR);
				respStr.append("Content-Type: text/xml"+CR);
				respStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+CR);
				respStr.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+CR);
				respStr.append("			   xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\""+CR);
				respStr.append("			   xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/"+CR);
				respStr.append("								   http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">"+CR);
				respStr.append("	<soap:Header xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\""+CR);
				respStr.append("				 xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd"+CR);
				respStr.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">"+CR);
				respStr.append("		<eb:MessageHeader eb:version=\"2.0\" soap:mustUnderstand=\"1\">"+CR);
				respStr.append("			<eb:From>"+CR);
				respStr.append("				<eb:PartyId>"+pidFrom+"</eb:PartyId>"+CR);
				respStr.append("				<eb:Role>DOBE</eb:Role>"+CR);
				respStr.append("			</eb:From>"+CR);
				respStr.append("			<eb:To>"+CR);
				respStr.append("				<eb:PartyId>"+header.fromPartyId+"</eb:PartyId>"+CR);
				respStr.append("				<eb:Role>"+header.fromRole+"</eb:Role>"+CR);
				respStr.append("			</eb:To>"+CR);
				respStr.append("			<eb:CPAId>"+idCPA+"</eb:CPAId>"+CR);
				respStr.append("			<eb:ConversationId>"+header.messageId+"</eb:ConversationId>"+CR);
				respStr.append("			<eb:Service>"+services+"</eb:Service>"+CR);
				respStr.append("			<eb:Action>"+action+"</eb:Action>"+CR);
				respStr.append("			<eb:MessageData>"+CR);
				respStr.append("				<eb:MessageId>"+header.messageId+"</eb:MessageId>"+CR);
				respStr.append("				<eb:Timestamp>"+timestamp.toXMLFormat()+"</eb:Timestamp>"+CR);
				respStr.append("				<eb:RefToMessageId>"+header.messageId+"</eb:RefToMessageId>"+CR);
				respStr.append("			</eb:MessageData>"+CR);
				respStr.append("		</eb:MessageHeader>"+CR);
				respStr.append("		<eb:Acknowledgment eb:id=\""+header.messageId+"\" eb:version=\"2.0\" soap:actor=\"...\" soap:mustUnderstand=\"1\">"+CR);
				respStr.append("			<eb:Timestamp>"+timestamp.toXMLFormat()+"</eb:Timestamp>"+CR);
				respStr.append("			<eb:RefToMessageId>"+header.messageId+"</eb:RefToMessageId>"+CR);
				respStr.append("			<eb:From>"+CR);
				respStr.append("				<eb:PartyId eb:type=\"string\">"+header.fromPartyId+"</eb:PartyId>"+CR);
				respStr.append("				<eb:Role>"+header.fromRole+"</eb:Role>"+CR);
				respStr.append("			</eb:From>"+CR);
				
				respStr.append("			<eb:Reference URI=\"\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\" >"+CR);
				respStr.append("			   <eb:Transform/>"+CR);
				respStr.append("			   <eb:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>"+CR);
				respStr.append("			   <eb:DigestValue>...</eb:DigestValue>"+CR);
				respStr.append("			</eb:Reference>"+CR);
				respStr.append("			<eb:Reference URI=\"cid:Acknowledge"+header.messageId+"\" xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\" >"+CR);
				respStr.append("			   <eb:Transform/>"+CR);
				respStr.append("			   <eb:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>"+CR);
				respStr.append("			   <eb:DigestValue>...</eb:DigestValue>"+CR);
				respStr.append("			</eb:Reference>"+CR);
				
				respStr.append("		</eb:Acknowledgment>"+CR);
				respStr.append("	</soap:Header>"+CR);
				respStr.append("	<soap:Body xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
				respStr.append("			   xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + CR);
				respStr.append("									http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"/>"+CR);
				respStr.append("</soap:Envelope>"+CR);
			} catch ( Exception ex ) {
				respStr = new StringBuffer();
				respStr.append("HTTP/1.1 500 Internal Server Error"+CR);
				respStr.append("MIME-Version: 1.0"+CR);
				respStr.append("Content-Type: text/xml"+CR);
				respStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+CR);
				respStr.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+CR);
				respStr.append("			   xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\""+CR);
				respStr.append("			   xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/"+CR);
				respStr.append("								   http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">"+CR);
				respStr.append("	<soap:Header xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\""+CR);
				respStr.append("				 xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd"+CR);
				respStr.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">"+CR);
				respStr.append("		<eb:MessageHeader eb:version=\"2.0\" soap:mustUnderstand=\"1\">"+CR);
				respStr.append("			<eb:From>"+CR);
				respStr.append("				<eb:PartyId>"+pidFrom+"</eb:PartyId>"+CR);
				respStr.append("				<eb:Role>DOBE</eb:Role>"+CR);
				respStr.append("			</eb:From>"+CR);
				respStr.append("			<eb:To>"+CR);
				respStr.append("				<eb:PartyId>"+pidTo+"</eb:PartyId>"+CR);
				respStr.append("				<eb:Role>NSW</eb:Role>"+CR);
				respStr.append("			</eb:To>"+CR);
				respStr.append("			<eb:CPAId>"+idCPA+"</eb:CPAId>"+CR);
				respStr.append("			<eb:ConversationId>"+idConversation+"</eb:ConversationId>"+CR);
				respStr.append("			<eb:Service>"+services+"</eb:Service>"+CR);
				respStr.append("			<eb:Action>"+action+"</eb:Action>"+CR);
				respStr.append("			<eb:MessageData>"+CR);
				respStr.append("				<eb:MessageId>"+idConversation+"</eb:MessageId>"+CR);
				respStr.append("				<eb:Timestamp>"+timestamp.toXMLFormat()+"</eb:Timestamp>"+CR);
				respStr.append("				<eb:RefToMessageId>"+idConversation+"</eb:RefToMessageId>"+CR);
				respStr.append("			</eb:MessageData>"+CR);
				respStr.append("		</eb:MessageHeader>"+CR);
				respStr.append("		<eb:ErrorList>"+CR);
				respStr.append("			<eb:Error eb:id=\"\" eb:codeContext=\"\" eb:errorCode=\"\" eb:severity=\"Warning\" eb:location=\"\">"+CR);
				respStr.append("				<eb:Description></eb:Description>"+CR);;
				respStr.append("			</eb:Error>"+CR);
				respStr.append("		</eb:ErrorList>"+CR);
				respStr.append("	</soap:Header>"+CR);
				respStr.append("	<soap:Body xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
				respStr.append("			   xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + CR);
				respStr.append("									http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"/>"+CR);
				respStr.append("</soap:Envelope>"+CR);
			}
		} catch ( Exception ex ) {
			logger.error("Failed to read stream from servlet request, " + ex.getMessage() );
			respStr = new StringBuffer();
			respStr.append("HTTP/1.1 500 Internal Server Error"+CR);
			respStr.append("MIME-Version: 1.0"+CR);
			respStr.append("Content-Type: text/xml"+CR);
			respStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+CR);
			respStr.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+CR);
			respStr.append("			   xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\""+CR);
			respStr.append("			   xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/"+CR);
			respStr.append("								    http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">"+CR);
			respStr.append("	<soap:Fault>"+CR);
			respStr.append("		<faultcode>soap:Server</faultcode>"+CR);
			respStr.append("		<faultstring>"+ex.getMessage()+"</faultstring>"+CR);
			respStr.append("	</soap:Fault>"+CR);
			respStr.append("</soap:Envelope>"+CR);
		} finally {
			PrintWriter out = response.getWriter();
		    out.print(respStr.toString());
		}
	}
}
