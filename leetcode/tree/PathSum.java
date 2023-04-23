package leetcode.tree;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[1,2]");// [5,4,8,11,null,13,4,7,2,null,null,null,1]");

		System.out.println(hasPathSum(root, 3));
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		System.out.println(sum + " root.val = " + root.val);
		if (root.left == null && root.right == null && sum == root.val)
			return true;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

}
