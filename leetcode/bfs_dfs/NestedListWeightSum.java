package leetcode.bfs_dfs;

import java.util.LinkedList;
import java.util.List;
import javafx.util.Pair;

/*
 * 339. Nested List Weight Sum
Easy 581 147
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 10 
Explanation: Four 1's at depth 2, one 2 at depth 1.
Example 2:

Input: [1,[4,[6]]]
Output: 27 
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.

 */
public class NestedListWeightSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 *     // Constructor initializes an empty nested list.
	 *     public NestedInteger();
	 *
	 *     // Constructor initializes a single integer.
	 *     public NestedInteger(int value);
	 *
	 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 *     public boolean isInteger();
	 *
	 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
	 *     // Return null if this NestedInteger holds a nested list
	 *     public Integer getInteger();
	 *
	 *     // Set this NestedInteger to hold a single integer.
	 *     public void setInteger(int value);
	 *
	 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	 *     public void add(NestedInteger ni);
	 *
	 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	 *     // Return null if this NestedInteger holds a single integer
	 *     public List<NestedInteger> getList();
	 * }
	 */
	
	public interface NestedInteger {
		     // Constructor initializes an empty nested list.
		     //public NestedInteger();
		
		     // Constructor initializes a single integer.
		     //public NestedInteger(int value);
		
		     // @return true if this NestedInteger holds a single integer, rather than a nested list.
		     public boolean isInteger();
		
		     // @return the single integer that this NestedInteger holds, if it holds a single integer
		     // Return null if this NestedInteger holds a nested list
		     public Integer getInteger();
		
		     // Set this NestedInteger to hold a single integer.
		     public void setInteger(int value);
		
		     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
		     public void add(NestedInteger ni);
		
		     // @return the nested list that this NestedInteger holds, if it holds a nested list
		     // Return null if this NestedInteger holds a single integer
		     public List<NestedInteger> getList();
		     
	}
	
	class Solution {
	    
	    public int depthSum(List<NestedInteger> nestedList) {
	     
	        int sum = 0;
	        
	        if(nestedList==null){
	            return sum;
	        }
	        
	        Queue<Pair<NestedInteger, Integer>> q = new LinkedList<>();
	        
	        for(NestedInteger nI: nestedList){
	            q.add(new Pair(nI,1));
	        }
	        
	        while(!q.isEmpty()){
	            Pair<NestedInteger, Integer> p = q.poll();
	            NestedInteger nI = p.getKey();
	            int lvl = p.getValue();
	            
	            if(nI==null)
	                continue;
	            
	            if(nI.isInteger()){
	                sum+=nI.getInteger()*lvl;
	            } else {
	                
	                for(NestedInteger n: nI.getList())
	                    q.add(new Pair(n,lvl+1));
	            }
	        }
	        
	        return sum;
	    }
	}

}