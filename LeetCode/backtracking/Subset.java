package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;


/*
 * 78. Subsets
 * 46. Permutations
 */
public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 2, 3};
		System.out.println("Subsets : "+subsets(nums));
		
		Subset ss= new Subset();
		//System.out.println(ss.permute(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> subset = new ArrayList<List<Integer>>();
		
		if(nums.length == 0) {
			subset.add(new ArrayList<Integer>());
			return subset;
		}
		System.out.println("subsets");
		addSubset(nums, 0, subset, new ArrayList<Integer>());
		
		return subset;
	}

	private static void addSubset(int[] nums,int index,  List<List<Integer>> subset, List<Integer> temp) {
		// TODO Auto-generated method stub
		
		subset.add(new ArrayList<>(temp));

		 if (temp.size() == nums.length) {
			 //subset.add(new ArrayList<>(temp));
	            return;
	        }
		 System.out.println(index);
	        for(int i = index; i < nums.length; i++) {
	            if (nums[i] != Integer.MIN_VALUE) {
	                temp.add(nums[i]);
	                //System.out.print("begin : "+nums[i]);
	                nums[i] = Integer.MIN_VALUE;
	                //System.out.print(" mid : "+nums[i]);
	                addSubset(nums,i, subset, temp);
	                nums[i] = temp.get(temp.size() - 1);
	                temp.remove(temp.size() - 1);
	                //System.out.print(" end :"+nums[i]);
	            }
	            //System.out.println();
	        }

	}

	/**
	 * Copied from Leetcode
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(nums, ans, new ArrayList<>());
        return ans;
    }

    private void recursion(int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                temp.add(nums[i]);
                System.out.print("begin : "+nums[i]);
                nums[i] = Integer.MIN_VALUE;
                System.out.print(" mid : "+nums[i]);
                recursion(nums, ans, temp);
                nums[i] = temp.get(temp.size() - 1);
                temp.remove(temp.size() - 1);
                System.out.print(" end :"+nums[i]);
            }
            System.out.println();
        }
    }
    
    
	/*public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> allSubsets = new ArrayList();
		
		
		if (nums.length == 0)
			return allSubsets;
		if(nums.length ==1) {
			List<Integer> subSets = new ArrayList<Integer>();
			subSets.add(nums[0]);
			allSubsets.add(subSets);
			System.out.println(allSubsets);
			return allSubsets;
		}

		for (int i = 0; i < nums.length; i++) {
			List<Integer> subSets = new ArrayList<Integer>();
			subSets.add(nums[i]);
			for (int j = 0; j < nums.length ; j++) {
				if( i != j )
					subSets.add(nums[j]);
			}
			
			allSubsets.add(subSets);
			System.out.println(allSubsets);
		}
		
		for (int i = nums.length-1; i >=0 ; i--) {
			List<Integer> subSets = new ArrayList<Integer>();
			subSets.add(nums[i]);
			for (int j = nums.length-1; j >=0 ; j--) {
				if( i != j )
					subSets.add(nums[j]);
			}
			
			allSubsets.add(subSets);
			System.out.println(allSubsets);
		}

		return allSubsets;
	}*/

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> allSubsets = new ArrayList();
		allSubsets.add(new ArrayList<Integer>());
		for (int num : nums) {
			List<List<Integer>> moreSubsets = new ArrayList();
			for (List<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubSet = new ArrayList(subset);
				newSubSet.add(num);
				moreSubsets.add(newSubSet);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}

}
