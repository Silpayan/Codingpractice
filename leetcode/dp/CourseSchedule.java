package leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * 207. Course Schedule
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */

public class CourseSchedule {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 2, prerequisites[][] = {{1,0},{0,1}};
		System.out.println(canFinish(numCourses, prerequisites));

	}
	
	static int n;
    static int[] indegree;
    static Map<Integer,List<Integer>> adj = new HashMap<>();
    
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        for(int[] pr : prerequisites){//Creating the dependency Map/Graph
            List<Integer> l =  adj.getOrDefault(pr[1], new ArrayList<>());
            l.add(pr[0]); indegree[pr[0]]++;
            adj.put(pr[1], l);
        }
        Queue<Integer> q = new LinkedList<>();
        int countCourse = 0;
        for(int i = 0; i < indegree.length; i++){//All nDegree of 0 to our queue -> No dependency
            if(indegree[i] == 0) q.add(i); 
        }
        while(!q.isEmpty()){
            int Course = q.poll();
            if(indegree[Course] == 0)countCourse++;//This course can be taken.
            if(!adj.containsKey(Course)) continue; //No dependency so check for the next in queue 
            for(int nei : adj.get(Course)){ // traversing dependency list
                indegree[nei]--; //decreasing the In degree of each neighbor of this course 
                if(indegree[nei]== 0) q.add(nei); //adding 
            }

        }

        return countCourse == numCourses;
    }
}
