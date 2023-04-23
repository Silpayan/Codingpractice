package leetcode.dp;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 2, 3, 1 };
		System.out.println(rob(nums));
		for (int a : nums) {
			System.out.print(a + " ");
		}

		System.out.println();

		int nums1[] = { 2, 7, 9, 3, 1 };
		System.out.println(rob(nums1));

		for (int a : nums1) {
			System.out.print(a + " ");
		}

	}

	public static int rob(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return nums[0]>nums[1]?nums[0]:nums[1];
		}

		int maxBeforeCurrentIndex = nums[0];
		int maxTillCurrentIndex = nums[1];

		for (int i = 2; i < nums.length; i++) {
			nums[i] = maxBeforeCurrentIndex + nums[i];//Adding current and updating current value with the sum
			maxBeforeCurrentIndex = maxBeforeCurrentIndex>maxTillCurrentIndex?maxBeforeCurrentIndex:maxTillCurrentIndex;
			maxTillCurrentIndex = nums[i];
		}

		return maxBeforeCurrentIndex>maxTillCurrentIndex?maxBeforeCurrentIndex:maxTillCurrentIndex;
	}

}
