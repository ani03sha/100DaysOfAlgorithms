package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _004Count1Bits {
	// This array will store the number of '1' bits in the binary representation of
	// the
	// numbers from 0 to 15 - 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
	private int[] numberOfBits = new int[] { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };

	/**
	 * This method counts the number of 1 bits in the binary representation of the
	 * passed number
	 */
	public int countBits(int n) {
		// Base condition - n is 0 thus, there are no 1 bits
		if (n == 0) {
			return numberOfBits[0];
		}

		// The nibble - group of 4 bits
		int nibble = 0;

		// Divide the number into nibbles - group of 4 bits from right to left
		nibble = n & 0xf;

		// Return the number of 1 bits in the nibble and recurse on the remaining number
		// shifted by 4
		return numberOfBits[nibble] + countBits(n >> 4);
	}
}
