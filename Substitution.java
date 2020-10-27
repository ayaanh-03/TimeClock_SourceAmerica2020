package com.phs;

/**
 *This class encodes and decodes any string based on the famous substitution cipher
 * @author Varun Khilnani
 *
 */
public class Substitution implements CipherInterface{
	
	/**
	 * The 26 letter key the user will input to match up with the alphaKey
	 */
	private String key;
	
	private final String alphaKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * Default Constructor that sets the key to QWERTYUIOPASDFGHJKLZXCVBNM
	 */
	public Substitution() {
		key = "QWERTYUIOPASDFGHJKLZXCVBNM";
	}
	
	/**
	 * A Constructor which takes the user's choice of key
	 * @param userKey
	 */
	public Substitution(String userKey) {
		// Has to be 26 letters and unique  
		key=userKey.toUpperCase();
	}

	/**
	 *This method takes a plainText as a String and uses the Caesar Cipher to encode it (using the key set in the Constructor)
	 *This method then returns the encoded message
	 */
	@Override
	public String encode(String plainText) {
		
		plainText = plainText.toUpperCase();
		
		//initializes encodedText to a blank String so encoded characters
		//can be concatenated to it
		String encodedText = "";
		
		//This for loop extracts every character of the String
		for(int i = 0; i < plainText.length(); i++){
			
			//This is the character that is being currently encoded
			char c = plainText.charAt(i);
			if(c >= 'A' && c <= 'Z'){
			
			int position = alphaKey.indexOf(c);
			char subsi = key.charAt(position);
			encodedText += subsi;
			}
			
			else 
				encodedText += c;
			
		}
		
		
		return encodedText;
	}
	

	/**
	 *This method takes a cipherText as a String and uses the Caesar Cipher to decode it (using the key set in the Constructor)
	 *This method then returns the decoded message
	 */
	@Override
	public String decode(String cipherText) {
		cipherText = cipherText.toUpperCase();
		//initializes decodedText to a blank String so decoded characters
		//can be concatenated to it
		String decodedText = "";
		
		//This for loop extracts every character of the String
		for(int i = 0; i < cipherText.length(); ++i){
			
			//This is the character that is being currently decoded
			char c = cipherText.charAt(i);
			if(c >= 'A' && c <= 'Z'){
			int position = key.indexOf(c);
			char subsi = alphaKey.charAt(position);
			decodedText += subsi;
			}
			
			else {
				decodedText+= c;
			}
		}
		
		
		return decodedText;
	}
	}


	

