package leetcode.array.matrix;

public class TransposeMatrix {

	public static void main(String[] args) {
		int mat[][] = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

		int mtx[][] = { { 1, 2, 3 }, { 4, 5, 6 } };

		for (int a[] : mat) {
			for (int b : a)
				System.out.print(b + ", ");
			System.out.println();

		}
		System.out.println();
		
		mat = transposeMXMby2(mat);

		System.out.println("\nTransposed : ");
		for (int a[] : mat) {
			for (int b : a)
				System.out.print(b + ", ");
			System.out.println();

		}
	}

	public static int[][] transpose(int[][] A) {

		int B[][] = new int[A[0].length][A.length];
		for (int row = 0; row < A.length; row++) {
			for (int col = 0; col < A[0].length; col++) {
				B[col][row] = A[row][col];
			}
		}

		return B;
	}

	public static int[][] transposeMXMby2(int[][] A) { //No extra space for answer matrix works when it Row=Column

		// int B[][] = new int[A[0].length][A.length];
		for (int row = 0; row < A.length; row++) {
			for (int col = row; col < A[0].length; col++) {
				// swap non diagonal elements
				if (row != col) {
					int temp = A[row][col];
					A[row][col] = A[col][row];
					A[col][row] = temp;
				}
				System.out.print(A[row][col]+", ");
			}
			System.out.println();
		}
		
		return A;
	}
}
