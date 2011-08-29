package com.itap.ebms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class MessageDigestSHA1 {

	/**
	 * Convert byte array data to Hex string 
	 * @param data
	 * @return Hex string represent byte[] data.
	 */
	private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    } 
	
	/**
	 * Convert byte array data to string
	 * @param bytes
	 * @return String represent byte[] data.
	 */
	private static String bytes2String(byte[] bytes) {
        StringBuilder string = new StringBuilder();
        for (byte b: bytes) {
                String hexString = Integer.toHexString(0x00FF & b);
                string.append(hexString.length() == 1 ? "0" + hexString : hexString);
        }
        return string.toString();
	}
 
	/**
	 * Digest text by SHA-1 Algorithm
	 * @param text
	 * @return SHA-1 encoding string represent text.
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
    public static String getHex(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
    	MessageDigest md = MessageDigest.getInstance("SHA-1");
    	byte[] sha1hash = new byte[40];
    	md.update(text.getBytes("iso-8859-1"), 0, text.length());
    	sha1hash = md.digest();
    	return convertToHex(sha1hash);
    } 
    
    /**
	 * Digest text by SHA-1 Algorithm
	 * @param text
	 * @return SHA-1 encoding string represent text.
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
    public static String getString(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
    	MessageDigest md = MessageDigest.getInstance("SHA-1");
    	byte[] sha1hash = new byte[40];
    	md.update(text.getBytes("iso-8859-1"), 0, text.length());
    	sha1hash = md.digest();
    	return bytes2String(sha1hash);
    } 
    
    
    /**
     * Get X509 Certificate from key
     * @param keyStore
     * @param storePasswd
     * @return String 
     * @throws KeyStoreException
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws NoSuchAlgorithmException 
     * @throws javax.security.cert.CertificateException 
     * @throws UnrecoverableEntryException 
     */
    public static String getCertificate(String keyStorePath, 
    									String storePasswd, 
    									String aliasName) 
    	throws KeyStoreException, 
    		NoSuchAlgorithmException, 
    		CertificateException, 
    		FileNotFoundException, 
    		IOException, 
    		UnrecoverableEntryException {
    	//StreamSource ss = new StreamSource( new StringReader( x509Cert ) );
    	KeyStore ks = KeyStore.getInstance("JKS");
    	ks.load(new FileInputStream(keyStorePath), storePasswd.toCharArray());
    	KeyStore.PrivateKeyEntry keyEntry =
    	    (KeyStore.PrivateKeyEntry) ks.getEntry(aliasName, new KeyStore.PasswordProtection(storePasswd.toCharArray()));
    	X509Certificate cert = (X509Certificate) keyEntry.getCertificate();
    	return bytes2String(cert.getPublicKey().getEncoded());
    }
    
    /**
     * Get Signature from key
     * @param keyStore
     * @param storePasswd
     * @return String 
     * @throws KeyStoreException
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws NoSuchAlgorithmException 
     * @throws javax.security.cert.CertificateException 
     * @throws UnrecoverableEntryException 
     */
    public static String getSignature(String keyStorePath, 
    									String storePasswd, 
    									String aliasName) 
    	throws KeyStoreException, 
    		NoSuchAlgorithmException, 
    		CertificateException, 
    		FileNotFoundException, 
    		IOException, 
    		UnrecoverableEntryException {
    	//StreamSource ss = new StreamSource( new StringReader( x509Cert ) );
    	KeyStore ks = KeyStore.getInstance("JKS");
    	ks.load(new FileInputStream(keyStorePath), storePasswd.toCharArray());
    	KeyStore.PrivateKeyEntry keyEntry =
    	    (KeyStore.PrivateKeyEntry) ks.getEntry(aliasName, new KeyStore.PasswordProtection(storePasswd.toCharArray()));
    	X509Certificate cert = (X509Certificate) keyEntry.getCertificate();
    	return bytes2String(cert.getSignature());
    }
    
}
