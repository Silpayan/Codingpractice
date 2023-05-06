package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        List<Integer>[] arr=new ArrayList[numCourses];
	        
	        //Creating array with each cell holding a array list
	        for(int i=0;i<numCourses;i++)
	            arr[i]=new ArrayList<Integer>();
	        
	        //Create a boolean array to check if it is visited or not
	        int[] visited=new int[numCourses];
	        for(int[] x:prerequisites){
	            int a=x[0];
	            int b=x[1];
	            arr[b].add(a);
	        }
	        //Moving cell by cell
	        for(int i=0;i<numCourses;i++){
	            if(visited[i]==0){
	                if(dfs(i,arr,visited)==false) return false;
	            }
	        }
	        return true;
	    }
	    public boolean dfs(int root,List<Integer>[] arr,int[] visited){
	        visited[root]=1;//initailise the incomming cell as visited
	        
	        //traverse throught its neighbours
	        for(int neighbours: arr[root]){
	            //if not visited go into its neighbours
	            if(visited[neighbours]==0){
	               if(dfs(neighbours,arr,visited)==false) return false;
	            }
	            //incase visited return false
	            else if(visited[neighbours]==1){
	                return false;
	            }
	        }
	        //rename the cell value as 2, this says the cell is has no contradicting dependencies
	        visited[root]=2;
	        return true;
	    }

}
