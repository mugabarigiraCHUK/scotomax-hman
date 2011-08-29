package com.itap.ebms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
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
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.crypto.dsig.spec.XPathFilterParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SignFileExample {

	private static final String KEY_STORE_TYPE = "JKS";
    private static final String KEY_STORE_NAME = "mykeystore";
    private static final String KEY_STORE_PASS = "keystore-pass";
    private static final String PRIVATE_KEY_PASS = "privatekey-pass";
    private static final String KEY_ALIAS = "myprivatekey";

    private static final String PATH = "/PatientRecord/Account";
    private static final String ID = "acct";

    private static enum SignatureType {
	SIGN_BY_ID,
	SIGN_BY_PATH,
	SIGN_WHOLE_DOCUMENT
    };

    public static void main(String[] args) throws Exception {
	if (args.length < 2) {
	    usage();
	    return;
	}

	String inputFile = args[0];
	String outputFile = args[1];
	
	SignatureType sigType = SignatureType.SIGN_WHOLE_DOCUMENT;
	if (args.length >= 3) {
	    if ("id".equals(args[2])) {
		sigType = SignatureType.SIGN_BY_ID;
	    }
	    else if ("path".equals(args[2])) {
		sigType = SignatureType.SIGN_BY_PATH;
	    }
	}

	// Instantiate the document to be signed
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	dbFactory.setNamespaceAware(true);
	Document doc = dbFactory.newDocumentBuilder()
		       				.parse(new FileInputStream(inputFile));

	// prepare signature factory
    String providerName = System.getProperty("jsr105Provider", 
				  "org.jcp.xml.dsig.internal.dom.XMLDSigRI"
			      );

	final XMLSignatureFactory sigFactory = XMLSignatureFactory.getInstance(
					    "DOM",
					    (Provider) Class.forName(providerName).newInstance()
					 );

	Node nodeToSign = null;
	Node sigParent = null;
	String referenceURI = null;
	XPathExpression expr = null; 
	NodeList nodes;
	List transforms = null;

	XPathFactory factory = XPathFactory.newInstance();
	XPath xpath = factory.newXPath();
	switch (sigType) {
	    case SIGN_BY_ID:
			expr = xpath.compile(
			    String.format("//*[@id='%s']", ID)
			);
			nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			if (nodes.getLength() == 0) {
			    System.out.println("Can't find node with id: " + ID);
			    return;
			}
	
			nodeToSign = nodes.item(0);
			sigParent = nodeToSign.getParentNode();
			referenceURI = "#" + ID;
			/* 
	                 * This is not needed since the signature is alongside the signed element, not enclosed in it.
			transforms = Collections.singletonList(
				    	sigFactory.newTransform(
					    Transform.ENVELOPED, 
					    (TransformParameterSpec) null
					)
				    );
			    */
			break;
	    case SIGN_BY_PATH:
			// Find the node to be signed by PATH
			expr = xpath.compile(PATH);
			nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			if (nodes.getLength() < 1) {
			    System.out.println("Invalid document, can't find node by PATH: " + PATH);
			    return;
			}
	
			nodeToSign = nodes.item(0);
			sigParent = nodeToSign.getParentNode();
			referenceURI = ""; // Empty string means whole document
			transforms = new ArrayList<Transform>() {{
			    add(sigFactory.newTransform(
				    Transform.XPATH,
				    new XPathFilterParameterSpec(PATH)
				)
			    );
			    add(sigFactory.newTransform(
				    Transform.ENVELOPED,
				    (TransformParameterSpec) null
				)
			    );
			}};
	
			break;
	    default:
		sigParent = doc.getDocumentElement();
		referenceURI = ""; // Empty string means whole document
		transforms = Collections.singletonList(
			    	sigFactory.newTransform(
				    Transform.ENVELOPED, 
				    (TransformParameterSpec) null
				)
			    );
		break;
	}

        // Retrieve signing key
	KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
	keyStore.load(
	    new FileInputStream(KEY_STORE_NAME),  
	    KEY_STORE_PASS.toCharArray()
	);

	PrivateKey privateKey = (PrivateKey) keyStore.getKey(
				    KEY_ALIAS,
				    PRIVATE_KEY_PASS.toCharArray()
				);

	X509Certificate cert = (X509Certificate) keyStore.getCertificate(KEY_ALIAS);
	PublicKey publicKey = cert.getPublicKey();

        // Create a Reference to the enveloped document
	Reference ref = sigFactory.newReference(
			    referenceURI,
			    sigFactory.newDigestMethod(DigestMethod.SHA1, null),
			    transforms,
			    null, 
			    null
			);

	// Create the SignedInfo
	SignedInfo signedInfo = sigFactory.newSignedInfo(
				    sigFactory.newCanonicalizationMethod(
					CanonicalizationMethod.INCLUSIVE_WITH_COMMENTS, 
					(C14NMethodParameterSpec) null
				    ), 
				    sigFactory.newSignatureMethod(
					SignatureMethod.RSA_SHA1, 
					null
				    ),
				    Collections.singletonList(ref)
				);

        // Create a KeyValue containing the RSA PublicKey 
	KeyInfoFactory keyInfoFactory = sigFactory.getKeyInfoFactory();
        KeyValue keyValue = keyInfoFactory.newKeyValue(publicKey);

	// Create a KeyInfo and add the KeyValue to it
        KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(keyValue));

        // Create a DOMSignContext and specify the RSA PrivateKey and
        // location of the resulting XMLSignature's parent element
	DOMSignContext dsc = new DOMSignContext(
				 privateKey, 
				 sigParent
			     );

	// Create the XMLSignature (but don't sign it yet)
	XMLSignature signature = sigFactory.newXMLSignature(signedInfo, keyInfo);

        // Marshal, generate (and sign) the enveloped signature
        signature.sign(dsc);

	// output the resulting document
	OutputStream os = new FileOutputStream(args[1]);
	Transformer trans = TransformerFactory.newInstance()
					      .newTransformer();
	trans.transform(new DOMSource(doc), new StreamResult(os));
    }

    private static void usage() {
	System.out.println("Usage: java SignFile <inputFile> <outputFile> [id|path|whole]");
    }
}
