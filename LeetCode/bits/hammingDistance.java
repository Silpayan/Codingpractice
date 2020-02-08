package leetcode.bits;

public class hammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingDistance(1,9));
		

	}

	public static int hammingDistance(int x, int y) {
		int i=0;
        int count=0;
        int r=0, p=0;
        while(i<32){
            r=x&1;
            p=y&1;
            if(r!=p){count++;}
            x>>=1; y>>=1; i++;
        }
        return count;
    }
}
