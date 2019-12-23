package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _020StrassenAlgorithmTest {

	_020StrassenAlgorithm strassen = new _020StrassenAlgorithm();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._020StrassenAlgorithm#multiply(int[][], int[][])}.
	 */
	@Test
	void testMultiply() {

		int[][] A = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] B = new int[][] { { 5, 6 }, { 7, 8 } };

		int[][] C = strassen.multiply(A, B);

		assertEquals(19, C[0][0]);
		assertEquals(22, C[0][1]);
		assertEquals(43, C[1][0]);
		assertEquals(50, C[1][1]);

		A = new int[][] { { 1, 1 }, { 1, 1 } };
		B = new int[][] { { 1, 1 }, { 1, 1 } };
		
		C = strassen.multiply(A, B);

		assertEquals(2, C[0][0]);
		assertEquals(2, C[0][1]);
		assertEquals(2, C[1][0]);
		assertEquals(2, C[1][1]);
	}

}
