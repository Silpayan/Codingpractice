package pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Merging2Packages {

	static int[] getIndicesOfItemWeights(int[] arr, int limit) {
	    // your code goes here
	    
	    if(arr==null || arr.length==0){
	      return new int[0];
	    }
	    
	    System.out.println("DEBBUG: "+arr.length);
	    
	    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	    
	    for(int i = arr.length-1;i>=0;i--){
	      System.out.println("DEBBUG: "+arr[i]);
	       if(map.containsKey(limit-arr[i])) {
	          int res[] = new int[2];
	          res[0] = map.get(limit-arr[i]); //  4,1   
	          res[1] = i;
	          return res;
	      } else {    
	            map.put(arr[i],i);
	       }
	    }
	  
	  return new int[0];
	    
	  }
	  
	  /*
	  4, 16, 10, 5, 18
	  
	  Arrays.sort()
	  4, 5, 10, 16, 18 
	  
	  HashMap
	  
	  4,i
	  5, 
	  i=0 to n;
	  map.containsKey(limit-arr[i]) {
	    int res[] = new int[2];
	    res[0] = map.get(limit-arr[i]);   4,1   
	    res[1] = i;
	    return res;
	  } else {
	    map.put(arr[i],i);
	  }
	  
	  return new int[];
	  */

	  public static void main(String[] args) {

	    System.out.println("DEBUG");
	    
	    int arr[] = {4, 6, 10, 15, 16};
	    int lim = 21;
	    
	    System.out.println(Arrays.toString(arr));
	    
	    System.out.println(Arrays.toString(getIndicesOfItemWeights(arr,lim)));
	  }

}
