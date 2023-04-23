package leetcode.tree;
/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
 */
public class Searcha2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		
		System.out.println(new Searcha2DMatrixII().searchMatrix(matrix, 30));
	}
	
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length == 0 || matrix[0].length==0){
            return false;
        }
        
        
        int cntCpmlx = 0, row = 0, col = matrix[0].length-1;
        
        while(col>=0 && row<=matrix.length-1){
            System.out.print(cntCpmlx++);
            
            if(target==matrix[row][col]){
                return true;
            } else if(target>matrix[row][col]){
                row++;
            } else{
                col--;    
            }
        }
        
        return false;
    }

}
