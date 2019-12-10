package org.redquark.hundred.algorithms;

import java.util.Random;

/**
 * @author Anirudh Sharma
 *
 */
public class _015OneTimePadEncryption {

	// Reference Strings
	private final String alphaUpperCase;
	private final String alphaLowerCase;

	// Key for one particular instance of OTP
	private String key;

	public _015OneTimePadEncryption(String plainText) {
		this.key = getKey(plainText.length());
		alphaUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		alphaLowerCase = "abcdefghijklmnopqrstuvwxyz";
	}

	/**
	 * This method encrypts the plain text string into an encrypted string
	 */
	public String encrypt(String plainText) {

		// Getting the length of the plain text
		int length = plainText.length();

		// Encrypted string
		StringBuilder encrypted = new StringBuilder();

		// Loop through the length of the plain text so that each character of the
		// message is encoded
		for (int i = 0; i < length; i++) {
			// Current character of the message
			char plainTextCharacter = plainText.charAt(i);
			char cipherTextCharacter = key.charAt(i);

			// Check if the plain text character is uppercase
			if (Character.isUpperCase(plainTextCharacter)) {
				// Get the index of the character
				int plainTextCharacterIndex = alphaUpperCase.indexOf(plainTextCharacter);
				// Get the index of the cipher's character
				int cipherTextCharacterIndex = alphaUpperCase.indexOf(Character.toUpperCase(cipherTextCharacter));

				// Get the modulus index of the encoded text
				int encryptedCharacterIndex = (plainTextCharacterIndex + cipherTextCharacterIndex) % 26;

				// Add the encoded character to the existing string
				encrypted.append(alphaUpperCase.charAt(encryptedCharacterIndex));
			}
			// Check if the plain text character is lowercase
			else if (Character.isLowerCase(plainTextCharacter)) {
				// Get the index of the character
				int plainTextCharacterIndex = alphaLowerCase.indexOf(plainTextCharacter);
				// Get the index of the cipher's character
				int cipherTextCharacterIndex = alphaLowerCase.indexOf(Character.toLowerCase(cipherTextCharacter));

				// Get the modulus index of the encoded text
				int encryptedCharacterIndex = (plainTextCharacterIndex + cipherTextCharacterIndex) % 26;

				// Add the encoded character to the existing string
				encrypted.append(alphaLowerCase.charAt(encryptedCharacterIndex));
			}
			// Else we just append the current character
			else {
				encrypted.append(plainTextCharacter);
			}
		}
		return encrypted.toString();
	}

	/**
	 * This method returns the decrypted string using the same key used for the
	 * encryption
	 */
	public String decrypt(String encrypted) {

		// Getting the length of the encrypted string
		int length = encrypted.length();

		// Decrypted string
		StringBuilder decrypted = new StringBuilder();

		// Loop through the length of the plain text so that each character of the
		// message is encoded
		for (int i = 0; i < length; i++) {
			// Current character of the message
			char plainTextCharacter = encrypted.charAt(i);
			char cipherTextCharacter = key.charAt(i);

			// Check if the plain text character is uppercase
			if (Character.isUpperCase(plainTextCharacter)) {
				// Get the index of the character
				int plainTextCharacterIndex = alphaUpperCase.indexOf(plainTextCharacter);
				// Get the index of the cipher's character
				int cipherTextCharacterIndex = alphaUpperCase.indexOf(Character.toUpperCase(cipherTextCharacter));

				// Get the modulus index of the encoded text
				int decryptedCharacterIndex = (plainTextCharacterIndex - cipherTextCharacterIndex) % 26;
				decryptedCharacterIndex = (decryptedCharacterIndex < 0) ? decryptedCharacterIndex + 26
						: decryptedCharacterIndex;

				// Add the encoded character to the existing string
				decrypted.append(alphaUpperCase.charAt(decryptedCharacterIndex));
			}
			// Check if the plain text character is lowercase
			else if (Character.isLowerCase(plainTextCharacter)) {
				// Get the index of the character
				int plainTextCharacterIndex = alphaLowerCase.indexOf(plainTextCharacter);
				// Get the index of the cipher's character
				int cipherTextCharacterIndex = alphaLowerCase.indexOf(Character.toLowerCase(cipherTextCharacter));

				// Get the modulus index of the encoded text
				int decryptedCharacterIndex = (plainTextCharacterIndex - cipherTextCharacterIndex) % 26;
				decryptedCharacterIndex = (decryptedCharacterIndex < 0) ? decryptedCharacterIndex + 26
						: decryptedCharacterIndex;

				// Add the encoded character to the existing string
				decrypted.append(alphaLowerCase.charAt(decryptedCharacterIndex));
			}
			// Else we just append the current character
			else {
				decrypted.append(plainTextCharacter);
			}
		}
		return decrypted.toString();
	}

	/**
	 * This method returns the random key for a plain text
	 */
	private String getKey(int length) {

		// Instance of Random
		Random r = new Random();

		// Randomly generated key
		StringBuilder key = new StringBuilder();

		// Loop through the length of the plain text - it is needed as we will be
		// creating the key of length equals to the length of the plain text
		for (int i = 0; i < length; i++) {
			key.append((char) (r.nextInt(26) + 'A'));
		}

		return key.toString();
	}
}
