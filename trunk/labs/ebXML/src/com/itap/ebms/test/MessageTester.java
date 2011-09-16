package com.itap.ebms.test;

import org.junit.Test;

import com.itap.ebms.sign.SignatureGenerator;
import com.itap.ebms.sign.ValidateXMLSignature;

public class MessageTester {
	
	final String CR = System.getProperty("line.separator");

	@Test
	public void signHeader() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer ebHeader = new StringBuffer();
		
		ebHeader.append("	<SOAP:Header xmlns:xlink=\"http://www.w3.org/1999/xlink\"" + CR);
		ebHeader.append("				 xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\"" + CR);
		ebHeader.append("				 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + CR);
		ebHeader.append("				 xsi:schemaLocation=\"http://schemas.xmlsoap.org/soap/envelope/" + CR);
		ebHeader.append("									  http://www.oasis-open.org/committees/ebxml-msg/schema/envelope.xsd\">" + CR);
		ebHeader.append("									  http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd" + CR);
		ebHeader.append("									  http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\">" + CR);
		ebHeader.append("		<eb:MessageHeader xmlns:eb=\"http://www.oasis-open.org/committees/ebxml-msg/schema/msg-header-2_0.xsd\"" + CR);
		ebHeader.append("						  version=\"2.0\"" + CR);
		ebHeader.append("						  SOAP:mustUnderstand=\"1\">" + CR);
		ebHeader.append("			<eb:From>"+CR);
		ebHeader.append("				<eb:PartyId eb:type=\"string\">DOEB_PARTYID</eb:PartyId>"+CR);
		ebHeader.append("				<eb:Role>DOEB_ROLE</eb:Role>"+CR);
		ebHeader.append("			</eb:From>"+CR);
		ebHeader.append("			<eb:To>"+CR);
		ebHeader.append("				<eb:PartyId eb:type=\"string\">TCDNSW_PARTYID</eb:PartyId>"+CR);
		ebHeader.append("				<eb:Role>TCDNSW_ROLE</eb:Role>"+CR);
		ebHeader.append("			</eb:To>"+CR);	
		ebHeader.append("			<eb:CPAId>TCDNSW_CPAID</eb:CPAId>" + CR);
		ebHeader.append("			<eb:ConversationId>123456789_1234</eb:ConversationId>" + CR);
		ebHeader.append("			<eb:Service eb:type=\"string\">TCDNSW_SERVICES</eb:Service>" + CR);
		ebHeader.append("			<eb:Action>LICENSE_PERINVOICE_ACTION</eb:Action>" + CR);
		ebHeader.append("			<eb:MessageData>" + CR);
		ebHeader.append("				<eb:MessageId>messageId</eb:MessageId>" + CR);
		ebHeader.append("				<eb:Timestamp>12-12-1999T00:00:00</eb:Timestamp>" + CR);
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
		
		String keystoreFile = getClass().getClassLoader().getResource("sarayut.jks").getPath();
		//String ebSigned = SignatureGenerator.digitalSign(keystoreFile, "12345678", "1", "Dpeb#173", ebHeader.toString(), "ds");
		String ebSigned = SignatureGenerator.digitalSign(keystoreFile, "12345678", "www.sarayut.org", "12345678", ebHeader.toString(), "ds");
		
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
		xml.append("<LicensePerInvoice xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""+CR);
		xml.append("					  xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""+CR);
		xml.append("					  xmlns=\"http://ebxml.customs.go.th/schema/LicensePerInvoiceMsg_2_0.xsd\">"+CR);
		xml.append("   <DocumentHeader xmlns=\"\">"+CR);
		xml.append("	  <DocumentReference>"+CR);
		xml.append("         <Name>USR001</Name>"+CR);
		xml.append("         <UserID>USR001</UserID>"+CR);
		xml.append("      </DocumentReference>"+CR);
		xml.append("      <LicenseInfo>"+CR);
		xml.append("         <LicenseNo>123456</LicenseNo>"+CR);
		xml.append("         <TaxReference>TAX001</TaxReference>"+CR);
		xml.append("         <LicenseType>BB</LicenseType>"+CR);
		xml.append("         <IssueDate>2010-09-29</IssueDate>"+CR);
		xml.append("         <CountryCode>AA</CountryCode>"+CR);
		xml.append("         <Description>DESC</Description>"+CR);
		xml.append("         <EffectiveDate>2010-09-29</EffectiveDate>"+CR);
		xml.append("         <AuthorityID>4321</AuthorityID>"+CR);
		xml.append("         <AuthorityName>4321</AuthorityName>"+CR);
		xml.append("         <LicenseName>ABACAD</LicenseName>"+CR);
		xml.append("         <InspectionLevel>I1234</InspectionLevel>"+CR);
		xml.append("         <InspectionDesc>IDESC</InspectionDesc>"+CR);
		xml.append("      </LicenseInfo>"+CR);
		xml.append("   </DocumentHeader>"+CR);
		xml.append("   <DocumentDetails xmlns=\"\">"+CR);
		xml.append("      <DocumentDetail>"+CR);
		xml.append("         <InvoiceInfo>"+CR);
		xml.append("            <InvoiceNumber>ITEM001</InvoiceNumber>"+CR);
		xml.append("            <InvoiceDate>2010-09-29</InvoiceDate>"+CR);
		xml.append("            <InvoiceItem>1</InvoiceItem>"+CR);
		xml.append("            <Description>DESC</Description>"+CR);
		xml.append("         </InvoiceInfo>"+CR);
		xml.append("         <DeclarationLineNo>12345678</DeclarationLineNo>"+CR);
		xml.append("         <TariffInfo>"+CR);
		xml.append("            <Classification>11</Classification>"+CR);
		xml.append("            <StatisticalCode>88</StatisticalCode>"+CR);
		xml.append("         </TariffInfo>"+CR);
		xml.append("         <ProductInfo>"+CR);
		xml.append("            <WeightInfo>"+CR);
		xml.append("               <Weight>125</Weight>"+CR);
		xml.append("               <UnitCode>KK</UnitCode>"+CR);
		xml.append("            </WeightInfo>"+CR);
		xml.append("            <QuantityInfo>"+CR);
		xml.append("               <Quantity>12</Quantity>"+CR);
		xml.append("               <UnitCode>KK</UnitCode>"+CR);
		xml.append("               <SamplingQuantity>10</SamplingQuantity>"+CR);
		xml.append("               <SamplingUnitCode>KK</SamplingUnitCode>"+CR);
		xml.append("            </QuantityInfo>"+CR);
		xml.append("            <RegistrationNumber>ABC1234</RegistrationNumber>"+CR);
		xml.append("            <BodyNo>0001</BodyNo>"+CR);
		xml.append("            <EngineNo>0002</EngineNo>"+CR);
		xml.append("            <Displacement>1221</Displacement>"+CR);
		xml.append("            <ModelCode>AE86</ModelCode>"+CR);
		xml.append("            <Year>2010</Year>"+CR);
		xml.append("            <BrandName>MAMA</BrandName>"+CR);
		xml.append("            <CountryCode>BB</CountryCode>"+CR);
		xml.append("            <Characteristic>CHAR</Characteristic>"+CR);
		xml.append("         </ProductInfo>"+CR);
		xml.append("         <CountryCode>BB</CountryCode>"+CR);
		xml.append("         <Remark>MARK</Remark>"+CR);
		xml.append("      </DocumentDetail>"+CR);
		xml.append("   </DocumentDetails>"+CR);
		xml.append("</LicensePerInvoice>");
		
		String keystoreFile = getClass().getClassLoader().getResource("sarayut.jks").getPath();
		//String ebPayload = SignatureGenerator.digitalSign(keystoreFile, "12345678", "1", "Dpeb#173", xml.toString(), "");
		String ebPayload = SignatureGenerator.digitalSign(keystoreFile, "12345678", "www.sarayut.org", "12345678", xml.toString(), "");
		
		System.out.println(ebPayload);
		
		ValidateXMLSignature.validate(ebPayload);
		
		return ebPayload;
	}

}
