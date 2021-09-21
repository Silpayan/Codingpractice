package pramp;

import java.util.Arrays;

public class ArrayQuadruplet {

  static int[] findArrayQuadruplet(int[] arr, int s) {
    // your code goes here
    int n = arr.length;
    int sumR, sum, left, end = n-1;
    
    Arrays.sort(arr);

    //System.out.println(Arrays.toString(arr));
    
    //0  4  5 7 9
    
    for(int i  = 0; i<n-3; i++){// i<2 0,1
      for( int j = i+1 ; j<n-2;j++ ){// j<3
        
        sumR = s - arr[i] - arr[j];
        
        left = j+1;
        end = n-1;
        
        //System.out.println(arr[i]+", "+arr[j]+", "+left+", "+end+" sumR = "+sumR);
        
        while(left<end){ ///0  4  5 7 9 sumR = 12
          sum = arr[left]+arr[end]; //5 7 9 sum = 16
          
          //System.out.println(sum+" =? "+sumR);
          if(sum == sumR){
              int res[] = new int[4];
              
              res[0] = arr[i];
              res[1] = arr[j];
              res[2] = arr[left];
              res[3] = arr[end];
              return res;
          }
          
          if(sum<sumR){//
            left++;
          } else  {
               end--;
          }
          
        }
        
      }  
      
    }
    
    return new int[0];
  }

  public static void main(String[] args) {

	  int arr[] = {2, 7, 4, 0, 9, 5, 1, 3}, sum = 20;
	  
	  System.out.println(Arrays.toString(findArrayQuadruplet(arr,sum)));
  }

}


/*

2, 7, 4, 0, 9, 5, 1, 3

sort 0,1,2,3,4,5,7,9  16

     i   j j+1     n-1
     
      3,4,5,7,9 //14

          s   e   //14   s<e
for(i  = 0 to n-4)
  for( j = i+1 to n-3 )
  
    sum2 = arr[i]+arr[j];
    
     for(k = j+1 to n-2) //n^3
      
      val  = sum-(sum2+arr[k])
      start = k+1 end  = n-1;
        while(stat <end){ //log n
        //binary
        }

*/
