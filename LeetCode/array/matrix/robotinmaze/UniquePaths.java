package leetcode.array.matrix.robotinmaze;

/*
 * 62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(1, 1));
	}
	
	public static int uniquePaths(int m, int n) {
    
		int grid[][] = new int[m][n];
		
		if(m==0||n==0) {
			return 0;
		}
		
		if(m==1||n==1) {
			return 1;
		}
		//First cell no path
		grid[0][0] = 0;
		//First Row paths(only 1) from left
		for(int col = 1;col<n;col++) {
			grid[0][col] = 1;
			//System.out.print(grid[0][col]);
		}
		System.out.println();
		//First Col paths only from top.
		for(int row = 1;row<m;row++) {
			grid[row][0] = 1;
			//System.out.print(grid[row][0]);
		}
		System.out.println();
		
		
		for(int row = 1;row<m; row++) {
			for(int col = 1;col<n;col++) {
				grid[row][col] = grid[row][col-1]+grid[row-1][col];//prev row+prev col
				//System.out.print(grid[row][col]+ " ");
			}
		}
		
		return grid[m-1][n-1];
    }

}
