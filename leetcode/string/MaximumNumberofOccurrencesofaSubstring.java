package leetcode.string;

import java.util.HashMap;
import java.util.PriorityQueue;

/*5293. Maximum Number of Occurrences of a Substring
Given a string s, return the maximum number of ocurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.
*/

public class MaximumNumberofOccurrencesofaSubstring {

	public static void main(String[] args) {

		String s = "ffcbcecaaeaafcb";//"aababcaab";
		
		int maxLetters = 1, minSize = 8, maxSize = 10;
		
		System.out.println(new MaximumNumberofOccurrencesofaSubstring().maxFreq(s, maxLetters, minSize, maxSize));
		
	}
	
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int freq = 0;
        HashMap<String, Integer> frqMap = new HashMap<String, Integer>();
        
        for(int i=0; i<s.length();i++) {
        	for(int j = minSize; j<=maxSize && i+j<=s.length();j++) {//finding possible substrings
        		
        		String str = s.substring(i,i+j);
        		System.out.println(str);
        		//checking if the maxLetter
        		int chkMaxUnqLtr = 0 ;
        		for(char c:str.toCharArray()) {
        			if(str.indexOf(c)==str.lastIndexOf(c)) {
        				chkMaxUnqLtr++;
        			}
        		}
        		if(chkMaxUnqLtr>maxLetters) {
        			continue;
        		}
        		
        		frqMap.put(str, frqMap.getOrDefault(str, 0) + 1);
        	}
        	
        }
        
        System.out.println(frqMap);
        
	    
	    for (String str: frqMap.keySet()) {
	    int f = frqMap.get(str);
	      if(freq<f) {
	    	  freq = f;
	      }
	    }
        
        return freq;
	    
	    
	}

}
