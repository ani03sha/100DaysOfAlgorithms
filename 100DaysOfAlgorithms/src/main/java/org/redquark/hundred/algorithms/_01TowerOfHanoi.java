package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _01TowerOfHanoi {

	private StringBuilder result;
	private int count;

	public String moveOperations(int n) {
		// This variable will store all the move operations
		result = new StringBuilder();
		result.append("OPERATIONS:");
		// Initialize the value of count variable - This will store the number of
		// operations needed
		count = 0;

		// Method that will be called recursively to get all the operations needed to
		// move discs from one rod to another
		moveOperations(n, 'A', 'B', 'C');

		return result.toString();
	}

	/**
	 * This method actually gets called recursively for all the move operations of
	 * discs.
	 */
	private String moveOperations(int n, char from, char to, char aux) {

		// Increment count for each operation
		count++;

		// Base condition - if there is only one disc left
		if (n == 1) {
			result.append("\nMove disc 1 from rod ").append(from).append(" to rod ").append(to);
			return result.toString();
		}
		// Recursive calls
		moveOperations(n - 1, from, aux, to);
		result.append("\nMove disc ").append(n).append(" from rod ").append(from).append(" to rod ").append(to);
		moveOperations(n - 1, aux, to, from);

		return result.toString();
	}

	/**
	 * This method returns the count of operations needed to move all discs from the
	 * "from" tower to the "to" tower.
	 */
	public int getCountOfOperations() {
		// This means that the move operations have not been called yet
		if (count == 0) {
			throw new RuntimeException("Please perform move operations first");
		}
		return count;
	}
}
