package leetcode.array;

import java.util.HashMap;

/*
 * 325 Maximum Size Subarray Sum Equals k  
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range
 */

public class MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,1,-1,6,-2,2,-2,0};
		System.out.println(new MaximumSizeSubarraySumEqualsk().maxSubArrayLen(nums,4));
	}
	

	public int maxSubArrayLen(int[] nums, int k) {
		
		int result = 0;
		
		if(nums==null || nums.length==0) {
			return result;
		}

		int sum = 0;
		
	    HashMap<Integer, Integer> map = new HashMap<>();
	    map.put(sum, -1); 	
	    
	    for(int i=0; i<nums.length; i++){
	        sum += nums[i];
	        if(map.containsKey(sum - k)){
	        	System.out.println(i+" "+sum+" Result "+result+" "+map+" "+map.get(sum - k));
	            result = Math.max(result, i - map.get(sum - k));
	        }
	        map.putIfAbsent(sum, i);
	        
	    }
	 
	    return result;
	}

}
