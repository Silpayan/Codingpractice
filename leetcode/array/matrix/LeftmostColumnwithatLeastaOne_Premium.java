package leetcode.array.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 1428	Leftmost Column with at Least a One
 * 
 * 
A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
You can’t access the Binary Matrix directly. You may only access the matrix using a 
BinaryMatrix interface: BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [m, n], which means the matrix is m * n.
https://medium.com/@sumukhballal/leftmost-column-with-at-least-a-one-problem-leetcode-57361bb66bf6
 */
public class LeftmostColumnwithatLeastaOne_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{0,0,0,0,1},{0,0,0,1,1},{0,0,1,1,1},{0,0,1,1,1},{0,0,1,1,1}};
		
		System.out.println(new LeftmostColumnwithatLeastaOne_Premium().leftMostColumnWithOne(new BinaryMatrix(mat)));
	}

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension=binaryMatrix.dimensions();
        int n=dimension.get(0);
        int m=dimension.get(1);
       
        int row=0,col=m-1,leftMostOne=-1;
        
        while(row<n && col>=0)
        {
            int value=binaryMatrix.get(row,col);
            if(value==0)
              row++;
            else{
                leftMostOne=col;
                col--;
             }
        } 
        return leftMostOne;
    }
	
}

class BinaryMatrix{

	int mat [][];
	
	BinaryMatrix(int [][]m){
		mat = m;
	}
	int get(int x, int y) {
		return mat[x][y];
	}
	List<Integer> dimensions() {
		List<Integer> size = new ArrayList<Integer>();
		size.add(mat.length);
		size.add(mat[0].length);
		return size;
	}

}

