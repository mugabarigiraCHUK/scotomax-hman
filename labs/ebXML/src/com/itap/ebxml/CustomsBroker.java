package com.itap.ebxml;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.itap.ebxml.beans.CanonicalizationMethod;
import com.itap.ebxml.beans.CustomsTariffQuantityType;
import com.itap.ebxml.beans.DocumentDetailsTransportType;
import com.itap.ebxml.beans.DocumentHeaderType;
import com.itap.ebxml.beans.DocumentReferenceType;
import com.itap.ebxml.beans.InvoiceInfoType;
import com.itap.ebxml.beans.KeyInfo;
import com.itap.ebxml.beans.LicenseInfoType;
import com.itap.ebxml.beans.LicensePerInvoice;
import com.itap.ebxml.beans.QuantityType;
import com.itap.ebxml.beans.Reference;
import com.itap.ebxml.beans.Signature;
import com.itap.ebxml.beans.SignatureMethod;
import com.itap.ebxml.beans.SignatureValue;
import com.itap.ebxml.beans.SignedInfo;
import com.itap.ebxml.beans.DocumentDetailsTransportType.ProductInfo;
import com.itap.ebxml.beans.DocumentDetailsTransportType.ProductInfo.WeightInfo;
import com.itap.ebxml.util.Content;

public class CustomsBroker implements ICustomsBroker {

	// Logger
	final Logger logger = LoggerFactory.getLogger(CustomsBroker.class);
	// Class-Instance
	final static CustomsBroker INSTANCE = new CustomsBroker();
	// Spring application context
	ClassPathXmlApplicationContext ctx = null;
	// Spring context file name
	final String[] SPRING_CONFIG_FILES = new String[] { "spring-beans.xml" };
	// Spring Web Service template object
	WebServiceTemplate wsTemplate;

	/**
	 * Constructor-method
	 * 
	 */
	public CustomsBroker() {
		// TODO Auto-Generated
	}

	/**
	 * Initialize Spring context components and Spring web services template
	 * 
	 * @param (String) defaultURI
	 * @throws Exception
	 */
	public void init(String defaultURI) throws Exception {
		try {
			ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILES);
			wsTemplate = (WebServiceTemplate) ctx.getBean("wsTemplate");
			wsTemplate.setDefaultUri(defaultURI);
		} catch (Exception ex) {
			logger.error("Failed to Spring context intialize, "
					+ ex.getMessage());
			throw ex;
		}
	}

	/**
	 * Getting customs broker instance
	 * 
	 * @return CustomsBroker.class
	 */
	public static CustomsBroker getInstance() {
		return INSTANCE;
	}

	/**
	 * Remote web method for execute license per invoice process by each data
	 * object which pass through services
	 * 
	 * @param (LicensePerInvoice.class) licensePerInvoice
	 * @throws Exception
	 */
	public void proceedlicensePerInvoice(LicensePerInvoice licensePerInvoice)
			throws Exception {
		try {
			wsTemplate.marshalSendAndReceive(licensePerInvoice);
		} catch (Exception ex) {
			logger.error("Failed to Spring context intialized, "
					+ ex.getMessage());
			throw new Exception(ex);
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
	 * @param (String) authorityID
	 * @param (String) authorityName
	 * @param (String) countryCode
	 * @param (String) description
	 * @param (String) inspectionLevel
	 * @param (String) inspectionDesc
	 * @param (String) taxReference
	 * @return LicenseInfoType.class
	 */
	public LicenseInfoType createLicenseInfoType(String licenseNo,
			String licenseName, String licenseType, String authorityID,
			String authorityName, String countryCode, String description,
			String inspectionLevel, String inspectionDesc, String taxReference) {
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

}
