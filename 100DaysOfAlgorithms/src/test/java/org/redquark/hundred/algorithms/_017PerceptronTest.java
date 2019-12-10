package org.redquark.hundred.algorithms;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _017PerceptronTest {

	_017Perceptron perceptron = new _017Perceptron();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._017Perceptron#findClass(int, int)}.
	 */
	@Test
	void testDecisionBoundaryEquation() {
		// Since this method uses the random values hence we are printing only the decision boundary equation
		System.out.println(perceptron.decisionBoundaryEquation());
	}

}
