package com.phs;

/**
 *This class encodes and decodes any string based on the famous caesar cipher
 * @author Varun Khilnani
 *
 */
public class Caesar implements CipherInterface{
	
	/**
	 * The lexicographical shift (addition) that will be used to encrypt a String
	 */
	private int key;
	
	/**
	 * Default Constructor that sets the key to 1
	 */
	public Caesar() {
		key = 1;
	}
	
	/**
	 * A Constructor which takes the user's choice of key
	 * @param userKey
	 */
	public Caesar(int userKey) {
		key=userKey;
	}

	/**
	 *This method takes a plainText as a String and uses the Caesar Cipher to encode it (using the key set in the Constructor)
	 *This method then returns the encoded message
	 */
	@Override
	public String encode(String plainText) {
		
		//initializes encodedText to a blank String so encoded characters
		//can be concatenated to it
		String encodedText = "";
		
		//This for loop extracts every character of the String
		for(int i = 0; i < plainText.length(); i++){
			
			//This is the character that is being currently encoded
			char c = plainText.charAt(i);
			
			//This if statement checks if the character is lower case
			if(c >= 'a' && c <= 'z'){
				
				//This operation adds the key value to the lexicographic value of the character to 
				//get the encoded character
	            c = (char)(c + key);
	            
	            //If a lowercase letter turns into another non-lowercase character through the shift
	            //the if statement will cycle the lexicographic value so the character
	            //will only remain lowercase
	            if(c > 'z'){
	                c = (char)(c - 'z' + 'a' - 1);
	            }
	            
	            //Concatenates the encoded character to the encodedText
	            encodedText += c;
	        }
			//This if statement checks if the character is upper case
	        else if(c >= 'A' && c <= 'Z'){
	        	
	        	//This operation adds the key value to the lexicographic value of the character to 
				//get the encoded character
	            c = (char)(c + key);
	            
	            //If an uppercase letter turns into another non-uppercase character through the shift
	            //the if statement will cycle the lexicographic value so the character
	            //will only remain uppercase
	            if(c > 'Z'){
	                c = (char)(c - 'Z' + 'A' - 1);
	            }
	            
	          //Concatenates the encoded character to the encodedText
	            encodedText += c;
	        }
			//This else statement checks if the character is not a letter
	        else {
	        	
	        	//Concatenates the encoded character to the encodedText
	        	encodedText += c;
	        }
		}
		
		
		return encodedText;
	}
	

	/**
	 *This method takes a cipherText as a String and uses the Caesar Cipher to decode it (using the key set in the Constructor)
	 *This method then returns the decoded message
	 */
	@Override
	public String decode(String cipherText) {
		
		//initializes decodedText to a blank String so decoded characters
		//can be concatenated to it
		String decodedText = "";
		
		//This for loop extracts every character of the String
		for(int i = 0; i < cipherText.length(); ++i){
			
			//This is the character that is being currently decoded
			char ch = cipherText.charAt(i);
			
			//This if statement checks if the character is lower case
			if(ch >= 'a' && ch <= 'z'){
				
				//This operation subtracts the key value to the lexicographic value of the character to 
				//get the decoded character
	            ch = (char)(ch - key);
	            
	            //If a lowercase letter turns into another non-lowercase character through the shift
	            //the if statement will cycle the lexicographic value so the character
	            //will only remain lowercase
	            if(ch < 'a'){
	                ch = (char)(ch + 'z' - 'a' + 1);
	            }
	            
	          //Concatenates the decoded character to the encodedText
	            decodedText += ch;
	        }
			
			//This if statement checks if the character is upper case
	        else if(ch >= 'A' && ch <= 'Z'){
	        	//This operation subtracts the key value to the lexicographic value of the character to 
				//get the decoded character
	            ch = (char)(ch - key);
	            
	            //If an uppercase letter turns into another non-uppercase character through the shift
	            //the if statement will cycle the lexicographic value so the character
	            //will only remain uppercase
	            if(ch < 'A'){
	                ch = (char)(ch + 'Z' - 'A' + 1);
	            }
	            
	          //Concatenates the decoded character to the encodedText
	            decodedText += ch;
	        }
			
			//This else statement checks if the character is not a letter
	        else {
	        	
	        	//Concatenates the decoded character to the encodedText
	        	decodedText += ch;
	        }
		}
		
		
		return decodedText;
	}
	}


	


