package leetcode.bits;

public class HammingWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 4294967293L;//4294967295L
		System.out.println(hammingWeight(n));
		
		System.out.println(Integer.parseInt("1111111111111111111111111111111", 2));
	}
	
	// you need to treat n as an unsigned value
    public static int hammingWeight(long n) {
        int count =0;
        if(n==0)
        	return 0;
        
        count = (int)n%2==0?0:1;
        n=n/2;
        System.out.println(n+ " count : "+count);
        
        count += hammingWeight(n);
        
        System.out.println(n+ " count : "+count);
        
    	return count;
    }

    public static int hammingWeightBit(int n) {
        int i=0;
        int count=0;
        while(i<32){
            int r=n&1;
            if(r==1){count++;}
            n>>=1;i++;
        }
        return count;
    }
}
