package org.redquark.hundred.algorithms;

/**
 * Given an array or string, the task is to find the next lexicographically
 * greater permutation.
 * 
 * @author Anirudh Sharma
 *
 */
public class _003NextPermutation {

	/**
	 * This method finds out the next permutation of a sequence of numbers in the
	 * lexicographical order.
	 * 
	 * ----------------------------< STEPS >-----------------------------
	 * 
	 * 1. Iterate through array from right to left to find the number array[i] where
	 * the descending order occurs for the first time.
	 * 
	 * 2. Scan through the array from right to i+1 to find a number that is greater
	 * array[i] and swap the number with it
	 * 
	 * 3. Reverse array[i+1] ... array[array.length-1].
	 */
	public int[] findNextPermutation(int[] a) {

		// Getting the variable 'i' which is 2 less than the length of the array because
		// we need to compare i+1 element as well
		int i = a.length - 2;

		// Loop from right to left until we find the descending order for the very first
		// time - called as the Pivot
		while (i >= 0 && a[i + 1] <= a[i]) {
			// Decrement the counter (Nothing to do - move ahead)
			i--;
		}

		// Check if have not reached to the negative index
		if (i >= 0) {
			// Get the last index of the array in j
			int j = a.length - 1;
			// Loop from the right to the index (i+1) until we find a number that is greater
			// than a[i] - called as the ChangeNumber
			while (j >= 0 && a[j] <= a[i]) {
				j--;
			}
			// Now swap Pivot and ChangeNumber
			swap(a, i, j);
		}
		// Now reverse the elements from a[i+1] to a[a.length-1]
		reverse(a, i + 1);

		return a;
	}

	/**
	 * This method swaps two elements in the array
	 */
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * This method reverses the array starting from the index 'start' and until the
	 * end of the array
	 */
	private void reverse(int[] a, int start) {
		int i = start;
		int j = a.length - 1;
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
	}
}
