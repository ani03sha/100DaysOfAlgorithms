package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _11McCarthy91Test {

	_11McCarthy91 m = new _11McCarthy91();
	
	/**
	 * Test method for {@link org.redquark.hundred.algorithms._11McCarthy91#mccarthy(int)}.
	 */
	@Test
	void testMccarthy() {
		assertEquals(91, m.mccarthy(12));
		assertEquals(91, m.mccarthy(50));
		assertEquals(91, m.mccarthy(90));
		assertEquals(91, m.mccarthy(90));
		assertEquals(94, m.mccarthy(104));
		assertEquals(99, m.mccarthy(109));
		assertEquals(194, m.mccarthy(204));
	}

}
