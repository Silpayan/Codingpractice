package leetcode.bfs_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * 5354. Time Needed to Inform All Employees
A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also it's guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the employees of the company of an urgent piece of news. He will inform his direct subordinates and they will inform their subordinates and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.
 * 
 */

public class TimeNeededtoInformAllEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int n;
    static int[] indegree;
    static Map<Integer,List<Integer>> adj = new HashMap<>();
    
	
public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
	int orderofCources[] = new int[numCourses];
    indegree = new int[numCourses];
    for(int[] pr : prerequisites){//Creating the dependency Map/Graph
        List<Integer> l =  adj.getOrDefault(pr[1], new ArrayList<>());
        l.add(pr[0]); 
        indegree[pr[0]]++;
        adj.put(pr[1], l);
    }
    Queue<Integer> q = new LinkedList<>();
    int countCourse = 0;
    for(int i = 0; i < indegree.length; i++){//All nDegree of 0 to our queue -> No dependency
        if(indegree[i] == 0) q.add(i); 
    }
    
    while(!q.isEmpty()){
        int Course = q.poll();
        if(indegree[Course] == 0){ //This course can be taken.
            orderofCources[countCourse++] = Course;
            
        }
        if(!adj.containsKey(Course)) continue; //No dependency so check for the next in queue 
        for(int nei : adj.get(Course)){ // traversing dependency list
            indegree[nei]--; //decreasing the In degree of each neighbor of this course 
            if(indegree[nei]== 0) q.add(nei); //adding 
        }

    }

    return countCourse == numCourses?orderofCources:new int[0];
    }

}
