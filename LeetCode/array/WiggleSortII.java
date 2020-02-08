package leetcode.array;


//324. Wiggle Sort II

public class WiggleSortII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,7,3,4,5,6};
		wiggleSort(num);
		
		System.out.println("Array after wiggle");
		for(int i=0;i<num.length; i++)
			System.out.print(num[i]+" ");
		
		int[] num1 = {8, 3, 2, 2, 3, 1};
		
		wiggleSort(num1);
		
		System.out.println("\nArray after wiggle");
		for(int i=0;i<num1.length; i++)
			System.out.print(num1[i]+" ");

	}
	
	public static void wiggleSort(int[] nums) {
		
		for(int i=0;i<nums.length-1; i++) {
			if(i%2==0 && nums[i]>=nums[i+1]) {//for even positions i.e. 0,2,4,6,8,10...
				int temp = nums[i];
				nums[i]=nums[i+1];
				nums[i+1]=temp;
				
			} else
				if(nums[i]<nums[i+1]) { //for odd positions i.e. 1,3,5,7...
					int temp = nums[i];
					nums[i]=nums[i+1];
					nums[i+1]=temp;
				}
			//i++;
		}
        
    }

}
