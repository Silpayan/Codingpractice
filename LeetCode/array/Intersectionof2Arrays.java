package leetcode.array;

public class Intersectionof2Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {1,2,3,3,4};
		int nums2[] = {2,3,4,5};
		
		int intersect[] = intersect(nums1, nums2);
		
		System.out.println("Intersection Array : ");
		
		for(int a:intersect) {
			System.out.print(a);
		}	
			
		int digits[] = {9,9,9,9,9};
		
		int plusOne[] = plusOne(digits);
			
		System.out.println("\nPlus One : ");
		for(int a:plusOne) {
			System.out.print(a);
		
		}

	}
	 public static int[] intersect(int[] nums1, int[] nums2) {
	     
		 int size = nums1.length <nums2.length?nums1.length:nums2.length, count =0;
		 int intersect[] = new int [size];  
			 
			 
		 for(int i=0;i<nums1.length;i++) {
			 for(int j=0; j<nums2.length; j++) {
				 if(nums1[i]==nums2[j]) {
					 intersect[count++]=nums1[i];
					 
					 nums1[i] = Integer.MAX_VALUE;
					 nums2[j] = Integer.MIN_VALUE;
					 
				 }
			 }
		 }
		 
		 int intersect1[] = new int[count];
		 for(int i= 0; i<count; i++) {
			 intersect1[i]=intersect[i];
		 }
		 return intersect1;
	    }
	 
	 
	 public static int[] plusOne(int[] digits) {
	        
		 int carry = 1;
		 
		 System.out.println("\nPlus One : ");
		/*	for(int a:digits) {
				System.out.print(a+" ,");
			
			}*/
			
		 for(int i=digits.length;i>0;i--) {
			 
			 digits[i-1] += carry;
			 
			 System.out.println(digits[i-1]);
			 
			 if(digits[i-1]==10) {
				 carry = 1;
				 digits[i-1] = 0;
			 }
			 else 
				 carry = 0;
			 
		 }
		 
		 if (carry == 1) {
			int digits1[] = new int[digits.length+1];
			digits1[0] = 1;
			for (int i = 1; i < digits.length+1; i++) {
				digits1[i] = digits[i-1];
			} 
			return digits1;
		} else
		 	return digits;
		 
	    }
	 
}
