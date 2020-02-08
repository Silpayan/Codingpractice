package leetcode.array;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {1,2,3,4};
		
		ProductofArrayExceptSelf prod = new ProductofArrayExceptSelf();
		
		int result[] = prod.productExceptSelf(nums);
		System.out.println("Result : ");
		for(int a:result)
			System.out.print(a+" ");

	}

	public int[] productExceptSelf(int[] nums) {
    
		int result[] = new int[nums.length];
		result[0] = 1;
		for(int i=1;i<nums.length;i++) {
			result[i] = result[i-1] * nums[i-1];
		}
		
		for(int a:result)
			System.out.print(a+" ");
		
		int r=1;
		
		for(int i=nums.length-1;i>=0;i--) {
			result[i] = result[i]*r;
			r *= nums[i];
		}
		
		return result;
    }
}
