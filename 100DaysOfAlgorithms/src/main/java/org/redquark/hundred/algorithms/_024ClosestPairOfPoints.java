package org.redquark.hundred.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class _024ClosestPairOfPoints {

	/**
	 * This method finds the two closest pair of points
	 */
	public double findClosestPairDistance(Point[] points) {
		// Base condition
		if (points.length < 2) {
			throw new IllegalArgumentException();
		}
		// Array of x coordinates of points
		Point[] px = new Point[points.length];
		// Array of y coordinates of points
		Point[] py = new Point[points.length];
		// Filling x and y coordinate arrays
		for (int i = 0; i < points.length; i++) {
			px[i] = points[i];
			py[i] = points[i];
		}
		// Sort by x and y coordinates
		Arrays.sort(px, new XSorter());
		Arrays.sort(py, new YSorter());
		// Minimum distance
		int minDistance = closestPair(px, py, 0, points.length - 1);
		return Math.sqrt(minDistance);
	}

	/**
	 * Find the closest distance between the points
	 */
	private int closestPair(Point[] px, Point[] py, int start, int end) {
		// Base condition
		if (end - start < 3) {
			return computeMinimumDistance(px, start, end);
		}
		// Find the middle points
		int mid = start + (end - start) / 2;
		// Left and right subarrays
		Point[] pyLeft = new Point[mid - start + 1];
		Point[] pyRight = new Point[end - mid];
		// Divide the points array into left and right subarrays based on x coordinate
		int i = 0, j = 0;
		for (Point p : px) {
			if (p.x <= px[mid].x) {
				pyLeft[i++] = p;
			} else {
				pyRight[j++] = p;
			}
		}
		// Find minimum distance in the left subarray
		int dLeft = closestPair(px, pyLeft, start, mid);
		int dRight = closestPair(px, pyRight, mid + 1, end);
		// Minimum of the two
		int d = Math.min(dLeft, dRight);
		// Find delta points
		List<Point> deltaPoints = new ArrayList<>();
		for (Point p : px) {
			if (Math.sqrt(distance(p, px[mid])) < Math.sqrt(d)) {
				deltaPoints.add(p);
			}
		}
		int d3 = closest(deltaPoints);
		return Math.min(d, d3);
	}

	/**
	 * This method finds the minimum distance among all the delta points
	 */
	private int closest(List<Point> deltaPoints) {
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < deltaPoints.size(); i++) {
			for (int j = i + 1; j <= i + 7 && j < deltaPoints.size(); j++) {
				int distance = distance(deltaPoints.get(i), deltaPoints.get(j));
				minDistance = Math.min(minDistance, distance);
			}
		}
		return minDistance;
	}

	/**
	 * This method return the square of euclidean distance between two points
	 */
	private int distance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	/**
	 * This method calculates the minimum distance of two points
	 */
	private int computeMinimumDistance(Point[] points, int start, int end) {
		// If there are only two points
		if (end - start == 1) {
			Point p1 = points[start];
			Point p2 = points[end];
			return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
		}
		// If there are three points
		else if (end - start == 2) {
			Point p1 = points[start];
			Point p2 = points[end - 1];
			Point p3 = points[end];
			return Math.min(
					Math.min((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y),
							(p1.x - p3.x) * (p1.x - p3.x) + (p1.y - p3.y) * (p1.y - p3.y)),
					(p2.x - p3.x) * (p2.x - p3.x) + (p2.y - p3.y) * (p2.y - p3.y));
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This class represents one point in the plane
	 */
	static class Point {
		// Abscissa
		private int x;
		// Ordinate
		private int y;

		/**
		 * Default constructor
		 */
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * Utility class for sorting points by x coordinate
	 */
	private class XSorter implements Comparator<Point> {
		@Override
		public int compare(Point o1, Point o2) {
			return o1.x > o2.x ? 1 : -1;
		}
	}

	/**
	 * Utility class for sorting points by y coordinate
	 */
	private class YSorter implements Comparator<Point> {
		@Override
		public int compare(Point o1, Point o2) {
			return o1.y > o2.y ? 1 : -1;
		}
	}
}
