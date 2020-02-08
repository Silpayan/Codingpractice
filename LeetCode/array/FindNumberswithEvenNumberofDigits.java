package leetcode.array;

public class FindNumberswithEvenNumberofDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {580,317,640,957,718,764};
		System.out.println(new FindNumberswithEvenNumberofDigits().findNumbers(nums));
	}
	
	public int findNumbers(int[] nums) {
		
		int count = 0;
        
		for(int a:nums) {
			int lenCnt = 0;
			while(a!=0) {
				System.out.println(a);
				a/=10;
				lenCnt++;
				
			}
			if(lenCnt%2==0) {
				count++;
			}
		}
		
		return count;
    }
	

}
