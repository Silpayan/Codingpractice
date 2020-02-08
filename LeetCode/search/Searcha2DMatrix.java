package leetcode.search;

public class Searcha2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = { { 1, 3 } };	//{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
								//{ { 1, 3 } };	
								// { {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50} }

		int target = 1;
		System.out.println(new Searcha2DMatrix().searchMatrixLC(matrix, target));
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null)
			return false;
		if (matrix.length == 0)
			return false;
		if (matrix[0].length == 0)
			return false;

		int start1 = 0, start2 = 0;
		int end1 = matrix.length, end2 = matrix[0].length;

		while (start1 + start2 <= end1 + end2) {
			int mid1 = (start1 + end1) / 2;
			int mid2 = (start2 + end2) / 2;

			System.out.println(mid1 + " " + mid2);

			if (matrix[mid1][mid2] == target) {
				System.out.println(mid1 + " " + mid2);
				return true;
			} else if (matrix[mid1][mid2] < target) {// search right side if mid leass than target
				start1 = mid1;
				start2 = mid2 + 1;
				if (start2 == matrix[0].length) {// fixing row out of index >length
					start2--;
					start1++;
					if (start1 == matrix.length) {
						System.out.println("Returning false as start1 == matrix.length");
						return false;// end of matrix reached still no match found!
					}
				}

			} else {
				end1 = mid1;
				end2 = mid2 - 1;
				if (end2 < 0) { // fixing row out of index <0
					end2 = matrix[0].length;
					end1--;
					if (end1 < 0) {// end of matrix reached still no match found!
						System.out.println("Returning false as end1<0");
						return false;
					}
				}
			}

		}
		return false;
	}
	
	
	public boolean searchMatrixLC(int[][] matrix, int target) {
		
		int row_num = matrix.length;
		int col_num = matrix[0].length;
		
		int begin = 0, end = row_num * col_num - 1;
		
		while(begin <= end){
			int mid = (begin + end) / 2;
			int mid_value = matrix[mid/col_num][mid%col_num]; ///*****mid/col_num*/
			
			if( mid_value == target){
				return true;
			
			}else if(mid_value < target){//moving the search scope to right
				//Should move a bit further, otherwise dead loop.
				begin = mid+1;
			}else{
				end = mid-1;
			}
		}
		
		return false;
	}
}
