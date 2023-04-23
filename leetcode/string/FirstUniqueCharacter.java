package leetcode.string;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
		
	}
	
	public static int firstUniqChar(String s) {
		if(s==null)
			return -1;
		
		HashMap<Character, Integer> freq = new HashMap();
		int i=0;
		//First create a hashmap with freq of char
		
	    for(char c:s.toCharArray()){
	    	freq.put(c,freq.getOrDefault(c,0)+1);
	    }

	  //Traverse the string again
	    for(char c:s.toCharArray()){
	    	
	    	if(freq.get(c)==1) {
	    		return i;
	    	}
	    	i++;
	    }
	    
	    return -1;
	
	}
	
	  public int firstUniqCharBestInLC(String s) {
	        
	        if(s==null||s.length()==0){
	            
	            return -1;
	        }
	    int min=Integer.MAX_VALUE;
	        int findex=0;
	        int lindex=0;
	        for(char ch='a';ch<='z';ch++){
	            findex=s.indexOf(ch);
	            lindex=s.lastIndexOf(ch);
	            
	            if(findex!=-1&&findex==lindex){
	                min=Math.min(min,lindex);
	                
	            }
	        }
	        
	        if(min==Integer.MAX_VALUE){
	            return -1;
	        }
	     return min;
	        
	    }

}
