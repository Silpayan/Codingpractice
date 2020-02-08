package leetcode.dp;

/*
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = {{'X','X','X','X'},
							{'X','O','O','X'},
							{'X','X','O','X'},
							{'X','O','O','O'},
							{'X','X','X','X'}};
		solve(board);
		System.out.println("Surrounded Regions : ");
		for(char a[]:board) {
			for(char b:a) {
				System.out.print(b+",");
			}
			System.out.println();
		}
	}
	
	public static void solve(char[][] board) {
		 if(board.length == 0) return;
	        boolean[][] CC = new boolean[board.length][board[0].length];
	        for(int row = 0; row < board.length; row ++){//Row wise
	            dfs(row, 0, CC, board);	//First Row
	            dfs(row, board[0].length - 1, CC, board);//Last Row
	        }
	        for(int col = 0; col < board[0].length; col ++){
	            dfs(0, col, CC, board); //First Column
	            dfs(board.length - 1, col, CC, board);	//Last Column
	        }
	        for(int i = 0; i < board.length; i ++){
	            for(int j = 0; j < board[0].length; j ++){
	                if(!CC[i][j]) board[i][j] = 'X';
	            }
	        }
	    }
	    
	    private static void dfs(int row, int col, boolean[][] CC, char[][] board){
	        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
	        if(CC[row][col] || board[row][col] == 'X') return;
	        if(board[row][col] == 'O'){
	            CC[row][col] = true;
	            dfs(row + 1, col, CC, board);
	            dfs(row - 1, col, CC, board);
	            dfs(row, col + 1, CC, board);
	            dfs(row, col - 1, CC, board);
	        }
	    }
/*
 * Example:

	X X X X
	X O O X
	X X O X
	X O X X
	After running your function, the board should be:
	
	X X X X
	X X X X
	X X X X
	X O X X
 */
}
