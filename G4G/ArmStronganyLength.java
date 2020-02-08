package G4G;

import java.util.Scanner;

public class ArmStronganyLength {
	//find the power or the length of the i/p
	public static int findPower(int x) {
		int n=0;
				
		while(x>0) {
			n++;
			x/=10;
		}
		
		return n;
	}
	
	
	
	//Code to drive test
	public static void main(String [] s) {
		System.out.print("Input for Armstrong test : ");
		Scanner keyboard= new Scanner(System.in);
		int isArmStrng = keyboard.nextInt();
		int ipLen = findPower(isArmStrng);
		System.out.println("Length of the i/p : "+ ipLen);
		
		System.out.println(isArmStrng(isArmStrng, ipLen));	
		
		keyboard.close();
	}



	private static boolean isArmStrng(int isArmStrng, int ipLen) {
		// TODO Auto-generated method stub
		int validator = 0, x= isArmStrng;
		
		while(x > 0) {
			
			validator += Math.pow(x%10, ipLen);
			x/=10;
			System.out.println(x);
			
		}
		System.out.println(isArmStrng+"=="+validator);
		return isArmStrng==validator;
	}
	
	

}
