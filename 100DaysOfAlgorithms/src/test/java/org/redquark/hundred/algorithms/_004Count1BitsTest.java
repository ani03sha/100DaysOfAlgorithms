package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _004Count1BitsTest {

	_004Count1Bits cb = new _004Count1Bits();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._004Count1Bits#countBits(int)}.
	 */
	@Test
	void testCountBits() {
		assertEquals(0, cb.countBits(0));
		assertEquals(5, cb.countBits(31));
		assertEquals(1, cb.countBits(8));
		assertEquals(2, cb.countBits(65));
	}

}
