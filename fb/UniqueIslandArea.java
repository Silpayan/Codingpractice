package fb;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a 2D matrix, containing only 0 and 1 where 0 represents water and 1 represents land. A piece of land is connected to another land if they are adjoint either horizontally, vertically or diagonally.
Find the area of all the unique islands and return the list of areas.

int[] uniqueIslandArea(int[][] island)

Example Input:
0 0 0 1 0 1
1 0 1 0 0 1
1 0 0 0 0 1
0 1 0 1 0 0

Example Output:
[3, 2, 1, 3]

Helping text:
0 0 0 B 0 D
A 0 B 0 0 D
A 0 0 0 0 D
0 A 0 C 0 0

i 0-n
  j 0-m
  
0 0 S 1 S 1
1 S 1 S S 1
1 0 S 0 0 1
0 1 0 1 0 0
 */

public class UniqueIslandArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int isLand[][] = {  {0, 0, 0, 1, 0, 1},
							{1, 0, 1, 0, 0, 1},
							{1, 0, 0, 0, 0, 1},
							{0, 1, 0, 1, 0, 0}};
		
		System.out.println(new UniqueIslandArea().uniqueIslandArea(isLand));
		
		int isLand2[][] = { {0, 1, 0, 1, 0, 1},
							{1, 0, 1, 0, 1, 1},
							{1, 0, 0, 0, 0, 1},
							{0, 1, 0, 1, 1, 0}};
		System.out.println(new UniqueIslandArea().uniqueIslandArea(isLand2));

	}
	
		public List<Integer> uniqueIslandArea(int[][] isLand){

		  int m = isLand.length, n = isLand[0].length;//wrong to use[]
		  //null
		  if(m==0 && n==0){
		    return new ArrayList<Integer>();
		  }
		  
		  List<Integer> areaOfIsland = new ArrayList<>();
		  
		  //for loop
		  
		  for(int row = 0; row<m; row++){
		    
		   for(int col = 0; col<n; col++){
		     
		     if(isLand[row][col] == 1){
		     
			       int isLandArea = dfs(isLand, row, col); //MXN   dfs = NXM
			       areaOfIsland.add(isLandArea);
		       
		     	}//wrong bracket
		   }
		  }
		  
		    return areaOfIsland;

		}
		  
		  private int dfs(int[][] island, int row, int col){
		    
		    //boundary check and 0(Stop)
		    
		    if(row<0||row>=island.length || col<0 || col>=island[0].length || island[row][col] == 0){//again [], missed [0]
		      return 0;  
		    }
		    
		    
		    // -1 +1 0..
		    
		    int[][] dir = {{-1, 1},{-1,0}, {-1,-1}, {1, -1},{0,1}, {1,1}, {1,0},{0,-1}}; //2 side
		    
		    int area  = 1;
		    
		    island[row][col] = 0;
		    
		    //count the size
		    for(int []d:dir){
		    //recurse 8 directions
		      
		      area += dfs(island, row+d[0], col+d[1]);
		     
		      
		    }
		      
		    return area;
		    
		    
		  }

}
