package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _018Monopoly {

	/**
	 * This method finds out the probability of stepping at position n during the
	 * first round
	 */
	public double probability(int n) {

		// This will be solved by the principle of total probability

		// Array that will store the initial probabilities
		double[] p = new double[n + 6];

		// Initial probability
		p[5] = 1;

		// Next field is conditioned on previous six fields
		for (int i = 6; i < p.length; i++) {
			p[i] = Math.round((p[i - 1] + p[i - 2] + p[i - 3] + p[i - 4] + p[i - 5] + p[i - 6]) / 6 * 100.00) / 100.00;
		}

		// Return the sub array from index 6 to the end
		return p[p.length - 1];
	}

}
