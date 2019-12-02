package org.redquark.hundred.algorithms;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class _003NextPermutationTest {

	private _003NextPermutation np = new _003NextPermutation();

	@Test
	void testFindNextPermutation() {
		int[] a = new int[] { 1, 2, 3 };
		int[] nextPermutation = new int[] { 1, 3, 2 };
		assertArrayEquals(nextPermutation, np.findNextPermutation(a));

		a = new int[] { 4, 6, 1, 6 };
		nextPermutation = new int[] { 4, 6, 6, 1 };
		assertArrayEquals(nextPermutation, np.findNextPermutation(a));

		a = new int[] { 4, 2, 5, 3, 1 };
		nextPermutation = new int[] { 4, 3, 1, 2, 5 };
		assertArrayEquals(nextPermutation, np.findNextPermutation(a));
		
		a = new int[] {3, 2, 1};
		nextPermutation = new int[] {1, 2, 3};
		assertArrayEquals(nextPermutation, np.findNextPermutation(a));
	}

}
