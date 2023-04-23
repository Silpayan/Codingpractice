package leetcode.tree;

/*
 * 
 270. Closest Binary Search Tree Value
Easy

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
 * 
 */
public class ClosestBinarySearchTreeValue_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,2,5,1,3};
		TreeNode root = ConvertSortedArraytoBinarySearch.sortedArrayToBST(nums);
		
		System.out.println(new ClosestBinarySearchTreeValue_Premium().closestValue(root, 2.3));

	}
	  public int closestValue(TreeNode root, double target) {
		    int val, closest = root.val;
		    while (root != null) {
		      val = root.val;
		      closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
		      root =  target < root.val ? root.left : root.right;
		    }
		    return closest;
		  }

	
}
