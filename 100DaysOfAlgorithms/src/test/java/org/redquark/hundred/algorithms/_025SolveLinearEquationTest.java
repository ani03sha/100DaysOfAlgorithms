package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _025SolveLinearEquationTest {

	private _025SolveLinearEquation solveLinearEquation = new _025SolveLinearEquation();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._025SolveLinearEquation#solve(double[][], double[])}.
	 */
	@Test
	void testSolve() {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		double[][] A = { { 0.42456748, 0.62491921, 0.63465604 }, { 0.71041907, 0.5504464, 0.35387507 },
				{ 0.72968393, 0.89913427, 0.40387709 }, { 0.56011875, 0.59026065, 0.30582469 },
				{ 0.34856696, 0.10710266, 0.38166378 } };
		double[] B = { 0.95400042, 0.11466396, 0.77725362, 0.54264563, 0.36871966 };
		double[] expected = { -1.028, 1.038, 1.289 };
		double[] actual = solveLinearEquation.solve(A, B);
		for(int i = 0; i < actual.length; i++) {
			actual[i] = Double.parseDouble(df.format(actual[i]));
		}
		assertArrayEquals(expected, actual);
	}

}
