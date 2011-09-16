package com.itap.ebxml;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

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

public interface ICustomsBroker {

	/**
	 * Initialize Spring context components and Spring web services template
	 * 
	 * @param (String) defaultURI
	 * @throws Exception
	 */
	public void init(String defaultURI) throws Exception;
	
	/**
	 * Remote web method for execute license per invoice process by each data
	 * object which pass through services
	 * 
	 * @param (LicensePerInvoice.class) licensePerInvoice
	 * @throws Exception
	 */
	public void proceedlicensePerInvoice(LicensePerInvoice licensePerInvoice)
			throws Exception;

	/**
	 * Create license per invoice object for communicate services
	 * 
	 * @param (DocumentHeaderType.class) documentHeader
	 * @return LicensePerInvoice.class
	 */
	public LicensePerInvoice createLicensePerInvoice(
			DocumentHeaderType documentHeader,
			List<DocumentDetailsTransportType> documentDetails,
			List<Signature> signatures);

	/**
	 * Create document header type
	 * 
	 * @param (DocumentReferenceType.class) documentReference
	 * @param (LicenseInfoType.class) licenseInfo
	 * @return DocumentHeaderType.class
	 */
	public DocumentHeaderType createDocumentHeaderType(
			DocumentReferenceType documentReference, LicenseInfoType licenseInfo);

	/**
	 * Create document reference type
	 * 
	 * @param (String) registrationID
	 * @param (BigInteger) dischargePort
	 * @param (BigInteger) loadPort
	 * @return DocumentReferenceType.class
	 */
	public DocumentReferenceType createDocumentReferenceType(
			String registrationID, BigInteger dischargePort, BigInteger loadPort);

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
			String inspectionLevel, String inspectionDesc, String taxReference);

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
			CustomsTariffQuantityType tariffInfo);

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
			throws DatatypeConfigurationException;

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
			String characteristic, String countryCode, BigDecimal Displacement,
			String engineNo, String modelCode, QuantityType quantityInfo,
			String registrationNumber, WeightInfo weightInfo, BigInteger year);

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
			BigDecimal samplingQuantity);

	/**
	 * Create weight info
	 * 
	 * @param (String) unitCode
	 * @param (BigDecimal) weight
	 * @return WeightInfo.class
	 */
	public WeightInfo createWeightInfo(String unitCode, BigDecimal weight);

	/**
	 * Create tariff info
	 * 
	 * @param (BigInteger) classification
	 * @param (BigInteger) statisticalCode
	 * @return CustomsTariffQuantityType.class
	 */
	public CustomsTariffQuantityType createCustomsTariffQuantityType(
			BigInteger classification, BigInteger statisticalCode);

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
			SignatureValue signatureValue, SignedInfo signedInfo);

	/**
	 * Create key info is defined by ID
	 * 
	 * @param (String) id
	 * @param (List<Content.class>) contents
	 * @return KeyInfo.class
	 */
	public KeyInfo createKeyInfo(String id, List<Content> contents);

	/**
	 * Create signature by value
	 * 
	 * @param (String) id
	 * @param (byte[]) value
	 * @return SignatureValue.class
	 */
	public SignatureValue createSignatureValue(String id, byte[] value);

	/**
	 * Create signature info object
	 * 
	 * @param (String) id
	 * @param (CanonicalizationMethod.class) canonicalization method
	 * @param (SignatureMethod.class) signature method
	 * @return SignedInfo.class
	 */
	public SignedInfo createSignedInfo(String id,
			CanonicalizationMethod canonicalizationMethod,
			SignatureMethod signatureMethod, List<Reference> references);

	/**
	 * Create Canonicalization method is defined by algorithm value
	 * 
	 * @param (String) algorithm
	 * @param (List<Content.class>) contents
	 * @return CanonicalizationMethod.class
	 */
	public CanonicalizationMethod createCanonicalizationMethod(
			String algorithm, List<Content> contents);

	/**
	 * Create Signature method is defined by algorithm value
	 * 
	 * @param (String) algorithm
	 * @param (List<Content.class>) contents
	 * @return SignatureMethod.class
	 */
	public SignatureMethod createSignatureMethod(String algorithm,
			List<Content> contents);
}
