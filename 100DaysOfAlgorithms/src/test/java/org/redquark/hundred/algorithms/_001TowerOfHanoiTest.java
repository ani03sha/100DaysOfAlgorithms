package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _001TowerOfHanoiTest {

	// Instance of the Tower of Hanoi class
	_001TowerOfHanoi toh = new _001TowerOfHanoi();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._001TowerOfHanoi#moveOperations(int)}.
	 */
	@Test
	void testMoveOperations() {
		String result = "OPERATIONS:\n" + "Move disc 1 from rod A to rod B\n" + "Move disc 2 from rod A to rod C\n"
				+ "Move disc 1 from rod B to rod C\n" + "Move disc 3 from rod A to rod B\n"
				+ "Move disc 1 from rod C to rod A\n" + "Move disc 2 from rod C to rod B\n"
				+ "Move disc 1 from rod A to rod B";
		assertEquals(result, toh.moveOperations(3));

		result = "OPERATIONS:\n" + "Move disc 1 from rod A to rod C\n" + "Move disc 2 from rod A to rod B\n"
				+ "Move disc 1 from rod C to rod B\n" + "Move disc 3 from rod A to rod C\n"
				+ "Move disc 1 from rod B to rod A\n" + "Move disc 2 from rod B to rod C\n"
				+ "Move disc 1 from rod A to rod C\n" + "Move disc 4 from rod A to rod B\n"
				+ "Move disc 1 from rod C to rod B\n" + "Move disc 2 from rod C to rod A\n"
				+ "Move disc 1 from rod B to rod A\n" + "Move disc 3 from rod C to rod B\n"
				+ "Move disc 1 from rod A to rod C\n" + "Move disc 2 from rod A to rod B\n"
				+ "Move disc 1 from rod C to rod B";
		assertEquals(result, toh.moveOperations(4));
	}

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._001TowerOfHanoi#getCountOfOperations()}.
	 */
	@Test
	void testGetCountOfOperations() {
		final RuntimeException re = assertThrows(RuntimeException.class, () -> {
			toh.getCountOfOperations();
		});
		assertEquals("Please perform move operations first", re.getMessage());
		assertDoesNotThrow(() -> {
			toh.moveOperations(3);
			toh.getCountOfOperations();
		});
		toh.moveOperations(3);
		assertEquals(Math.pow(2, 3) - 1, toh.getCountOfOperations());
		toh.moveOperations(4);
		assertEquals(Math.pow(2, 4) - 1, toh.getCountOfOperations());
	}

}
