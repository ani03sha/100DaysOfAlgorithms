package org.redquark.hundred.algorithms;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _17PerceptronTest {

	_17Perceptron perceptron = new _17Perceptron();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._17Perceptron#findClass(int, int)}.
	 */
	@Test
	void testDecisionBoundaryEquation() {
		// Since this method uses the random values hence we are printing only the decision boundary equation
		System.out.println(perceptron.decisionBoundaryEquation());
	}

}
