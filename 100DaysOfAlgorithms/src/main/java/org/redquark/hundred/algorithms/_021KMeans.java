package org.redquark.hundred.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Anirudh Sharma
 *
 */
public class _021KMeans {

	private static final int MIN_COORDINATE = 0;
	private static final int MAX_COORDINATE = 10;

	// List of points
	private List<Point> points;
	// List of clusters
	private List<Cluster> clusters;

	/**
	 * Default constructor
	 */
	public _021KMeans() {
		this.points = new ArrayList<>();
		this.clusters = new ArrayList<>();
	}

	/**
	 * This method calculates the clusters using the KMeans algorithm
	 */
	public String calculate(int numberOfClusters, int numberOfPoints) {
		// Create some random points
		points = Point.createRandomPoints(MIN_COORDINATE, MAX_COORDINATE, numberOfPoints);
		// Create clusters and set random centroids
		for (int i = 0; i < numberOfClusters; i++) {
			Cluster cluster = new Cluster(i);
			Point centroid = Point.createRandomPoint(MIN_COORDINATE, MAX_COORDINATE);
			cluster.setCentroid(centroid);
			clusters.add(cluster);
		}

		/**********************************************************
		 * The process to calculate the K Means starts from here
		 *********************************************************/

		// Flag that will indicate if the process is finished
		boolean finish = false;
		while (!finish) {
			// Clear cluster state
			clearClusters();
			// Get the list of lastly calculated centroids
			List<Point> lastCentroids = getCentroids(numberOfClusters);
			// Assign points to the closer cluster
			assignCluster(numberOfClusters);
			// Calculate new centroids
			calculateCentroids();
			// Get the current centroids
			List<Point> currentCentroids = getCentroids(numberOfClusters);
			// Calculate total distance between new and old centroids
			double distance = 0;
			for (int i = 0; i < lastCentroids.size(); i++) {
				distance += Point.distance(lastCentroids.get(i), currentCentroids.get(i));
			}
			// If there is no distance between the current and the previous, we will stop
			if (distance == 0) {
				finish = true;
			}
		}
		// Get the total result
		return plotClusters(numberOfClusters);
	}

	/**
	 * This method calculates the total result with the final clusters assigned
	 */
	private String plotClusters(int numberOfClusters) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < numberOfClusters; i++) {
			Cluster c = clusters.get(i);
			result.append(c.plotCluster());
		}
		return result.toString();
	}

	/**
	 * This method calculates the new centroids for each clusted based on the points
	 * assigned to a cluster
	 */
	private void calculateCentroids() {

		for (Cluster cluster : clusters) {
			double sumX = 0;
			double sumY = 0;
			List<Point> list = cluster.getPoints();
			int nPoints = list.size();

			for (Point point : list) {
				sumX += point.getX();
				sumY += point.getY();
			}

			Point centroid = cluster.getCentroid();
			if (nPoints > 0) {
				double newX = sumX / nPoints;
				double newY = sumY / nPoints;
				centroid.setX(newX);
				centroid.setY(newY);
			}
		}
	}

	/**
	 * This method assign clusters to the points
	 */
	private void assignCluster(int numberOfClusters) {
		double max = Double.MAX_VALUE;
		double min = max;
		int cluster = 0;
		double distance = 0.0;

		for (Point point : points) {
			min = max;
			for (int i = 0; i < numberOfClusters; i++) {
				Cluster c = clusters.get(i);
				distance = Point.distance(point, c.getCentroid());
				if (distance < min) {
					min = distance;
					cluster = i;
				}
			}
			point.setClusterNumber(cluster);
			clusters.get(cluster).addPoint(point);
		}
	}

	/**
	 * This method returns the list of centroids of the clusters
	 */
	private List<Point> getCentroids(int numberOfClusters) {
		List<Point> centroids = new ArrayList<>(numberOfClusters);
		for (Cluster cluster : clusters) {
			Point aux = cluster.getCentroid();
			Point p = new Point(aux.getX(), aux.getY());
			centroids.add(p);
		}
		return centroids;
	}

	/**
	 * This method clears clusters
	 */
	private void clearClusters() {
		for (Cluster cluster : clusters) {
			cluster.clear();
		}
	}

	private static class Point {
		// Abscissa - x-coordinate
		private double x = 0;
		// Ordinate - y-coordinate
		private double y = 0;
		
		/**
		 * Default constructor
		 */
		public Point(double x, double y) {
			this.setX(x);
			this.setY(y);
		}

		/**
		 * @return the x
		 */
		public double getX() {
			return x;
		}

		/**
		 * @param x the x to set
		 */
		public void setX(double x) {
			this.x = x;
		}

		/**
		 * @return the y
		 */
		public double getY() {
			return y;
		}

		/**
		 * @param y the y to set
		 */
		public void setY(double y) {
			this.y = y;
		}

		/**
		 * @param clusterNumber the clusterNumber to set
		 */
		public void setClusterNumber(int clusterNumber) {
		}

		/**
		 * Returns the euclidean distance between current point and the centroid
		 */
		protected static double distance(Point p, Point centroid) {
			return Math.sqrt(Math.pow((centroid.getY() - p.getY()), 2) + Math.pow((centroid.getX() - p.getX()), 2));
		}

		/**
		 * This method creates a random point in the space and returns it
		 */
		protected static Point createRandomPoint(int min, int max) {
			Random r = new Random();
			double x = min + (max - min) * r.nextDouble();
			double y = min + (max - min) * r.nextDouble();
			return new Point(x, y);
		}

		/**
		 * Returns the list of all the points that are created randomly
		 */
		protected static List<Point> createRandomPoints(int min, int max, int n) {
			List<Point> points = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				points.add(createRandomPoint(min, max));
			}
			return points;
		}

		/**
		 * This method returns the String representation of a point in space
		 */
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	/**
	 * This class represents each cluster
	 * 
	 * @author Anirudh Sharma
	 *
	 */
	private static class Cluster {

		// List of points in this cluster
		private List<Point> points;
		// Centroid of this cluster
		private Point centroid;
		// Cluster id
		private int id;

		/**
		 * Creates a new cluster
		 */
		Cluster(int id) {
			this.id = id;
			this.points = new ArrayList<>();
			this.centroid = null;
		}

		/**
		 * @return the points
		 */
		public List<Point> getPoints() {
			return points;
		}

		/**
		 * @return the centroid
		 */
		public Point getCentroid() {
			return centroid;
		}

		/**
		 * @param centroid the centroid to set
		 */
		public void setCentroid(Point centroid) {
			this.centroid = centroid;
		}

		/**
		 * This method adds a new point to the list of points that belong to this
		 * cluster
		 */
		public void addPoint(Point point) {
			points.add(point);
		}

		/**
		 * This method empties the list of points
		 */
		public void clear() {
			points.clear();
		}

		/**
		 * This method returns the String representation of the points in the cluster
		 */
		public String plotCluster() {
			StringBuilder result = new StringBuilder();
			result.append("[Cluster: ").append(id).append("]").append("[Centroid: ").append(centroid).append("]")
					.append("[Points: \n");
			for (Point p : points) {
				result.append(p);
			}
			result.append("]");

			return result.toString();
		}
	}
}
