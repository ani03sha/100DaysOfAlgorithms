package org.redquark.hundred.algorithms;

import org.ejml.data.Complex64F;
import org.ejml.data.DenseMatrix64F;
import org.ejml.factory.DecompositionFactory;
import org.ejml.interfaces.decomposition.EigenDecomposition;

/**
 * @author Anirudh Sharma
 *
 */
public class _12RootsOfPolynomial {

	/**
	 * This method returns the root for the polynomial whose coefficients are given
	 */
	public Complex64F[] findRoots(double... coefficients) {

		// Number of coefficients
		int N = coefficients.length - 1;

		// Construct the companion matrix
		// DenseMatrix64F is a dense matrix with elements that are 64-bit floats
		// (doubles). A matrix is the fundamental data structure in linear algebra.
		// Unlike a sparse matrix, there is no compression in a dense matrix and every
		// element is stored in memory. This allows for fast reads and writes to the
		// matrix.
		DenseMatrix64F denseMatrix64F = new DenseMatrix64F(N, N);

		// Getting the coefficient of the highest power
		double a = coefficients[N];

		// Set the weighted coefficients in the dense matrix. By weighted, we mean that
		// we need to make the equation in such a way that of a is 1.
		for (int i = 0; i < N; i++) {
			// Assigns the element in the Matrix to the specified value. Performs a bounds
			// check to make sure the requested element is part of the matrix.
			denseMatrix64F.set(i, N - 1, -coefficients[i] / a);
		}

		for (int i = 1; i < N; i++) {
			denseMatrix64F.set(i, i - 1, 1);
		}

		// This will compute the eigen values
		EigenDecomposition<DenseMatrix64F> evd = DecompositionFactory.eig(N, false);

		// Computes the decomposition of the input matrix.
		evd.decompose(denseMatrix64F);

		// Create an instance of Complex64F to store roots
		Complex64F[] roots = new Complex64F[N];

		// Store the eigen values which will be roots in the array
		for (int i = 0; i < N; i++) {
			roots[i] = evd.getEigenvalue(i);
		}

		return roots;
	}
}
