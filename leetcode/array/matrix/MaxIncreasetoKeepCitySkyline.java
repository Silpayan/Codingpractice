package leetcode.array.matrix;

public class MaxIncreasetoKeepCitySkyline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

		System.out.println("Total Height Increased : "+maxIncreaseKeepingSkyline(grid));
		
		printArray2D(grid);
	}

	public static int maxIncreaseKeepingSkyline(int[][] grid) {
        
		if(grid.length == 0)
			return 0;
		
		int heightIncrease = 0;
        int topView[] = new int[grid.length];
        int sideView[] = new int[grid.length];
        //Brute force
        //first determine max height of bottom and top view
        //then determine max height of left and right view
        for(int row=0;row<grid.length;row++) {
			for(int col=0;col<grid[row].length;col++) {
				topView[col] = topView[col]>grid[row][col]?topView[col]:grid[row][col];
				sideView[row] = sideView[row]>grid[row][col]?sideView[row]:grid[row][col];
			}
			//System.out.println();
		}

        /*System.out.println("\nSide View : " );
        for(int a:sideView) {
        	System.out.print(a+" ");
        }
        System.out.println("\nTop View : " );
        for(int a:topView) {
        	System.out.print(a+" ");
        }*/
       
        
        //Determine Increase required
        for(int row=0;row<grid.length;row++) {
			for(int col=0;col<grid[row].length;col++) {
				int newHeight = topView[col]<sideView[row]?topView[col]:sideView[row];
				heightIncrease += newHeight - grid[row][col];
				grid[row][col] = newHeight;				
			}
			//System.out.println();
		}
        
        return heightIncrease;
    }
	
	public static void printArray2D(int matrix[][]) {
		System.out.println("\nArray2D:");
		for(int row=0;row<matrix.length;row++) {
			for(int col=0;col<matrix[row].length;col++) {
				System.out.print(matrix[row][col]+" ");
			}
			System.out.println();
		}
	}
}
