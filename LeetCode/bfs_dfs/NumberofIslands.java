package leetcode.bfs_dfs;
/*
 * 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by 
 * water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of 
 * the grid are all surrounded by water.
 * 
 */
public class NumberofIslands {

	public static void main(String[] args) {

		char grid[][]= {{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}};
		
		NumberofIslands n = new NumberofIslands();
		
		System.out.println("Number of Island : "+n.numIslands(grid));
		
	}

	public int numIslands(char[][] grid) {
		if( grid == null || grid.length == 0)
			return 0;
		
		int numsofIsland = 0;
		
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid[0].length;j++) {
				numsofIsland+=dfs(grid, i, j);
			}
		}
	
		return numsofIsland;
    }

	private int dfs(char[][] grid, int i, int j) {
		
		if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]=='0')
			return 0;
		
		grid[i][j] = '0';
		
		dfs(grid,i-1,j);
		dfs(grid,i+1,j);
		dfs(grid,i,j-1);
		dfs(grid,i,j+1);
		
		return 1;
	}
}
