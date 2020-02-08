package aam;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class SynchronisationofFilestoServers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumHours(int rows, int columns, List<List<Integer> > grid)
    {
        // WRITE YOUR CODE HERE
        //Checking null import
        if(grid==null|| grid.size()!= rows || grid.get(0).size()!=columns){
            return -1;//Input is not matching with problem statement.
        }
        
        //need to iterate thru the matrix to update the cells
        //BFS?
        
        Queue<int[]> q = new LinkedList<>();
        
        int res= 0, cnt= 0;
        //Initializing the queue with all the servers with files
        for(int row = 0;row<rows;row++){
            for(int col = 0; col<columns;col++){
                if(grid.get(row).get(col)==1){
                    q.offer(new int[] {row,col});
                    cnt++;
                }
            }
        }
        
        //matrix definine adjucent nodes 
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        //Looping thru the queue utill it is empty
        
        while(!q.isEmpty()){
            int size = q.size();
            
            if(cnt == rows*columns){
                return res;
            }
            
            //looping for all in queue
            for(int i=0;i<size;i++){
                int cur[] = q.poll();//poping 1 by one from the queue
                
                //traverse consecutive nodes
                for(int[] dir:dirs){
                    
                    int nrow = cur[0] + dir[0];
                    int ncol = cur[1] + dir[1];
                    
                    if(nrow>=0 && nrow< rows && ncol>=0 && ncol< columns && grid.get(nrow).get(ncol) == 0){
                        cnt++;
                        
                        q.offer(new int[] {nrow,ncol});
                        grid.get(nrow).set(ncol,1);//synchronized
                    }
                }
                
            }
            
            res++;
        }
        
        return -1;
    }
}
