package G4G;

public class BitWise {
	public static void main(String[] args) {

		int a = 5;
		int b = -2;

		// left shift operator
		// 0000 0101<<2 =0001 0100(20)
		// similar to 5*(2^2)
		System.out.println("5<<2 = " + (5 << 2)); //5<<2 = 20
		
		a<<=2;
		System.out.println("a<<=2" + a);//220
		
		a=5;
		a>>=2;
		System.out.println("a>>=2" + a);//21
		
		// right shift operator
		// 0000 0101 >> 2 =0000 0001(1)
		// similar to 5/(2^2)
		System.out.println("5>>2 = " + (5 >> 2)); //5>>2 = 1
		
		
		System.out.println("5>>2 = " + (-5 >> 2)); //5>>2 = -2

		// unsigned right shift operator
		System.out.println("b>>>2 = " + (-2 >>> 2)); // b>>>2 = 1073741823
		
		System.out.println("2^32 = " + (Math.pow(-2,30)-1)); // 2^32 = 1.073741823E9
		
		
	}
}
