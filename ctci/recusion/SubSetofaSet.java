package ctci.recusion;

import java.util.ArrayList;
import java.util.List;

import leetcode.dp.Permutations;

public class SubSetofaSet {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3 };
		
		System.out.println(new SubSetofaSet().getSubsets2(nums));
	}


	ArrayList<ArrayList<Integer>> getSubsets2(int[] set) {

		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.length; /* Compute 2^n */
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertlntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}

	ArrayList<Integer> convertlntToSet(int x, int[] set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set[index]);
			}
			index++;
		}
		return subset;
	}

}
