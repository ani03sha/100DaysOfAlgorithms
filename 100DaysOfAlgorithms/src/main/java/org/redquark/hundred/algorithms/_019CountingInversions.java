package org.redquark.hundred.algorithms;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class _019CountingInversions {

	/**
	 * This method returns the count of inversions in the given array
	 */
	public int count(int[] a) {

		return mergeAndCount(a, 0, a.length - 1);
	}

	/**
	 * This method returns the total number of inversions in an array.
	 * 
	 * Total = Inversions in left subarray + inversions in right subarray +
	 * inversions while merging
	 */
	private int mergeAndCount(int[] a, int low, int high) {
		// Keeps track of the inversion count at a particular node of the recursion tree
		int count = 0;

		// Loop until condition holds true - it is similar to the condition in the Merge
		// Sort algorithm
		if (low < high) {
			// Find the mid point
			int mid = low + (high - low) / 2;

			// Left subarray count
			count += mergeAndCount(a, low, mid);

			// Right subarray count
			count += mergeAndCount(a, mid + 1, high);

			// Count while merging
			count += merge(a, low, mid, high);
		}

		return count;
	}

	/**
	 * This method merges the sub arrays and also keeps count of the inversions
	 * while merging
	 */
	private int merge(int[] a, int low, int mid, int high) {

		// Left subarray
		int[] left = Arrays.copyOfRange(a, low, mid + 1);

		// Right sub array
		int[] right = Arrays.copyOfRange(a, mid + 1, high + 1);

		// Index for left subarray
		int i = 0;
		// Index for right subarray
		int j = 0;

		int k = low;

		// Number of swaps
		int swaps = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				a[k++] = left[i++];
			} else {
				a[k++] = right[j++];
				swaps += (mid + 1) - (low + i);
			}
		}

		// Fill from the rest of the subarray
		while (i < left.length) {
			a[k++] = left[i++];
		}

		// Fill from the left of the right subarray
		while (j < right.length) {
			a[k++] = right[j++];
		}

		return swaps;
	}
}
