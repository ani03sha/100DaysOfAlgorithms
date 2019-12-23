package org.redquark.hundred.algorithms;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _021KMeansTest {

	private _021KMeans kmeans = new _021KMeans();
	
	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._021KMeans#calculate(int, int)}.
	 */
	@Test
	void testCalculate() {
		// Since this code is works on the Random points for the illustration purpose,
		// so we cannot determine the outcome in advance. Hence will only be printing
		// the final result.
		System.out.println(kmeans.calculate(3, 15));
		System.out.println(kmeans.calculate(5,  25));
	}

}
