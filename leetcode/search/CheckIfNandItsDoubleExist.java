package leetcode.search;

import java.util.Arrays;
/*
 * 5332. Check If N and Its Double Exist

Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 */
public class CheckIfNandItsDoubleExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,2,5,3};//{10,2,5,3};//[-10,12,-20,-8,15]  {-16,-13,8};
		System.out.println(new CheckIfNandItsDoubleExist().checkIfExist(arr));
		
	}

	public boolean checkIfExistPositive(int[] arr) {
        
		for(int i=0;i<arr.length;i++) {
			arr[i] = Math.abs(arr[i]);
		}
		
        Arrays.sort(arr);
        
        for(int a:arr){
            System.out.print(a+", ");
        }
        
        System.out.println();
        
        for(int i=0;i<arr.length-1;i++){
            int left = i;
            int right = arr.length-1;
            int val = Math.abs(arr[i]*2);
            while(left<=right){
                int mid = (left+right)/2;
                System.out.println(i+", "+mid+", val = "+val+", arr[mid] = "+arr[mid]);
                // midVal = arr[mid];
                if(val==arr[mid]){
                    return true;
                } else if(val<arr[left] || val>arr[right]){
                    break; //no double exists
                } else if(val>arr[mid]){
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            }
            
        }
        
        return false;
    }
	
	public boolean checkIfExist(int[] arr) {
        
        
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++) {
            	if(arr[i]*2==arr[j] || arr[i]==arr[j]*2) {
            		return true;
            	}
            }
        }
        
        return false;
    }
	
}
