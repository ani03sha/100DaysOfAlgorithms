package org.redquark.hundred.algorithms;

import org.ejml.simple.SimpleMatrix;

/**
 * This class demonstrates the process to solve a linear equation given as Ax=B
 * where A and B are the matrices
 * 
 * @author Anirudh Sharma
 *
 */
public class _025SolveLinearEquation {

	/**
	 * This method returns the solution of Ax = B system where A and B are matrices.
	 */
	public double[] solve(double[][] A, double[] B) {
		// Get the order of matrices
		int m = A.length;
		int n = A[0].length;
		// Create two instances of SimpleMatrix
		SimpleMatrix A1 = new SimpleMatrix(m, n);
		SimpleMatrix B1 = new SimpleMatrix(m, 1);
		// Setting values in the respective SimpleMatrix instances
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A1.setRow(i, j, A[i][j]);
			}
			B1.setRow(i, 0, B[i]);
		}
		// Solve the equation
		SimpleMatrix X = A1.solve(B1);
		// Create an array that will store resultant values of x
		double[] x = new double[X.getNumElements()];
		// Setting the values in the result array
		for (int i = 0; i < x.length; i++) {
			x[i] = X.get(i, 0);
		}
		return x;
	}
}
