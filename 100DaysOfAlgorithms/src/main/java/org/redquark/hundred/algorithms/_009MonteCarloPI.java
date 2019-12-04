package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _009MonteCarloPI {

	/**
	 * This method estimates the value of "Pi" using the Monte Carlo estimation
	 * method
	 * 
	 * 1. Initialize circle_points, square_points and interval to 0.
	 * 
	 * 2. Generate random point x.
	 * 
	 * 3. Generate random point y.
	 * 
	 * 4. Calculate d = x*x + y*y.
	 * 
	 * 5. If d <= 1, increment circle_points.
	 * 
	 * 6. Increment square_points.
	 * 
	 * 7. Increment interval.
	 * 
	 * 8. If increment < NO_OF_ITERATIONS, repeat from 2.
	 * 
	 * 9. Calculate pi = 4*(circle_points/square_points).
	 * 
	 * 10. Terminate.
	 */
	public double estimatePi(int n) {

		// x and y coordinates of the unit ciricle
		double x, y;

		// Number of points inside or on the circle
		int points = 0;

		// Loop through the interval
		for (int i = 0; i <= n; i++) {
			// Random values of x and y
			x = Math.random();
			y = Math.random();

			// Check if the values lie inside or on the circle
			if (x * x + y * y <= 1) {
				points++;
			}
		}
		return 4 * points / n;
	}
}
