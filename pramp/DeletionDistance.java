package pramp;

public class DeletionDistance {

	static int deletionDistance(String str1, String str2) {
	    // your code goes here
	    if(str1==null && str2 == null) return 0;
	    if(str1=="") return str2.length();
	    if(str2=="") return str1.length();
	    
	    int s1 = str1.length();
	    int s2 = str2.length();
	    int n = s1>s2?s1-s2:s2-s1;
	    int count=0; 
	    for(int i=0, j=0; i<s1 || j<s2;){
	      System.out.println(i+", "+j);
	      
	      if(i<s1 && j<s2 && str1.charAt(i)==str2.charAt(j))
	      {
	        i++;j++;
	      } 
	      else{ 
	        count++;
	       if(s1>s2 && i<s1) i++;
	       else
	    	   if(s2>s1 && j<s2)
	    		   j++;
	    	   else {
	    		   i++;j++;
	    		   //System.out.println(i+", "+j);
	    	   }
	    		   
	      }
	      
	    }
	    
	    return count;
	  }

	  public static void main(String[] args) {
	    
	    //System.out.println(" hot and not = "+deletionDistance("hot","not"));
	    System.out.println("\"heat\",\"hit\" = "+deletionDistance("heat","hde"));
	  }

}
