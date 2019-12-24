package org.redquark.hundred.algorithms;

/**
 * @author Anirudh Sharma
 *
 */
public class _023Sudoku {

	// This will denote the empty space in the Grid
	private static final int EMPTY = 0;
	// Order of the Grid
	private static final int SIZE = 9;

	public int[][] usingBackracking(int[][] grid) {
		return solveUsingBacktracking(grid) ? grid : null;
	}

	/**
	 * This method will solve the Sudoku grid using the recursive backtracking
	 * algorithm
	 */
	private boolean solveUsingBacktracking(int[][] grid) {

		// Loop for grid
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				// Search an empty cell
				if (grid[row][column] == EMPTY) {
					// We try possible numbers
					for (int number = 1; number <= SIZE; number++) {
						if (canBeInserted(grid, row, column, number)) {
							grid[row][column] = number;
							// Start backtracking recursively
							if (solveUsingBacktracking(grid)) {
								return true;
							} else {
								// If not a solution, we empty the cell and continue
								grid[row][column] = EMPTY;
							}
						}
					}
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * This method checks if the passed number is present in the given row or not
	 */
	private boolean isInRow(int[][] grid, int row, int number) {
		for (int i = 0; i < SIZE; i++) {
			if (grid[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks if the passed number is present in the given column or not
	 */
	private boolean isInColumn(int[][] grid, int column, int number) {
		for (int i = 0; i < SIZE; i++) {
			if (grid[i][column] == number) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks if the number is present in 3X3 box or not
	 */
	private boolean isInBox(int[][] grid, int row, int column, int number) {
		int r = row - row % 3;
		int c = column - column % 3;
		// Check in the 3X3 sub matrix
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (grid[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method checks if the number can be inserted or not
	 */
	private boolean canBeInserted(int[][] grid, int row, int column, int number) {
		return !isInRow(grid, row, number) && !isInColumn(grid, column, number) && !isInBox(grid, row, column, number);
	}
}
