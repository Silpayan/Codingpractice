package leetcode.tree;

/*
 * 1430	Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a 
 * valid sequence in such binary tree. We get the given string from the concatenation of an array of integers arr and the 
 * concatenation of all values of the nodes along a path results in a sequence in the given binary tree.


 */

public class CheckStringIsaValidSequencefromRoottoLeavesPathBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidSequence(TreeNode root, int[] arr) {
	       
        return checkPath(root, arr, 0);
       
    }
   
     private static boolean checkPath(TreeNode root, int arr[], int index)
    {
         if(root == null || index == arr.length)
             return false;
        
         if(root.left == null && root.right == null && root.val == arr[index] && index == arr.length-1)
             return true;
       
         return root.val == arr[index] && (checkPath(root.left, arr, index+1) || checkPath(root.right, arr, index+1));
   
    }

}
