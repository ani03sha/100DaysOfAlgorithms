package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _002MatrixChainMultiplication {

	public int findMinimumCost(int[] a) {

		// Length of the array
		int n = a.length;

		// DP array which will be used in overlapping substructure problems.
		// For simplicity of the program, one extra row and one extra column are
		// allocated in m[][]. 0th row and 0th column of m[][] are not used.
		int[][] dp = new int[n][n];

		// dp[i,j] = Minimum number of scalar multiplications needed to compute the
		// matrix A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is p[i-1] x p[i]

		// Cost of scalar multiplication
		int cost = 0;

		// Cost is zero when multiplying one matrix as there is no other matrix by which
		// we can multiply this matrix to.
		for (int i = 0; i < n; i++) {
			dp[i][i] = 0;
		}

		// Loop until the length of the chain - here 'l' denotes the chain length
		for (int l = 2; l < n; l++) {
			for (int i = 0; i < n - l; i++) {
				int j = i + l;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					// Calculate the cost of the multiplication
					cost = dp[i][k] + dp[k][j] + a[i] * a[k] * a[j];
					if (cost < dp[i][j]) {
						dp[i][j] = cost;
					}
				}
			}
		}
		return dp[0][n - 1];
	}
}
