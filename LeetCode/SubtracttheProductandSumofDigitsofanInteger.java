package leetcode;

public class SubtracttheProductandSumofDigitsofanInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(subtractProductAndSum(705));

	}

	public static int subtractProductAndSum(int n) {
        int prod= 1, sum = 0;
        
        if(n==0)
            return 0;
        
        do{
            int digit = n%10;
            sum += digit;
            prod *= digit;
            System.out.println(digit);
            n=n/10;
        }while(n!=0);
            
        return prod-sum;
    }
}
