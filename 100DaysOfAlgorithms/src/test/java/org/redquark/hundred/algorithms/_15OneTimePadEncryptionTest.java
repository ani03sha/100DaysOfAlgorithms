package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _15OneTimePadEncryptionTest {

	private _15OneTimePadEncryption otp;

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._15OneTimePadEncryption#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncryptAndDecrypt() {
		String message = "REPEAT ATTACK TONIGHT";
		otp = new _15OneTimePadEncryption(message);
		String encrypted = otp.encrypt(message);
		String decrypted = otp.decrypt(encrypted);
		assertEquals(message, decrypted);

		message = "we will transfer ammunition tomorrow";
		otp = new _15OneTimePadEncryption(message);
		encrypted = otp.encrypt(message);
		decrypted = otp.decrypt(encrypted);
		assertEquals(message, decrypted);
	}
}
