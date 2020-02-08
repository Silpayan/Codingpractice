package leetcode.sorting;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {10,9,2,5,3,7,101,18};//{1,2,3,4,5,6,};
		
		LongestIncreasingSubsequence list = new LongestIncreasingSubsequence();
		
		System.out.println("Length : "+list.lengthOfLIS(nums));
	}
	
	public int lengthOfLIS(int[] nums) {
		int len=1, start = 0, trailLen = 1;
		
		if(nums.length==0)
			return 0;
		
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]<nums[i+1]) {
				System.out.println("len = "+len+" trailLen = "+trailLen+" nums[i] = "+nums[i]);
				trailLen++;
				if(trailLen>len) {
					len = trailLen;
					//start = len-i;
				}
			}
			else {
				trailLen = 1;
				
			}
			
		}
		
		return len;
    }

}
