package org.redquark.hundred.algorithms;

import static org.junit.Assert.assertArrayEquals;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _016NoConditionSwapTest {

	private _016NoConditionSwap ncs = new _016NoConditionSwap();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._016NoConditionSwap#swap(int, int)}.
	 */
	@Test
	void testSwap() {
		int[] a = new int[] { 4, 5 };
		ArrayUtils.reverse(a);
		assertArrayEquals(a, ncs.swap(a[1], a[0]));
		
		a = new int[] {-7, 0};
		ArrayUtils.reverse(a);
		assertArrayEquals(a, ncs.swap(a[1], a[0]));
		
		a = new int[] {0 , 0};
		ArrayUtils.reverse(a);
		assertArrayEquals(a, ncs.swap(a[1], a[0]));
	}

}
