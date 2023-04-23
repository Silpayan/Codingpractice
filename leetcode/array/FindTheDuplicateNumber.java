package leetcode.array;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,4,6,6,6,2,3};//{2,5,9,6,9,3,8,9,7,1};//{1,3,4,3,2};
		System.out.println(findDuplicate(nums));

	}
	
    public static int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            System.out.println(tortoise+" "+hare);
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        System.out.println("While");
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
        	System.out.println(ptr1+" "+ptr2);
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
            System.out.println(ptr1+" "+ptr2);
        }

        return ptr1;
        
    }

}
