package G4G;

public class MatrixParellel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println("Matrix : ");
		
		printMatrix(matrix);
		
		spiralPrintMatrix(matrix);
		
		
	}

	private static void spiralPrintMatrix(int[][] matrix) {
		
		for(int row=0;row<matrix.length;row++) {
			for (int col=0;col<matrix[row].length;col++) {
				System.out.print(matrix[row][col]+ " ");
			}
			System.out.println();
		}
		
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;

				System.out.println(matrix[first][i]); // top
				// left, top
				System.out.println(matrix[last - offset][first]);
				// bottom, left
				System.out.println(matrix[last][last - offset]);
				// right, bottom
				System.out.println(matrix[i][last]);
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for(int row=0;row<matrix.length;row++) {
			for (int col=0;col<matrix[row].length;col++) {
				System.out.print(matrix[row][col]+ " ");
			}
			System.out.println();
		}
	}

}
