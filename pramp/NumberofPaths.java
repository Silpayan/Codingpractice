package pramp;

public class NumberofPaths {

	  static int numOfPathsToDest(int x, int y, int n, int[][] memo){
	    // base cases
	    if(y > x || x >= n || y >=n) { return 0;}
	    if(x == n-1 && y == n-1) { return 1; }
	    
	    if(memo[x][y] == 0){
	      memo[x][y] = numOfPathsToDest(x+1, y, n, memo) + numOfPathsToDest(x, y+1, n, memo);
	    }
	    
	    // Car is at (2, 1)
	    return memo[x][y];
	  }
	  
	  static int numOfPathsToDest(int n) {
	    // your code goes here
	    if(n == 1) {return 1;}
	    
	    int[][] memo = new int[n][n];
	    
	    return numOfPathsToDest(0, 1, n, memo) + numOfPathsToDest(1, 0, n , memo);
	  }

	  public static void main(String[] args) {
	    int n = 10;
	    System.out.println(numOfPathsToDest(n));
	  }


}
