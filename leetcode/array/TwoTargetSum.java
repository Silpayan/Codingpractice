package leetcode.array;

public class TwoTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {0,0,1,2,3};
		moveZeroes(nums);
		System.out.println("Array after moveing 0 :");
		for(int a : nums) {
			System.out.print(a+", ");
		}
	}

	public static void moveZeroes(int[] nums) {
		
		int counter = 0;
		
		for(int i=0; i<nums.length;i++) {
			if(nums[i] != 0) {//found 0 shift the array left upto the last element and fill the end with 0
				nums[counter++] = nums[i];
			}
		}	
			
		for(int i=counter;i<nums.length;i++) {
			nums[i] = 0;
		}
   }
}
