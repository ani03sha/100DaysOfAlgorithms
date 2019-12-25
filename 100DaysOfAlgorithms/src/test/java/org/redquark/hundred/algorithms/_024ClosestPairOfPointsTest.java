package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;
import org.redquark.hundred.algorithms._024ClosestPairOfPoints.Point;

/**
 * @author Anirudh Sharma
 *
 */
class _024ClosestPairOfPointsTest {

	_024ClosestPairOfPoints closesPair = new _024ClosestPairOfPoints();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._024ClosestPairOfPoints#findClosestPairDistance(org.redquark.hundred.algorithms._024ClosestPairOfPoints.Point[])}.
	 */
	@Test
	void testFindClosestPairDistance() {
		Point[] points = new Point[] { new Point(2, 3), new Point(12, 30), new Point(40, 50), new Point(5, 1),
				new Point(12, 10), new Point(3, 4) };
		assertEquals(1.41421, Precision.round(closesPair.findClosestPairDistance(points), 5));

		points = new Point[] { new Point(6, 2), new Point(4, 6), new Point(5, 4), new Point(-8, 2), new Point(0, 2) };
		assertEquals(2.23607, Precision.round(closesPair.findClosestPairDistance(points), 5));

		
		assertThrows(IllegalArgumentException.class, () -> {
			Point[] point = new Point[] { new Point(6, 7) };
			closesPair.findClosestPairDistance(point);
		});
		
		points = new Point[] {new Point(0, 0), new Point(3, 4)};
		assertEquals(5.00000, Precision.round(closesPair.findClosestPairDistance(points), 5));
	}

}
