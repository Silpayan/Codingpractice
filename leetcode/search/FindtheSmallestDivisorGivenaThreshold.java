package leetcode.search;
/*
 * 1283. Find the Smallest Divisor Given a Threshold
 * 
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 * Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * It is guaranteed that there will be an answer.
 */
public class FindtheSmallestDivisorGivenaThreshold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {909771,973275,979226,934386,981517}, threshold =11;//{2,3,5,7,11}, threshold = 11;
		System.out.println(smallestDivisor(nums, threshold));
	}
	
	public static int smallestDivisor(int[] nums, int threshold) {
        int divL = 1;//Try with primes.   Actually Binary search!!! :-P
        
        
        int divH = nums[0];
        for(int num: nums){
        	divH = Math.max(divH, num);
        }
        
        System.out.println(divH);
        
        while(divL<divH) {
        	int divM = (divL+divH)/2;
        	int divSum = 0;
        	
        	for(int a : nums) {
        		
        		divSum += a/divM;
        		if(a%divM!=0)
        			divSum++;
        	}
        
        	System.out.println(divM+" "+divSum);
        	
        	if(divSum>threshold)
        		divL = divM+1;
        	else
        		divH = divM;
        	
        	System.out.println(divL+" "+divH);
        }
        
        return divL;
    }

}
