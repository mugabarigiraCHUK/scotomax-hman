package com.itap.ebms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.ebms.cancel.LicenseCancel;
import com.itap.ebms.req.CanonicalizationMethod;
import com.itap.ebms.req.CustomsTariffQuantityType;
import com.itap.ebms.req.DocumentDetailsTransportType;
import com.itap.ebms.req.DocumentDetailsTransportType.ProductInfo;
import com.itap.ebms.req.DocumentDetailsTransportType.ProductInfo.WeightInfo;
import com.itap.ebms.req.DocumentHeaderType;
import com.itap.ebms.req.DocumentReferenceType;
import com.itap.ebms.req.InvoiceInfoType;
import com.itap.ebms.req.KeyInfo;
import com.itap.ebms.req.LicenseInfoType;
import com.itap.ebms.req.LicensePerInvoice;
import com.itap.ebms.req.QuantityType;
import com.itap.ebms.req.Reference;
import com.itap.ebms.req.Signature;
import com.itap.ebms.req.SignatureMethod;
import com.itap.ebms.req.SignatureValue;
import com.itap.ebms.req.SignedInfo;
import com.itap.ebms.resp.LicenseResponse;
import com.itap.ebms.sign.SignatureGenerator;

/**
 * 
 * @author ITAP
 * @version 1.0.0
 *
 */
public class MessageProducer {

	// Logger
	final Logger logger = LoggerFactory.getLogger(MessageProducer.class);
	// Line separator string
	final String CR = System.getProperty("line.separator");
	// Soap producer message interface
	SoapProducer soapProducer = new SoapProducer();
	
	public MessageProducer() {
		super();
		
	}

	/**
	 * Request LicensePerInvoice
	 * 
	 * @param conversationId
	 * @param license
	 * @return String represent the word result of process
	 * @throws Exception
	 */
	public String produce(String conversationId,  LicensePerInvoice license) throws Exception {
		try {
			if ( conversationId == null || conversationId.trim().length() == 0 )
				throw new RuntimeException("System found conversation Id is empty.");
	 
			if ( license == null )
				throw new RuntimeException("System found license data container object is empty.");
			
			logger.debug("System customize conversation id to message id");
			
			String messageId = "";
			if ( conversationId.indexOf("_") != -1 ) {
				String[] sp = conversationId.split("_");
				messageId = sp[0];
				if ( DOCUMENT_REF_NAME == null || DOCUMENT_REF_NAME.trim().length() == 0 ) {
					DOCUMENT_REF_NAME = "";
					for ( int i=1; i<sp.length;i++ ) 
						if (i > 1) 
							DOCUMENT_REF_NAME = DOCUMENT_REF_NAME+"_"+sp[i];
						else
							DOCUMENT_REF_NAME = DOCUMENT_REF_NAME+sp[i];
				}
			} else messageId = conversationId;
			
			logger.debug("System call XML builder for making payload");
			soapProducer = new SoapProducer();
			String ebPayload = soapProducer.buildLicensePerInvoiceMsg(DOCUMENT_REF_NAME, 
																	messageId, 
																	license);
			ebPayload = SignatureGenerator.digitalSign(KEYSTORE_PATH, 
													KEYSTORE_PASSWORD, 
													KEYSTORE_ALIASNAME, 
													ALIASNAME_PASSWORD, 
													ebPayload, null);
			
			File outBox = new File( DIRECTORY_OUTBOX );
			if ( !outBox.exists() && !outBox.isDirectory() )
				throw new Exception("Undefined ebXML message outbox directory.");
				
			String fname = DIRECTORY_OUTBOX+"doeb_"+messageId+"_nsw.xml";
			
			logger.debug("System generate payload file name: " + fname);
			
			Writer writer = null; 
			
			try {
				
				logger.debug("System write XML string into file");
				
				File f = new File(fname);
				if ( f.exists() && f.isFile() ) {
					throw new Exception("System found this document in progress.");
				} else {
					writer = new BufferedWriter(new FileWriter(f));
					writer.write(ebPayload);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				logger.error( e.getMessage() );
				throw new Exception( e.getMessage() );
			} catch (IOException e) {
				e.printStackTrace();
				logger.error( e.getMessage() );
				throw new Exception( e.getMessage() );
			} finally {
				try {
					if (writer != null) writer.close();
				} catch ( IOException e ) {
					e.printStackTrace();
					logger.error( e.getMessage() );
				}
			}
			return "System send document request successfully.";
		} catch ( Exception e ) {
			e.printStackTrace();
			logger.error( "Failed generate Payload file into outbox, " + e.getMessage() );
			return e.getMessage();
		}
	}
	
	/**
	 * Request LicenseCancel
	 * @param conversationId
	 * @param license
	 * @return String represent the word result of process
	 * @throws Exception
	 */
	public String cancel(String conversationId,  LicenseCancel license) throws Exception {
		try {
			if ( conversationId == null || conversationId.trim().length() == 0 )
				throw new RuntimeException("System found conversation Id is empty.");
	 
			if ( license == null )
				throw new RuntimeException("System found license data container object is empty.");
			
			logger.debug("System customize conversation id to message id");
			
			String messageId = "";
			if ( conversationId.indexOf("_") != -1 ) {
				String[] sp = conversationId.split("_");
				messageId = sp[0];
				if ( DOCUMENT_REF_NAME == null || DOCUMENT_REF_NAME.trim().length() == 0 ) {
					DOCUMENT_REF_NAME = "";
					for ( int i=1; i<sp.length;i++ ) 
						if (i > 1) 
							DOCUMENT_REF_NAME = DOCUMENT_REF_NAME+"_"+sp[i];
						else
							DOCUMENT_REF_NAME = DOCUMENT_REF_NAME+sp[i];
				}
			} else messageId = conversationId;
			
			logger.debug("System call XML builder for making payload");
			
			String ebPayload = soapProducer.buildLicenseCancelMsg(DOCUMENT_REF_NAME, 
																	messageId, 
																	license);
			ebPayload = SignatureGenerator.digitalSign(KEYSTORE_PATH, 
													KEYSTORE_PASSWORD, 
													KEYSTORE_ALIASNAME, 
													ALIASNAME_PASSWORD, 
													ebPayload, null);
			
			File outBox = new File( DIRECTORY_OUTBOX );
			if ( !outBox.exists() && !outBox.isDirectory() )
				throw new Exception("Undefined ebXML message outbox directory.");
			
			String fname = DIRECTORY_OUTBOX+"doeb_"+messageId+"_nsw.xml";
			
			logger.debug("System generate payload file name: " + fname);
			
			Writer writer = null; 
			
			try {
				
				logger.debug("System write XML string into file");
				
				File f = new File(fname);
				if ( f.exists() && f.isFile() ) {
					throw new Exception("System found this document in progress.");
				} else {
					writer = new BufferedWriter(new FileWriter(f));
					writer.write(ebPayload);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				logger.error( e.getMessage() );
				throw new Exception( e.getMessage() );
			} catch (IOException e) {
				e.printStackTrace();
				logger.error( e.getMessage() );
				throw new Exception( e.getMessage() );
			} finally {
				try {
					if (writer != null) writer.close();
				} catch ( IOException e ) {
					e.printStackTrace();
					logger.error( e.getMessage() );
				}
			}
			return "System send document request successfully.";
		} catch ( Exception e ) {
			e.printStackTrace();
			logger.error( "Failed generate Payload file into outbox, " + e.getMessage() );
			return e.getMessage();
		}
	}
	
	/**
	 * Getting list of file name from inbox.
	 * @return List of file name from inbox message
	 * @throws Exception
	 */
	public List<String> getMessagesInbox() throws Exception {
		List<String> list = new ArrayList<String>();
		File finbox = new File(DIRECTORY_INBOX);
		if ( finbox.exists() && finbox.isDirectory() ) {
			File[] fList = finbox.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					// TODO Auto-generated method stub
					if ( pathname.getName().endsWith(".xml") 
							|| pathname.getName().endsWith(".XML") ) {
						return true;
					} else return false;
				}
			});
			
			if ( fList != null && fList.length > 0 ) {
				for ( File f : fList ) {
					list.add( f.getName() );
				}
			}
		} else {
			throw new Exception( "Undefined ebXML message inbox directory." );
		}
		return list;
	}
	
	
	/**
	 * Getting list of file name from inbox.
	 * @return List of file name from inbox message
	 * @throws Exception
	 */
	public List<String> getMessagesOutbox() throws Exception {
		List<String> list = new ArrayList<String>();
		File finbox = new File(DIRECTORY_OUTBOX);
		if ( finbox.exists() && finbox.isDirectory() ) {
			File[] fList = finbox.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					// TODO Auto-generated method stub
					if ( pathname.getName().endsWith(".xml") 
							|| pathname.getName().endsWith(".XML") ) {
						return true;
					} else return false;
				}
			});
			
			if ( fList != null && fList.length > 0 ) {
				for ( File f : fList ) {
					list.add( f.getName() );
				}
			}
		} else {
			throw new Exception( "Undefined ebXML message inbox directory." );
		}
		return list;
	}
	
	
	/**
	 * Parsing XML file from Outbox into data object
	 * 
	 * @param fname
	 * @return LicenseResponse.class data container
	 * @throws Exception
	 */
	public LicenseResponse getLicenseResponse(String fname) throws Exception {
		File f = new File(DIRECTORY_INBOX + "/" + fname);
		if ( f.exists() && f.isFile() ) {
			return soapProducer.parsLicenseResponseMsg(fileToString(f));
		} else {
			throw new Exception( "No found ebXML message file for parsing." );
		}
	}
	
	/**
	 * Getting all string from a file.
	 * @param File f
	 * @return String represent file content.
	 * @throws Exception
	 */
	public String fileToString(File f) throws Exception {
		if ( f.exists() && f.isFile() ) {
			StringBuffer contents = new StringBuffer();
	        BufferedReader reader = null;
	        try {
	            reader = new BufferedReader(new FileReader(f));
	            String text = null;
	            // repeat until all lines is read
	            while ((text = reader.readLine()) != null) {
	                contents.append(text)
	                        .append(System.getProperty("line.separator"));
	            }
	        } catch (FileNotFoundException e) {
	        	e.printStackTrace();
	            logger.error( e.getMessage() );
	        } catch (IOException e) {
	        	e.printStackTrace();
	        	logger.error( e.getMessage() );
	        } finally {
	            try {
	                if (reader != null)
	                	reader.close();
	            } catch (IOException e) {
	            	logger.error( e.getMessage() );
	            }
	        }
	        return contents.toString();
		} else return null;
	}
	
	/**
	 * Produce  License Per Invoice ebMS XML request to services endpoint.
	 * 
	 * @param Conversation ID String ( {ebXML UserID}_{Document Reference ID} )
	 * @param Time to live of message request (Minutes)
	 * @param LicensePerInvoice class data container
	 * @return String represent result object
	 * @throws Exception
	 * 			Code: 100, Message: Host connection problem
	 * 			Code: 101, Message: Communication/Protocols problem
	 * 			Code: 102, Message: No response from services end-point.
	 */
	public String produce(String conversationId, 
						  Integer minutesToLeave, 
						  LicensePerInvoice license) 
		throws Exception {
		
		logger.debug(" *** Debugging Time: 3");
		
		logger.debug("URI: https://"+IP_ADDRESS+":"+SERVICES_PORT+""+SERVICES_PATH );
		logger.debug("Trust store: " + TRUST_STORE_PATH );
		logger.debug("Trust store password: " + TRUST_STORE_PASSWORD );
		
		logger.debug("Conversation ID: " + conversationId );
		logger.debug("Document ref. name: " + DOCUMENT_REF_NAME );
		
		logger.debug("Keystore path: " + KEYSTORE_PATH );
		logger.debug("Keystore password: " + KEYSTORE_PASSWORD );
		logger.debug("Keystore alias: " + KEYSTORE_ALIASNAME );
		
		if ( conversationId == null || conversationId.trim().length() == 0 )
			throw new RuntimeException("System found conversation Id is empty.");
 
		if ( license == null )
			throw new RuntimeException("System found license data container object is empty.");
		
		String messageId = "";
		if ( conversationId.indexOf("_") != -1 ) {
			String[] sp = conversationId.split("_");
			messageId = sp[0];
			if ( DOCUMENT_REF_NAME == null || DOCUMENT_REF_NAME.trim().length() == 0 ) {
				DOCUMENT_REF_NAME = "";
				for ( int i=1; i<sp.length;i++ ) 
					if (i > 1) 
						DOCUMENT_REF_NAME = DOCUMENT_REF_NAME+"_"+sp[i];
					else
						DOCUMENT_REF_NAME = DOCUMENT_REF_NAME+sp[i];
			}
		} else messageId = conversationId;

		System.setProperty("javax.net.ssl.trustStore", TRUST_STORE_PATH );
		System.setProperty("javax.net.ssl.trustStorePassword", TRUST_STORE_PASSWORD );
		
		String ret = null; 
		String[] proto = {"SSLv3"}; //SSLv2Hello , SSLv3 
		BufferedWriter wr = null; 
		SSLSocket socket = null; 
		BufferedReader in = null; 
		
		try {
			// Time stamp XML format
			DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(new Date());
			XMLGregorianCalendar timestamp = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
			
			soapProducer = new SoapProducer();
			
			String ebPayload = "";
			try {
				ebPayload = soapProducer.buildLicensePerInvoiceMsg(DOCUMENT_REF_NAME, 
																	messageId, 
																	license);
				ebPayload = SignatureGenerator.digitalSign(KEYSTORE_PATH, 
														KEYSTORE_PASSWORD, 
														KEYSTORE_ALIASNAME, 
														ALIASNAME_PASSWORD, 
														ebPayload, null);
			} catch ( Exception e ) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
			
			logger.debug("Initial SSL Socket...");
			SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			socket = (SSLSocket) factory.createSocket( IP_ADDRESS, SERVICES_PORT);
			
			socket.setEnabledProtocols(proto); 
			socket.setSoTimeout(300 * 1000); 
	
			logger.debug(" *** Socket start hand shaking...");
			socket.startHandshake(); 
	       
			//Open socket output pipe streaming 
			logger.debug(" *** Open socket output pipe streaming...");
			wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")); 
			
			StringBuffer ebMS = new StringBuffer();
			
			ebMS.append("--boundaryValue" + CR); 
			ebMS.append("Content-ID: <ebxmlheader@ptc.doeb.go.th>" + CR);
			ebMS.append("Content-Type: text/xml; charset=\"UTF-8\"" + CR);
			
			ebMS.append( CR );
			// Build MessageHeade
			logger.debug(" *** Build XML MessageHeade...");
			ebMS.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + CR);
			ebMS.append("<SOAP:Envelope xmlns:xlink=\"http://www.w3.org/1999/xlink\"" + CR);
			ebMS.append("				xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\"" + CR);
			ebMS.append("				xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
			ebMS.append("				xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + CR);
			ebMS.append("				xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/" + CR);
			ebMS.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd" + CR);
			ebMS.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + CR);
			ebMS.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">" + CR);
			
			StringBuffer ebHeader = new StringBuffer();
			
			ebHeader.append("	<SOAP:Header xmlns:xlink=\"http://www.w3.org/1999/xlink\"" + CR);
			ebHeader.append("				 xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\"" + CR);
			ebHeader.append("				 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + CR);
			ebHeader.append("				 xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/" + CR);
			ebHeader.append("									  http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">" + CR);
			ebHeader.append("		<eb:MessageHeader xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
			ebHeader.append("						  version=\"2.0\"" + CR);
			ebHeader.append("						  SOAP:mustUnderstand=\"1\">" + CR);
			ebHeader.append("			<eb:From>"+CR);
			ebHeader.append("				<eb:PartyId eb:type=\"string\">"+DOEB_PARTYID+"</eb:PartyId>"+CR);
			ebHeader.append("				<eb:Role>"+DOEB_ROLE+"</eb:Role>"+CR);
			ebHeader.append("			</eb:From>"+CR);
			ebHeader.append("			<eb:To>"+CR);
			ebHeader.append("				<eb:PartyId eb:type=\"string\">"+TCDNSW_PARTYID+"</eb:PartyId>"+CR);
			ebHeader.append("				<eb:Role>"+TCDNSW_ROLE+"</eb:Role>"+CR);
			ebHeader.append("			</eb:To>"+CR);	
			ebHeader.append("			<eb:CPAId>"+TCDNSW_CPAID+"</eb:CPAId>" + CR);
			ebHeader.append("			<eb:ConversationId>"+conversationId+"</eb:ConversationId>" + CR);
			ebHeader.append("			<eb:Service eb:type=\"string\">"+TCDNSW_SERVICES+"</eb:Service>" + CR);
			ebHeader.append("			<eb:Action>"+LICENSE_PERINVOICE_ACTION+"</eb:Action>" + CR);
			ebHeader.append("			<eb:MessageData>" + CR);
			ebHeader.append("				<eb:MessageId>"+messageId+"</eb:MessageId>" + CR);
			ebHeader.append("				<eb:Timestamp>"+timestamp.toXMLFormat()+"</eb:Timestamp>" + CR);
			ebHeader.append("			</eb:MessageData>" + CR);
			ebHeader.append("		</eb:MessageHeader>" + CR);
			ebHeader.append("		<eb:SyncReply xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
			ebHeader.append("					  SOAP:actor=\"http://schema.xmlsoap.org/soap/actor/next\"" + CR);
			ebHeader.append("					  SOAP:mustUnderstand=\"1\"" + CR);
			ebHeader.append("					  eb:version=\"2.0\"/>" + CR);
			ebHeader.append("		<eb:AckRequested xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
			ebHeader.append("						 SOAP:actor=\"urn:oasis:names:tc:ebxml-msg:actor:toPartyMSH\"" + CR);
			ebHeader.append("						 SOAP:mustUnderstand=\"1\"" + CR);
			ebHeader.append("						 eb:version=\"2.0\"" + CR);
			ebHeader.append("						 eb:signed=\"false\"/>" + CR);
			ebHeader.append("	</SOAP:Header>" + CR);
			
			String signedHeader = SignatureGenerator.digitalSign(KEYSTORE_PATH, 
															KEYSTORE_PASSWORD, 
															KEYSTORE_ALIASNAME, 
															ALIASNAME_PASSWORD, 
															ebHeader.toString(), 
															"ds");
			
			// Add more ds:Reference for contain DigestValue of Payload for Signature ebXML message header.
			String digest = ebPayload.substring(ebPayload.indexOf("</Transforms>"), 
												ebPayload.indexOf("</Reference>"));
			digest = digest.substring("</Transforms>".length());
			
			digest = "<ds:Reference URI=\"cid:Payload-0\">"
				    +digest.replace("DigestMethod", "ds:DigestMethod")
						   .replace("DigestValue", "ds:DigestValue")
					+"</ds:Reference>";
			
			signedHeader = signedHeader.substring(0, signedHeader.indexOf("</ds:SignedInfo>")) 
						   + digest + signedHeader.substring(signedHeader.indexOf("</ds:SignedInfo>"));
			
			String unrequired = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
			ebMS.append( signedHeader.substring(unrequired.length(), signedHeader.length()) );
			
			ebMS.append("	<SOAP:Body xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + CR);
			ebMS.append("									http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">" + CR);
			ebMS.append("		<eb:Manifest xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\" eb:version=\"2.0\">" + CR);
			ebMS.append("			<eb:Reference xlink:href=\"cid:Payload-0\"" + CR);
			ebMS.append("						  xlink:role=\"XLinkRole\"" + CR);
			ebMS.append("						  xlink:type=\"simple\">" + CR);
			ebMS.append("			</eb:Reference>" + CR);
			ebMS.append("		</eb:Manifest>" + CR);
			ebMS.append("	</SOAP:Body>" + CR);
			ebMS.append("</SOAP:Envelope>" + CR);
			
			ebMS.append( CR );
			ebMS.append("--boundaryValue" + CR);
			ebMS.append("Content-ID: <Payload-0>" + CR);
			ebMS.append("Content-Type: text/xml" + CR);
			ebMS.append( CR );
			
			ebMS.append( ebPayload ); 
			ebMS.append( CR );
			
            ebMS.append("--boundaryValue--" + CR);
			
            //Send header 
			logger.debug(" *** Making HTTPS POST method...");
			wr.write("POST " + SERVICES_PATH + " HTTP/1.1" + CR);
			wr.write("Host: "+IP_ADDRESS+":"+SERVICES_PORT + CR);
			wr.write("SOAPAction: \"ebXML\"" + CR);
			wr.write("Content-Type: multipart/related; type=\"text/xml\"; boundary=\"boundaryValue\"; start=\"<ebxmlheader@ptc.doeb.go.th>\" "+ CR);
			wr.write("Content-Length: " + ebMS.toString().length() + "\r\n");
			
			wr.write( CR );
			//Sending ebXML Messages
			logger.debug(" *** Sending ebXML Messages...");
			wr.write( ebMS.toString() );
			// Flush data into streaming
			wr.flush();  
			
			logger.debug( "POST " + SERVICES_PATH + " HTTP/1.1" + CR  
								  + "Host: "+IP_ADDRESS+":"+SERVICES_PORT + CR
								  + "SOAPAction: \"ebXML\"" + CR
								  + "Content-Type: multipart/related; type=\"text/xml\"; boundary=\"boundaryValue\"; start=\"<ebxmlheader@ptc.doeb.go.th>\"" + CR
								  + "Content-Length: " + ebMS.toString().length() + CR
								  + CR
								  + ebMS.toString() );
			
			logger.debug(" *** Waiting for xml response...");
	       
			StringBuffer results = new StringBuffer(); 
			in = new BufferedReader( new InputStreamReader(socket.getInputStream())); 
	
			if ( in != null ){
				
				logger.debug(" *** Start translate stream to string respons...");
				String inputLine; 

				while ((inputLine = in.readLine()) != null) { 
					results.append(inputLine.trim());
				}
				
				ret = URLDecoder.decode( results.toString(), "UTF-8"); 
				
			} 
			logger.debug(" *** Display response : " + ret);
			
			if ( ret != null && !ret.isEmpty() ) {
				// Validate XML contain SOAP Envelop Header
				if ( ret.indexOf("<soap:Envelope") != -1 ) {
					// Parsing SOAP Envelope Header
					String strXML = ret.substring(ret.indexOf("<soap:Envelope"));
					// Validate XML contain ebXML message header
					if ( strXML.indexOf("<eb:MessageHeader") != -1 ) {
						// Parsing ebXML message header
						String body = strXML.substring(strXML.indexOf("<eb:MessageHeader"), strXML.indexOf("</eb:MessageHeader"));
						// Validate XML contain ebXML message 'action' element
						if ( body.indexOf("<eb:Action") != -1 ) {
							// Parsing ebXML message 'action' element for getting value
							String action = body.substring(body.indexOf("<eb:Action"), body.indexOf("</eb:Action>"));
					        String valAction = action.substring(action.indexOf('>')+1);
					        logger.debug( "Action: "+valAction );
					        // Validate Action result.
					        if ( valAction != null && !valAction.isEmpty() ) {
					        	// Validate Action result.
					        	if ( valAction.toLowerCase().equals("messageerror") ) {
					        		// Validate ebXML message 'errorList' element.
							        if ( strXML.indexOf("<eb:ErrorList") != -1 ) {
							        	// Parsing SOAP Envelop header 'errorList' element for getting value.
							        	String errorList = strXML.substring(strXML.indexOf("<eb:ErrorList"), strXML.indexOf("</eb:ErrorList>"));
								        String error = errorList.substring(errorList.indexOf("<eb:Error"), errorList.indexOf("</eb:Error>"));
								        String valError = error.substring(error.indexOf('>')+1);
								        // Validate SOAP Envelop header 'error' element
								        if ( valError.indexOf("<eb:Description") != -1 ) {
								        	// Parsing SOAP Envelop header 'error' element for getting value
								        	String description = valError.substring(valError.indexOf("<eb:Description"), valError.indexOf("</eb:Description>"));
									        String valDesc = description.substring(description.indexOf('>')+1);
									        logger.debug( "Error Description: "+valDesc );
									        
									        if ( valDesc == null || valDesc.isEmpty()) {
									        	return "Code: 104, Message: services end-point response result is error and description is empty.";
									        } else return valDesc;
								        } else {
								        	return "Code: 104, Message: services end-point response result is error and description is empty.";
								        }
							        } else {
							        	return "Code: 104, Message: services end-point response result is error and description is empty.";
							        }
					        	} else {
					        		return "Code: 000, Message: the ebXML message id["+messageId+"] is sent successfully.";
					        	}
					        } else throw new Exception("Code: 102, Message: No response from services end-point.");
						} else throw new Exception("Code: 102, Message: No response from services end-point.");
					} else throw new Exception("Code: 102, Message: No response from services end-point.");
				} else throw new Exception("Code: 102, Message: No response from services end-point.");
			} else throw new Exception("Code: 102, Message: No response from services end-point.");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			// Connection refused.
			logger.error( e.getMessage() );
			e.printStackTrace();
			throw new Exception("Code: 100, Message: Host connection problem");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// Communicate problem
			logger.error( e.getMessage() );
			e.printStackTrace();
			throw new Exception("Code: 101, Message: Communication/Protocols problem");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			// No response from destination
			logger.error( e.getMessage() );
			e.printStackTrace();
			throw new Exception("Code: 102, Message: No response from services end-point.");
		} catch (RuntimeException e) {
			// Internal server error
			logger.error( e.getMessage() );
			e.printStackTrace();
			throw new Exception("Code: 103, Message: Internal server error.");
		} finally {
			try {
				// Close HTTP Output Stream
				if (wr != null) wr.close();
			} catch (Exception ex) {  /* Nothing */  }
			try {
				// Close HTTP Input Stream
				if (in != null) in.close();
			} catch (Exception ex) {  /* Nothing */  }
			try {
				// Close HTTP Socket
				if (socket != null) socket.close();
			} catch (Exception ex) {  /* Nothing */  }
		}
	}
	
	
	/**
	 * Produce  License Cancel ebMS XML request to services endpoint.
	 * 
	 * @param Message ID String ( {ebXML UserID}_{Document Reference ID} )
	 * @param Time to live of message request (Minutes)
	 * @param LicenseCancel class data container
	 * @return String represent result object
	 * @throws Exception
	 * 			Code: 100, Message: Host connection problem
	 * 			Code: 101, Message: Communication/Protocols problem
	 * 			Code: 102, Message: No response from services end-point.
	 */
	public String cancel(String conversationId, Integer minutesToLeave, LicenseCancel license) throws Exception {
		
		logger.debug("URI: https://"+IP_ADDRESS+":"+SERVICES_PORT+""+SERVICES_PATH );
		logger.debug("Trust store: " + TRUST_STORE_PATH );
		logger.debug("Trust store password: " + TRUST_STORE_PASSWORD );
		
		logger.debug("Conversation ID: " + conversationId );
		logger.debug("Document ref. name: " + DOCUMENT_REF_NAME );
		
		logger.debug("Keystore path: " + KEYSTORE_PATH );
		logger.debug("Keystore password: " + KEYSTORE_PASSWORD );
		logger.debug("Keystore alias: " + KEYSTORE_ALIASNAME );

		String messageId = "";
		if ( conversationId.indexOf("_") != -1 ) {
			String[] sp = conversationId.split("_");
			messageId = sp[0];
			if ( DOCUMENT_REF_NAME == null || DOCUMENT_REF_NAME.trim().length() == 0 ) {
				DOCUMENT_REF_NAME = "";
				for ( int i=1; i<sp.length;i++ ) 
					if (i > 1) 
						DOCUMENT_REF_NAME = DOCUMENT_REF_NAME+"_"+sp[i];
					else
						DOCUMENT_REF_NAME = DOCUMENT_REF_NAME+sp[i];
			}
		} else messageId = conversationId;
		
        System.setProperty("javax.net.ssl.trustStore", TRUST_STORE_PATH );
		System.setProperty("javax.net.ssl.trustStorePassword", TRUST_STORE_PASSWORD );
		
		String ret = null; 
		String[] proto = {"SSLv3"}; //SSLv2Hello , SSLv3 
		BufferedWriter wr = null; 
		SSLSocket socket = null; 
		BufferedReader in = null; 
		
		try {
			// Time stamp XML format
			DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(new Date());
			XMLGregorianCalendar timestamp = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
			
			soapProducer = new SoapProducer();
			
			String ebPayload = "";
			try {
				ebPayload = soapProducer.buildLicenseCancelMsg(DOCUMENT_REF_NAME, 
																messageId, 
																license);
				
				ebPayload = SignatureGenerator.digitalSign(KEYSTORE_PATH, 
														KEYSTORE_PASSWORD, 
														KEYSTORE_ALIASNAME, 
														ALIASNAME_PASSWORD, 
														ebPayload, 
														null);
			} catch ( Exception e ) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
			
			logger.debug("Initial SSL Socket...");
			SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			socket = (SSLSocket) factory.createSocket( IP_ADDRESS, SERVICES_PORT);
			
			socket.setEnabledProtocols(proto); 
			socket.setSoTimeout(300 * 1000); 
	
			logger.debug("  *** Socket start hand shaking...");
			socket.startHandshake(); 
			
			//Open socket output pipe streaming 
			logger.debug(" *** Open socket output pipe streaming...");
			wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")); 
			
			StringBuffer ebMS = new StringBuffer();
			
			ebMS.append("--boundaryValue" + CR); 
			ebMS.append("Content-ID: <ebxmlheader@ptc.doeb.go.th>" + CR);
			ebMS.append("Content-Type: text/xml; charset=\"UTF-8\"" + CR);
			ebMS.append( CR );
			// Build MessageHeade
			logger.debug(" *** Build XML MessageHeade...");
			ebMS.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + CR);
			ebMS.append("<SOAP:Envelope xmlns:xlink=\"http://www.w3.org/1999/xlink\"" + CR);
			ebMS.append("				xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\"" + CR);
			ebMS.append("				xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
			ebMS.append("				xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + CR);
			ebMS.append("				xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/" + CR);
			ebMS.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd" + CR);
			ebMS.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + CR);
			ebMS.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">" + CR);
			
			StringBuffer ebHeader = new StringBuffer();
			
			ebHeader.append("	<SOAP:Header xmlns:xlink=\"http://www.w3.org/1999/xlink\"" + CR);
			ebHeader.append("				 xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\"" + CR);
			ebHeader.append("				 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + CR);
			ebHeader.append("				 xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/" + CR);
			ebHeader.append("									  http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">" + CR);
			ebHeader.append("		<eb:MessageHeader xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
			ebHeader.append("						  version=\"2.0\"" + CR);
			ebHeader.append("						  SOAP:mustUnderstand=\"1\">" + CR);
			ebHeader.append("			<eb:From>"+CR);
			ebHeader.append("				<eb:PartyId eb:type=\"string\">"+DOEB_PARTYID+"</eb:PartyId>"+CR);
			ebHeader.append("				<eb:Role>"+DOEB_ROLE+"</eb:Role>"+CR);
			ebHeader.append("			</eb:From>"+CR);
			ebHeader.append("			<eb:To>"+CR);
			ebHeader.append("				<eb:PartyId eb:type=\"string\">"+TCDNSW_PARTYID+"</eb:PartyId>"+CR);
			ebHeader.append("				<eb:Role>"+TCDNSW_ROLE+"</eb:Role>"+CR);
			ebHeader.append("			</eb:To>"+CR);	
			ebHeader.append("			<eb:CPAId>"+TCDNSW_CPAID+"</eb:CPAId>" + CR);
			ebHeader.append("			<eb:ConversationId>"+conversationId+"</eb:ConversationId>" + CR);
			ebHeader.append("			<eb:Service eb:type=\"string\">"+TCDNSW_SERVICES+"</eb:Service>" + CR);
			ebHeader.append("			<eb:Action>"+LICENSE_CANCEL_ACTION+"</eb:Action>" + CR);
			ebHeader.append("			<eb:MessageData>" + CR);
			ebHeader.append("				<eb:MessageId>"+messageId+"</eb:MessageId>" + CR);
			ebHeader.append("				<eb:Timestamp>"+timestamp.toXMLFormat()+"</eb:Timestamp>" + CR);
			ebHeader.append("			</eb:MessageData>" + CR);
			ebHeader.append("		</eb:MessageHeader>" + CR);
			ebHeader.append("		<eb:SyncReply xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
			ebHeader.append("					  SOAP:actor=\"http://schema.xmlsoap.org/soap/actor/next\"" + CR);
			ebHeader.append("					  SOAP:mustUnderstand=\"1\"" + CR);
			ebHeader.append("					  eb:version=\"2.0\"/>" + CR);
			ebHeader.append("		<eb:AckRequested xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
			ebHeader.append("						 SOAP:actor=\"urn:oasis:names:tc:ebxml-msg:actor:toPartyMSH\"" + CR);
			ebHeader.append("						 SOAP:mustUnderstand=\"1\"" + CR);
			ebHeader.append("						 eb:version=\"2.0\"" + CR);
			ebHeader.append("						 eb:signed=\"false\"/>" + CR);
			ebHeader.append("	</SOAP:Header>" + CR);
			
			String signedHeader = SignatureGenerator.digitalSign(KEYSTORE_PATH, 
															KEYSTORE_PASSWORD, 
															KEYSTORE_ALIASNAME, 
															ALIASNAME_PASSWORD, 
															ebHeader.toString(), 
															"ds");
			
			// Add more ds:Reference for contain DigestValue of Payload for Signature ebXML message header.
			String digest = ebPayload.substring(ebPayload.indexOf("</Transforms>"), 
												ebPayload.indexOf("</Reference>"));
			digest = digest.substring("</Transforms>".length());
			
			digest = "<ds:Reference URI=\"cid:Payload-0\">"
					 +digest.replace("DigestMethod", "ds:DigestMethod")
							.replace("DigestValue", "ds:DigestValue")
					 +"</ds:Reference>";
			
			signedHeader = signedHeader.substring(0, signedHeader.indexOf("</ds:SignedInfo>")) 
						   + digest + signedHeader.substring(signedHeader.indexOf("</ds:SignedInfo>"));
			
			String unrequired = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
			ebMS.append( signedHeader.substring(unrequired.length(), signedHeader.length()) );
			
			ebMS.append("	<SOAP:Body xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + CR);
			ebMS.append("									http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">" + CR);
			ebMS.append("		<eb:Manifest xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\" eb:version=\"2.0\">" + CR);
			ebMS.append("			<eb:Reference eb:id=\"Payload-0\"" + CR);
			ebMS.append("						  xlink:href=\"cid:Payload-0\"" + CR);
			ebMS.append("						  xlink:type=\"simple\">" + CR);
			ebMS.append("			</eb:Reference>" + CR);
			ebMS.append("		</eb:Manifest>" + CR);
			ebMS.append("	</SOAP:Body>" + CR);
			ebMS.append("</SOAP:Envelope>" + CR);
			
			ebMS.append( CR );
			ebMS.append("--boundaryValue" + CR);
			ebMS.append("Content-ID: <Payload-0>" + CR);
			ebMS.append("Content-Type: text/xml" + CR);
			
			ebMS.append( CR );
			
			ebMS.append( ebPayload ); 
			ebMS.append( CR );
			
            ebMS.append("--boundaryValue--" + CR);
			
            //Send header 
			logger.debug(" *** Making HTTPS POST method...");
			wr.write("POST " + SERVICES_PATH + " HTTP/1.1" + CR);
			wr.write("Host: "+IP_ADDRESS+":"+SERVICES_PORT + CR);
			wr.write("SOAPAction: \"ebXML\"" + CR);
			wr.write("Content-Type: multipart/related; type=\"text/xml\"; boundary=\"boundaryValue\"; start=\"<ebxmlheader@ptc.doeb.go.th>\""+ CR);
			wr.write("Content-Length: " + ebMS.toString().length() + "\r\n");
			
			wr.write( CR );
			//Sending ebXML Messages
			logger.debug(" *** Sending ebXML Messages...");
			wr.write( ebMS.toString() );
			// Flush data into streaming
			wr.flush();  
			
			logger.debug( "POST " + SERVICES_PATH + " HTTP/1.0" + CR  
								  + "Host: "+IP_ADDRESS+":"+SERVICES_PORT + CR
								  + "SOAPAction: \"ebXML\"" + CR
								  + "Content-Type: multipart/related; type=\"text/xml\"; boundary=\"boundaryValue\"; start=\"<ebxmlheader@ptc.doeb.go.th>\"" + CR
								  + "Content-Length: " + ebMS.toString().length() + CR
								  + CR
								  + ebMS.toString() );
			
			logger.debug(" *** Waiting for xml response...");
	       
			StringBuffer results = new StringBuffer(); 
			in = new BufferedReader( new InputStreamReader(socket.getInputStream())); 
	
			if ( in != null ) {
				
				logger.debug(" *** Start translate stream to string respons...");
				String inputLine; 
	
				while ((inputLine = in.readLine()) != null) { 
					results.append(inputLine.trim());
				}
				
				ret = URLDecoder.decode( results.toString(), "UTF-8"); 
				
			}
			logger.debug(" *** Display response : " + ret);
			
			if ( ret != null && !ret.isEmpty() ) {
				// Validate XML contain SOAP Envelop Header
				if ( ret.indexOf("<soap:Envelope") != -1 ) {
					// Parsing SOAP Envelope Header
					String strXML = ret.substring(ret.indexOf("<soap:Envelope"));
					// Validate XML contain ebXML message header
					if ( strXML.indexOf("<eb:MessageHeader") != -1 ) {
						// Parsing ebXML message header
						String body = strXML.substring(strXML.indexOf("<eb:MessageHeader"), strXML.indexOf("</eb:MessageHeader"));
						// Validate XML contain ebXML message 'action' element
						if ( body.indexOf("<eb:Action") != -1 ) {
							// Parsing ebXML message 'action' element for getting value
							String action = body.substring(body.indexOf("<eb:Action"), body.indexOf("</eb:Action>"));
					        String valAction = action.substring(action.indexOf('>')+1);
					        logger.debug( "Action: "+valAction );
					        // Validate Action result.
					        if ( valAction != null && !valAction.isEmpty() ) {
					        	// Validate Action result.
					        	if ( valAction.toLowerCase().equals("messageerror") ) {
					        		// Validate ebXML message 'errorList' element.
							        if ( strXML.indexOf("<eb:ErrorList") != -1 ) {
							        	// Parsing SOAP Envelop header 'errorList' element for getting value.
							        	String errorList = strXML.substring(strXML.indexOf("<eb:ErrorList"), strXML.indexOf("</eb:ErrorList>"));
								        String error = errorList.substring(errorList.indexOf("<eb:Error"), errorList.indexOf("</eb:Error>"));
								        String valError = error.substring(error.indexOf('>')+1);
								        // Validate SOAP Envelop header 'error' element
								        if ( valError.indexOf("<eb:Description") != -1 ) {
								        	// Parsing SOAP Envelop header 'error' element for getting value
								        	String description = valError.substring(valError.indexOf("<eb:Description"), valError.indexOf("</eb:Description>"));
									        String valDesc = description.substring(description.indexOf('>')+1);
									        logger.debug( "Error Description: "+valDesc );
									        
									        if ( valDesc == null || valDesc.isEmpty()) {
									        	return "Code: 104, Message: services end-point response result is error and description is empty.";
									        } else return valDesc;
								        } else {
								        	return "Code: 104, Message: services end-point response result is error and description is empty.";
								        }
							        } else {
							        	return "Code: 104, Message: services end-point response result is error and description is empty.";
							        }
					        	} else {
					        		return "Code: 000, Message: the ebXML message id["+messageId+"] is sent successfully.";
					        	}
					        } else throw new Exception("Code: 102, Message: No response from services end-point.");
						} else throw new Exception("Code: 102, Message: No response from services end-point.");
					} else throw new Exception("Code: 102, Message: No response from services end-point.");
				} else throw new Exception("Code: 102, Message: No response from services end-point.");
			} else throw new Exception("Code: 102, Message: No response from services end-point.");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			// Connection refused.
			logger.error( e.getMessage() );
			e.printStackTrace();
			throw new Exception("Code: 100, Message: Host connection problem");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// Communicate problem
			logger.error( e.getMessage() );
			e.printStackTrace();
			throw new Exception("Code: 101, Message: Communication/Protocols problem");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			// No response from destination
			logger.error( e.getMessage() );
			e.printStackTrace();
			throw new Exception("Code: 102, Message: No response from services end-point.");
		} catch (RuntimeException e) {
			// Internal server error
			logger.error( e.getMessage() );
			e.printStackTrace();
			throw new Exception("Code: 103, Message: Internal server error.");
		} finally {
			try {
				// Close HTTP Output Stream
				if (wr != null) wr.close();
			} catch (Exception ex) { /* Nothing */  }
			try {
				// Close HTTP Input Stream
				if (in != null) in.close();
			} catch (Exception ex) { /* Nothing */ }
			try {
				// Close HTTP Socket
				if (socket != null) socket.close();
			} catch (Exception ex) { /* Nothing */ }
		}
	}
	
	
	/* REQUIRED ATTRIBUTES */
	String IP_ADDRESS;
	Integer SERVICES_PORT;
	String SERVICES_PATH;
	String TRUST_STORE_PATH;
	String TRUST_STORE_PASSWORD;
	String TRUST_ALIAS_NAME;
	
	String TCDNSW_CPAID = "NSW_DOEB_1_00";
	
	String TCDNSW_PARTYID = "TCDNSWDemo";
	String TCDNSW_ROLE = "NSW";
	String DOEB_PARTYID;
	String DOEB_ROLE;
	
	String TCDNSW_SERVICES = "TCDeLicense";
	String LICENSE_PERINVOICE_ACTION = "LicensePerInvoice";
	String LICENSE_RESPONSE_ACTION = "LicenseResponse";
	String LICENSE_CANCEL_ACTION = "LicenseCancel";
	
	String KEYSTORE_PATH = "";
	String KEYSTORE_PASSWORD = "";
	String KEYSTORE_ALIASNAME = "";
	String ALIASNAME_PASSWORD = "";
	
	String DIRECTORY_OUTBOX = "";
	String DIRECTORY_INBOX  = "";
	
	String DOCUMENT_REF_NAME = "";
	
	public void setIP_ADDRESS(String iP_ADDRESS) {
		IP_ADDRESS = nullToEmpty( iP_ADDRESS );
	}

	public void setSERVICES_PORT(Integer sERVICES_PORT) {
		SERVICES_PORT = sERVICES_PORT;
	}

	public void setSERVICES_PATH(String sERVICES_PATH) {
		SERVICES_PATH = nullToEmpty( sERVICES_PATH );
	}

	public void setTRUST_STORE_PATH(String tRUST_STORE_PATH) {
		TRUST_STORE_PATH = nullToEmpty( tRUST_STORE_PATH );
	}

	public void setTRUST_STORE_PASSWORD(String tRUST_STORE_PASSWORD) {
		TRUST_STORE_PASSWORD = nullToEmpty( tRUST_STORE_PASSWORD );
	}
	
	public void setTRUST_ALIAS_NAME(String tRUST_ALIAS_NAME) {
		TRUST_ALIAS_NAME = tRUST_ALIAS_NAME;
	}

	public void setDOEB_PARTYID(String dOEB_PARTYID) {
		DOEB_PARTYID = nullToEmpty( dOEB_PARTYID );
	}
	
	public void setTCDNSW_CPAID(String tCDNSW_CPAID) {
		TCDNSW_CPAID = nullToEmpty( tCDNSW_CPAID );
	}

	public void setTCDNSW_PARTYID(String tCDNSW_PARTYID) {
		TCDNSW_PARTYID = nullToEmpty( tCDNSW_PARTYID );
	}

	public void setTCDNSW_ROLE(String tCDNSW_ROLE) {
		TCDNSW_ROLE = nullToEmpty( tCDNSW_ROLE );
	}

	public void setDOEB_ROLE(String dOEB_ROLE) {
		DOEB_ROLE = nullToEmpty( dOEB_ROLE );
	}

	public void setTCDNSW_SERVICES(String tCDNSW_SERVICES) {
		TCDNSW_SERVICES = nullToEmpty( tCDNSW_SERVICES );
	}

	public void setLICENSE_PERINVOICE_ACTION(String lICENSE_PERINVOICE_ACTION) {
		LICENSE_PERINVOICE_ACTION = nullToEmpty( lICENSE_PERINVOICE_ACTION );
	}

	public void setLICENSE_RESPONSE_ACTION(String lICENSE_RESPONSE_ACTION) {
		LICENSE_RESPONSE_ACTION = nullToEmpty( lICENSE_RESPONSE_ACTION );
	}

	public void setLICENSE_CANCEL_ACTION(String lICENSE_CANCEL_ACTION) {
		LICENSE_CANCEL_ACTION = nullToEmpty( lICENSE_CANCEL_ACTION );
	}
	
	public void setKEYSTORE_PATH(String kEYSTORE_PATH) {
		KEYSTORE_PATH = kEYSTORE_PATH;
	}

	public void setKEYSTORE_PASSWORD(String kEYSTORE_PASSWORD) {
		KEYSTORE_PASSWORD = kEYSTORE_PASSWORD;
	}

	public void setKEYSTORE_ALIASNAME(String kEYSTORE_ALIASNAME) {
		KEYSTORE_ALIASNAME = kEYSTORE_ALIASNAME;
	}

	public void setALIASNAME_PASSWORD(String aLIASNAME_PASSWORD) {
		ALIASNAME_PASSWORD = aLIASNAME_PASSWORD;
	}

	public void setDIRECTORY_OUTBOX(String dIRECTORY_OUTBOX) {
		DIRECTORY_OUTBOX = dIRECTORY_OUTBOX;
	}

	public void setDIRECTORY_INBOX(String dIRECTORY_INBOX) {
		DIRECTORY_INBOX = dIRECTORY_INBOX;
	}
	
	public void setDOCUMENT_REF_NAME(String dOCUMENT_REF_NAME) {
		DOCUMENT_REF_NAME = dOCUMENT_REF_NAME;
	}
	
	/**
	 * Check val is not empty
	 * 
	 * @param val
	 * @return true when val is not empty, otherwise is false.
	 */
	public boolean isNotEmpty(String val) {
		try {
			if ( val == null ) return false;
			if ( val.trim().length() == 0 ) return false;
			return true;
		} catch ( Exception ex ) {
			return false;
		}
	}
	
	/**
	 * Check val is number or not
	 * 
	 * @param val
	 * @return true when val is number, otherwise is false.
	 */
	public boolean isNumber(String val) {
		try {
			if ( val == null ) return false;
			if ( val.trim().length() == 0 ) return false;
			for ( char ch : val.trim().toCharArray() )
				if ( !Character.isDigit(ch) ) return false;
			return true;
		} catch ( Exception ex ) {
			return false;
		}
	}

	/**
	 * Create license per invoice object for communicate services
	 * 
	 * @param (DocumentHeaderType.class) documentHeader
	 * @return LicensePerInvoice.class
	 */
	public LicensePerInvoice createLicensePerInvoice(
			DocumentHeaderType documentHeader,
			List<DocumentDetailsTransportType> documentDetails,
			List<Signature> signatures) {
		LicensePerInvoice licensePerInvoice = new LicensePerInvoice();
		licensePerInvoice.setDocumentHeader(documentHeader);
		licensePerInvoice.getDocumentDetails().addAll(documentDetails);
		licensePerInvoice.getSignatures().addAll(signatures);
		return licensePerInvoice;
	}

	/**
	 * Create document header type
	 * 
	 * @param (DocumentReferenceType.class) documentReference
	 * @param (LicenseInfoType.class) licenseInfo
	 * @return DocumentHeaderType.class
	 */
	public DocumentHeaderType createDocumentHeaderType(
			DocumentReferenceType documentReference, LicenseInfoType licenseInfo) {
		DocumentHeaderType documentHeaderType = new DocumentHeaderType();
		documentHeaderType.setDocumentReference(documentReference);
		documentHeaderType.setLicenseInfo(licenseInfo);
		return documentHeaderType;
	}

	/**
	 * Create document reference type
	 * 
	 * @param (String) registrationID
	 * @param (BigInteger) dischargePort
	 * @param (BigInteger) loadPort
	 * @return DocumentReferenceType.class
	 */
	public DocumentReferenceType createDocumentReferenceType(
			String registrationID, BigInteger dischargePort, BigInteger loadPort) {
		DocumentReferenceType documentReferenceType = new DocumentReferenceType();
		documentReferenceType.setRegistrationID(registrationID);
		documentReferenceType.setDischargePort(dischargePort);
		documentReferenceType.setLoadPort(loadPort);
		return documentReferenceType;
	}

	/**
	 * Create license info type
	 * 
	 * @param (String) licenseNo
	 * @param (String) licenseName
	 * @param (String) licenseType
	 * @param (Date) issueDate
	 * @param (String) authorityID
	 * @param (String) authorityName
	 * @param (String) countryCode
	 * @param (String) description
	 * @param (Date) effectiveDate
	 * @param (Date) expireDate
	 * @param (String) inspectionLevel
	 * @param (String) inspectionDesc
	 * @param (String) taxReference
	 * @return LicenseInfoType.class
	 * @throws DatatypeConfigurationException 
	 */
	public LicenseInfoType createLicenseInfoType(String licenseNo,
			String licenseName, 
			String licenseType, 
			Date issueDate,
			String authorityID,
			String authorityName, 
			String countryCode, 
			String description,
			Date effectiveDate,
			Date expireDate,
			String inspectionLevel, 
			String inspectionDesc, 
			String taxReference) throws DatatypeConfigurationException {
		LicenseInfoType licenseInfoType = new LicenseInfoType();
		licenseInfoType.setAuthorityID(authorityID);
		licenseInfoType.setAuthorityName(authorityName);
		licenseInfoType.setCountryCode(countryCode);
		licenseInfoType.setDescription(description);
		licenseInfoType.setInspectionDesc(inspectionDesc);
		licenseInfoType.setInspectionLevel(inspectionLevel);
		licenseInfoType.setLicenseName(licenseName);
		licenseInfoType.setLicenseNo(licenseNo);
		licenseInfoType.setLicenseType(licenseType);
		licenseInfoType.setTaxReference(taxReference);
		
		DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		
		if ( issueDate != null ) {
			gregorianCalendar.setTime(issueDate);
			licenseInfoType.setIssueDate(datatypeFactory.newXMLGregorianCalendar(gregorianCalendar));
		}
		
		if ( effectiveDate != null ) {
			gregorianCalendar.setTime(effectiveDate);
			licenseInfoType.setEffectiveDate(datatypeFactory.newXMLGregorianCalendar(gregorianCalendar));
		}
		
		if ( expireDate != null ) {
			gregorianCalendar.setTime(expireDate);
			licenseInfoType.setExpireDate(datatypeFactory.newXMLGregorianCalendar(gregorianCalendar));
		}
		
		return licenseInfoType;
	}

	/**
	 * Create document detail transport type
	 * 
	 * @param (BigInteger) declarationLineNo
	 * @param (String) countryCode
	 * @param (String) remark
	 * @param (InvoiceInfoType.class) invoiceInfo
	 * @param (ProductInfo.class) productInfo
	 * @param (CustomsTariffQuantityType.class) tariffInfo
	 * @return DocumentDetailsTransportType.class
	 */
	public DocumentDetailsTransportType createDocumentDetailsTransportType(
			BigInteger declarationLineNo, String countryCode, String remark,
			InvoiceInfoType invoiceInfo, ProductInfo productInfo,
			CustomsTariffQuantityType tariffInfo) {
		DocumentDetailsTransportType detailsTransportType = new DocumentDetailsTransportType();
		detailsTransportType.setDeclarationLineNo(declarationLineNo);
		detailsTransportType.setCountryCode(countryCode);
		detailsTransportType.setInvoiceInfo(invoiceInfo);
		detailsTransportType.setProductInfo(productInfo);
		detailsTransportType.setRemark(remark);
		detailsTransportType.setTariffInfo(tariffInfo);
		return detailsTransportType;
	}

	/**
	 * Create invoice info type
	 * 
	 * @param (String) invoiceNumber
	 * @param (BigInteger) invoiceItem
	 * @param (String) description
	 * @param (Date) invoiceDate
	 * @return InvoiceInfoType.class
	 * @throws DatatypeConfigurationException
	 */
	public InvoiceInfoType createInvoiceInfoType(String invoiceNumber,
			BigInteger invoiceItem, String description, Date invoiceDate)
			throws DatatypeConfigurationException {
		InvoiceInfoType invoiceInfoType = new InvoiceInfoType();
		invoiceInfoType.setInvoiceNumber(invoiceNumber);
		invoiceInfoType.setInvoiceItem(invoiceItem);
		invoiceInfoType.setDescription(description);

		DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(invoiceDate);

		invoiceInfoType.setInvoiceDate(datatypeFactory
				.newXMLGregorianCalendar(gregorianCalendar));
		return invoiceInfoType;
	}

	/**
	 * Create product info
	 * 
	 * @param (String) bodyNo
	 * @param (String) brandName
	 * @param (String) characteristic
	 * @param (String) countryCode
	 * @param (BigDecimal) displacement
	 * @param (String) engineNo
	 * @param (String) modelCode
	 * @param (QuantityType.class) quantityInfo
	 * @param (String) registrationNumber
	 * @param (WeightInfo.class) weightInfo
	 * @param (BigInteger) year
	 * @return ProductInfo.class
	 */
	public ProductInfo createProductInfo(String bodyNo, String brandName,
			String characteristic, String countryCode, BigDecimal displacement,
			String engineNo, String modelCode, QuantityType quantityInfo,
			String registrationNumber, WeightInfo weightInfo, BigInteger year) {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setBodyNo(bodyNo);
		productInfo.setBrandName(brandName);
		productInfo.setCharacteristic(characteristic);
		productInfo.setCountryCode(countryCode);
		productInfo.setDisplacement(displacement);
		productInfo.setEngineNo(engineNo);
		productInfo.setModelCode(modelCode);
		productInfo.setQuantityInfo(quantityInfo);
		productInfo.setRegistrationNumber(registrationNumber);
		productInfo.setWeightInfo(weightInfo);
		productInfo.setYear(year);
		return productInfo;
	}

	/**
	 * Create quantity type
	 * 
	 * @param (String) unitCode
	 * @param (BigDecimal) quantity
	 * @param (String) samplingUnitCode
	 * @param (BigDecimal) samplingQuantity
	 * @return QuantityType.class
	 */
	public QuantityType createQuantityType(String unitCode,
			BigDecimal quantity, String samplingUnitCode,
			BigDecimal samplingQuantity) {
		QuantityType quantityType = new QuantityType();
		quantityType.setUnitCode(unitCode);
		quantityType.setQuantity(quantity);
		quantityType.setSamplingUnitCode(samplingUnitCode);
		quantityType.setSamplingQuantity(samplingQuantity);
		return quantityType;
	}

	/**
	 * Create weight info
	 * 
	 * @param (String) unitCode
	 * @param (BigDecimal) weight
	 * @return WeightInfo.class
	 */
	public WeightInfo createWeightInfo(String unitCode, BigDecimal weight) {
		WeightInfo weightInfo = new WeightInfo();
		weightInfo.setUnitCode(unitCode);
		weightInfo.setWeight(weight);
		return weightInfo;
	}

	/**
	 * Create tariff info
	 * 
	 * @param (BigInteger) classification
	 * @param (BigInteger) statisticalCode
	 * @return CustomsTariffQuantityType.class
	 */
	public CustomsTariffQuantityType createCustomsTariffQuantityType(
			BigInteger classification, BigInteger statisticalCode) {
		CustomsTariffQuantityType tariffInfo = new CustomsTariffQuantityType();
		tariffInfo.setClassification(classification);
		tariffInfo.setStatisticalCode(statisticalCode);
		return tariffInfo;
	}

	/**
	 * Create signature
	 * 
	 * @param (String) id
	 * @param (KeyInfo.class) keyinfo
	 * @param (SignatureValue.class) signatureValue
	 * @param (SignedInfo.class) signedInfo
	 * @return Signature.class
	 */
	public Signature createSignature(String id, KeyInfo keyinfo,
			SignatureValue signatureValue, SignedInfo signedInfo) {
		Signature sign = new Signature();
		sign.setId(id);
		sign.setKeyInfo(keyinfo);
		sign.setSignatureValue(signatureValue);
		sign.setSignedInfo(signedInfo);
		return sign;
	}

	/**
	 * Create key info is defined by ID Might be required List<Object> contents
	 * 
	 * @param (String) id
	 * @param (List<Content.class>) contents
	 * @return KeyInfo.class
	 */
	public KeyInfo createKeyInfo(String id, List<Content> contents) {
		KeyInfo keyInfo = new KeyInfo();
		keyInfo.setId(id);
		keyInfo.getContent().addAll(contents);
		return keyInfo;
	}

	/**
	 * Create signature by value
	 * 
	 * @param (String) id
	 * @param (byte[]) value
	 * @return SignatureValue.class
	 */
	public SignatureValue createSignatureValue(String id, byte[] value) {
		SignatureValue signatureValue = new SignatureValue();
		signatureValue.setId(id);
		signatureValue.setValue(value);
		return signatureValue;
	}

	/**
	 * Create signature info object
	 * 
	 * @param (String) id
	 * @param (CanonicalizationMethod.class) canonicalization method
	 * @param (SignatureMethod.class) signature method
	 * @param (List<Reference.class>) list of reference
	 * @return SignedInfo.class
	 */
	public SignedInfo createSignedInfo(String id,
			CanonicalizationMethod canonicalizationMethod,
			SignatureMethod signatureMethod, List<Reference> references) {
		SignedInfo signedInfo = new SignedInfo();
		signedInfo.setId(id);
		signedInfo.setCanonicalizationMethod(canonicalizationMethod);
		signedInfo.setSignatureMethod(signatureMethod);
		signedInfo.getReferences().addAll(references);
		return signedInfo;
	}

	/**
	 * Create Canonicalization method is defined by algorithm value
	 * 
	 * @param (String) algorithm
	 * @param (List<Content.class>) contents
	 * @return CanonicalizationMethod.class
	 */
	public CanonicalizationMethod createCanonicalizationMethod(
			String algorithm, List<Content> contents) {
		CanonicalizationMethod canonicalizationMethod = new CanonicalizationMethod();
		canonicalizationMethod.setAlgorithm(algorithm);
		canonicalizationMethod.getContent().addAll(contents);
		return canonicalizationMethod;
	}

	/**
	 * Create Signature method is defined by algorithm value
	 * 
	 * @param (String) algorithm
	 * @param (List<Content.class>) contents
	 * @return SignatureMethod.class
	 */
	public SignatureMethod createSignatureMethod(String algorithm,
			List<Content> contents) {
		SignatureMethod signatureMethod = new SignatureMethod();
		signatureMethod.setAlgorithm(algorithm);
		signatureMethod.getContent().addAll(contents);
		return signatureMethod;
	}
	
	/**
	 * Null to empty string
	 * @param val
	 * @return String
	 */
	private String nullToEmpty(String val) {
		if ( val == null ) return "";
		else if ( val.trim().length() == 0 ) return "";
		else return val.trim();
	}
}
