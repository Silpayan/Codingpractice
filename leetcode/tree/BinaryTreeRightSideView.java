package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	/*
	 * 199. Binary Tree Right Side View Given a binary tree, imagine yourself
	 * standing on the right side of it, return the values of the nodes you can see
	 * ordered from top to bottom.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[1,2,3,null,5,null,4]");// "[1,2,3,null,5,null,4]");//"[8,3,10,1,6,null,14,null,null,4,7,13]");
		System.out.println(rightSideView(root));
	}

	public static List<Integer> rightSideView(TreeNode root) {

		List<Integer> rightViewNodes = new ArrayList<Integer>();

		if (root == null)
			return rightViewNodes;

		rightViewNodes.add(root.val);
		rightSideView(root.left, rightViewNodes, 1);
		rightSideView(root.right, rightViewNodes, 1);
		return rightViewNodes;
	}

	private static void rightSideView(TreeNode root, List<Integer> rightViewNodes, int level) {

		if (root == null)
			return;
		//int valFrmLeftSubTree = rightViewNodes.get(level);
		if(level<rightViewNodes.size())
			rightViewNodes.set(level, root.val);
		else
			rightViewNodes.add(level, root.val);
		//rightViewNodes.remove(valFrmLeftSubTree);
		System.out.println(level + " " + rightViewNodes);
		rightSideView(root.left, rightViewNodes, level + 1);
		rightSideView(root.right, rightViewNodes, level + 1);
	}
}
