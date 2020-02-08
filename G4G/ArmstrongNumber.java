package G4G;

import java.util.*;
import java.lang.*;
import java.io.*;

public class ArmstrongNumber {

	public static void main(String a[]) {
		System.out.println("Please provice Input count :");
		Scanner keyboard= new Scanner(System.in);
		//System.out.println("provide Input :");
		
		int count= keyboard.nextInt();
		
		int i=0;
		do{
			int num = keyboard.nextInt();
			if(num<100 || num>=1000) continue;
			if(num==(Math.pow((num/100),3)+Math.pow((num%10),3)+Math.pow(((num/10)%10),3)))
				System.out.println("Yes");
			else
				System.out.println("No");
		} while(i++<count-1 && count <=31); 	
	}
}
