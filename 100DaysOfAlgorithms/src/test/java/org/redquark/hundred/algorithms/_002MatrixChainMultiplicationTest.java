package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class _002MatrixChainMultiplicationTest {

	_002MatrixChainMultiplication mcm = new _002MatrixChainMultiplication();

	@Test
	void testFindMinimumCost() {
		int[] a = { 1, 2, 3, 4 };
		assertEquals(18, mcm.findMinimumCost(a));
		
		a = new int[]{2, 3, 6, 4, 5};
		assertEquals(124, mcm.findMinimumCost(a));
	}

}
