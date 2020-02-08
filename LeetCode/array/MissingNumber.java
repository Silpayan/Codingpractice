package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		System.out.println(missingNumber(nums));
		
		System.out.println(missingNumberHashSet(nums));
		
		System.out.println(missingNumberXOR(nums));
	}
/*
 * int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
 */
	public static int missingNumber(int[] nums) {
		int total = nums.length*(nums.length + 1)/2;
		//int max = 0;

		//System.out.println(total + " Max : " + max);

		for (int i = 0; i < nums.length; i++) {
			total -= nums[i];
		}
		//System.out.println(total + " Max : " + max);
		return total;
	}

	public static int missingNumberHashSet(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		for (int num : nums)
			numSet.add(num);

		int expectedNumCount = nums.length + 1;
		for (int number = 0; number < expectedNumCount; number++) {
			if (!numSet.contains(number)) {
				return number;
			}
		}
		return -1;
	}
	
	public static int missingNumberXOR(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
            System.out.println(missing+" nums["+i+"] : "+nums[i]);
        }
        return missing;
    }
}
