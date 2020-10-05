package leetcode.string;

/*
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
direction can be 0 (for left shift) or 1 (for right shift).
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.
 */
public class PerformStringShifts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "mecsk";
		int shift[][] = {{1,4},{0,5},{0,4},{1,1},{1,5}}; //kmecs
					  // ecskm ecskm mecsk kmecs kmecs  
		System.out.println(new PerformStringShifts().stringShift( s, shift));
	}
	
	
	public String stringShift(String s, int[][] shift) {
        int shft = 0;
        if(shift == null || shift.length == 0) return s;
        //0 = left
        //1 = right
        /*      0,2 
        
        */
        System.out.println(s);

        int n=s.length();
        
        for(int []a : shift){
            /*if(left==-1) {//first in the array
                left = a[0]; //check again
                shft = a[1];
            }*/
            //else {
            shft += (a[0]==0?-a[1]%n:a[1]%n);//left shift - right +
            System.out.println(shft);
       
                
            //}
            
        }
        
        //abcdefg 3  = s.substring(3+1,n)+s.substring(0,3);  efgabcd
        //abcdefg -3  = s.substring(0,3)+s.substring(3+1,2); 
        
       return s.substring(shft+1,n)+s.substring(0,shft+1);
        
    }

}
