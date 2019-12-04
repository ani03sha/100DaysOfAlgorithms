package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _007BinaryAdditionTest {
	
	_007BinaryAddition ba = new _007BinaryAddition();

	/**
	 * Test method for {@link org.redquark.hundred.algorithms._007BinaryAddition#add(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAdd() {
		assertEquals("0", ba.add("0", "0"));
		assertEquals("111", ba.add("101", "10"));
		assertEquals("10001", ba.add("1101", "100"));
	}

}
