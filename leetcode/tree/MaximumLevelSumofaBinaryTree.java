package leetcode.tree;

import java.util.ArrayList;
/*
 * 1161. Maximum Level Sum of a Binary Tree
 * 
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 */
public class MaximumLevelSumofaBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[1,7,0,7,-8,null,null]");//"[989,null,10250,98693,-89388,null,null,null,-32127]");//"[1,7,0,7,-8,null,null]");
		
		MaximumLevelSumofaBinaryTree maxL = new MaximumLevelSumofaBinaryTree();
		System.out.println("MaximumLevelSumofaBinaryTree : "+maxL.maxLevelSum(root));
	}
	
	ArrayList<Integer> sumsL = new ArrayList<Integer>();
	
	public int maxLevelSum(TreeNode root) {
		
		int maxLevelSum = Integer.MIN_VALUE;
		int maxLevel=Integer.MIN_VALUE;

		maxLevelSum(root, 0);
		
		System.out.println(sumsL);
		int count=0;
		
		for(Integer sumL:sumsL) {
			
			if(maxLevelSum<sumL) {
				count++;
				maxLevel=count;
				maxLevelSum = sumL;
				System.out.println(maxLevel+" "+maxLevelSum);
				continue;
			}
			
			count++;
		}
		
		return maxLevel;
    }

	private void maxLevelSum(TreeNode root, int level) {
		if(root==null)
			return;
		
		System.out.println(level+" "+sumsL.size());
		
		if (!sumsL.isEmpty() && sumsL.size() > level) {
			sumsL.set(level, sumsL.get(level)+root.val);
		} else {
			sumsL.add(level, root.val);
		}
		
		maxLevelSum(root.left, level+1);

		maxLevelSum(root.right, level+1);
		
	}

}
