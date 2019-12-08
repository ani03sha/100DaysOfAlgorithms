package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _16NoConditionSwap {

	/**
	 * This method will swap two passed numbers using the bitwise XOR operator
	 */
	public int[] swap(int x, int y) {
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		return new int[] { x, y };
	}
}
