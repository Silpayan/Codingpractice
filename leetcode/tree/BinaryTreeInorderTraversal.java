package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Input: [1,null,2,3]
   1
    \
     2
    /
   3

 * Output: [1,3,2]
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {

		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[1,null,2,3]");// "[1,2,3,null,5,null,4]");//"[8,3,10,1,6,null,14,null,null,4,7,13]");
		BinaryTreeInorderTraversal treeInOrder = new BinaryTreeInorderTraversal();
		System.out.println(treeInOrder.inorderTraversal(root));

	}

	List<Integer> inOrder = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {

		if (root != null) {
			inorderTraversal(root.left);
			inOrder.add(root.val);
			System.out.print(root.val + " ");
			inorderTraversal(root.right);
		}

		return inOrder;
	}

	/*
	 * private static void inorderTraversalHelper(TreeNode root, List<Integer>
	 * inOrder) {
	 * 
	 * 
	 * }
	 */

}
