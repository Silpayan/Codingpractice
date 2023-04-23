package leetcode.backtracking;

import java.util.ArrayList;

/*
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
*/
public class NQueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int GRID_SIZE = 8;

	void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) { // Found valid placement
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col; // Place queen
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}

	/*
	 * Check if (row1, column1) is a valid spot for a queen by checking if there is
	 * a queen in the same column or diagonal. We don't need to check it for queens
	 * in the same row because the calling placeQueen only attempts to place one
	 * queen at a time. We know this row is empty.
	 */
	boolean checkValid(Integer[] columns, int row1, int column1) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			/*
			 * Check if (row2, column2) invalidates (row1, column1) as a queen spot.
			 */

			/* Check if rows have a queen in the same column */
			if (column1 == column2) {
				return false;
			}

			/*
			 * Check diagonals : if the distance between the columns equals the distance
			 * between the rows, then they're in the same diagonal.
			 */
			int columnDistance = Math.abs(column2 - column1);

			/* row1 > row2, so no need for abs */
			int rowDistance = row1 - row2;
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

}
