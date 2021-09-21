package cs;

import java.util.Arrays;

/* Given a 2d array, print the elements in spiral order
{ 
  1,   2,   3,  4   
  12,  13,  14, 5
  11,  16,  15  6
  10,  9,   8,  7
}

Prints : 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16 
*/

class Spiral {

public int[] spiralCopy(int [][] mat){

int m = mat.length, n= mat[0].length;

int result[] = new int[m*n];//Resultant array, returning this

int startC = 0, endC = m;
int startR = 0, endR = n, c=0;

while(startC<=endC && startR<=endR){
 
 //left to right row copy
 for(int i = startC; i<=endC; i++){
   result[c++] = mat[startR][i];
 }
 
 startR++;
 
 for(int i=startR; i<=endR ;i++){
     result[c++] = mat[i][endC];
 }
 
 endC--;
 if(startC<=endC){
     for(int i=endR; i>= startR ;i--){
       result[c++] = mat[i][startC];
     }
   }
   
   startC++;
 
}

return result;
}

public static void main(String []s){

int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};

System.out.println(Arrays.toString(new Spiral().spiralCopy(mat)));

}

}

//Done the coding...with discussion with Viswa.
//Thanks
