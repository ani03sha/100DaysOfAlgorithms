package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _018MonopolyTest {

	_018Monopoly monopoly = new _018Monopoly();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._018Monopoly#probability(int)}.
	 */
	@Test
	void testProbability() {
		double[] expected = new double[] { 0.17, 0.19, 0.23, 0.27, 0.31, 0.36, 0.25, 0.27, 0.28, 0.29, 0.29, 0.29, 0.28,
				0.28, 0.29, 0.29, 0.29, 0.29, 0.29, 0.29, 0.29, 0.29, 0.29, 0.29 };
		int n = 5;
		assertEquals(expected[n - 1], monopoly.probability(n));
		
		n = 9;
		assertEquals(expected[n - 1], monopoly.probability(n));
	}

}
