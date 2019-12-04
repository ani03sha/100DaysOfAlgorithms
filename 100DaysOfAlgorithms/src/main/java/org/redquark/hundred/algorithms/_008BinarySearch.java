package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _008BinarySearch {

	/**
	 * This method searches for the given key 'k' in the given array 'a'. This
	 * method requires that the array has to be sorted before searching.
	 */
	public int search(int[] a, int k) {

		// Find the left and right indexes
		int left = 0;
		int right = a.length - 1;

		// Loop until the left index is less than the right index
		while (left <= right) {
			// Mid index
			int mid = left + (right - left) / 2;

			// Check if the middle element is the key
			if (a[mid] == k) {
				return mid;
			}
			// If the key is present in the left half of the array
			else if (a[mid] > k) {
				right = mid - 1;
			}
			// If the element is present in the right half of the array
			else {
				left = mid + 1;
			}
		}
		// If we reach here, it means the element is not present in the array
		return -1;
	}

}
