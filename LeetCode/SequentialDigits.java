package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 5124 SequentialDigits
 * 
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 */
public class SequentialDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sequentialDigits(100, 1300));
	}

	 public static List<Integer> sequentialDigits(int low, int high) {
	    	List<Integer> ret = new ArrayList<>();
	        for(int d = 1;d <= 9;d++){
	        	int val = 0;
	        	for(int e = d;e <= 9;e++){
	        		val = val * 10 + e;
	        		System.out.println(val);
	        		if(low <= val && val <= high){
	        			ret.add(val);
	        		}
	        	}
	        }
	        Collections.sort(ret);
	        return ret;
	    }
}
