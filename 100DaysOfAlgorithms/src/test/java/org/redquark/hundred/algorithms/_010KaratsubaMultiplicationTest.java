package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _010KaratsubaMultiplicationTest {
	
	_010KaratsubaMultiplication km = new _010KaratsubaMultiplication();

	/**
	 * Test method for {@link org.redquark.hundred.algorithms._010KaratsubaMultiplication#multiply(long, long)}.
	 */
	@Test
	void testMultiply() {
		assertEquals(687282734622L, km.multiply(24061994, 28563));
		assertEquals(19422547022L, km.multiply(457367, 42466));
	}

}
