package leetcode.tree;
/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes 
 * p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Complexity O(n)
 */

public class LowestCommonAncestorBST {

	public static void main(String[] args) {
		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
		TreeNode p = LCStringtoTreeNode.stringToTreeNode("[5]");
		TreeNode q = LCStringtoTreeNode.stringToTreeNode("[1]");
		TreeNode tn = lowestCommonAncestor(root, p, q);
		if (tn == null)
			System.out.println("null");
		else
			System.out.println(tn.val);

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
		//With bug in case p or node is not present in the tree
		if (root == null)
			return null;

		System.out.println(root.val);
		if (root == p || root == q)//if either p or q found return it and don't call further
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;
		if (left == null && right == null)
			return null;

		return left != null ? left : right;//At least 1 node found among p,q
	}

	/*Code from CICT*/
	class Result {
		public TreeNode node;
		public boolean isAncestor;

		public Result(TreeNode n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}

	TreeNode lowestCommonAncestorCICT(TreeNode root, TreeNode p, TreeNode q) {
		Result r = commonAncHelper(root, p, q);
		if (r.isAncestor) {
			return r.node;
		}
		return null;
	}

	Result commonAncHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return new Result(null, false);

		if (root == p && root == q) {
			return new Result(root, true);
		}

		Result rx = commonAncHelper(root.left, p, q);
		if (rx.isAncestor) { // Found common ancestor
			return rx;
		}

		Result ry = commonAncHelper(root.right, p, q);
		if (ry.isAncestor) { // Found common ancestor
			return ry;
		}

		if (rx.node != null && ry.node != null) {
			return new Result(root, true); // This is the common ancestor
		} else if (root == p || root == q) {
			/*
			 * If we're currently at p or q, and we also found one of those nodes in a
			 * subtree, then this is truly an ancestor and the flag should be true.
			 */
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
	}

}
