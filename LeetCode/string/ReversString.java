package leetcode.string;

public class ReversString {

	public static void main(String[] str) {
		printRecursively(0, "silpayan".toCharArray());
		
		char[] str1 = {'H','a','n','n','a','h'};
		int len = str1.length-1;
		storeRecursively(0,str1.length-1, str1 );
		System.out.println("\nstoreRecursively : ");
		for(int count=0;count<str1.length;count++) {
			System.out.print(str1[count]+" ");
		}
		
	}

	private static void printRecursively(int index, char[] str) {
		if (str == null || index >= str.length) {
			return;
		}
		printRecursively(index + 1, str);
		System.out.print(str[index]);

	}
	
	private static void storeRecursively(int forward, int revers, char[] str) {
		if (str == null || forward >= str.length/2 || forward>revers) {
			return;
		}
		char temp = str[forward];
		str[forward] = str[revers];
		str[revers] = temp;
		storeRecursively(forward + 1, revers-1 , str);
	}
}
