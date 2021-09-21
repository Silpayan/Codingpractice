package ctci;

import java.util.Arrays;

public class SmallestDifferance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {11, 1, 2, 15}, b[] = {127, 235, 4, 13, 19, 23 };
		
		System.out.println(new SmallestDifferance().findSmallestDifference(a, b));
		
	}
	
	private int findSmallestDifference(int []a, int []b) {
		int smallestDiff = Integer.MAX_VALUE;
		int aLen = a.length, bLen = b.length, i = 0, j = 0;
		
		Arrays.sort(a); //1, 2, 11, 15
		Arrays.sort(b); //4, 10, 19, 23, 127, 235
		
		while(i<aLen && j<bLen) {
			smallestDiff = Math.min(smallestDiff, Math.abs(a[i]-b[j]));
			
			/*move smaller index to higher so diff reduces*/
			if(a[i]<b[j]) {
				i++;
			} else {
				j++;
			}
			
		}
		
		return smallestDiff;
	}
	

}
