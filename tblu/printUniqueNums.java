package tblu;

import java.util.HashSet;
import java.util.Set;

public class printUniqueNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printUniqueNums pun = new printUniqueNums();
		pun.deduplicate(new All());
	}
	
	void deduplicate(All io) {
	    
	    if(io==null){
	        return;
	    }
	    
	    Integer ip = io.getNext();
	    //Set<Integer> nums = new HashSet<Integer>();
	    int num=0;
	    while(ip!=null){
	        /*if(nums.add(ip)){        
	            io.output(ip);
	        }*/
	    	num^=ip;
	    	
	    	System.out.println(num+" ip = "+ip);
	    	if(num==ip) {
	    		io.output(ip);
	    	}
	    	
	        ip=io.getNext();
	    }
	    
	}

}

class All {
    int i = 0;//Integer.MIN_VALUE;
    
    int arr[] = {4,5,6,7,8,4,9,5,3,2,1,0};
    /** return null when no more values */
    Integer getNext() {
        if (arr[i]>0) {
        	//i /= 32;
        	return arr[i++];
        }
        else return null;
    }
    
    /** call this to output a value */
    void output(Integer i) {
        System.out.println(i);
    }
    
}
