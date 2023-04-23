package leetcode.array.matrix.robotinmaze;

import java.util.ArrayList;
import java.util.HashSet;


/*
 * 63. Unique Paths II
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 */
public class UniquePathsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{0,0,0},
				  		{0,0,0},
				  		{0,1,0}};
		System.out.println(uniquePathsWithObstacles(grid)); 
		
		//System.out.println(new UniquePathsII().getPath(grid));

	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		if(m==0||n==0||obstacleGrid[0][0]==1) {
			return 0;
		}
		
		// Number of ways of reaching the starting cell = 1.
		obstacleGrid[0][0]=1;
				
		//First cell no path
		//obstacleGrid[0][0] = 0;
		//First Row paths(only 1) from left
		for(int col = 1;col<n;col++) {
			obstacleGrid[0][col] = (obstacleGrid[0][col]==0 && obstacleGrid[0][col-1]==1)?1:0;
			//System.out.print(obstacleGrid[0][col]);
		}
		System.out.println();
		//First Col paths only from top.
		for(int row = 1;row<m;row++) {
			obstacleGrid[row][0] = (obstacleGrid[row][0]==0 && obstacleGrid[row-1][0]==1)?1:0; 
			//System.out.print(obstacleGrid[row][0]);
		}
		System.out.println();
		
		
		for(int row = 1;row<m; row++) {
			for(int col = 1;col<n;col++) {
				if(obstacleGrid[row][col] == 0) {
				obstacleGrid[row][col] = obstacleGrid[row][col-1]+obstacleGrid[row-1][col];//prev row+prev col
				
				} else {
					obstacleGrid[row][col] = 0;
				}
				//System.out.print(obstacleGrid[row][col]+ " ");
			}
			//System.out.println();
		}
		
		return obstacleGrid[m-1][n-1];
    
    }

}
