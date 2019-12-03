package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _005EratosthenesSieveTest {

	_005EratosthenesSieve es = new _005EratosthenesSieve();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._005EratosthenesSieve#findPrimes(int)}.
	 */
	@Test
	void testFindPrimes() {
		int n = 10;
		assertTrue(Arrays.asList(2, 3, 5, 7).equals(es.findPrimes(n)));

		n = 20;
		assertTrue(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19).equals(es.findPrimes(n)));

		n = 100;
		assertTrue(Arrays
				.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
				.equals(es.findPrimes(n)));

		n = 200;
		assertTrue(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
				89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
				199).equals(es.findPrimes(n)));
	}

}
