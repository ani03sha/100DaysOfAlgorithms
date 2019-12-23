package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _022DeterminantTest {

	private _022Determinant determinant = new _022Determinant();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._022Determinant#calculate(int[][], int)}.
	 */
	@Test
	void testCalculate() {
		int[][] matrix = new int[][] { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };
		assertEquals(360, determinant.calculate(matrix, matrix.length));

		matrix = new int[][] { { 1 } };
		assertEquals(1, determinant.calculate(matrix, matrix.length));

		matrix = new int[][] { { 1, 0, 2, -1 }, { 3, 0, 0, 5 }, { 2, 1, 4, -3 }, { 1, 0, 5, 0 } };
		assertEquals(30, determinant.calculate(matrix, matrix.length));

		matrix = new int[][] { { 2, 2 }, { 2, 2 } };
		assertEquals(0, determinant.calculate(matrix, matrix.length));
	}

}
