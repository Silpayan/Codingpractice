package leetcode.tree;
/*
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[10,5,15,null,null,6,20]");
		// TreeNode root = ConvertSortedArraytoBinarySearch.sortedArrayToBST(nums);

		System.out.println(isValidBST(root));

		System.out.print("Tree PreOrder : \n[");
		printTreePreOrder(root);
		System.out.println("]");
	}
	
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public static boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
		if (node == null)
			return true;
		System.out.println(node.val+" "+lower+" "+upper);
			
		if (lower != null && node.val <= lower)
			return false;
		if (upper != null && node.val >= upper)
			return false;

		
		return isValidBST(node.right, node.val, upper) && isValidBST(node.left, lower, node.val);
	}

	public static boolean isValidBSTSelf(TreeNode root) { // 70/75 test case passed, This was not able to check 2 above level.

		boolean validBST = false;

		if (root == null)
			return true;
		System.out.println(root.val);

		if ((root.left == null || root.left.val < root.val) && (root.right == null || root.val < root.right.val)) {

			validBST = !isValidBST(root.left) && !isValidBST(root.right);

		} else
			return false;

		return validBST;
	}

	public static void printTreePreOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + ", ");
		// System.out.println("\t/ \\");
		if (root.left != null) {
			// System.out.println("/");
			printTreePreOrder(root.left);
		} else
			System.out.print(" null,");
		if (root.right != null) {
			// System.out.println("\\");
			printTreePreOrder(root.right);
		} else
			System.out.print(" null,");
	}

}
