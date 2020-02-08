package leetcode.maths;

public class SuperPow_aPbMod1337 {

	public static void main(String s[]) {
		SuperPow_aPbMod1337 p = new SuperPow_aPbMod1337();
		int b[] = {2,0,0};
		System.out.println(p.superPow(2147483647,b));
	}

	public int superPow(int a, int[] b) {
        
		if(b==null || b.length == 0) return 0;
		if(a==0 || a==1) return a;
		
		int ans = 1;
		
		
        for(int p:b) {
        	int tmp = myPow(a, p);
            ans = ( myPow(ans, 10) * tmp) % 1337;
        }
        
        System.out.println(ans);
        
		return ans; //1198
    }
	

	 int helper(int x, int n){
	        if(n == 0){
	            return 1;
	        }
	        if(n == 1){
	            return x;
	        }
	        int res = myPow(x, n/2);//binary tree type calculation for each 1/2
	        System.out.println(res+" "+x+" "+n);
	        return res * res * (n % 2 == 0 ? 1 : x);//multiplyong by 1 if n is even and by x if n is odd
	    }
	 
	 
	    public int myPow(int a, int pow) {
	    	if(a > 1337) a %= 1337;
	        int ans = 1;
	        for(int i=0;i<pow;i++){
	            ans *= a;
	            if(ans > 1337) ans %= 1337;
	        }
	        return ans;
	    }
}
