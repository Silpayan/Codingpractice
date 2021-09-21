package pramp;

public class DeletionDistance {

	
	static int deletionDistanceDP(String str1, String str2) {
	    // your code goes here
	    
	    
	    int m = str1.length(), n = str2.length();
	    
	    int dp[][] = new int[m+1][n+1];
	    
	    /*for(int i = 0; i<=n; i++){
	       dp[0][i] = i;
	    }
	    
	    for(int i = 0; i<=m; i++){
	       dp[i][0] = i;
	    }*/
	    
	    dp[0][0] = 0;
	    
	    for(int i = 0; i<=m; i++){
	      for(int j = 0; j<=n; j++){

	        if(i == 0){
	          dp[i][j] = j;
	          continue;
	        }
	        
	        if(j == 0){
	          dp[i][j] = i;
	          continue;
	        }
	        
	        if(str1.charAt(i-1) == str2.charAt(j-1)){
	          dp[i][j] = dp[i-1][j-1];
	        } else {
	          dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;//1 + min(memo[i-1][j], memo[i][j-1])
	        }
	        
	        //System.out.println();
	        
	      }
	    }
	    
	    return dp[m][n];
	  }
	
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
