package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _007BinaryAddition {

	/**
	 * This method adds two binary numbers that are represented as Strings
	 */
	public String add(String a, String b) {

		// To store results
		StringBuilder result = new StringBuilder();

		// This will store the sum of digits
		int sum = 0;

		// Traverse both Strings from right to left
		int i = a.length() - 1, j = b.length() - 1;
		while (i >= 0 || j >= 0 || sum == 1) {
			// Compute the sum of last digits and carry
			sum += (i >= 0) ? a.charAt(i) - '0' : 0;
			sum += (j >= 0) ? b.charAt(j) - '0' : 0;

			// If the sum comes out to be 1 or 3, add 1 to the result
			result.append((char)(sum % 2 + '0'));

			// Calculate carry
			sum /= 2;

			// Decrement by 1
			i--;
			j--;
		}
		return result.toString();
	}
}
