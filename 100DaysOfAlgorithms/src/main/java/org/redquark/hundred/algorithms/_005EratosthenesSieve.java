package org.redquark.hundred.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class EratosthenesSieve {

	/**
	 * This method returns the array of prime numbers upto a specified number n
	 */
	public List<Integer> findPrimes(int n) {

		// Boolean array that will store the flags that if a number is prime or not
		boolean[] isPrime = new boolean[n + 1];
		// Set all the entries in the array as true for now
		Arrays.fill(isPrime, true);

		// List that will store the prime numbers
		List<Integer> primes = new ArrayList<>();

		// Start from 2 and loop until the square root of the n
		for (int i = 2; i <= Math.sqrt(n); i++) {
			// If isPrime[i] is not changed, it means it is a prime number
			if (isPrime[i]) {
				// Now update all the multiples of i starting from i*i. Since it is established
				// until now that 'i' is a prime number, hence its multiples cannot be primes
				for (int j = i * i; j <= n; j = j + i) {
					isPrime[j] = false;
				}
			}
		}
		// Added all those indexes to the list of prime whose values are true in
		// "isPrime" array
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
}
