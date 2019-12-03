package org.redquark.hundred.algorithms;

import java.util.Stack;

/**
 * @author Anirudh Sharma
 *
 */
public class _006PostfixNotation {

	/**
	 * This method converts a given infix expression to the postfix expression
	 * 
	 * 1. Scan the infix expression from left to right.
	 * 
	 * 2. If the scanned character is an operand, output it.
	 * 
	 * 3. Else, …..3.1 If the precedence of the scanned operator is greater than the
	 * precedence of the operator in the stack(or the stack is empty or the stack
	 * contains a ‘(‘ ), push it. …..3.2 Else, Pop all the operators from the stack
	 * which are greater than or equal to in precedence than that of the scanned
	 * operator. After doing that Push the scanned operator to the stack. (If you
	 * encounter parenthesis while popping then stop there and push the scanned
	 * operator in the stack.)
	 * 
	 * 4. If the scanned character is an ‘(‘, push it to the stack.
	 * 
	 * 5. If the scanned character is an ‘)’, pop the stack and and output it until
	 * a ‘(‘ is encountered, and discard both the parenthesis.
	 * 
	 * 6. Repeat steps 2-6 until infix expression is scanned.
	 * 
	 * 7. Print the output 8. Pop and output from the stack until it is not empty.
	 */
	public String infixToPostfix(String expression) {

		// This will store the final postfix notation
		StringBuilder result = new StringBuilder();

		// Stack that will scan the expression character by character
		Stack<Character> stack = new Stack<>();

		// Loop through the length of the expression
		for (int i = 0; i < expression.length(); i++) {
			// Get the current character
			char c = expression.charAt(i);
			// If the scanned character is an operand add it to the result
			if (Character.isLetterOrDigit(c)) {
				result.append(c);
			}
			// If the scanned character is '(', push it to the Stack
			else if (c == '(') {
				stack.push(c);
			}
			// If the scanned character is an ')', pop and output from the stack
			// until an '(' is encountered.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				if (!stack.isEmpty() && stack.peek() != '(') {
					throw new RuntimeException("Invalid expression");
				} else {
					stack.pop();
				}
			}
			// An operator is encountered
			else {
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
					if (stack.peek() == '(') {
						throw new RuntimeException("Invalid expression");
					}
					result.append(stack.pop());
				}
				stack.push(c);
			}
		}

		// Pop all operators from the stack
		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				throw new RuntimeException("Invalid expression");
			}
			result.append(stack.pop());
		}
		return result.toString();
	}

	/**
	 * This method takes the postfix expression and evaluates the same to give the
	 * final result
	 * 
	 * 1) Create a stack to store operands (or values).
	 * 
	 * 2) Scan the given expression and do following for every scanned element.
	 * …..a) If the element is a number, push it into the stack …..b) If the element
	 * is a operator, pop operands for the operator from stack. Evaluate the
	 * operator and push the result back to the stack
	 * 
	 * 3) When the expression is ended, the number in the stack is the final answer
	 */
	public int evaluatePostfix(String expression) {

		// Stack that will store the operands
		Stack<Integer> stack = new Stack<>();

		// Scan all characters one by one
		for (int i = 0; i < expression.length(); i++) {
			// Get the current character
			char c = expression.charAt(i);

			// If the scanned character is the operand, push it to the stack
			if (Character.isDigit(c)) {
				stack.push((c - '0'));
			}
			// If the scanned character is the operator, pop two elements from the stack and
			// evaluate them
			else {
				int a = stack.pop();
				int b = stack.pop();

				switch (c) {
				case '+':
					stack.push(a + b);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '*':
					stack.push(a * b);
					break;
				case '/':
					stack.push(b / a);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + c);
				}
			}
		}
		return stack.pop();
	}

	/**
	 * This utility method calculates the precedence of an operator
	 */
	private static int precedence(char c) {

		switch (c) {

		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}
}
