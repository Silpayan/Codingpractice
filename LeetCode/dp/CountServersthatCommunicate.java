package leetcode.dp;

/*
 * 1267. Count Servers that Communicate
 * Difficulty:Medium
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

 * Return the number of servers that communicate with any other server.
 * 
 * Input: grid = [[1,0],[0,1]]
 * Output: 0
 * Explanation: No servers can communicate with others.

 * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * Output: 4
 * 
 */
public class CountServersthatCommunicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{ 1, 1, 1, 1 }, 
						{ 0, 0, 0, 1 }, 
						{ 1, 0, 0, 1 },
						{ 1, 1, 0, 1 }};
		
		int grid1[][] = {{1,0},
						{1,1}};
		
		int grid2[][] = {{1,0,0,1,0},
						 {0,0,0,0,0},
						 {0,0,0,1,0}};
				
		System.out.println(countServers(grid2));
	}

	public static int countServers(int[][] grid) {

		int count = 0;

		if (grid == null || grid.length == 0)
			return 0;

		System.out.println(grid.length+" "+grid[0].length);
		
		// Traverse row wise
		int prevNode = 0;

		for (int row = 0; row < grid.length; row++) {
			boolean is2ndServerInRow = true;
			for (int col = 0; col < grid[row].length; col++) {
				if (prevNode == 1 && grid[row][col] == 1) {
					count++;
					grid[row][col] = 2;
					if (is2ndServerInRow) {
						count++;
						grid[row][col-1] = 2;
						is2ndServerInRow = false;
					}
				}

				if(prevNode==0)
					prevNode = grid[row][col] == 0?0:1 ;
			}
			prevNode = 0;
		}

		print(grid);
		
		System.out.println("Count afetr Row Traversal : "+count);
		// Traverse Column wise

		for (int col = 0; col < grid[0].length; col++) {
			boolean is2ndServerInCol = true;
			for (int row = 0; row < grid.length; row++) {
				if (prevNode == 1 && grid[row][col] != 0) {
					if(grid[row][col]!=2)count++;
					if (is2ndServerInCol) {
						count++;
						is2ndServerInCol = false;
					}
				}
				if(prevNode==0)
					prevNode = grid[row][col] != 1?0:1;
			}
			prevNode = 0;
		}
		return count;
	}

	private static void print(int[][] grid) {
		System.out.println("After Rowwise Traversal Grid : ");
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				System.out.print(grid[row][col]+" ");
			}
			System.out.println();
		}
	}

	public static int countServers2(int[][] grid) {
	    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
	    int numRows = grid.length;
	    int numCols = grid[0].length;
	    int rowCount[] = new int[numRows];
	    int colCount[] = new int[numCols];
	    int totalServers = 0;
	    for (int row = 0; row < numRows; row++) {
	        for (int col = 0; col < numCols; col++) {
	            if (grid[row][col] == 1) {
	                rowCount[row]++;
	                colCount[col]++;
	                totalServers++;
	            }
	        }
	    }
	    for (int row = 0; row < numRows; row++) {
	        for (int col = 0; col < numCols; col++) {
	            if (grid[row][col] == 1) {
	                if (rowCount[row] == 1 && colCount[col] == 1) {
	                    totalServers--;
	                }
	            }
	        }
	    }
	    return totalServers;
	}

}
