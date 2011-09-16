package com.itap.ebms.sign;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 
 * @author scotomax
 * 
 * Adds a specified certificate chain and associated RSA private key
 * to a Java keystore.
 * 
 * Usage: java KeyStoreImport KEYSTORE CERTS KEY ALIAS
 * 
 *            KEYSTORE is the name of the file containing the Java keystore
 *            CERTS is the name of a file containing a chain of concatenated
 *                    DER-encoded X.509 certificates
 *            KEY is the name of a file containing a DER-encoded PKCS#8 RSA
 *                    private key
 *            ALIAS is the alias for the private key entry in the keystore
 * 
 * Â©Neal Groothuis
 * 2006-08-08
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */
public class KeyTools {
	
	/**
	 * Generate a 1024-bit Digital Signature Algorithm (DSA) key pair
     *  generateKeys("DSA", 1024);
	 *
     * Generate a 576-bit DH key pair
     *   generateKeys("DH", 576);
	 *
     * Generate a 1024-bit RSA key pair
     *   generateKeys("RSA", 1024);
	 * 
	 * PrivateKey Format : PKCS#8
	 * PublicKey Format : X.509
	 * 
	 * @param keyAlgorithm
	 * @param numBits
	 * @return KeyPair
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	@SuppressWarnings("unused")
	public static KeyPair generateKeyPair(String keyAlgorithm, int numBits) 
		throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		// Get the public/private key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(keyAlgorithm);
        keyGen.initialize(numBits);
        KeyPair keyPair = keyGen.genKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey  publicKey  = keyPair.getPublic();

        
        // Get the bytes of the public and private keys
        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[] publicKeyBytes  = publicKey.getEncoded();

        // Get the formats of the encoded bytes
        String formatPrivate = privateKey.getFormat(); // PKCS#8
        String formatPublic  = publicKey.getFormat(); // X.509

        System.out.println("  Private Key Format : " + formatPrivate);
        System.out.println("  Public Key Format  : " + formatPublic);

        // The bytes can be converted back to public and private key objects
        KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateKey2 = keyFactory.generatePrivate(privateKeySpec);

        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey2 = keyFactory.generatePublic(publicKeySpec);
        
        // The original and new keys are the same
        //System.out.println("  Are both private keys equal? " + privateKey.equals(privateKey2));
        //System.out.println("  Are both public keys equal? " + publicKey.equals(publicKey2));
        
        return keyPair;
	}
	
	/**
	 * Save key-pair
	 * 
	 * @param privateKeyPath
	 * @param publicKeyPath
	 * @param keyPair 
	 * 		DSA : n-bit Digital Signature Algorithm (DSA) key pair
	 *  	DH : n-bit DH key pair
	 *  	RSA : n-bit RSA key pair
	 * @throws IOException
	 */
	public static void SaveKeyPair(String privateKeyPath,
								   String publicKeyPath,
								   KeyPair keyPair) 
			throws IOException {
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
 
		// Store Public Key.
		X509EncodedKeySpec x509EncodedKeySpec = 
			new X509EncodedKeySpec(publicKey.getEncoded());
		FileOutputStream fos = new FileOutputStream( publicKeyPath );
		fos.write(x509EncodedKeySpec.getEncoded());
		fos.close();
 
		// Store Private Key.
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = 
			new PKCS8EncodedKeySpec(privateKey.getEncoded());
		fos = new FileOutputStream( privateKeyPath );
		fos.write(pkcs8EncodedKeySpec.getEncoded());
		fos.close();
	}
 
	/**
	 * Load private/public key file
	 * for initial key-pair
	 * 
	 * @param privateKeyPath
	 * @param publicKeyPath
	 * @param algorithm 
	 * 		DSA : n-bit Digital Signature Algorithm (DSA) key pair
	 *  	DH : n-bit DH key pair
	 *  	RSA : n-bit RSA key pair
	 * @return KeyPair
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static KeyPair LoadKeyPair(String privateKeyPath,
			   						  String publicKeyPath,
			   						  String algorithm)
			throws IOException, NoSuchAlgorithmException,
			InvalidKeySpecException {
		// Read Public Key.
		File filePublicKey = new File( publicKeyPath );
		FileInputStream fis = new FileInputStream( publicKeyPath );
		byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
		fis.read(encodedPublicKey);
		fis.close();
 
		// Read Private Key.
		File filePrivateKey = new File( privateKeyPath );
		fis = new FileInputStream( privateKeyPath );
		byte[] encodedPrivateKey = new byte[(int) filePrivateKey.length()];
		fis.read(encodedPrivateKey);
		fis.close();
 
		// Generate KeyPair.
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
		PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
 
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
 
		return new KeyPair(publicKey, privateKey);
	}

	/**
	 * Load KeyStore for usage
	 * 
	 * @param keyStoreFileName
	 * @param keyStorePassword
	 * @return KeyStore
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static KeyStore loadKeyStore(String keyStoreFileName,
			String keyStorePassword) throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException {
		// Load the keystore
		KeyStore keyStore = KeyStore.getInstance("jks");
		FileInputStream keyStoreInputStream = new FileInputStream(keyStoreFileName);
		keyStore.load(keyStoreInputStream, keyStorePassword.toCharArray());
		keyStoreInputStream.close();

		return keyStore;
	}

	/**
	 * Load certificate chain for usage
	 * 
	 * @param certChainFileName
	 * @return Certificate[]
	 * @throws CertificateException
	 * @throws IOException
	 */
	public static java.security.cert.Certificate[] loadCertChain(
			String certChainFileName) throws CertificateException, IOException {
		// Load the certificate chain (in X.509 DER encoding).
		FileInputStream certStream = new FileInputStream(certChainFileName);
		CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
		// Required because Java is STUPID. You can't just cast the result
		// of toArray to Certificate[].
		java.security.cert.Certificate[] chain = {};
		chain = certFactory.generateCertificates(certStream).toArray(chain);
		certStream.close();

		return chain;
	}

	/**
	 * Load private key for usage
	 * 
	 * @param privateKeyFileName
	 * @return PrivateKey
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static PrivateKey loadPrivateKey(String privateKeyFileName) 
		throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		// Load the private key (in PKCS#8 DER encoding).
		File keyFile = new File(privateKeyFileName);
		byte[] encodedKey = new byte[(int) keyFile.length()];
		FileInputStream keyInputStream = new FileInputStream(keyFile);
		keyInputStream.read(encodedKey);
		keyInputStream.close();
		KeyFactory rSAKeyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = rSAKeyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
		
		return privateKey;
	}

	/**
	 * Key store import
	 * 
	 * @param keyStoreFileName
	 * @param certificateChainFileName
	 * @param privateKeyFileName
	 * @param entryAlias
	 * @param keyStorePassword
	 * @param privateKeyEntryPassword
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws InvalidKeySpecException
	 */
	public static void keyStoreImport(String keyStoreFileName,
							String certificateChainFileName,
							String privateKeyFileName,
							String entryAlias,
							String keyStorePassword,
							String privateKeyEntryPassword) 
			throws KeyStoreException, 
				   IOException, 
				   NoSuchAlgorithmException, 
				   CertificateException, 
				   InvalidKeySpecException {

		// Load the keystore
		KeyStore keyStore = KeyStore.getInstance("jks");
		FileInputStream keyStoreInputStream = new FileInputStream(keyStoreFileName);
		keyStore.load(keyStoreInputStream, keyStorePassword.toCharArray());
		keyStoreInputStream.close();

		// Load the certificate chain (in X.509 DER encoding).
		FileInputStream certificateStream = new FileInputStream(certificateChainFileName);
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		// Required because Java is STUPID. You can't just cast the result
		// of toArray to Certificate[].
		java.security.cert.Certificate[] chain = {};
		chain = certificateFactory.generateCertificates(certificateStream).toArray(chain);
		certificateStream.close();

		// Load the private key (in PKCS#8 DER encoding).
		File keyFile = new File(privateKeyFileName);
		byte[] encodedKey = new byte[(int) keyFile.length()];
		FileInputStream keyInputStream = new FileInputStream(keyFile);
		keyInputStream.read(encodedKey);
		keyInputStream.close();
		KeyFactory rSAKeyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = rSAKeyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));

		// Add the new entry
		keyStore.setEntry(entryAlias, 
						  new KeyStore.PrivateKeyEntry(privateKey, chain), 
						  new KeyStore.PasswordProtection(privateKeyEntryPassword.toCharArray()));

		// Write out the keystore
		FileOutputStream keyStoreOutputStream = new FileOutputStream(keyStoreFileName);
		keyStore.store(keyStoreOutputStream, keyStorePassword.toCharArray());
		keyStoreOutputStream.close();
	}
}