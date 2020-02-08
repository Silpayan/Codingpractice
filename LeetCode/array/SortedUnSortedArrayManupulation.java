package leetcode.array;

import java.util.Arrays;

public class SortedUnSortedArrayManupulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {0,1,1,1,1,2,2,3,3,4,5};
		//int len = removeDuplicates(nums);
		
		System.out.println("Array Contain Duplicate? "+containsDuplicate(nums));
		
		//System.out.println("Array length now : "+len+ " Array ");
		for(int a:nums) {
			System.out.print(a);
		}
		
		int nums1[] = {1,2,3,4,5,6,7,10};
		//len =removeDuplicates(nums1);
		
		System.out.println("\nArray Contain Duplicate? "+containsDuplicate(nums1));
		
		//System.out.println("Array length now : "+len);
		
		int oneUnique[] = {2,2,1};
	
		System.out.println("One Unique number is : "+singleNumber(oneUnique));
		
		int oneUnique1[] = {4,1,2,1,2};
		
		System.out.println("One Unique number is : "+singleNumber(oneUnique1));
		
	}

	public static int removeDuplicates(int[] nums) {
		
		if(nums == null || nums.length==0) {
			return 0;
		}
        int length = 1;
        
        for(int i = 1; i<nums.length;i++) {
   
        	
        	if(nums[i] == nums[i-1]) {
        		continue;
        	}else {
        		nums[length++] = nums[i];//just copy the uniqe at the length location
        	}

        	
        }
        
		
		
		return length;
    }
	
	public static boolean containsDuplicate1(int[] nums) {
		
		for(int i=0;i<nums.length; i++) {
			for(int j = 0; j<nums.length; j++) {
				if(nums[i] == nums[j] && i!=j) {
					System.out.println(" i  = "+i+" j = "+j);
					return true;
					
				}
			}
		}
		
		return false;
	}
	
	public static boolean containsDuplicate(int[] nums) {
		
		Arrays.sort(nums);
		
		for(int i=1;i<nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				System.out.println(" i  = "+i);
				return true;
				
			}
		}
		
		return false;
	}
	
	 public static int singleNumber(int[] nums) {
	        int singleNumber = nums[0];
	        for (int i = 1; i < nums.length; i++) {
	            singleNumber ^= nums[i];
	        }
	        
	        return singleNumber;
	    }


}
