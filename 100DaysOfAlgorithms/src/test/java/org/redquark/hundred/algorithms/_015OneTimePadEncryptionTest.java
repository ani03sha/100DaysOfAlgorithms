package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _015OneTimePadEncryptionTest {

	private _015OneTimePadEncryption otp;

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._015OneTimePadEncryption#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncryptAndDecrypt() {
		String message = "REPEAT ATTACK TONIGHT";
		otp = new _015OneTimePadEncryption(message);
		String encrypted = otp.encrypt(message);
		String decrypted = otp.decrypt(encrypted);
		assertEquals(message, decrypted);

		message = "we will transfer ammunition tomorrow";
		otp = new _015OneTimePadEncryption(message);
		encrypted = otp.encrypt(message);
		decrypted = otp.decrypt(encrypted);
		assertEquals(message, decrypted);
	}
}
