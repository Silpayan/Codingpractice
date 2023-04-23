package leetcode.array;

import java.util.HashMap;

/*
 * 560. Subarray Sum Equals K
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,1,-1,6,-2,2,-2,0};
		System.out.println(new SubarraySumEqualsK().subarraySum(nums,4));
	}
	
    public int subarraySum(int[] nums, int k) {
        int result = 0, sum = 0;
		
		if(nums==null || nums.length==0) {
			return result;
		}

		
	    HashMap<Integer, Integer> map = new HashMap<>();
	    map.put(sum, 1); 	
	    
	    for(int i=0; i<nums.length; i++){
	        sum += nums[i];
	        if(map.containsKey(sum - k)){
	        	System.out.println(i+" "+sum+" Result "+result+" "+map+" "+map.get(sum - k));
	            result += map.get(sum - k);
	        }
	        map.put(sum, map.getOrDefault(sum, 0) + 1);
	        
	    }
	 
	    return result;
    }

}
