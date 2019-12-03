package org.redquark.hundred.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Anirudh Sharma
 *
 */
class _006PostfixNotationTest {

	_006PostfixNotation pn = new _006PostfixNotation();

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._006PostfixNotation#infixToPostfix(java.lang.String)}.
	 */
	@Test
	void testInfixToPostfix() {
		String expression = "a+b*(c^d-e)^(f+g*h)-i";
		assertEquals("abcd^e-fgh*+^*+i-", pn.infixToPostfix(expression));

		expression = "x^y/(5*z)+10";
		assertEquals("xy^5z*/10+", pn.infixToPostfix(expression));

		expression = "(A*(B+(C/D)))";
		assertEquals("ABCD/+*", pn.infixToPostfix(expression));
	}

	/**
	 * Test method for
	 * {@link org.redquark.hundred.algorithms._006PostfixNotation#evaluatePostfix(java.lang.String)}.
	 */
	@Test
	void testEvaluatePostfix() {
		String expression = "231*+9-";
		assertEquals(-4, pn.evaluatePostfix(expression));
		
		expression = "48+65-*32-22+*/";
		assertEquals(3, pn.evaluatePostfix(expression));
	}
}
