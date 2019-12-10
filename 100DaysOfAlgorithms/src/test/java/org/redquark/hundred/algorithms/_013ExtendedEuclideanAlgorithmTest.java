package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _013ExtendedEuclideanAlgorithmTest {

	_013ExtendedEuclideanAlgorithm eea = new _013ExtendedEuclideanAlgorithm();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._013ExtendedEuclideanAlgorithm#gcd(int, int, int, int)}.
	 */
	@Test
	void testGcd() {
		assertEquals(2, eea.gcd(0, 2, Integer.MAX_VALUE, Integer.MIN_VALUE));
		assertEquals(5, eea.gcd(15, 35, 1, 1));
	}

}
