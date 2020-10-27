package com.phs;

public class Vigenère implements CipherInterface{
	
	/**
	 * The lexicographical shift (addition) that will be used to encrypt a String
	 */
	private String key;
	
	/**
	 * Default Constructor that sets the key to 1
	 */
	public Vigenère() {
		key = "MANGO";
	}
	
	/**
	 * A Constructor which takes the user's choice of key
	 * @param userKey
	 */
	public Vigenère(String userKey) {
		key=userKey.toUpperCase();
		
	}

	@Override
	public String encode(String plainText) {
		
		plainText = plainText.toUpperCase();
		
		// Check for plaintext and key size
		int plainTextSize = plainText.length(); // 14
		int keySize = key.length(); // 4
		int rep = plainTextSize/keySize; //3
		
		String newKey = "";
		for (int k=0; k<rep; k++)
		{
			newKey = newKey + key;
		}
		
		int rem = plainTextSize%keySize;
		
		newKey = newKey + key.substring(0,rem);
		key = newKey;

		
		
		
		
		//initializes encodedText to a blank String so encoded characters
				//can be concatenated to it
				String encodedText = "";
				
				//This for loop extracts every character of the String
				for(int i = 0; i < plainText.length(); i++){
					
					//This is the character that is being currently encoded
					char c = plainText.charAt(i);
					
					if(c >= 'A' && c <= 'Z'){
						char d = key.charAt(i);
						
						int addLexPlainText = (int)c - 65;
						int addLexKey = (int)d - 64;
						
						
						//This operation adds the key value to the lexicographic value of the character to 
						//get the encoded character
			           
			          //Concatenates the encoded character to the encodedText
						int lex = addLexPlainText + addLexKey + 64;
						 if((char)lex > 'Z'){
				                lex = (char)((char)lex - 'Z' + 'A' - 1);
				            }
			            encodedText += (char)lex;
					}
					else {
						encodedText+= c;
					}
				}
				return encodedText;
	}

	@Override
	public String decode(String cipherText) {
		cipherText = cipherText.toUpperCase();
		String encodedText = "";
		
		//This for loop extracts every character of the String
		for(int i = 0; i < cipherText.length(); i++){
			
			//This is the character that is being currently encoded
			char c = cipherText.charAt(i);
			if(c >= 'A' && c <= 'Z'){
			char d = key.charAt(i);
			
			int addLexPlainText = (int)c - 64;
			int addLexKey = (int)d - 64;
			
			//This operation adds the key value to the lexicographic value of the character to 
			//get the encoded character
           
          //Concatenates the encoded character to the encodedText
			int lex = addLexPlainText - addLexKey + 65;
			if ( addLexPlainText < addLexKey)
				lex = lex + 26;
			
			if((char)lex > 'Z'){
	                lex = (char)((char)lex + 'Z' - 'A' + 1);
	            }
            encodedText += (char)lex;
			}
			else {
				encodedText+= c;
			}
		}
		return encodedText;
	}

}
