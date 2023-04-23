package leetcode.dfs;

import leetcode.tree.LCStringtoTreeNode;
import leetcode.tree.TreeNode;

/*
 * 
 */
public class MinimumDistanceBetweenBSTNodes {

	public static void main(String[] args) {

		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[90,69,null,49,89,null,52,null,null,null,null]"); // [90,69,null,49,89,null,52,null,null,null,null]

		MinimumDistanceBetweenBSTNodes minDist = new MinimumDistanceBetweenBSTNodes();

		System.out.println("minDiffInBST : ");
		System.out.println(minDist.minDiffInBST(root));

		System.out.println("\n\nminDiffInBSTLC : ");
		System.out.println(minDist.minDiffInBSTLC(root));
	}

	int mini = Integer.MAX_VALUE;
	Integer previ = null;

	public int minDiffInBST(TreeNode root) {
		if (root == null)
			return 0;

		return minDiffInBST(root, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	private int minDiffInBST(TreeNode root, int pval, int min) {

		if (root != null) {

			int min1 = minDiffInBST(root.left, root.val, min); // check if left subtree has a smaller value

			min = Math.min(Math.abs(root.val - pval), min); // parent child has the min value
			System.out.println("root : " + root.val);

			int min2 = minDiffInBST(root.right, root.val, min);// check if right subtree has a smaller value

			// Add check for right most of left sub tree
			int min3 = minDiffInBSTLMLS(root, min);
			// Add check for left most of right sub tree
			int min4 = minDiffInBSTLMRS(root, min);

			min = min < min1 ? min : min1;
			min = min < min2 ? min : min2;

			min3 = min3 < min4 ? min3 : min4;
			min = min < min3 ? min : min3;

			System.out.println("min : " + min);
		}

		return min;

	}

	private int minDiffInBSTLMRS(TreeNode root, int min) {
		int val = root.val;
		if (root.left == null)
			return Integer.MAX_VALUE;
		root = root.left;
		while (root.right != null) {// going to right most of left sub tree
			root = root.right;
			min = Math.abs(val - root.val);
			System.out.println(val + " " + min);
		}

		System.out.println("Min from right most of left sub tree : " + min);
		return min;
	}

	private int minDiffInBSTLMLS(TreeNode root, int min) {
		int val = root.val;

		if (root.right == null) // going to right subtree
			return Integer.MAX_VALUE;
		root = root.right;

		while (root.left != null) {// Going to left most of right sub tree
			root = root.left;
			min = Math.abs(root.val - val);
			System.out.println("val = " + val + "root.val" + " " + min);
		}

		System.out.println("Min from left most of right sub tree : " + min);
		return min;
	}

	int min = Integer.MAX_VALUE;
	Integer prev = null;

	public int minDiffInBSTLC(TreeNode root) {
		if (root == null)
			return 0;

		int min = 0;
		int left_res = Integer.MAX_VALUE;
		int right_res = Integer.MAX_VALUE;
		int diff_left = Integer.MAX_VALUE, diff_right = Integer.MAX_VALUE;
		TreeNode left = root.left;
		TreeNode right = root.right;

		if (left != null) {
			TreeNode node = left;
			while (node.right != null)
				node = node.right;

			diff_left = root.val - node.val;
			left_res = minDiffInBST(left);
		}
		if (right != null) {
			TreeNode node = right;
			while (node.left != null) {
				node = node.left;
			}
			diff_right = node.val - root.val;
			right_res = minDiffInBST(right);
		}

		min = Math.min(diff_left, diff_right);
		min = Math.min(min, left_res);
		min = Math.min(min, right_res);

		return min;

	}
}
