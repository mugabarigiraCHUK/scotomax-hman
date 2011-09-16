package com.itap.ebms.sign;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyException;
import java.security.PublicKey;
import java.util.List;

import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLSignatureValidation {

	private static class MyKeySelector extends KeySelector {
		@SuppressWarnings("rawtypes")
		public KeySelectorResult select(KeyInfo keyInfo,
				KeySelector.Purpose purpose, AlgorithmMethod method,
				XMLCryptoContext context) throws KeySelectorException {
			
			if (keyInfo == null) {
				throw new KeySelectorException("Null KeyInfo object!");
			}
			
			SignatureMethod signatureMethod = (SignatureMethod) method;
			List list = keyInfo.getContent();

			String signatureMethodAlgorithm = signatureMethod.getAlgorithm();
			// Currently we support DSA_SHA1 and
			// RSA_SHA1 only, but other algorithms are
			// not impossible

			if (signatureMethodAlgorithm
					.equalsIgnoreCase(SignatureMethod.DSA_SHA1)
					|| signatureMethodAlgorithm
							.equalsIgnoreCase(SignatureMethod.RSA_SHA1)) {

				for (int i = 0; i < list.size(); i++) {
					XMLStructure xmlStructure = (XMLStructure) list.get(i);
					if (xmlStructure instanceof KeyValue) {
						
						PublicKey publicKey = null;
						
						try {
							publicKey = ((KeyValue) xmlStructure)
									.getPublicKey();
						} catch (KeyException e) {
							throw new KeySelectorException(e);
						}

						// make sure the algorithm is correct
						String publicKeyAlgorithm = publicKey.getAlgorithm();

						if (publicKeyAlgorithm.equalsIgnoreCase("DSA")
								|| publicKeyAlgorithm.equalsIgnoreCase("RSA")) {
							return new MyKeySelectorResult(publicKey);
						}
					}
				}
			}
			throw new KeySelectorException("KeyValue not found!");
		}
	}

	private static class MyKeySelectorResult implements KeySelectorResult {
		private PublicKey publicKey;

		public MyKeySelectorResult(PublicKey publicKey) {
			this.publicKey = publicKey;
		}

		public Key getKey() {
			return publicKey;
		}
	}
	
	/*
	public static void main(String[] args) {

		// Instantiate the SignedDocument.xml to be validated

		String inputFileName = "SignedDocument.xml";
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		documentBuilderFactory.setNamespaceAware(true);

		NodeList nodeList = null;
		try {
			Document document = documentBuilderFactory.newDocumentBuilder()
					.parse(new FileInputStream(inputFileName));

			// Find Signature element
			nodeList = document.getElementsByTagNameNS(XMLSignature.XMLNS,
					"Signature");
			if (nodeList.getLength() == 0) {
				System.err.println("Signature not found");

				System.exit(1);
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		// Create a DOM XMLSignatureFactory
		XMLSignatureFactory xmlSignatureFactory =

		XMLSignatureFactory.getInstance();

		// Create a DOMValidateContext, passing an instance
		// of MyKeySelector
		DOMValidateContext domValidateContext = new DOMValidateContext

		(new MyKeySelector(), nodeList.item(0));

		// unmarshal the XMLSignature
		try {
			XMLSignature signature = xmlSignatureFactory
					.unmarshalXMLSignature(domValidateContext);

			// Validate the signature
			if (signature.validate(domValidateContext)) {
				System.out.println("Signature valid.");
			} else {
				System.err.println("Signature failed core validation");

			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	*/
}
