package leetcode.array.matrix;

public class RotateMatrix90Degree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {
						{ 5, 1, 9,11},
						{ 2, 4, 8,10},
		               	{13, 3, 6, 7},
		               	{15,14,12,16}
						};
		
		int mat1[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				};
		
		rotate(mat1);
		
		for(int a[]:mat1) {
			for(int b:a)
				System.out.print(b+", ");
			System.out.println();
		}
	}
	
	 public static void rotate(int[][] matrix) {
		 
		 for(int layer = 0; layer<=matrix.length/2; layer++) {
			 
				for (int i = layer; i < matrix.length-layer-1; i++) {
					
					 int top = matrix[layer][i]; // save top
						// left -> top
						matrix[layer][i] = matrix[matrix.length - 1 - i ][layer];
						// bottom -> left
						matrix[matrix.length - 1 - i ][layer] = matrix[matrix.length - 1 - layer][matrix.length-1- i];
						// right -> bottom
						matrix[matrix.length - 1 - layer][matrix.length-1- i] = matrix[i][matrix.length - 1 - layer];
						// top -> right
						matrix[i][matrix.length - 1 - layer] = top; // right <- saved top
				}
		 }
	    }
}
