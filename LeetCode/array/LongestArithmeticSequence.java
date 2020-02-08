package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence {

	/*
	 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., 
A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence 
B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {20,1,15,3,10,5};
		System.out.println(longestArithSeqLength(nums));
	}
	
	public static int longestArithSeqLength(int[] A) {
		
		Try self
		 Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	        int res = 1;
	        int n = A.length;
	        Map<Integer, Integer> s = new HashMap<>();
	        s.put(A[0], 1);
	        map.put(0, s);
	        for (int i = 1; i < n; i++) {
	            Map<Integer, Integer> cur = new HashMap<>();
	            for (int j = 0; j < i; j++) {
	                int diff = A[i] - A[j];
	                cur.put(diff, 2);
	                Map<Integer, Integer> pre = map.get(j);
	                if (pre.containsKey(diff)) {
	                    cur.put(diff, pre.get(diff) + 1);
	                }
	                res = Math.max(cur.get(diff), res);
	            }
	            map.put(i, cur);
	        }
	        return res;
	    }

}
