package fr.univ.lyon1.m1if.m1if10Grp13.classes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class PasswordEncryption {

	public PasswordEncryption() {
		
	}
	
	public static String encrypt(String password) {
		String encryptedPassword = null;


		try {
			// Creation de la signature de l'objet
		    Signature sign = Signature.getInstance("SHA256withRSA");

		    // Creation d'un objet qui génère les pairs de clé
		    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		      
		    // Initialisation de l'objet
		    keyPairGen.initialize(2048);
		    
		    // Generation de la pair de clés
		    KeyPair pair = keyPairGen.generateKeyPair();
		    
		    // Recupération de la clé public pour le codage
		    PublicKey publicKey = pair.getPublic();  

		    // Creation d'une instance de cipher
		    Cipher cipher;
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			
		    // Initialization de cipher
		    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			  
		    // Conversion du password en Byte format et l'ajouter à l'instance cipher
		    byte[] bytePassword = password.getBytes();	  
		    cipher.update(bytePassword);
			  
		    // Encryption des données
		    byte[] cipherPassword = cipher.doFinal();
		    
		    // Retourner le mot de passe encrypté sous forme de string
		    encryptedPassword = new String(cipherPassword, "UTF8");
		    return encryptedPassword;
		    
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	      
	      return encryptedPassword;

	}
	
	public static String decrypt(String encryptedPassword) {
		String password = null;
		
		try {
			// Creation de la signature de l'objet
		    Signature sign = Signature.getInstance("SHA256withRSA");

		    // Creation d'un objet qui génère les pairs de clé
		    KeyPairGenerator keyPairGen;
			keyPairGen = KeyPairGenerator.getInstance("RSA");
			
		    // Initialisation de l'objet
		    keyPairGen.initialize(2048);
		    
		    // Generation de la pair de clés
		    KeyPair pair = keyPairGen.generateKeyPair();
		    
		    // Creation d'une instance de cipher
		    Cipher cipher;
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

		    // Initialization du cipher avec la clé privé pour le decryptage
		    cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
		    
		    // Conversion du password en Byte format et l'ajouter à l'instance cipher
		    byte[] bytePassword = encryptedPassword.getBytes();	  
		    cipher.update(bytePassword);
		      
		    //Decryptage du mot de passe et recupération d'un String
		    byte[] decipheredText = cipher.doFinal(bytePassword);
		    password = new String(decipheredText);
		    
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
	      
	      
	      return password;
	}

}
