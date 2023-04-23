package leetcode.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;

/*
 * 
340. Longest Substring with At Most K Distinct Characters
Hard

Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.

Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

FB, MS, Google, Amazon
 * 
 */
public class LongestSubstringwithAtMostKDistinctCharacters_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "eceba";
		
		System.out.println( new LongestSubstringwithAtMostKDistinctCharacters_Premium().lengthOfLongestSubstringKDistinct(s, 2));
		
		s = "aa";
		System.out.println( new LongestSubstringwithAtMostKDistinctCharacters_Premium().lengthOfLongestSubstringKDistinct(s, 1));
		
	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
	    int n = s.length();
	    if (n*k == 0) return 0;

	    // sliding window left and right pointers
	    int left = 0;
	    int right = 0;
	    // hashmap character -> its rightmost position 
	    // in the sliding window
	    HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

	    int max_len = 1;

	    while (right < n) {
	      // add new character and move right pointer
	      hashmap.put(s.charAt(right), right++);

	      // slidewindow contains 3 characters
	      if (hashmap.size() > k) {
	        // delete the leftmost character
	        int del_idx = Collections.min(hashmap.values());
	        hashmap.remove(s.charAt(del_idx));
	        // move left pointer of the slidewindow
	        left = del_idx + 1;
	      }

	      max_len = Math.max(max_len, right - left);
	    }
	    return max_len;
	  }

}
