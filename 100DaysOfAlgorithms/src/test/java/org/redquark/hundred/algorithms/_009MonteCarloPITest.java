package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _009MonteCarloPITest {

	_009MonteCarloPI mcp = new _009MonteCarloPI();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._009MonteCarloPI#estimatePi(int)}.
	 */
	@Test
	void testEstimatePi() {
		int n = 10000;
		assertTrue((Math.PI - 0.5) <= mcp.estimatePi(n) && (Math.PI + 0.5) >= mcp.estimatePi(n));
		
		n = 20000;
		assertTrue((Math.PI - 0.25) <= mcp.estimatePi(n) && (Math.PI + 0.25) >= mcp.estimatePi(n));
	}

}
