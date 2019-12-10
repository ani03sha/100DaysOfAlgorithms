package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _011McCarthy91 {

	/**
	 * When you plug a natural number N in, McCarthy91 flushes N-10 out, if N is
	 * larger than 100. Otherwise it always returns 91.
	 * 
	 * It is a test case for formal verification in computer science
	 */
	public int mccarthy(int n) {
		// Check if the number is greater than 100
		if (n > 100) {
			return n - 10;
		}
		// Else call the function recursively until the output is less than 100
		return mccarthy(mccarthy(n + 11));
	}
}
