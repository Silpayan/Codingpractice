package pramp;

import java.util.Arrays;

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
		
		char arr1[] = {'p','e','r','f','e','c','t',' ',
                'm','a','k','e','s',' ',
                'p','r','a','c','t','i','c','e'};
    
		  System.out.println(Arrays.toString(reverseWordsInPlace(arr1)));
		  char arr2[] = {'h','e','l','l','o'};
		  System.out.println(Arrays.toString(reverseWordsInPlace(arr2)));
		  
  
		/*
		 * output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k', 'e',
		 * 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't' ]
		 */

	}
	
	static char[] reverseWordsInPlace(char[] arr) {
	    // your code goes here
	    
	    char temp;
	    int len = arr.length;
	    
	    for(int i = 0; i<len/2;i++){
	      
	      temp = arr[i];
	      arr[i] = arr[len-i-1];
	      arr[len-i-1] = temp;
	    }
	    //
	    
	// The sun rises
	    
	//[sesir nus ehT]

	//'rises' sun The 
	    
	    int start = 0;
	    
	    for(int i = 0; i<len;i++){//[sesir nus ehT]
	     
	      if(arr[i]==' ' || i==len-1){//loop till ' ' and fix reverse words
	        //6
	        if(i==len-1) i++;
	        for(int j = start; j<(start+i)/2;j++){//6, 9
	          
	          temp = arr[j]; //s e n  
	          arr[j] = arr[start+i-j-1]; //r i  9-6-1 = 8
	          arr[start+i-j-1] = temp;
	        }
	        
	         System.out.println(Arrays.toString(arr));
	           
	        start = i+1;
	      }
	    }
	    
	    return arr;
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
