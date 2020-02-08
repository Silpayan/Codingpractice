package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	/*
	 * 18. 4Sum Given an array nums of n integers and an integer target, are there
	 * elements a, b, c, and d in nums such that a + b + c + d = target? Find all
	 * unique quadruplets in the array which gives the sum of target.
	 * 
	 * https://www.youtube.com/watch?v=bixvM1-28us
	 */
	public static void main(String[] args) {

		int nums[] = { 1, 0, -1, 0, -2, 2 }, target = 0;
		FourSum fs = new FourSum();
		System.out.println(fs.fourSum(nums, target));
	}

	public List<List<Integer>> fourSumSelf(int[] nums, int target) {

		List<List<Integer>> lists = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0)
			return lists;

		//List<Integer> list = new ArrayList<Integer>(7);
		sumHelper(nums, lists, target, new ArrayList<>(7), 0);

		return lists;
	}

	private void sumHelper(int[] nums, List<List<Integer>> lists, int targetSum, List<Integer> tempList, int runningSum) {

		if (tempList.size() == 4) {
			if(runningSum == targetSum) {
				lists.add(new ArrayList<>(tempList));
				System.out.println(tempList+ " "+runningSum+" "+targetSum);
			}
			return;
		} else if(tempList.size()<4){
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != Integer.MIN_VALUE) {
					runningSum += nums[i];
					tempList.add(nums[i]);
					nums[i] = Integer.MIN_VALUE;
					System.out.println(i + " " + i+ " "+runningSum+ " "+targetSum);
					sumHelper(nums, lists, targetSum, tempList, runningSum);
					nums[i] = tempList.get(tempList.size() - 1);
					tempList.remove(tempList.size() - 1);
					
				}
			}
		}
	}
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {//Finding 3Sum for each element in the array
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < nums.length - 2; j++) {//Finding 2Sum for each element in the array
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                int left = j + 1;
                int right = nums.length - 1;
                
              //Now for each nums[i], nums[j] traversing the sorted array to make the targetSum with 2 element from remaining part of the array
              //Since the Array is sorted selecting the complementary value by 2 pointer search
                while (left < right) { 
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[left]);
                        quadruplet.add(nums[right]);
                        
                        result.add(quadruplet);
                        
                        left++;
                        right--;
                        
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }                    
                }                
            }            
        }
        
        return result;
        
        // Time Complexity: O(n^3)
        // Space Complexity: O(n^3)
    }

}
