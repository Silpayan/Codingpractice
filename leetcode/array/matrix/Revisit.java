package leetcode.array.matrix;

public class Revisit {

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
		
		rotate90(mat1);
		
		for(int a[]:mat1) {
			for(int b:a)
				System.out.print(b+", ");
			System.out.println();
		}
	}

	private static void rotate90(int[][] mat) {

		for(int layer = 0; layer<=mat.length/2 ; layer++) {
			for(int col = 0; col<mat[0].length; col++){

			}
		}
	}

}
