package leetcode.array.matrix;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {

		// check Row wise
		System.out.println("Checking Row wise");
		for (char b[] : board) {
			boolean digitsCol[] = new boolean[9];
			for (char c : b) {
				if (c == '.')
					continue;
				System.out.print(c + ", ");
				if (digitsCol[c - 49]) { // ASCII 49 = 1, array starts from 0
					return false;
				} else {
					digitsCol[c - 49] = true;
				}
			}
		}

		// check Column wise
		System.out.println("\nchecking Column wise");
		for (int col = 0; col < board.length; col++) {
			boolean digitsRow[] = new boolean[9];
			for (int row = 0; row < board[col].length; row++) {
				if (board[row][col] == '.')
					continue;
				System.out.print(board[row][col] + ", ");
				if (digitsRow[board[row][col] - 49]) {
					return false;
				} else {
					digitsRow[board[row][col] - 49] = true;
				}
			}
		}

		// check 3X3
		System.out.println("\nChecking 3X3 wise");
		for (int colIncr = 0; colIncr <= 8; colIncr+=3) {
			for (int rowIncr = 0; rowIncr <= 8; rowIncr += 3) {
				boolean digits3X3[] = new boolean[9];
				for (int col = 1; col <= 3; col++) {
					for (int row = 1; row <= 3; row++) {
						System.out.print(board[row + rowIncr - 1][col + colIncr - 1] + ", ");
						System.out.print((row + rowIncr - 1) + "," + (col + colIncr - 1) + " \t");

						if (board[row + rowIncr - 1][col + colIncr - 1] == '.')
							continue;

						if (digits3X3[board[row + rowIncr - 1][col + colIncr - 1] - 49]) {
							return false;
						} else {
							digits3X3[board[row + rowIncr - 1][col + colIncr - 1] - 49] = true;
						}
					}
					System.out.println();
				}
				System.out.println();
			}
		}

		return true;
	}

	public static void main(String[] args) {

		char board1[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
							{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
							{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
							{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
							{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
							{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
							{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
							{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
							{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		//System.out.println("\nBoard1 isValidSudoku : " + isValidSudoku(board1));

		char board2[][] = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
							{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
							{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
							{ '5', '.', '.', '.', '6', '.', '.', '.', '3' }, 
							{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
							{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
							{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
							{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
							{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		//System.out.println("\nBoard2 isValidSudoku : " + isValidSudoku(board2));
		
		char board3[][]  = { {'.','.','.','.','5','.','.','1','.'},
							 {'.','4','.','3','.','.','.','.','.'},
							 {'.','.','.','.','.','2','.','.','9'},
							 {'8','.','.','.','.','.','.','2','.'},
							 {'.','.','2','.','7','.','.','.','.'},
							 {'.','1','5','.','.','.','.','.','.'},
							 {'.','.','.','.','.','2','.','3','.'},
							 {'.','2','.','9','.','.','.','.','3'},
							 {'.','.','4','.','.','.','.','.','.'} };
		
		System.out.println("\nBoard3 isValidSudoku : " + isValidSudoku(board3));
		
		/*
		 * 	0,0 0,1 0,2 0,3 0,4 0,5 0,6 0,7 0,8
			1,0 1,1 1,2 1,3	1,4	1,5 1,6 1,7 1,8
			2,0 2,1 2,2 2,3 2,4 2,5 2,6 2,7 2,8
			3,0 3,1 3,2 3,3 3,4 3,5 3,6 3,7 3,8
			4,0 4,1 4,2 4,3 4,4 4,5 4,6 4,7 4,8
			5,0 5,1 5,2 5,3 5,4 5,5 5,6 5,7 5,8
			6,0 6,1 6,2 6,3 6,4 6,5 6,6 6,7 6,8
			7,0 7,1 7,2 7,3 7,4 7,5 7,6 7,7 7,8
			8,0 8,1 8,2 8,3 8,4 8,5 8,6 8,7 8,8
		 * 
		 */

	}

}
