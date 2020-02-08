package leetcode.dp;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * 494. Target Sum
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. 
 * For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */

public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TargetSum ts = new TargetSum();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   
		int nums[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		//{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(dtf.format(LocalDateTime.now())); 
		System.out.println(ts.findTargetSumWays(nums, 18));
		
		System.out.println(LocalDateTime.now());
		System.out.println(findTargetSumWaysOln(nums, 18));
		System.out.println(LocalDateTime.now());
	}

	int count=0;
	public int findTargetSumWays(int[] nums, int S) {
        countWays(nums,0,0,S);
        return count;
        
    }
	private void countWays(int[] nums, int index, int runningSum, int targetSum) {
		
		if(index == nums.length) {
			if(runningSum == targetSum) {
				count++;
			}
		} else { //+ and - 2 options to 2 calls other as Binary tree. Complexity 2^n
			countWays(nums,index+1,runningSum+nums[index],targetSum);
			countWays(nums,index+1,runningSum-nums[index],targetSum);
		}
			
		
	}
	
	public static int findTargetSumWaysOln(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
}
