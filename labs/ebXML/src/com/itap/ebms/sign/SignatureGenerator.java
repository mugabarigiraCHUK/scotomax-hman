package com.itap.ebms.sign;

import java.io.FileInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class SignatureGenerator {

	/**
	 * Signed XML for signature
	 * 
	 * @param keyAlgorithm
	 * 		DSA : n-bit Digital Signature Algorithm (DSA) key pair
	 *  	DH : n-bit DH key pair
	 *  	RSA : n-bit RSA key pair
	 * @param numBits
	 * @param sourceXML
	 * @return XML included signature element.
	 * @throws Exception
	 */
	public static String signByGenerateKey(String keyAlgorithm, int numBits, String sourceXML)
			throws Exception {

		// Parse the XML document that we want to sign.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// We must also make the factory namespace-aware
		dbf.setNamespaceAware(true);

		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(sourceXML));

		// Which is used to parse the document
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.parse(is);

		// We generate a public key pair.
		KeyPair kp = KeyTools.generateKeyPair(keyAlgorithm, numBits);

		// We create an XML Digital Signature XMLSignContext containing
		// input parameters for generating the signature
		DOMSignContext dsc = new DOMSignContext(kp.getPrivate(),
				doc.getDocumentElement());

		// We assemble the different parts of the Signature element
		// into an XMLSignature object
		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

		// We then invoke various factory methods to create the different
		// parts of the XMLSignature object as shown below. We create
		// a Reference object, passing to it the following
		Reference ref = fac.newReference("", fac.newDigestMethod(
				DigestMethod.SHA1, null), Collections.singletonList(fac
				.newTransform(Transform.ENVELOPED,
						(TransformParameterSpec) null)), null, null);

		// we create the SignedInfo object, which is the object that is actually
		// signed,
		// as shown below. When creating the SignedInfo, we pass as parameters
		SignedInfo si = null;
		
		if (keyAlgorithm.equals("DSA")) {
			si = fac
			.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
					(C14NMethodParameterSpec) null), fac
					.newSignatureMethod(SignatureMethod.DSA_SHA1, null),
					Collections.singletonList(ref));
		} else if (keyAlgorithm.equals("DH")) {
			si = fac
			.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
					(C14NMethodParameterSpec) null), fac
					.newSignatureMethod(SignatureMethod.HMAC_SHA1, null),
					Collections.singletonList(ref));
		} else if (keyAlgorithm.equals("RSA")) {
			si = fac
			.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
					(C14NMethodParameterSpec) null), fac
					.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
					Collections.singletonList(ref));
		} else {
			throw new NoSuchAlgorithmException();
		}

		// which contains information that enables the recipient to find
		// the key needed to validate the signature
		KeyInfoFactory kif = fac.getKeyInfoFactory();

		// We then use the KeyInfoFactory to create the KeyValue object
		// and add it to a KeyInfo object
		KeyValue kv = kif.newKeyValue(kp.getPublic());
		KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));

		// we create the XMLSignature object, passing as parameters
		// the SignedInfo and KeyInfo objects that we created earlier
		XMLSignature signature = fac.newXMLSignature(si, ki);

		// Now we are ready to generate the signature
		signature.sign(dsc);

		// You can use the following code to print the resulting
		// signed document to a file or standard output
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(doc);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.transform(source, result);

		return result.getWriter().toString();
	}

	/**
	 * Signed XML for signature
	 * 
	 * @param privateKeyFilePath
	 * @param publicKeyFilePath
	 * @param keyAlgorithm
	 * 		DSA : n-bit Digital Signature Algorithm (DSA) key pair
	 *  	DH : n-bit DH key pair
	 *  	RSA : n-bit RSA key pair
	 * @param sourceXML
	 * @return XML included signature element.
	 * @throws Exception
	 */
	public static String signByPrivatePublicKey(String privateKeyFilePath, 
											   String publicKeyFilePath,
											   String keyAlgorithm,
											   String sourceXML) throws Exception {

		// Parse the XML document that we want to sign.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// We must also make the factory namespace-aware
		dbf.setNamespaceAware(true);

		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(sourceXML));

		// Which is used to parse the document
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.parse(is);

		// We generate a public key pair.
		KeyPair kp = KeyTools.LoadKeyPair(privateKeyFilePath, publicKeyFilePath, keyAlgorithm);

		// We create an XML Digital Signature XMLSignContext containing
		// input parameters for generating the signature
		DOMSignContext dsc = new DOMSignContext(kp.getPrivate(),
				doc.getDocumentElement());

		// We assemble the different parts of the Signature element
		// into an XMLSignature object
		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

		// We then invoke various factory methods to create the different
		// parts of the XMLSignature object as shown below. We create
		// a Reference object, passing to it the following
		Reference ref = fac.newReference("", fac.newDigestMethod(
				DigestMethod.SHA1, null), Collections.singletonList(fac
				.newTransform(Transform.ENVELOPED,
						(TransformParameterSpec) null)), null, null);

		// we create the SignedInfo object, which is the object that is actually
		// signed,
		// as shown below. When creating the SignedInfo, we pass as parameters
		SignedInfo si = null;
		
		if (keyAlgorithm.equals("DSA")) {
			si = fac
			.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
					(C14NMethodParameterSpec) null), fac
					.newSignatureMethod(SignatureMethod.DSA_SHA1, null),
					Collections.singletonList(ref));
		} else if (keyAlgorithm.equals("DH")) {
			si = fac
			.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
					(C14NMethodParameterSpec) null), fac
					.newSignatureMethod(SignatureMethod.HMAC_SHA1, null),
					Collections.singletonList(ref));
		} else if (keyAlgorithm.equals("RSA")) {
			si = fac
			.newSignedInfo(fac.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS,
					(C14NMethodParameterSpec) null), fac
					.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
					Collections.singletonList(ref));
		} else {
			throw new NoSuchAlgorithmException();
		}

		// which contains information that enables the recipient to find
		// the key needed to validate the signature
		KeyInfoFactory kif = fac.getKeyInfoFactory();

		// We then use the KeyInfoFactory to create the KeyValue object
		// and add it to a KeyInfo object
		KeyValue kv = kif.newKeyValue(kp.getPublic());
		KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kv));

		// we create the XMLSignature object, passing as parameters
		// the SignedInfo and KeyInfo objects that we created earlier
		XMLSignature signature = fac.newXMLSignature(si, ki);

		// Now we are ready to generate the signature
		signature.sign(dsc);

		// You can use the following code to print the resulting
		// signed document to a file or standard output
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(doc);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.transform(source, result);

		return result.getWriter().toString();
	}
	
	/**
	 * Signed XML for signature
	 * 
	 * @param keyStoreFilePath
	 * @param keyStorePassword
	 * @param aliasName
	 * @param sourceXML
	 * @param defaultPrefix
	 * @return XML included signature element.
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String digitalSign(String keyStoreFilePath, 
					   String keyStorePassword,
					   String aliasName,
					   String keyPassword,
					   String sourceXML,
					   String defaultPrefix) throws Exception {

		// We assemble the different parts of the Signature element
		// into an XMLSignature object
		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
		
		// We then invoke various factory methods to create the different
		// parts of the XMLSignature object as shown below. We create
		// a Reference object, passing to it the following
		Reference ref = fac
			.newReference("", 
						  fac.newDigestMethod(DigestMethod.SHA1, null),
						  Collections.singletonList(fac
								  		.newTransform(Transform.ENVELOPED,
												    (TransformParameterSpec) null)),
						  null, 
						  null);

		// we create the SignedInfo object, which is the object that is actually
		// signed,
		// as shown below. When creating the SignedInfo, we pass as parameters
		SignedInfo si = fac.newSignedInfo
						 (fac.newCanonicalizationMethod
						  (CanonicalizationMethod.INCLUSIVE,
						   (C14NMethodParameterSpec) null),
						    fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
						     Collections.singletonList(ref));
		
		// Load the KeyStore and get the signing key and certificate.
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream( keyStoreFilePath ), keyStorePassword.toCharArray());
		KeyStore.PrivateKeyEntry keyEntry=null;
		if (keyPassword==null || keyPassword.equals("")) {
			keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry
		        ( aliasName, null);
		}
		else {
			keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry
		        ( aliasName, new KeyStore.PasswordProtection(keyPassword.toCharArray()));
		}
		X509Certificate cert = (X509Certificate) keyEntry.getCertificate();
		
		
		// Create the KeyInfo containing the X509Data.
		KeyInfoFactory kif = fac.getKeyInfoFactory();

		List x509Content = new ArrayList();
		
		X509IssuerSerial issue = kif
			.newX509IssuerSerial(cert.getIssuerX500Principal().getName(), 
								cert.getSerialNumber());

		x509Content.add(issue);
		x509Content.add(cert.getSubjectDN().getName());
		x509Content.add(cert);
		X509Data xd = kif.newX509Data(x509Content);
		
		KeyValue keyValue = kif.newKeyValue(keyEntry.getCertificate().getPublicKey());
		
		List keyInfoContent = new ArrayList();
		keyInfoContent.add(keyValue);
		keyInfoContent.add(xd);
		//KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
		KeyInfo ki = kif.newKeyInfo(keyInfoContent);
		
		// Instantiate the document to be signed.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(sourceXML));
		Document doc = dbf.newDocumentBuilder().parse(is);
		
		// Create a DOMSignContext and specify the RSA PrivateKey and
		// location of the resulting XMLSignature's parent element.
		DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getDocumentElement());
		
		if ( defaultPrefix != null && !defaultPrefix.isEmpty() )
			dsc.setDefaultNamespacePrefix(defaultPrefix);

		// Create the XMLSignature, but don't sign it yet.
		XMLSignature signature = fac.newXMLSignature(si, ki);

		// Marshal, generate, and sign the enveloped signature.
		signature.sign(dsc);
		
		// You can use the following code to print the resulting
		// signed document to a file or standard output
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(doc);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.transform(source, result);

		return result.getWriter().toString();
	}
	
}