package leetcode.search;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 4,5,6,7,0,1,2 }, target = 0; // 4,5,6,7,0,1,2
		System.out.println(search(nums, target));
	}

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		while (left <= right) {
			int mid = (right + left) / 2;
			
			if (nums[mid] == target)
				return mid;
			
			else if (nums[mid] <= nums[right]) { // check if right half is sorted
				if (target > nums[mid] && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			} else { // left half is sorted
				if (target >= nums[left] && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
		}

		return -1;
	}

	public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length;

		while (left <= right) {
			int mid = (right + left) / 2;
			System.out.println(mid);
			if (nums[mid] == target) {
				return mid;
			}

			if (target < nums[mid]) {// &&
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return -1;
	}

}
