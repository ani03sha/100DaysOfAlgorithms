package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _022Determinant {

	/**
	 * This method returns the determinant of an nXn order matrix
	 */
	public int calculate(int[][] matrix, int n) {
		// Base case - if matrix contains single element
		if (n == 1) {
			return matrix[0][0];
		}
		// This will store the final result
		int d = 0;
		// This will store the cofactor of an element
		int[][] cofactor = new int[n][n];
		// This will store the sign multiplier which inverts with each iteration
		int sign = 1;
		// Iterate for each element of the first row
		for (int i = 0; i < n; i++) {
			// Getting the cofactor of matrix[0][i]
			getCofactor(matrix, cofactor, 0, i, n);
			d += sign * matrix[0][i] * calculate(cofactor, n - 1);
			// Invert the sign
			sign = -sign;
		}
		return d;
	}

	/**
	 * This method will return the cofactor of matrix[p][q] in cofactor[][]. Where n
	 * is the current dimension of matrix[][].
	 */
	private void getCofactor(int[][] matrix, int[][] cofactor, int p, int q, int n) {
		// Temp variables
		int i = 0, j = 0;
		// Loop for each element of the matrix
		for (int row = 0; row < n; row++) {
			for (int column = 0; column < n; column++) {
				// Copying only those elements which are not in the current row and column in
				// the cofactor matrix
				if (row != p && column != q) {
					cofactor[i][j++] = matrix[row][column];
					// Row is filled, so increase the row index and reset column index
					if (j == n - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}

}
