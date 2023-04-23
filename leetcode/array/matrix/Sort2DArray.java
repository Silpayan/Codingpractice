package leetcode.array.matrix;

public class Sort2DArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix =   {{5, 12, 17, 21, 23},
                            {1, 2, 4, 6, 8},
                            {12, 14, 18, 19, 27},
                            {3, 7, 9, 15, 25}};

        printArray2D(matrix);

        int[][] sortedMatrix = sort2DArray(matrix);

        printArray2D(sortedMatrix);

    }

    private static int[][] sort2DArray(int[][] matrix) {
        // TODO Auto-generated method stub
        int[][] sortedMatrix = new int[matrix.length][matrix[0].length];
        int min = Integer.MAX_VALUE;

        System.out.println("Sortig");

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                //System.out.print(matrix[row][col]+" ");
                //sortedMatrix[col][row] = minofRows()
                if (min > matrix[row][col])
                    min = matrix[row][col];
                System.out.print(" min = " + min + " ");
            }
            //incomplete

            System.out.println();
        }


        return sortedMatrix;
    }

    public static void printArray2D(int[][] matrix) {
        System.out.println("Array2D:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
