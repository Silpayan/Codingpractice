package G4G;

public class NumberPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 1987791;
		if(num==revers(num))
			System.out.println("Palindrome Number");
		else 
			System.out.println("Not Palindrome Number");

	}
	
	static int revers(int num) {
		int newNum = 0;
		
		while(num>0) {
			newNum=newNum*10+num%10;
			//System.out.println(newNum);
			num/=10;
		}
		
		return newNum;
		
	}

}
