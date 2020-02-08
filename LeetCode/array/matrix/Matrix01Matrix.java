package leetcode.array.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * 542. 01 Matrix
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 */
public class Matrix01Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 }, { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
						{ 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
						{ 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
						{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 } };
		int[][] mtx = {{0,0,0},{0,1,0},{1,2,0}};

		mat = new Matrix01Matrix().updateMatrixLC(mat);

		System.out.println("Distance Matrix from nearest 0 :");
		for (int[] a : mat) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}

	}

	public int[][] updateMatrixLC(int[][] matrix) {//This is BFS, DFS will not work without extra dp matrix
		int m = matrix.length;
		int n = matrix[0].length;

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[] { i, j });
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
					System.out.println(matrix[i][j]);
				}
			}
		}

		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			for (int[] d : dirs) {
				int r = cell[0] + d[0];
				int c = cell[1] + d[1];
				if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[cell[0]][cell[1]] + 1)
					continue;
				queue.add(new int[] { r, c });
				matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
			}
		}

		return matrix;
	}
	
    Set<String> visited = new HashSet<String>();
    
    public int[][] updateMatrix(int[][] matrix) {//DFS will not work
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return matrix;
        }
        
        for(int row=0;row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length;col++){
                matrix[row][col] = countDist0DFS(matrix,row,col);
            }
        }
        return matrix;
    }
    
    private int countDist0DFS(int[][] matrix,int row,int col){
        if(row<0||col<0||row>=matrix.length||col>=matrix[0].length||matrix[row][col]==0||visited.contains(row+","+col)){
            return 0;
        }
        visited.add(row+","+col);
        //countDist0DFS(matrix,row+1,col);
        //countDist0DFS(matrix,row-1,col);
        //countDist0DFS(matrix,row,col+1);
        //countDist0DFS(matrix,row,col-1);
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE, up=Integer.MAX_VALUE, down=Integer.MAX_VALUE;
        int m = matrix.length ;
        int n = matrix[0].length;
        // Base Case 
         if(row<0 || row>m-1 || col < 0 || col > n-1) return Integer.MAX_VALUE;
         if(matrix[row][col] == 0) return 0;
         // Case 1 Find 0 on top
         if(row > 0 && matrix[row-1][col] == 0) return 1;
         // Case 2 Find 0 on right
         if(col < n-1 && matrix[row][col+1] == 0) return 1;
         // Case 3 Find 0 on bottom
         if(row < m-1 && matrix[row+1][col] == 0) return 1;
         // Case 4 Find 0 on left
          if(col>0 && matrix[row][col-1] == 0) return 1;
        // Case when no zero around ..do DFS
        //int left,bottom,right,top;
  
        // if recursive call
          if(row > 0 && matrix[row-1][col] != 0){
              up = matrix[row-1][col];
          }
          if(col> 0 && matrix[row][col-1] != 0){
              left = matrix[row][col-1];
          }

        /*if(row-1>=0)
            up = matrix[row-1][col];*/
        if(row+1<matrix.length)
            down = countDist0DFS(matrix,row+1,col);
        /*if(col-1>=0)
            left = matrix[row][col-1];*/
        if(col+1<matrix[0].length)
            right = countDist0DFS(matrix,row,col+1);
        System.out.println(up+" "+down+" "+left+" "+right);
        
        System.out.println(row+" "+col+" "+matrix[row][col]);
        
        return 1+Math.min(Math.min(up,down),
                                      Math.min(left,right));
        
    }
}
