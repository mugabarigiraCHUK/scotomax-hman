package com.itap.ebms;

import org.junit.Test;

import com.itap.ebms.sign.SignatureGenerator;
import com.itap.ebms.sign.ValidateXMLSignature;

public class MessageTester {
	
	final String CR = System.getProperty("line.separator");

	@Test
	public void signHeader() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer ebHeader = new StringBuffer();
		
		ebHeader.append("<SOAP:Envelope xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\"");
		ebHeader.append("				xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"");
		ebHeader.append("				xmlns:xlink=\"http://www.w3.org/1999/xlink\"");
		ebHeader.append("				xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		ebHeader.append("				xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/");
		ebHeader.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd");
		ebHeader.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd");
		ebHeader.append("									 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">");
		ebHeader.append("<SOAP:Header xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/");
		ebHeader.append("								   http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">");
		ebHeader.append("		<eb:MessageHeader SOAP:mustUnderstand=\"1\" version=\"2.0\">");
		ebHeader.append("			<eb:From>");
		ebHeader.append("				<eb:PartyId eb:type=\"string\">DOEBDemo</eb:PartyId>");
		ebHeader.append("				<eb:Role>OGAs</eb:Role>");
		ebHeader.append("			</eb:From>");
		ebHeader.append("			<eb:To>");
		ebHeader.append("				<eb:PartyId eb:type=\"string\">TCDNSWDemo</eb:PartyId>");
		ebHeader.append("				<eb:Role>NSW</eb:Role>");
		ebHeader.append("			</eb:To>");
		ebHeader.append("			<eb:CPAId>NSW_DOEB_1_02</eb:CPAId>");
		ebHeader.append("			<eb:ConversationId>40300363290000011_12/2553</eb:ConversationId>");
		ebHeader.append("			<eb:Service eb:type=\"string\">TCDeLicense</eb:Service>");
		ebHeader.append("			<eb:Action>LicensePerInvoice</eb:Action>");
		ebHeader.append("			<eb:MessageData>");
		ebHeader.append("				<eb:MessageId>40300363290000011</eb:MessageId>");
		ebHeader.append("				<eb:Timestamp>2010-11-03T17:36:31.349+07:00</eb:Timestamp>");
		ebHeader.append("			</eb:MessageData>");
		ebHeader.append("		</eb:MessageHeader>");
		ebHeader.append("		<eb:SyncReply SOAP:actor=\"http://schema.xmlsoap.org/soap/actor/next\" SOAP:mustUnderstand=\"1\" eb:version=\"2.0\"/>");
		ebHeader.append("		<eb:AckRequested SOAP:actor=\"urn:oasis:names:tc:ebxml-msg:actor:toPartyMSH\" SOAP:mustUnderstand=\"1\" eb:signed=\"false\" eb:version=\"2.0\"/>");
		ebHeader.append("</SOAP:Header>");
		ebHeader.append("<SOAP:Body xsi:schemaLocation=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd");
		ebHeader.append("								 http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">");
		ebHeader.append("		<eb:Manifest eb:version=\"2.0\">");
		ebHeader.append("			<eb:Reference xlink:href=\"cid:Payload-0\" xlink:role=\"XLinkRole\" xlink:type=\"simple\">");
		ebHeader.append("			</eb:Reference>");
		ebHeader.append("		</eb:Manifest>");
		ebHeader.append("	</SOAP:Body>");
		ebHeader.append("</SOAP:Envelope>");
		
		String keystoreFile = getClass().getClassLoader().getResource("sarayut.jks").getPath();
		String ebSigned = SignatureGenerator.signSoapHeader(keystoreFile, "12345678", "1", "Dpeb#173", ebHeader.toString(), "ds");
		//String ebSigned = SignatureGenerator.digitalSign(keystoreFile, "12345678", "www.sarayut.org", "12345678", ebHeader.toString(), "ds");
		
		String payloadSigned = signPayload();
		String digest = payloadSigned.substring(payloadSigned.indexOf("</Transforms>"), 
												payloadSigned.indexOf("</Reference>"));
		digest = digest.substring("</Transforms>".length());
		digest = "<ds:Reference URI=\"cid:Payload-0\">"+digest.replace("DigestMethod", "ds:DigestMethod").replace("DigestValue", "ds:DigestValue")+"</ds:Reference>";
		
		System.out.println(digest);
		
		String result = ebSigned.substring(0, ebSigned.indexOf("</ds:SignedInfo>")) + digest + ebSigned.substring(ebSigned.indexOf("</ds:SignedInfo>"));
		
		System.out.println(result);

		ValidateXMLSignature.validate(result);

	}
	
	private String signPayload() throws Exception  {
		// TODO Auto-generated method stub
		StringBuffer xml = new StringBuffer();
		xml.append("<LicensePerInvoice xmlns=\"http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_2_0.xsd\"");
		xml.append("				   xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
		xml.append("				   xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		xml.append("<DocumentHeader xmlns=\"\">");
		xml.append(" <DocumentReference>");
		xml.append("  <Name>40300363290000011</Name>");
		xml.append("  <UserID>40300363290000011</UserID>");
		xml.append(" </DocumentReference>");
		xml.append(" <LicenseInfo>");
		xml.append("  <LicenseNo>12/2553</LicenseNo>");
		xml.append("  <TaxReference>3101507416</TaxReference>");
		xml.append("  <LicenseType>0</LicenseType>");
		xml.append("  <IssueDate>2010-05-03</IssueDate>");
		xml.append("  <CountryCode/>");
		xml.append("  <ConsignmentInfo>");
		xml.append("   <CountryCode/>");
		xml.append("   <TaxReference>3101507416</TaxReference>");
		xml.append("  </ConsignmentInfo>");
		xml.append("  <Description/>");
		xml.append("  <EffectiveDate>2010-05-03</EffectiveDate>");
		xml.append("  <ExpireDate>2010-06-02</ExpireDate>");
		xml.append("  <AuthorityID/>");
		xml.append("  <AuthorityName>????????????????</AuthorityName>");
		xml.append("  <LicenseName>????????????????</LicenseName>");
		xml.append("  <InspectionLevel/>");
		xml.append("  <InspectionDesc/>");
		xml.append(" </LicenseInfo>");
		xml.append("</DocumentHeader>");
		xml.append("<DocumentDetails xmlns=\"\">");
		xml.append(" <DocumentDetail>");
		xml.append("  <InvoiceInfo>");
		xml.append("   <InvoiceNumber>1</InvoiceNumber>");
		xml.append("   <InvoiceDate>2010-04-20</InvoiceDate>");
		xml.append("   <InvoiceItem>1</InvoiceItem>");
		xml.append("   <Description>nap</Description>");
		xml.append("  </InvoiceInfo>");
		xml.append("  <DeclarationLineNo/>");
		xml.append("  <TariffInfo>");
		xml.append("   <Classification/>");
		xml.append("   <StatisticalCode/>");
		xml.append("  </TariffInfo>");
		xml.append("  <ProductInfo>");
		xml.append("   <WeightInfo>");
		xml.append("    <Weight>200</Weight>");
		xml.append("    <UnitCode>L</UnitCode>");
		xml.append("   </WeightInfo>");
		xml.append("   <QuantityInfo>");
		xml.append("    <Quantity>500</Quantity>");
		xml.append("    <UnitCode>L</UnitCode>");
		xml.append("    <SamplingQuantity/>");
		xml.append("    <SamplingUnitCode/>");
		xml.append("   </QuantityInfo>");
		xml.append("   <RegistrationNumber/>");
		xml.append("   <BodyNo/>");
		xml.append("   <BodyNo/>");
		xml.append("   <EngineNo/>");
		xml.append("   <Displacement/>");
		xml.append("   <ModelCode/>");
		xml.append("   <Year/>");
		xml.append("   <BrandName/>");
		xml.append("   <CountryCode/>");
		xml.append("   <Characteristic/>");
		xml.append("  </ProductInfo>");
		xml.append("  <CountryCode/>");
		xml.append("  <Remark/>");
		xml.append(" </DocumentDetail>");
		xml.append("</DocumentDetails>");
		xml.append("</LicensePerInvoice>");
		
		String keystoreFile = getClass().getClassLoader().getResource("sarayut.jks").getPath();
		String ebPayload = SignatureGenerator.signXmlPayload(keystoreFile, "12345678", "1", "Dpeb#173", xml.toString(), "");
		//String ebPayload = SignatureGenerator.digitalSign(keystoreFile, "12345678", "www.sarayut.org", "12345678", xml.toString(), "");
		
		System.out.println(ebPayload);
		
		ValidateXMLSignature.validate(ebPayload);
		
		return ebPayload;
	}
	
	
	public void testPayload() throws Exception  {
		// TODO Auto-generated method stub
		StringBuffer xml = new StringBuffer();
		xml.append("<LicensePerInvoice xmlns=\"http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_2_0.xsd\"");
		xml.append("				   xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
		xml.append("				   xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		xml.append("<DocumentHeader xmlns=\"\">");
		xml.append(" <DocumentReference>");
		xml.append("  <Name>40300363290000011</Name>");
		xml.append("  <UserID>40300363290000011</UserID>");
		xml.append(" </DocumentReference>");
		xml.append(" <LicenseInfo>");
		xml.append("  <LicenseNo>12/2553</LicenseNo>");
		xml.append("  <TaxReference>3101507416</TaxReference>");
		xml.append("  <LicenseType>0</LicenseType>");
		xml.append("  <IssueDate>2010-05-03</IssueDate>");
		xml.append("  <CountryCode/>");
		xml.append("  <ConsignmentInfo>");
		xml.append("   <CountryCode/>");
		xml.append("   <TaxReference>3101507416</TaxReference>");
		xml.append("  </ConsignmentInfo>");
		xml.append("  <Description/>");
		xml.append("  <EffectiveDate>2010-05-03</EffectiveDate>");
		xml.append("  <ExpireDate>2010-06-02</ExpireDate>");
		xml.append("  <AuthorityID/>");
		xml.append("  <AuthorityName>????????????????</AuthorityName>");
		xml.append("  <LicenseName>????????????????</LicenseName>");
		xml.append("  <InspectionLevel/>");
		xml.append("  <InspectionDesc/>");
		xml.append(" </LicenseInfo>");
		xml.append("</DocumentHeader>");
		xml.append("<DocumentDetails xmlns=\"\">");
		xml.append(" <DocumentDetail>");
		xml.append("  <InvoiceInfo>");
		xml.append("   <InvoiceNumber>1</InvoiceNumber>");
		xml.append("   <InvoiceDate>2010-04-20</InvoiceDate>");
		xml.append("   <InvoiceItem>1</InvoiceItem>");
		xml.append("   <Description>nap</Description>");
		xml.append("  </InvoiceInfo>");
		xml.append("  <DeclarationLineNo/>");
		xml.append("  <TariffInfo>");
		xml.append("   <Classification/>");
		xml.append("   <StatisticalCode/>");
		xml.append("  </TariffInfo>");
		xml.append("  <ProductInfo>");
		xml.append("   <WeightInfo>");
		xml.append("    <Weight>200</Weight>");
		xml.append("    <UnitCode>L</UnitCode>");
		xml.append("   </WeightInfo>");
		xml.append("   <QuantityInfo>");
		xml.append("    <Quantity>500</Quantity>");
		xml.append("    <UnitCode>L</UnitCode>");
		xml.append("    <SamplingQuantity/>");
		xml.append("    <SamplingUnitCode/>");
		xml.append("   </QuantityInfo>");
		xml.append("   <RegistrationNumber/>");
		xml.append("   <BodyNo/>");
		xml.append("   <BodyNo/>");
		xml.append("   <EngineNo/>");
		xml.append("   <Displacement/>");
		xml.append("   <ModelCode/>");
		xml.append("   <Year/>");
		xml.append("   <BrandName/>");
		xml.append("   <CountryCode/>");
		xml.append("   <Characteristic/>");
		xml.append("  </ProductInfo>");
		xml.append("  <CountryCode/>");
		xml.append("  <Remark/>");
		xml.append(" </DocumentDetail>");
		xml.append("</DocumentDetails>");
		xml.append("</LicensePerInvoice>");
		
		String keystoreFile = getClass().getClassLoader().getResource("sarayut.jks").getPath();
		String ebPayload = SignatureGenerator.signXmlPayload(keystoreFile, "12345678", "1", "Dpeb#173", xml.toString(), "");
		//String ebPayload = SignatureGenerator.digitalSign(keystoreFile, "12345678", "www.sarayut.org", "12345678", xml.toString(), "");
		
		System.out.println(ebPayload);
		
		ValidateXMLSignature.validate(ebPayload);
	}

}
