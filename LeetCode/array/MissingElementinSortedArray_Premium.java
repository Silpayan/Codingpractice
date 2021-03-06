package leetcode.array;

/*
 * 1060
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * 
 */
public class MissingElementinSortedArray_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {4,7,9,10};
		
		System.out.println(new MissingElementinSortedArray_Premium().missingElement(nums, 10000));
		
		int []nums1 = {4,7,9,10};
		System.out.println(new MissingElementinSortedArray_Premium().missingElement(nums1,3));
	}

	 public int missingElement(int[] nums, int k) {
		    int n = nums.length;
		  
		      if(missing(n - 1, nums)<k){
		          return nums[n-1]+k-missing(n-1,nums);
		      }
		      
		      //binary search to find left and right 
		      //where nums[left-1]<k<nums[left]
		      int left = 0, right = n-1, pivot;
		      
		      while(left!=right){
		          pivot = (left+right)/2;
		          
		          if(missing(pivot,nums)<k) left = pivot+1;
		          else right = pivot;
		      }
		      
		      // kth missing number is greater than nums[idx - 1]
		    // and less than nums[idx]
		      return nums[left-1] + k - missing( left-1 ,nums);
		    }
		    
		    //return count of missing at index idx
		    private int missing(int idx, int []nums){
		        return nums[idx] - nums[0] - idx;
		    }
		    
}
