package pramp;
/*
 * You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.

Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

Explain your solution and analyze its time and space complexities.

 * 
 */
public class SentenceReverseCharArray {

	public static void main(String[] s) {

		//char arr[] = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't','i', 'c', 'e' };
		
		char arr[] = {'a',' ', ' ','b'};//{'h','e','l','l','o'};
		

		arr = reverseWords(arr);
		System.out.println("Result :");
		for (char a : arr) {
			System.out.println(a + ",");
		}
		/*
		 * output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k', 'e',
		 * 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't' ]
		 */

	}

	static char[] reverseWords(char[] arr) {
		// your code goes here
		int n = arr.length;
		char[] result = new char[n];

		for (int i = 0, j = 0; i < n; i++) {

			if (arr[i] == ' ' || i==n-1) {
				
				System.out.println(i+", "+j);
				for (int k = n - i, l = j; k < n - j ; k++) {
					result[k] = arr[l++];
				}
				
				if(i!=n-1 )result[n - i - 1] = ' '; 
				j = i + 1;
				System.out.println("n - i + 1 ="+(n - i - 1)+" j "+j);
			}

		}

		return result;
	}

}
