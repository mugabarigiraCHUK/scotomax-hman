package com.itap.ebms;

import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.itap.ebms.cancel.DocumentHeaderType;
import com.itap.ebms.cancel.DocumentReferenceType;
import com.itap.ebms.cancel.LicenseCancel;
import com.itap.ebms.req.DocumentDetailsTransportType;
import com.itap.ebms.req.DocumentDetailsTransportType.ProductInfo;
import com.itap.ebms.req.LicenseInfoType;
import com.itap.ebms.req.LicensePerInvoice;
import com.itap.ebms.resp.BOIAccept;
import com.itap.ebms.resp.BOIReject;
import com.itap.ebms.resp.LicenseAccept;
import com.itap.ebms.resp.LicenseReject;
import com.itap.ebms.resp.LicenseResponse;
import com.itap.ebms.resp.LicenseResponse.MessageHeader;
import com.itap.ebms.resp.LicenseResponse.MessageHeader.MessageDetail;

@SuppressWarnings("rawtypes")
public class SoapProducer {

	final String CR = System.getProperty("line.separator");
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	final short XML_DATE_TYPE = 7;
	
	/**
	 * Build License per invoice XML request
	 * 
	 * @param name
	 * @param user ID
	 * @param LicensePerInvoice class data container
	 * @return XML string
	 */
	public String buildLicensePerInvoiceMsg(String name,
											String userId,
											LicensePerInvoice data) 
		throws Exception {
		
		StringBuffer strXML = new StringBuffer();
		
		if ( data != null ) {
			strXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + CR);
			strXML.append("<LicensePerInvoice xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + CR);
			strXML.append("					  xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"" + CR);
			strXML.append("					  xmlns=\"http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_2_0.xsd\">" + CR);
			if ( data.getDocumentHeader() != null ) {
				strXML.append("   <DocumentHeader xmlns=\"\">" + CR);
				/*
				if ( data.getDocumentHeader().getDocumentReference() != null ) {
					DocumentReferenceType dr = data.getDocumentHeader().getDocumentReference();
					strXML.append("      <DocumentReference>" + CR);
					strXML.append("         <DischargePort>"+dr.getDischargePort()+"</DischargePort>" + CR);
					strXML.append("         <LoadPort>"+dr.getLoadPort()+"</LoadPort>" + CR);
					strXML.append("         <RegistrationID>"+dr.getRegistrationID()+"</RegistrationID>" + CR);
					strXML.append("      </DocumentReference>" + CR);
				}
				*/
				strXML.append("      <DocumentReference>" + CR);
				strXML.append("         <Name>"+"ชื่อ/"+nullToEmpty( name )+"</Name>" + CR);
				strXML.append("         <UserID>"+nullToEmpty( userId )+"</UserID>" + CR);
				strXML.append("      </DocumentReference>" + CR);
				
				System.out.print("<< UTF-8 fix>>ชื่อ\n");
				
				if ( data.getDocumentHeader().getLicenseInfo() != null ) {
					LicenseInfoType lit = data.getDocumentHeader().getLicenseInfo();

					System.out.print("<< UTF-8 var>>\n" + nullToEmpty( lit.getAuthorityName() ));
					
					strXML.append("      <LicenseInfo>" + CR);
					strXML.append("         <LicenseNo>"+nullToEmpty( lit.getLicenseNo() )+"</LicenseNo>" + CR);
					strXML.append("         <TaxReference>"+nullToEmpty( lit.getTaxReference() )+"</TaxReference>" + CR);
					strXML.append("         <LicenseType>"+nullToEmpty( lit.getLicenseType() )+"</LicenseType>" + CR);
					if (lit.getIssueDate() != null) {
						strXML.append("         <IssueDate>"+ sdf.format( lit.getIssueDate().toGregorianCalendar().getTime() )+"</IssueDate>" + CR);
					} else {
						strXML.append("         <IssueDate>"+sdf.format(new Date())+"</IssueDate>" + CR);
					}
					strXML.append("         <CountryCode>"+nullToEmpty( lit.getCountryCode() )+"</CountryCode>" + CR);
					if ( lit.getConsignmentInfo() != null ) {
						strXML.append("         <ConsignmentInfo>" + CR);
						strXML.append("            <CountryCode>"+nullToEmpty( lit.getConsignmentInfo().getCountryCode() )+"</CountryCode>" + CR);
						strXML.append("            <TaxReference>"+nullToEmpty( lit.getConsignmentInfo().getTaxReference() )+"</TaxReference>" + CR);
						strXML.append("         </ConsignmentInfo>" + CR);
					}
					strXML.append("         <Description>"+nullToEmpty( lit.getDescription() )+"</Description>" + CR);
					if (lit.getEffectiveDate() != null) {
						strXML.append("         <EffectiveDate>"+sdf.format( lit.getEffectiveDate().toGregorianCalendar().getTime() )+"</EffectiveDate>" + CR);
					} else {
						strXML.append("         <EffectiveDate>"+sdf.format( new Date() )+"</EffectiveDate>" + CR);
					}
					if (lit.getExpireDate() != null)
						strXML.append("         <ExpireDate>"+sdf.format( lit.getExpireDate().toGregorianCalendar().getTime())+"</ExpireDate>" + CR);
					
					strXML.append("         <AuthorityID>"+nullToEmpty( lit.getAuthorityID() )+"</AuthorityID>" + CR);
					strXML.append("         <AuthorityName>"+nullToEmpty( lit.getAuthorityName() )+"</AuthorityName>" + CR);
					strXML.append("         <LicenseName>"+nullToEmpty( lit.getLicenseName() )+"</LicenseName>" + CR);
					strXML.append("         <InspectionLevel>"+nullToEmpty( lit.getInspectionLevel() )+"</InspectionLevel>" + CR);
					strXML.append("         <InspectionDesc>"+nullToEmpty( lit.getInspectionDesc() )+"</InspectionDesc>" + CR);
					strXML.append("      </LicenseInfo>" + CR);
				}
				strXML.append("   </DocumentHeader>" + CR);
			}
			
			if ( data.getDocumentDetails() != null && data.getDocumentDetails().size() > 0 ) {
				strXML.append("   <DocumentDetails xmlns=\"\">" + CR);
				for ( DocumentDetailsTransportType dd : data.getDocumentDetails() ) {
					strXML.append("      <DocumentDetail>" + CR);
					if (dd.getInvoiceInfo() != null) {
						strXML.append("         <InvoiceInfo>" + CR);
						strXML.append("            <InvoiceNumber>"+nullToEmpty( dd.getInvoiceInfo().getInvoiceNumber() )+"</InvoiceNumber>" + CR);
						if ( dd.getInvoiceInfo().getInvoiceDate() != null )
							strXML.append("            <InvoiceDate>"+sdf.format( dd.getInvoiceInfo().getInvoiceDate().toGregorianCalendar().getTime())+"</InvoiceDate>" + CR);
						
						strXML.append("            <InvoiceItem>"+nullToEmpty( dd.getInvoiceInfo().getInvoiceItem() )+"</InvoiceItem>" + CR);
						strXML.append("            <Description>"+nullToEmpty( dd.getInvoiceInfo().getDescription() )+"</Description>" + CR);
						strXML.append("         </InvoiceInfo>" + CR);
					}
					strXML.append("         <DeclarationLineNo>"+nullToEmpty( dd.getDeclarationLineNo() )+"</DeclarationLineNo>" + CR);
					if (dd.getTariffInfo() != null) {
						strXML.append("         <TariffInfo>" + CR);
						strXML.append("            <Classification>"+nullToEmpty( dd.getTariffInfo().getClassification() )+"</Classification>" + CR);
						strXML.append("            <StatisticalCode>"+nullToEmpty( dd.getTariffInfo().getStatisticalCode() )+"</StatisticalCode>" + CR);
						strXML.append("         </TariffInfo>" + CR);
					}
					if (dd.getProductInfo() != null) {
						ProductInfo pi = dd.getProductInfo();
						strXML.append("         <ProductInfo>" + CR);
						if ( pi.getWeightInfo() != null ) {
							strXML.append("            <WeightInfo>" + CR);
							strXML.append("               <Weight>"+nullToEmpty( pi.getWeightInfo().getWeight() )+"</Weight>" + CR);
							strXML.append("               <UnitCode>"+nullToEmpty( pi.getWeightInfo().getUnitCode() )+"</UnitCode>" + CR);
							strXML.append("            </WeightInfo>" + CR);
						}
						if ( pi.getQuantityInfo() != null ) {
							strXML.append("            <QuantityInfo>" + CR);
							strXML.append("               <Quantity>"+nullToEmpty( pi.getQuantityInfo().getQuantity() )+"</Quantity>" + CR);
							strXML.append("               <UnitCode>"+nullToEmpty( pi.getQuantityInfo().getUnitCode() )+"</UnitCode>" + CR);
							strXML.append("               <SamplingQuantity>"+nullToEmpty( pi.getQuantityInfo().getSamplingQuantity() )+"</SamplingQuantity>" + CR);
							strXML.append("               <SamplingUnitCode>"+nullToEmpty( pi.getQuantityInfo().getSamplingUnitCode() )+"</SamplingUnitCode>" + CR);
							strXML.append("            </QuantityInfo>" + CR);
						}
						strXML.append("            <RegistrationNumber>"+nullToEmpty( pi.getRegistrationNumber() )+"</RegistrationNumber>" + CR);
						strXML.append("            <BodyNo>"+nullToEmpty( pi.getBodyNo() )+"</BodyNo>" + CR);
						
						strXML.append("            <BodyNo>"+nullToEmpty( pi.getBodyNo() )+"</BodyNo>" + CR);
						strXML.append("            <EngineNo>"+nullToEmpty( pi.getEngineNo() )+"</EngineNo>" + CR);
						strXML.append("            <Displacement>"+nullToEmpty( pi.getDisplacement() )+"</Displacement>" + CR);
						strXML.append("            <ModelCode>"+nullToEmpty( pi.getModelCode() )+"</ModelCode>" + CR);
						strXML.append("            <Year>"+nullToEmpty( pi.getYear() )+"</Year>" + CR);
						strXML.append("            <BrandName>"+nullToEmpty( pi.getBrandName() )+"</BrandName>" + CR);
						strXML.append("            <CountryCode>"+nullToEmpty( pi.getCountryCode() )+"</CountryCode>" + CR);
						strXML.append("            <Characteristic>"+nullToEmpty( pi.getCharacteristic() )+"</Characteristic>" + CR);
						
						strXML.append("         </ProductInfo>" + CR);
					}
					strXML.append("         <CountryCode>"+nullToEmpty( dd.getCountryCode() )+"</CountryCode>" + CR);
					strXML.append("         <Remark>"+nullToEmpty( dd.getRemark() )+"</Remark>" + CR);
					strXML.append("      </DocumentDetail>" + CR);
				}
				strXML.append("   </DocumentDetails>" + CR);
			}
			
			strXML.append("</LicensePerInvoice>" + CR);
		}
		
		return strXML.toString();
	}
	
	/**
	 * build XML for cancel license request
	 * 
	 * @param String name
	 * @param String userId
	 * @param LicenseCancel data
	 * @return String XML format
	 * @throws Exception
	 */
	public String buildLicenseCancelMsg(String name,
										String userId,
										LicenseCancel data) 
		throws Exception {

		StringBuffer strXML = new StringBuffer();

		if ( data != null ) {
			strXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + CR);
			strXML.append("<LicenseCancel xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + CR);
			strXML.append("					  xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"" + CR);
			strXML.append("					  xmlns=\"http://ebxml.customs.go.th/schema/LicenseCancelMsg_0_1.xsd\">" + CR);
			if ( data.getDocumentHeader() != null ) {
				strXML.append("   <DocumentHeader>" + CR);
				DocumentHeaderType dht = data.getDocumentHeader();
				if ( dht.getDocumentReference() != null ) {
					DocumentReferenceType drt = dht.getDocumentReference();
					strXML.append("      <DocumentReference>" + CR);
					strXML.append("         <UserID>"+drt.getUserID()+"</UserID>");
					strXML.append("      </DocumentReference>" + CR);
				}	
				if ( dht.getLicenseInfo() != null ) {
					com.itap.ebms.cancel.LicenseInfoType lit = dht.getLicenseInfo();
					strXML.append("      <LicenseInfo>" + CR);
					strXML.append("         <LicenseNo>"+lit.getLicenseNo()+"</LicenseNo>");
					strXML.append("         <TaxReference>"+lit.getTaxReference()+"</TaxReference>");
					strXML.append("         <IssueDate>"+lit.getIssueDate().toXMLFormat()+"</IssueDate>");
					strXML.append("         <DocumentType>"+lit.getDocumentType()+"</DocumentType>");
					strXML.append("      </LicenseInfo>" + CR);
				}
				strXML.append("   </DocumentHeader>" + CR);
			}
			strXML.append("</LicenseCancel>" + CR);
		}
		return strXML.toString();
	}
	
	
	/**
	 * Parsing ebXML LicenseResponse agreement
	 * 
	 * <LicenseResponse>
	 *    <MessageHeader>  
     *       <MessageType>...</MessageType>
     *       <UserID>...</UserID>
     *       <Timestamp>...</Timestamp>
     *       <MessageDetail>
     *          <BOIReject>
     *             <LicenseNo>...</LicenseNo>
     *             <TaxReference>...</TaxReference>
     *             <LicenseDetail>...</LicenseDetail>
     *             <ErrorCode>...</ErrorCode>
     *             <Message>...</Message>
     *          </BOIReject>
     *          <BOIAccept>
     *             <LicenseNo>...</LicenseNo>
     *             <TaxReference>...</TaxReference>
     *             <CustomsStatus>...</CustomsStatus>
     *             <Message>...</Message>
     *          </BOIAccept>
     *          <LicenseReject>
     *             <LicenseNo>...</LicenseNo>
     *             <TaxReference>...</TaxReference>
     *             <InvoiceNo>...</InvoiceNo>
     *             <InvoiceDate>...</InvoiceDate>
     *             <InvoiceItem>...</InvoiceItem>
     *             <ErrorCode>...</ErrorCode>
     *             <Message>...</Message>
     *          </LicenseReject>
     *          <LicenseAccept>
     *             <LicenseNo>...</LicenseNo>
     *             <TaxReference>...</TaxReference>
     *             <CustomsStatus>...</CustomsStatus>
     *             <Message>...</Message>
     *          </LicenseAccept>
     *       </MessageDetail>
     *    </MessageHeader>
     *    ...
	 * </LicenseResponse>
	 * 
	 * @param LicenseResponse class data container
	 * @return XML string
	 */
	public LicenseResponse parsLicenseResponseMsg(String strXML) throws Exception {
		LicenseResponse licenseResp = new LicenseResponse();
		// Create SAX parser with XML validate
        SAXBuilder builder = new SAXBuilder();
        // XML parsing
        Document doc = builder.build( new StringReader( strXML ) );
        // Getter root
        Element root = doc.getRootElement();
        /*
         * <LicenseResponse> ... </LicenseResponse>
         */
        if ( root != null ) {
        
        	/*
             * <MessageHeader> ... </MessageHeader>
             */
        	List msgHeaderList = root.getChildren("MessageHeader");
        	if ( msgHeaderList != null && msgHeaderList.size() > 0 ) {
        		for ( Object msgHeader : msgHeaderList ) {
        			
        			MessageHeader messageHeader = new MessageHeader();
        			
        			messageHeader.setMessageType( ((Element)msgHeader).getChildText("MessageType") );
        			messageHeader.setUserID( ((Element)msgHeader).getChildText("UserID") );
        			messageHeader.setTimestamp( getXMLGregorianCalendar(((Element)msgHeader).getChildText("Timestamp")) );
        			
        			/*
        			 * <MessageDetail>...</MessageDetail>
        			 */
        			Element msgDetailElement = ((Element)msgHeader).getChild("MessageDetail");
        			if ( msgDetailElement != null ) {
        				MessageDetail messageDetail = new MessageDetail();
        				
        				/*
        				 * <BOIReject>...</BOIReject>
        				 */
        				Element boiRejectElement = msgDetailElement.getChild("BOIReject");
            			if ( boiRejectElement != null ) {
            				BOIReject boiReject = new BOIReject();
            				boiReject.setLicenseNo( boiRejectElement.getChildText("LicenseNo") );
            				boiReject.setTaxReference( boiRejectElement.getChildText("TaxReference") );
            				boiReject.setLicenseDetail( boiRejectElement.getChildText("LicenseDetail") );
            				boiReject.setErrorCode( boiRejectElement.getChildText("ErrorCode") );
            				boiReject.setMessage( boiRejectElement.getChildText("Message") );
            				// Add LicenseResponse <- MessageHeader <-MessageDetail <- BOIReject
            				messageDetail.setBOIReject(boiReject);
            			}
            			
            			/*
        				 * <BOIAccept>...</BOIAccept>
        				 */
            			Element boiAcceptElement = msgDetailElement.getChild("BOIAccept");
            			if ( boiAcceptElement != null ) {
            				BOIAccept boiAccept = new BOIAccept();
            				boiAccept.setLicenseNo( boiAcceptElement.getChildText("LicenseNo") );
            				boiAccept.setTaxReference( boiAcceptElement.getChildText("TaxReference") );
            				boiAccept.setCustomsStatus( boiAcceptElement.getChildText("CustomsStatus") );
            				boiAccept.setMessage( boiAcceptElement.getChildText("Message") );
            				// Add LicenseResponse <- MessageHeader <-MessageDetail <- BOIAccept
            				messageDetail.setBOIAccept(boiAccept);
            			}
            			
            			/*
        				 * <LicenseReject>...</LicenseReject>
        				 */
            			Element licenseRejectElement = msgDetailElement.getChild("LicenseReject");
            			if ( licenseRejectElement != null ) {
            				LicenseReject licenseReject = new LicenseReject();
            				licenseReject.setLicenseNo( licenseRejectElement.getChildText("LicenseNo") );
            				licenseReject.setTaxReference( licenseRejectElement.getChildText("TaxReference") );
            				licenseReject.setInvoiceNo( licenseRejectElement.getChildText("InvoiceNo") );
            				licenseReject.setInvoiceDate( getXMLGregorianCalendar(licenseRejectElement.getChildText("InvoiceDate")) );
            				if ( licenseRejectElement.getChildText("InvoiceItem") != null )
            					licenseReject.setInvoiceItem( new BigInteger(licenseRejectElement.getChildText("InvoiceItem")) );
            				licenseReject.setErrorCode( licenseRejectElement.getChildText("ErrorCode") );
            				licenseReject.setMessage( licenseRejectElement.getChildText("Message") );
            				// Add LicenseResponse <- MessageHeader <-MessageDetail <- LicenseReject
            				messageDetail.setLicenseReject(licenseReject);
            			}
            			
            			/*
        				 * <LicenseAccept>...</LicenseAccept>
        				 */
            			Element licenseAcceptElement = msgDetailElement.getChild("LicenseAccept");
            			if ( licenseAcceptElement != null ) {
            				LicenseAccept licenseAccept = new LicenseAccept();
            				licenseAccept.setLicenseNo( licenseAcceptElement.getChildText("LicenseNo") );
            				licenseAccept.setTaxReference( licenseAcceptElement.getChildText("TaxReference") );
            				licenseAccept.setCustomsStatus( licenseAcceptElement.getChildText("CustomsStatus") );
            				licenseAccept.setMessage( licenseAcceptElement.getChildText("Message") );
            				// Add LicenseResponse <- MessageHeader <-MessageDetail <- LicenseAccept
            				messageDetail.setLicenseAccept(licenseAccept);
            			}
            			// Add LicenseResponse <- MessageHeader <- MessageDetail
            			messageHeader.setMessageDetail(messageDetail);
        			} else throw new Exception("ebXML LicenseResponse message header is not contain message detail");
        			// Add LicenseResponse <- MessageHeader
        			licenseResp.getMessageHeaders().add(messageHeader);
        		}
        	} else throw new Exception("ebXML LicenseResponse message is not contain message header");
        	
        	/*
             * <Signature> ... </Signature>
             */
        	List signatureList = root.getChildren("Signature");
        	if ( signatureList != null && signatureList.size() > 0 ) {
        		/*
        		 * Security key processing
        		 * ------------------------
        		 * 
        		 */
        	}
        	
        } else throw new Exception("String is not XML");
		
		return licenseResp;
	}
	
	
	
	/* ############################# Soap ebXML message Header/Payload parsing  ##############################*/
	
	
	/**
	 * Parsing ebXML Message Header
	 * 
	 * <soap:Envalop>
	 *    <soap:Header>
	 *       <eb:MessageHeader>
	 *          <eb:From>
	 *             <eb:PartyId>...</eb:PartyId>
	 *             <eb:Role>...</eb:Role>
	 *          </eb:From>
	 *          <eb:To>
	 *             <eb:PartyId>...</eb:PartyId>
	 *             <eb:Role>...</eb:Role>
	 *          </eb:To>
	 *          <eb:CPAId>...</eb:CPAId>
	 *          <eb:ConversationId>...</eb:ConversationId>
	 *          <eb:Service>...</eb:Service>
	 *          <eb:Action>...</eb:Action>
	 *          <eb:MessageData>
	 *             <eb:MessageId>...</eb:MessageId>
	 *             <eb:Timestamp>...</eb:Timestamp>
	 *             <eb:TimeToLive>...</eb:TimeToLive>
	 *             <eb:AckRequest>...</eb:AckRequest>
	 *          </eb:MessageData>
	 *       </eb:MessageHeader>
	 *       ...
	 *    </soap:Header>
	 *    <soap:Body>
	 *    ...
	 *    </soap:Body>
	 * </soap:Envalop>
	 * 
	 * 
	 * @param strXML String
	 * @return MsgHeade class contain ebMS Header attributes data
	 * @throws Exception
	 */
	public MsgHeader parsMessageHeader(String strXML) throws Exception {
		MsgHeader msgHeader = new MsgHeader();
		// Create SAX parser with XML validate
        SAXBuilder builder = new SAXBuilder();
        // XML parsing
        Document doc = builder.build( new StringReader( strXML ) );
        // Getter root
        Element root = doc.getRootElement();
        if ( root != null ) {
        	Element header = root.getChild("soap:Header");
        	if ( header != null ) {
        		Element mh = header.getChild("eb:MessageHeader");
        		if ( mh != null ) {
        			Element from = mh.getChild("eb:From");
            		if ( from != null ) {
            			msgHeader.setFromPartyId( from.getChildText("eb:PartyId") );
            			msgHeader.setFromRole( from.getChildText("eb:Role") );
            		}
            		Element to = mh.getChild("eb:To");
            		if ( to != null ) {
            			msgHeader.setToPartyId( to.getChildText("eb:PartyId") );
            			msgHeader.setToRole( to.getChildText("eb:Role") );
            		}
            		msgHeader.setIdCPA( mh.getChildText("eb:CPAId") );
            		msgHeader.setIdConversation( mh.getChildText("eb:ConversationId") );
            		msgHeader.setServices( mh.getChildText("eb:Service") );
            		msgHeader.setAction( mh.getChildText("eb:Action") );
            		
            		Element msgData = mh.getChild("eb:MessageData");
            		if ( msgData != null ) {
            			msgHeader.setMessageId( msgData.getChildText("eb:MessageId") );
            			msgHeader.setTimestamp( msgData.getChildText("eb:Timestamp") );
            			msgHeader.setTimeToLive( msgData.getChildText("eb:TimeToLive") );
            			msgHeader.setAckRequest( msgData.getChildText("eb:AckRequest") );
            		}
            		
        		} else throw new Exception("No found ebXML MessageHeader element in XML response");
        	} else throw new Exception("No found SOAP header element in XML response");
        } else throw new Exception("String is not XML");
		return msgHeader;
	}
	
	/**
	 * Parsing ebXML Message Acknowledgment
	 * 
	 * <soap:Envalop>
	 *    <soap:Header>
	 *       <eb:MessageHeader>
	 *          ...
	 *       </eb:MessageHeader>
	 *       ...
	 *       <eb:Acknowledgment eb:id="..." eb:version="...">
	 *          <eb:Timestamp>...</eb:Timestamp>
	 *          <eb:RefToMessageId>...</eb:RefToMessageId>
	 *          <eb:Form>...</eb:Form>
	 *          <eb:PartyId>...</eb:PartyId>
	 *          ...
	 *       </eb:Acknowledgment>
	 *    </soap:Header>
	 *    <soap:Body>
	 *    ...
	 *    </soap:Body>
	 * </soap:Envalop>
	 * 
	 * 
	 * @param strXML
	 * @return Acknowledgment class data container
	 * @throws Exception
	 */
	public Acknowledgment parsAcknowledgeMeg(String messageid, String strXML) throws Exception {
		Acknowledgment ack = new Acknowledgment();
		// Create SAX parser with XML validate
        SAXBuilder builder = new SAXBuilder();
        // XML parsing
        Document doc = builder.build( new StringReader( strXML ) );
        // Getter root
        Element root = doc.getRootElement();
        if ( root != null ) {
        	Element header = root.getChild("SOAP:Header");
        	if ( header == null ) header = root.getChild("soap:Header");
        	if ( header == null ) header = root.getChild("SOAP-ENV:Header");
        	
        	if ( header != null ) {
        		Element acknowlesge = header.getChild("eb:Acknowledgment");
        		if ( acknowlesge != null ) {
        			ack.setAck_id(acknowlesge.getAttributeValue("eb:id"));
        	        ack.setAck_version(acknowlesge.getAttributeValue("eb:version"));
        	        
        	        ack.setAck_actor(acknowlesge.getAttributeValue("SOAP:actor"));
        	        if (ack.getAck_actor() == null) ack.setAck_actor(acknowlesge.getAttributeValue("soap:actor"));
        	        if (ack.getAck_actor() == null) ack.setAck_actor(acknowlesge.getAttributeValue("SOAP-ENV:actor"));
        	        
        	        ack.setAck_mustUnderstand(acknowlesge.getAttributeValue("SOAP:mustUnderstand"));
        	        if (ack.getAck_mustUnderstand() == null) ack.setAck_mustUnderstand(acknowlesge.getAttributeValue("soap:mustUnderstand"));
        	        if (ack.getAck_mustUnderstand() == null) ack.setAck_mustUnderstand(acknowlesge.getAttributeValue("SOAP-ENV:mustUnderstand"));
        	        
        	        ack.setTimestamp(acknowlesge.getChildText("eb:Timestamp"));
        	        ack.setRefToMessageId(acknowlesge.getChildText("eb:RefToMessageId"));
        	        
        	        if ( !messageid.equals(ack.getRefToMessageId()) ) 
        	        	throw new Exception("Error, Miss match message ID for communication ["+messageid+":"+ack.getRefToMessageId()+"]");
        	        
        	        Element from = acknowlesge.getChild("eb:Form");
        	        ack.setFrom(from.getChildText("eb:PartyId"));
        		} else throw new Exception("No found acknowledgment element in XML response");
        	} else throw new Exception("No found SOAP header element in XML response");
        } else throw new Exception("String is not XML");
		return ack;
	}
	
	/**
	 * Convert timestamp string (XML format) to
	 * XMLGregorianCalendat through XMLCalendar 
	 * 
	 * @param value
	 * @return XMLGregorianCalendar
	 */
	private XMLGregorianCalendar getXMLGregorianCalendar(String value) {
		try {
			if ( value != null && value.trim().length() > 0 ) {
				XMLCalendar cal = new XMLCalendar(value, XML_DATE_TYPE);
				return cal.normalize();
			} return null;
		} catch ( Exception ex ) {
			return null;
		}
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
	
	/**
	 * Null to empty string
	 * @param val
	 * @return String
	 */
	private String nullToEmpty(BigInteger val) {
		if ( val == null ) return "";
		else return val.toString();
	}
	
	/**
	 * Null to empty string
	 * @param val
	 * @return String
	 */
	private String nullToEmpty(BigDecimal val) {
		if ( val == null ) return "";
		else return val.toString();
	}
	
	
	/**
	 * @Test
	 */
	/*
	public static void main(String args[]) throws Exception {
		SoapProducer sp = new SoapProducer();
		LicensePerInvoice lpi = new LicensePerInvoice();
		com.itap.ebms.req.DocumentHeaderType dt = new com.itap.ebms.req.DocumentHeaderType();	
		com.itap.ebms.req.DocumentReferenceType dr = new com.itap.ebms.req.DocumentReferenceType();
		dr.setDischargePort(new BigInteger("9090"));
		dr.setLoadPort(new BigInteger("8080"));
		dr.setRegistrationID("เลขที่");
		dt.setDocumentReference(dr);
		LicenseInfoType lif = new LicenseInfoType();
		lif.setAuthorityID("เลขที่ผู้ใช้");
		lif.setAuthorityName("ผู้ชื่อใช้");
		lif.setCountryCode("ประเทศไทย");
		lif.setDescription("รายการ");
		lif.setInspectionDesc("รายละเอียด");
		lif.setInspectionLevel("ลำดับ");
		lif.setLicenseName("เลขที่ใบอนุญาต");
		lif.setLicenseNo("523/44");
		lif.setLicenseType("ใบลาออก");
		lif.setTaxReference("อ้างอิง");
		dt.setLicenseInfo(lif);
		lpi.setDocumentHeader(dt);
		System.out.println("Look-> "+sp.buildLicensePerInvoiceMsg("คนไทย", "เลขที่", lpi));
	}
	*/
}
