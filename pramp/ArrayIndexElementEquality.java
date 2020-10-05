package pramp;

public class ArrayIndexElementEquality {
	static int indexEqualsValueSearch(int[] arr) {
	    // your code goes here
	 
	    if(arr==null||arr.length==0){
	      return -1;
	    }
	    
	    int left = 0, right = arr.length-1;
	    int minMid = arr.length;
	    while(left<=right){
	      int mid = (right+left)/2;
	      //System.out.println(left+", "+mid+", "+minMid);
	      if(arr[mid]==mid) {
	        if(minMid>mid) 
	          minMid = mid;
	        right=mid-1;
	      }else 
	        if(arr[mid]>mid) right = mid-1;
	        else left = mid+1;
	    }  
	     return minMid==arr.length?-1:minMid;   
	  }

	  public static void main(String[] args) {

	    int []arr = {-8,0,2,5};
	    System.out.println(indexEqualsValueSearch(arr));
	    int arr1[] = {-6,-5,-4,-1,1,3,5,7};
	    System.out.println(indexEqualsValueSearch(arr1));
	    int []arr2 = {1,0};
	    System.out.println(indexEqualsValueSearch(arr2));
	  }
}
