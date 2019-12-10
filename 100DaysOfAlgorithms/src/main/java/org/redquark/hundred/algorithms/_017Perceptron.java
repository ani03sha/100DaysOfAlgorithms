package org.redquark.hundred.algorithms;

import java.text.DecimalFormat;

/**
 * @author Anirudh Sharma
 *
 */
public class _017Perceptron {

	private static final double LEARNING_RATE = 0.1;
	private static final int NUMBER_OF_INSTANCES = 100;
	private static int theta = 0;

	public String decisionBoundaryEquation() {

		// Find the weights of the equation
		double[] weights = getWeights();

		return weights[0] + "x" + " + " + weights[1] + "y" + " + " + weights[2] + "z" + " + " + weights[3] + " = 0";
	}

	/**
	 * Finds the final class for a range of inputs
	 */
	private double[] getWeights() {

		// Output class
		int output = Integer.MIN_VALUE;

		// Create three arrays - these will denote three features
		double[] x = new double[NUMBER_OF_INSTANCES];
		double[] y = new double[NUMBER_OF_INSTANCES];
		double[] z = new double[NUMBER_OF_INSTANCES];

		// Outputs
		int[] outputs = new int[NUMBER_OF_INSTANCES];

		// Prepare fifty random points of class 1
		for (int i = 0; i < NUMBER_OF_INSTANCES / 2; i++) {
			// Generate random values for x, y, z - the three features
			x[i] = getRandom(5, 10);
			y[i] = getRandom(4, 8);
			z[i] = getRandom(2, 9);
			// Set all outputs to 1 - the class
			outputs[i] = 1;
		}

		// Prepare 50 random points of class 0
		for (int i = NUMBER_OF_INSTANCES / 2; i < NUMBER_OF_INSTANCES; i++) {
			// Generate random values for x, y, z - the three features
			x[i] = getRandom(-1, 3);
			y[i] = getRandom(-4, 2);
			z[i] = getRandom(-3, 5);
			// Set all outputs to 1 - the class
			outputs[i] = 0;
		}

		// Array to store weights - three for features and one for the bias (weights[3])
		double[] weights = new double[4];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = getRandom(0, 1);
		}

		double localError;
		double globalError;
		int iteration = 0;

		do {
			// Initialize globalError for this iteration
			globalError = 0;
			// Loop through all instances - complete one epoch
			for (int i = 0; i < NUMBER_OF_INSTANCES; i++) {
				// Calculate predicted class
				output = getOutputClass(theta, weights, x[i], y[i], z[i]);
				// Get the local error - error for this iteration
				localError = outputs[i] - output;
				// Update weight and bias
				weights[0] += LEARNING_RATE * localError * x[i];
				weights[1] += LEARNING_RATE * localError * y[i];
				weights[2] += LEARNING_RATE * localError * z[i];
				weights[3] += LEARNING_RATE * localError;
				// Summation of squared error
				globalError += localError * localError;
			}
			iteration++;
		} while (globalError != 0 && iteration <= NUMBER_OF_INSTANCES);

		DecimalFormat df = new DecimalFormat("#.###");
		for (int i = 0; i < weights.length; i++) {
			String s = df.format(weights[i]);
			weights[i] = Double.parseDouble(s);
		}

		return weights;
	}

	/**
	 * This method returns a random double value within the given range
	 */
	private double getRandom(int min, int max) {
		// Decimal formal
		DecimalFormat df = new DecimalFormat("#.####");
		// Generate a random number
		double d = min + Math.random() * (max - min);
		// Convert the number into the required format
		String s = df.format(d);
		// Parse the number into double and return
		return Double.parseDouble(s);
	}

	/**
	 * This method finds out the predicted output class for each data point
	 */
	private int getOutputClass(int theta, double[] weights, double x, double y, double z) {
		// Calculate the sum
		double sum = x * weights[0] + y * weights[1] + z * weights[2] + weights[3];
		return (sum >= theta) ? 1 : 0;
	}
}
