package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _20StrassenAlgorithm {

	/**
	 * This method returns the multiplication of two square matrices of order NxN in
	 * O(N^(2.8074)) time
	 */
	public int[][] multiply(int[][] A, int[][] B) {

		// Get the order of the matrices
		int n = A.length;

		// This will store the result of the matrix multiplication
		int[][] C = new int[n][n];

		// Base condition - if the matrices are of order 1x1
		if (n == 1) {
			C[0][0] = A[0][0] * B[0][0];
		} else {

			// First matrix
			int[][] a = new int[n / 2][n / 2];
			int[][] b = new int[n / 2][n / 2];
			int[][] c = new int[n / 2][n / 2];
			int[][] d = new int[n / 2][n / 2];

			// Second matrix
			int[][] e = new int[n / 2][n / 2];
			int[][] f = new int[n / 2][n / 2];
			int[][] g = new int[n / 2][n / 2];
			int[][] h = new int[n / 2][n / 2];

			// Divide first matrix into 4 matrices of order (N/2)x(N/2)
			divideArray(A, a, 0, 0);
			divideArray(A, b, 0, n / 2);
			divideArray(A, c, n / 2, 0);
			divideArray(A, d, n / 2, n / 2);

			// Divide first matrix into 4 matrices of order (N/2)x(N/2)
			divideArray(B, e, 0, 0);
			divideArray(B, f, 0, n / 2);
			divideArray(B, g, n / 2, 0);
			divideArray(B, h, n / 2, n / 2);

			/**
			 * Strassesen's formula
			 * 
			 * p1 = (a + d)(e + h); p2 = (c + d)e; p3 = a(f - h); p4 = d(g - e); p5 = (a +
			 * b)h; p6 = (c - a) (e + f); p7 = (b - d) (g + h);
			 */

			int[][] p1 = multiply(addMatrices(a, d), addMatrices(e, h));
			int[][] p2 = multiply(addMatrices(c, d), e);
			int[][] p3 = multiply(a, subMatrices(f, h));
			int[][] p4 = multiply(d, subMatrices(g, e));
			int[][] p5 = multiply(addMatrices(a, b), h);
			int[][] p6 = multiply(subMatrices(c, a), addMatrices(e, f));
			int[][] p7 = multiply(subMatrices(b, d), addMatrices(g, h));

			/**
			 * C11 = p1 + p4 - p5 + p7; C12 = p3 + p5; C21 = p2 + p4; C22 = p1 - p2 + p3 +
			 * p6
			 */

			int[][] C11 = addMatrices(subMatrices(addMatrices(p1, p4), p5), p7);
			int[][] C12 = addMatrices(p3, p5);
			int[][] C21 = addMatrices(p2, p4);
			int[][] C22 = addMatrices(subMatrices(addMatrices(p1, p3), p2), p6);

			// Adding all subarray back into one
			copySubArray(C11, C, 0, 0);
			copySubArray(C12, C, 0, n / 2);
			copySubArray(C21, C, n / 2, 0);
			copySubArray(C22, C, n / 2, n / 2);
		}

		return C;
	}

	/**
	 * This method divides the given array
	 */
	private void divideArray(int[][] P, int[][] C, int iB, int jB) {
		for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
			for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
				C[i1][j1] = P[i2][j2];
			}
		}
	}

	/**
	 * This method adds two matrices
	 */
	private int[][] addMatrices(int[][] a, int[][] b) {
		int n = a.length;
		int[][] res = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = a[i][j] + b[i][j];
			}
		}
		return res;
	}

	/**
	 * This method subtracts two matrices
	 */
	private int[][] subMatrices(int[][] a, int[][] b) {
		int n = a.length;
		int[][] res = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = a[i][j] - b[i][j];
			}
		}
		return res;
	}

	/**
	 * This method copies two subarrays into one
	 */
	private void copySubArray(int[][] C, int[][] P, int iB, int jB) {
		for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
			for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
				P[i2][j2] = C[i1][j1];
	}
}
