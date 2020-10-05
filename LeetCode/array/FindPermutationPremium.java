package leetcode.array;

import java.util.Arrays;
import java.util.Stack;

/*
 * 484. Find Permutation Medium

By now, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a decreasing relationship between two numbers, 'I' represents an increasing relationship between two numbers. And our secret signature was constructed by a special integer array, which contains uniquely all the different number from 1 to n (n is the length of the secret signature plus 1). For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing special string that can't represent the "DI" secret signature.

On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] could refer to the given secret signature in the input.

Example 1:
Input: "I"
Output: [1,2]
Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", where the number 1 and 2 construct an increasing relationship.
Example 2:
Input: "DI"
Output: [2,1,3]
Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI", 
but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
 * 
 */
public class FindPermutationPremium {

	
	public static int[] findPermutation(String s) { //Using Stack
        int[] res = new int[s.length() + 1];
       Stack < Integer > stack = new Stack < > ();
       int j = 0;
       for (int i = 1; i <= s.length(); i++) {
           if (s.charAt(i - 1) == 'I') {
               stack.push(i);
               while (!stack.isEmpty())
                   res[j++] = stack.pop();
           } else
               stack.push(i);
       }
       stack.push(s.length() + 1);
       while (!stack.isEmpty())
           res[j++] = stack.pop();
       return res;
   }
	
	 public int[] findPermutationReversing(String s) {//eversing the subarray
	        int[] res = new int[s.length() + 1];
	        for (int i = 0; i < res.length; i++)
	            res[i] = i + 1;
	        int i = 1;
	        while (i <= s.length()) {
	            int j = i;
	            while (i <= s.length() && s.charAt(i - 1) == 'D')
	                i++;
	            reverse(res, j - 1, i);
	            i++;
	        }
	        return res;
	    }
	    public void reverse(int[] a, int start, int end) {
	        for (int i = 0; i < (end - start) / 2; i++) {
	            int temp = a[i + start];
	            a[i + start] = a[end - i - 1];
	            a[end - i - 1] = temp;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int res[] = findPermutation("DIID");
		System.out.println(Arrays.toString(res));
		
		res = findPermutation("IID");
		System.out.println(Arrays.toString(res));
	}

}
