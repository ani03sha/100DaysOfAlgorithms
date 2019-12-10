package org.redquark.hundred.algorithms;

/**
 * The extended Euclidean algorithm is an extension to the Euclidean algorithm.
 * Besides finding the greatest common divisor of integers a and b, as the
 * Euclidean algorithm does, it also finds integers x and y (one of which is
 * typically negative) that satisfy Bézout’s identity ax + by = gcd(a, b).
 * 
 * @author Anirudh Sharma
 *
 */
public class _013ExtendedEuclideanAlgorithm {

	/**
	 * This method finds the GCD that will satisfy the linear Diophantine equation
	 * i.e. ax + by = GCD(a, b)
	 */
	public int gcd(int a, int b, int x, int y) {

		// Base case - if a is zero
		if (a == 0) {
			x = 0;
			y = 1;
			return b;
		}

		// To store the results of recursive calls
		int x1 = 1;
		int y1 = 1;

		// Find the GCD recursively
		int gcd = gcd(b % a, a, x1, y1);

		// Update x1 and y1 based on the results of recursive calls
		x = y1 - (b / a) * x1;
		y = x1;

		return gcd;
	}

}
