package cs;

import java.util.Map;
import java.util.HashMap;

// package whatever; // don't place package name!

// Reverse string
// in:  "Hello, my favorite cat?!"
//         ^                    ^()  
// out: "tac, etirovaf ym olleH?!"

//in1: "This is as per ohm' s law!"
//out1: "wal s mho rep sa' si sihT!"

//StringBuilder sb = 
//append("")
public class ReverseString {

	private static final int HashMap = 0;
	private static final int Integer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new ReverseString().reverseString("Hello, my favorite cat?!"));
	}

	private String reverseString(String str){
		  
		  if(str.isEmpty())
		    return str;
		  //else return null;
		  
		  
		  char string[] = new char[str.length()];
		  
		  int indx=0, n=str.length()-1;
		  
		  for(int i = str.length()-1 ; i>=0 ; i-- ){
		    char c = str.charAt(i);
		    if((c>='a' && c<='z') || (c>='A' && c<='Z') || c == ' '){
		      string[indx++] = c;
		      System.out.println(string[n-i]+", "+indx);
		    } else {
		    	string[i] = c;
		    	//indx++;
		    	System.out.println(string[i]+", "+indx);
		    }
		  }
		  
		  return new String(string);
		}
	
	private String reverseStringChagol(String str){
	  
	  if(str.isEmpty())
	    return str;
	  //else return null;
	  
	  
	  StringBuilder sb = new StringBuilder();
	  Map<Integer,Character> pun = new HashMap<Integer,Character>();
	  int wCount = 0;
	  
	  for(int i = str.length()-1 ; i>=0 ; i-- ){
	    char c = str.charAt(i);
	    if((c>='a' && c<='z') || (c>='A' && c<='Z')){
	      sb.append(c);
	    } else 
	      if(c ==' '){
	        sb.append(c);
	        wCount++;
	    } else {
	      wCount++;
	      pun.put(wCount, c);
	    }
	  }
	 return new String(sb); 
	}

}
