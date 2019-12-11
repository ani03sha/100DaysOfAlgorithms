package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _019CountingInversionsTest {

	_019CountingInversions ci = new _019CountingInversions();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._019CountingInversions#count(int[])}.
	 */
	@Test
	void testCount() {
		int[] a = new int[] { 1, 20, 6, 4, 5 };
		assertEquals(5, ci.count(a));

		a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		assertEquals(0, ci.count(a));
		
		a = new int[] {1, 9, 6, 4, 5};
		assertEquals(5, ci.count(a));
	}

}
