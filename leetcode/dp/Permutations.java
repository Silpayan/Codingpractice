package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/*46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 * I/P: {1,2,3 }
 * [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
 */
public class Permutations {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3 };
		Permutations p = new Permutations();
		System.out.println(p.permute(nums));
		
		
		System.out.println(new Permutations().getPermsWithDups("123"));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		recursion(nums, ans, new ArrayList<>());
		return ans;
	}

	void recursion(int[] nums, List<List<Integer>> ans, List<Integer> temp) {
		if (temp.size() == nums.length) {
			ans.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != Integer.MIN_VALUE) {
				temp.add(nums[i]);
				nums[i] = Integer.MIN_VALUE;
				recursion(nums, ans, temp);
				nums[i] = temp.get(temp.size() - 1);
				temp.remove(temp.size() - 1);
			}
		}
	}

	ArrayList<String> getPermsWithDups(String str) {
		ArrayList<String> result = new ArrayList<String>();
		getPerms("", str, result);
		return result;
	}

	void getPerms(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0)
			result.add(prefix);

		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			getPerms(prefix + c, before + after, result);
		}
	}
	
	/*
	 * ctci
	 * List<List<Integer>> getPermsWithDups(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		getPerms(new ArrayList<>(), nums, result);
		return result;
	}

	void getPerms(List<Integer> temp, int[] nums, List<List<Integer>> result) {
		if (nums.length == 0) {
			result.add(new ArrayList<Integer>(temp));
			//return;
			//temp.clear();
		}

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int[] rem = new int[len-1];
			for(int j=0;j<rem.length;j++) {//coping array skipping i==j means current element.
				if(j<i) {
					rem[j] = nums[j];
					//System.out.println(rem[j]);
				} else
					if(j>=i) {
						rem[j] = nums[j+1];
						//System.out.println(rem[j]);
					}
			}
			//if (temp.indexOf(nums[i])==-1) {
				temp.add(nums[i]);//Adding current to temp list
				System.out.println(temp);
				getPerms(temp, rem, result);
			//}
		}
	}*/

}
