package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.ejml.data.Complex64F;
import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _012RootsOfPolynomialTest {

	_012RootsOfPolynomial rp = new _012RootsOfPolynomial();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._012RootsOfPolynomial#findRoots(double[])}.
	 */
	@Test
	void testFindRoots() {
		double[] coefficients = new double[] { 1, 1, 1 };
		Complex64F[] roots = rp.findRoots(coefficients);
		double[][] parts = findRealAndImaginaryParts(roots);
		assertArrayEquals(new double[] { 0.0, 0.0 }, parts[0]);
		assertArrayEquals(new double[] { 1, -1 }, parts[1]);

		coefficients = new double[] { 6, -5, 1 };
		roots = rp.findRoots(coefficients);
		parts = findRealAndImaginaryParts(roots);
		assertArrayEquals(new double[] { 3, 2 }, parts[0]);
		assertArrayEquals(new double[] { 0, 0 }, parts[1]);

		coefficients = new double[] { 1, 0, 1 };
		roots = rp.findRoots(coefficients);
		parts = findRealAndImaginaryParts(roots);
		assertArrayEquals(new double[] { 0, 0 }, parts[0]);
		assertArrayEquals(new double[] { 1, -1 }, parts[1]);

		coefficients = new double[] { -105, -5, -5, -5, -5, 103 };
		roots = rp.findRoots(coefficients);
		parts = findRealAndImaginaryParts(roots);
		assertArrayEquals(new double[] { 1, -1, -1, 0, 0 }, parts[0]);
		assertArrayEquals(new double[] { 0, 1, -1, 1, -1 }, parts[1]);
	}

	private double[][] findRealAndImaginaryParts(Complex64F[] roots) {
		double[] reals = new double[roots.length];
		double[] imaginaries = new double[roots.length];
		for (int i = 0; i < roots.length; i++) {
			reals[i] = Math.round(roots[i].real);
			imaginaries[i] = Math.round(roots[i].imaginary);
		}

		return new double[][] { reals, imaginaries };
	}

}
