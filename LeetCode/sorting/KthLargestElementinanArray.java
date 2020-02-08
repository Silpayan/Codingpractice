package leetcode.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class KthLargestElementinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {3,2,3,1,2,4,5,5,6};//{3,2,1,5,6,4};
		int k = 4;
		
		KthLargestElementinanArray kth = new KthLargestElementinanArray();
		
		System.out.println(kth.findKthLargest(nums, k));
	}
	
	public int findKthLargest(int[] nums, int k) {
        
        //HashMap<Integer> sorted = new HashMap<Integer>(){};
		
		if(nums == null || nums.length ==0 || nums.length <k) {
			return 0;
		}
		
		Arrays.sort(nums);
		return nums[nums.length-k];
    }

}
