package leetcode.array.matrix;
/*
 * 5286. Shortest Path in a Grid with Obstacles Elimination
User Accepted:20
User Tried:34
Total Accepted:20
Total Submissions:50
Difficulty:Hard
Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left or right from and to an empty cell.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 
 */
public class ShortestPathinaGridwithObstaclesElimination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int shortestPath(int[][] grid, int k) {
		int R = grid.length;
        int C = grid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (grid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        grid[0][0] = 1;

        /*/ Filling the values for the first column
        for (int i = 1; i < R; i++) {
            grid[i][0] = (grid[i][0] == 0 && grid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            grid[0][i] = (grid[0][i] == 0 && grid[0][i - 1] == 1) ? 1 : 0;
        }*/

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                    
                    
                    
                } else {
                    grid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return grid[R - 1][C - 1];
    }

}
