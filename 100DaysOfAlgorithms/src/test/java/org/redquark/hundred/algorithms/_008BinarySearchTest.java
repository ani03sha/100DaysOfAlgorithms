package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _008BinarySearchTest {

	_008BinarySearch bs = new _008BinarySearch();
	
	/**
	 * Test method for {@link org.redquark.hundred.algorithms._008BinarySearch#search(int[], int)}.
	 */
	@Test
	void testSearch() {
		int[] a = new int[] {2, 3, 4, 8, 10};
		assertEquals(-1, bs.search(a, 0));
		assertEquals(3, bs.search(a, 8));
		assertEquals(4, bs.search(a, 10));
	}

}
