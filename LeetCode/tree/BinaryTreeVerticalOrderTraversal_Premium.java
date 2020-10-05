package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
 * 314. Binary Tree Vertical Order Traversal
Medium

Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 * 
 */
public class BinaryTreeVerticalOrderTraversal_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
		System.out.println(new BinaryTreeVerticalOrderTraversal_Premium().verticalOrderSelf(root));
		
		root = LCStringtoTreeNode.stringToTreeNode("[1,null,3,2,5,null,null,4]");
		System.out.println(new BinaryTreeVerticalOrderTraversal_Premium().verticalOrderSelf(root));
		
		root = LCStringtoTreeNode.stringToTreeNode("[3,9,8,4,0,1,7,null,null,null,2,5]");
		System.out.println(new BinaryTreeVerticalOrderTraversal_Premium().verticalOrderSelf(root));
	}
	
public List<List<Integer>> verticalOrderSelf(TreeNode root) { //Do breath first Search stupid!
        
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        //verticalOrder(root, map, 0); //traverse and add nodes -n to -n key
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        
        q.add(root);
        level.add(0);
        
        while(!q.isEmpty() && !level.isEmpty()){
            
            TreeNode visiting = q.poll();
            int lvl = level.poll();
            
            if(map.containsKey(lvl)){
                map.get(lvl).add(visiting.val);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(visiting.val);
                map.put(lvl, l);
            }
            
            if(visiting.left!=null){
                q.add(visiting.left);
                level.add(lvl-1);
                
            }
                
            if(visiting.right!=null){
                q.add(visiting.right);
                level.add(lvl+1);
            }
        }
        
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
            
        for(int k:map.keySet()){
            res.add(map.get(k));
        }
        
        return res;
    }

}
