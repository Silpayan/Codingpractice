package leetcode.array.matrix;

/*
 * 
 *311. Sparse Matrix Multiplication
Medium

520

201

Add to List

Share
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]
  
3X2    2X2 => 3X2
  |    | Iner ignored
Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 * 
 */

public class SparseMatrixMultiplication_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[][] = { { 1, 0, 0},
				  {-1, 0, 3}},
		
			B[][] = {{ 7, 0, 0 },
				  	 { 0, 0, 0 },
				  	 { 0, 0, 1 }};
		
		int mat[][] = multiply(A, B);
		
		for(int a[]:mat) {
			for(int b:a)
				System.out.print(b+", ");
			System.out.println();
		}

	}
	
	public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;   
    }

}
