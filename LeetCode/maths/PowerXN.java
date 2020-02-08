package leetcode.maths;

public class PowerXN {
	
	public static void main(String s[]) {
		PowerXN p = new PowerXN();
		System.out.println(p.myPow(2.0,10));
		
	}
    public double myPow(double x, int n) {
        if(n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE){
            if(x == 1){
                return 1;
            }
            if(x == -1){
                return n % 2 == 0 ? 1 : -1;
            }
            return 0;
        }
        
        if(n < 0){
            return 1 / helper(x,Math.abs(n));
        }
        
        return helper(x, n);
    }
    
    double helper(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double res = myPow(x, n/2);//binary tree type calculation for each 1/2
        return res * res * (n % 2 == 0 ? 1 : x);//multiplyong by 1 if n is even and by x if n is odd
    }
    
}