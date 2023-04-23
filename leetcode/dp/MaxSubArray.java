package leetcode.dp;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,4,6,8,-9,1,5,3,1};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
		if(nums==null || nums.length==0)
				return 0;
		int sum, trailSum;
		sum = trailSum = nums[0];
		
		for(int i=1;i<nums.length;i++) {
			if(nums[i]>trailSum+nums[i])
				trailSum = nums[i];
			else
				trailSum += nums[i];
			
			if(trailSum>sum){
				sum=trailSum;
			}
			System.out.println(trailSum+" "+sum);
		}
        return sum;
    }
	
	public static int maxSubArrayFast(int[] nums) {
        int max=Integer.MIN_VALUE, localMax=0;
        for(int i=0;i<nums.length;i++){
            localMax+=nums[i];
            if(localMax>max)
                max=localMax;
            if(localMax<0)
                localMax=0;
        }
        return max;
    }

}
