package com.phs;

public class CipherApp {
	public static void main(String[] args) {
		
		Caesar c = new Caesar();
		String message = "cipher test";
		
		String encodedMessage = c.encode(message);
		System.out.println(encodedMessage);
		System.out.println(c.decode(encodedMessage));
		
		
		Substitution s = new Substitution( "QWERTYUIOPASDFGHJKLZXCVBNM");
		encodedMessage = s.encode(message);
		System.out.println(encodedMessage);
		System.out.println(s.decode(encodedMessage));
		
		Vigenère v = new Vigenère();
		encodedMessage = v.encode(message);
		System.out.println(encodedMessage);
		System.out.println(v.decode(encodedMessage));
		
		
	}

}
