package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _10KaratsubaMultiplication {

	/**
	 * This method returns the result of x * y using Karatsuba Multiplication
	 * Algorithm
	 */
	public long multiply(long x, long y) {

		// If the number is small, directly multiply and return
		if (x < 10 || y < 10) {
			return x * y;
		}

		// Find the length of the longest number
		int maxBase = (int) Math.max(Math.log10(x), Math.log10(y)) + 1;
		// Find the rounded half of the maxBase
		int halfMax = Math.round(maxBase / 2);

		// Find individual values of a, b, c, d
		long a = x / (int) Math.pow(10, halfMax);
		long b = x % (int) Math.pow(10, halfMax);
		long c = y / (int) Math.pow(10, halfMax);
		long d = y % (int) Math.pow(10, halfMax);

		// Now we will calculate ac, bd and abcd
		long ac = multiply(a, c);
		long bd = multiply(b, d);
		long abcd = multiply(a + b, c + d);
		abcd = abcd - ac - bd;

		return (long) ((ac * Math.pow(10, (2 * halfMax))) + (abcd * Math.pow(10, halfMax)) + bd);
	}
}
