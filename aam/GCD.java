package aam;

public class GCD {

	/*
	 * public static void main(String a[]) {
	 * 
	 * int num = 5; int arr[] = { 2,4,6,8,10 };// {0,0,0,0,0};
	 * 
	 * 
	 * // I don't really need to know the length as separate input // May be I need
	 * to validate both are matching?
	 * 
	 * int divisor = 1, min = 0, minIndex = 0, index = 0; boolean gcdFlag = false;
	 * 
	 * if (arr.length != num || arr.length == 0) { return;// your input is incorrect
	 * the numbers length doesn't match with the mentioned // count }
	 * 
	 * // First step is to find out the minimum of the numbers do { if (index == 0)
	 * { // min = num[index]; minIndex = index; } else if (arr[minIndex] >
	 * arr[index]) { // min = num[index]; //found smaller than minimum/0 so updating
	 * minimum value minIndex = index;// tracking index of minimum to avoid } }
	 * while (index++ < num - 1);
	 * 
	 * System.out.println("Minimum found : " + arr[minIndex]);
	 * 
	 * min = arr[minIndex];
	 * 
	 * if (min == 0) return;// negetive or 0 number are present not a valid input
	 * 
	 * // Find out the GCD // And I don't need to sort them as I can find the
	 * smallest one divisors // and try to see if any remainders are present for
	 * others and keep trying upto // the minimum and then return false // Could
	 * have check for prime number divisor like 2,3,5, 7, 11 but time // constrain
	 * for (int i = min; i > 1; i--) { System.out.println("deivisor trying with :" +
	 * i);
	 * 
	 * if (i == min) { i=min/2; for (index = 0; index < num; index++) { if (index ==
	 * minIndex) continue;
	 * 
	 * if (arr[index] % min == 0) { gcdFlag = true; divisor = min;
	 * //System.out.println("GCD : " + (min)); continue; } else { gcdFlag = false;
	 * break; } } }
	 * 
	 * if (gcdFlag) break;
	 * 
	 * if (min % i != 0) continue;// if it can't devide min then it is not worth
	 * looking for
	 * 
	 * for (index = 0; index < num; index++) { // devide each element of the array
	 * and // Check for a valid divisor // if reminder of % is not 0 break and
	 * resume prev loop if (arr[index] % i == 0) { if (index == num - 1) { gcdFlag =
	 * true; divisor = i; } continue; } else { gcdFlag = false; break; } }
	 * 
	 * }
	 * 
	 * System.out.println("GCD : " + (divisor)); }
	 */

	public static void main(String[] args) {
		int arr[] = { 20, 32, 60, 80, 164 };
		int n = arr.length;
		System.out.println(findGCD(arr, n));
	}

	// Function to return gcd of a and b
	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		System.out.println(a + " " + b);
		return gcd(b % a, a);
	}

	// Function to find gcd of array of
	// numbers
	static int findGCD(int arr[], int n) {
		int result = arr[0];
		for (int i = 1; i < n; i++) {
			System.out.println("Result : "+result);
			result = gcd(arr[i], result);

			if (result == 1) {
				return 1;
			}
		}

		return result;
	}

}
