package pramp;

public class SpiralCopyMatrix {

	
	  static int[] spiralCopyOld(int[][] matrix) {
		    // your code goes here
		    
		    //System.out.println("spiralCopy : "+inputMatrix.length+", "+inputMatrix[0].length);
		    
		    int m = matrix.length, n = matrix[0].length; 
		    
		    System.out.println("spiralCopy : "+m+", "+n);
		    //int mn = inputMatrix.length*inputMatrix[0].length;
		    int result[] = new int[m*n];
		    
		    System.out.println(result.length);
		    
		    int startC = 0, endC = matrix[0].length-1;
		    int startR = 0, endR = matrix.length-1;
		    int c = 0;
		    
		    while(startC<=endC && startR<=endR){
		      
		      
		       System.out.println(startC+", "+endC+", "+startR+", "+endR+", "+c);
		         
		         
		      for(int i = startC; i<=endC; i++){ //left to right row wise
		        result[c++] = matrix[startR][i];
		        //c++;
		      }
		      
		      startR++;
		      System.out.println(startC+", "+endC+", "+startR+", "+endR+", "+c);
		      
		      for(int i=startR; i<=endR ;i++){
		        result[c++] = matrix[i][endC];
		      }
		      
		      endC--;
		      
		      System.out.println(startC+", "+endC+", "+startR+", "+endR+", "+c);
		      
		      if(startR<=endR){
		        for(int i = endC; i>= startC; i--){ //right to left row wise
		          result[c++] = matrix[endR][i];
		          //c++;
		        }
		      }
		      
		      endR--;
		      
		      System.out.println(startC+", "+endC+", "+startR+", "+endR+", "+c);
		      
		      if(startC<=endC){
		        for(int i=endR; i>= startR ;i--){
		          result[c++] = matrix[i][startC];
		        }
		      }
		      
		      startC++;
		      
		      System.out.println(startC+", "+endC+", "+startR+", "+endR+", "+c);
		      
		    }
		    
		    return result; 
		    
		  }
	  
	  
	  static int[] spiralCopy(int[][] inputMatrix) {//11/25
		    // your code goes here
		    
		    int row = inputMatrix.length, col = inputMatrix[0].length;
		    int res[] = new int[row*col], idx = 0;
		    
		    int rowStart = 0, colStart = 0;// 0 0
		    int rowEnd = row, colEnd = col; //1 3

		    while(rowStart<rowEnd && colStart<colEnd){

		      
		      
		      //first row -> 0,0 0,1 0,2...
		      for(int c = colStart; c<colEnd;c++){//0  1
		        
		        res[idx++] = inputMatrix[rowStart][c]; //1 2 3 
		      }
		      
		      
		      //last colmn
		      rowStart++;//1
		      
		      for(int r = rowStart; r<rowEnd; r++){//
		        res[idx++] = inputMatrix[r][colEnd-1];
		      }

		      //last row
		      colEnd--;//2
		      
		      if(rowStart<rowEnd){
		          for(int c = colEnd-1; c>=colStart;c--){//2

		          res[idx++] = inputMatrix[rowEnd-1][c];
		          }
		        
		      }
		      
		      
		      rowEnd--; //3
		      
		      //first column
		      if(colStart<colEnd){
		        for(int r = rowEnd-1; r>=rowStart; r--){ //2  1

		          res[idx++] = inputMatrix[r][colStart];
		        }
		      }

		       colStart++;
		       

		      }
		    
		    return res;
		  }
		  
		  /* 1 2 3
		     4 5 6
		op: 123654

		     1 2 3
		     4 5 6
		     7 8 9
		     
		op: 123698745

		*/
		  public static void main(String[] args) {
		    
		    //int inputMatrix[][] = {{1}, {2}, {3}};
		    
			int inputMatrix[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		    
		    
		    System.out.println(inputMatrix.length+", "+inputMatrix[0].length);

		    int a[] = spiralCopy(inputMatrix);
		    
		    System.out.println("Output :");
		    
		    for(int e: a)
		      System.out.print(e+", ");
		   
		    
		  }
		  
		  
}

