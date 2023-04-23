package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences {
	/*
	 * #659 Given an array nums sorted in ascending order, return true if and only
	 * if you can split it into 1 or more subsequences such that each subsequence
	 * consists of consecutive integers and has length at least 3.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = {1,2,3,6,7,8,10,11};//{1,2,3,6,7,8,10,11};//{1,2,2,3,3,4,4,5,5,6,8};//1,2,3,3,4,5

		System.out.println("Split Array into Consecutive Subsequences possible? : " + isPossibleSoln(nums));

	}

	public static boolean isPossible(int[] nums) {
		// boolean isPossible = false;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		int seqLen = 0;
		if (nums.length < 6)
			return false;
		m.put(nums[0], 1);
		for (int i = 1; i < nums.length; i++) {
			 if(!(nums[i]-nums[i-1]==1 || nums[i]==nums[i-1])) {
				System.out.println("Returning False as not sequence"+ nums[i]+nums[i-1]);
				 return false;
			 }
			if (m.containsKey(nums[i])) {
				m.put(nums[i], m.get(nums[i]) + 1);
			} else
				m.put(nums[i], 1);
		}
		int prev = 0;
		for (int a : m.keySet()) {
			System.out.println(a+","+m.get(a));
			//if (!(prev == 0 || prev == a || prev + 1 == a))
			//	return false;
			if (m.get(a) == 1)
				seqLen++;
			else if (m.get(a) == 2)
				seqLen+=2;
			else
				return false;
			prev=a;
		}
		System.out.println("seqLen = "+seqLen);
		return seqLen < 6 ? false : true;
		
	}
	
	 public static boolean isPossibleSoln(int[] nums) {
	        Counter count = new Counter();
	        Counter tails = new Counter();
	        for (int x: nums) count.add(x, 1);

	        for (int x: nums) { //traversing the nums[] again and checking the Map
	        	System.out.println(x);
	            if (count.get(x) == 0) {//Some integer was 1 and moved to trail and value became 0 so this becomes true
	                continue; 
	            } else if (tails.get(x) > 0) {
	                tails.add(x, -1);
	                tails.add(x+1, 1);//To make sure x+1 is already present for the second Map for second array
	            } else if (count.get(x+1) > 0 && count.get(x+2) > 0) {
	                count.add(x+1, -1);
	                count.add(x+2, -1);
	                tails.add(x+3, 1);
	            } else {
	                return false;
	            }
	            count.add(x, -1);
	        }
	        return true;
	    }
	}

	class Counter extends HashMap<Integer, Integer> {
	    public int get(int k) {
	        return containsKey(k) ? super.get(k) : 0;
	    }

	    public void add(int k, int v) {
	        put(k, get(k) + v);
	    }
	
}
