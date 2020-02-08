package leetcode.array;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {1}, m = 1;
		int nums2[] = {0}, n = 0;
		merge(nums1, m, nums2, n);
		
		System.out.println("Array : ");
		for(int a:nums1) {
			System.out.print(a+", ");
		}
				

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=m-1, k=n-1;
        int i=m+n-1;
        for(; i>=0 && j>=0 && k>=0 ;i--){
        	System.out.println("j = "+j+" i = "+i+"k = "+k);
            if(nums1[j]>nums2[k]){
                nums1[i]=nums1[j];
                
                j--;
            }else
            {
                nums1[i]=nums2[k];
                k--;
            }
        }
            
        System.out.println(j+", "+k);
            if(j<=0) {
            	for(;i>=0&&k>=0;i--,k--) {
            		nums1[i]=nums2[k];
            	}
            }else
            	if(k==0) {
            		//copy nums1
            	}
        
    }
}
