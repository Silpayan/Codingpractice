package orcl;

public class BSTfromUnsortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 4, 6, 8, 1, 3, 5 };

		BSTfromUnsortedArray bst = new BSTfromUnsortedArray();

		Node root = bst.createBST(a);
		System.out.print("PreOrder : ");
		bst.displayBSTPreOrder(root);
		System.out.print("\nInOrder : ");
		bst.displayBSTInOrder(root);

	}

	private Node createBST(int[] a) {
		// TODO Auto-generated method stub
		if (a == null || a.length == 0) {
			return null;
		}

		Node root = this.new Node(a[0]);

		Node treeNode = root;

		for (int i = 1; i < a.length; i++) {
			Node n = new Node(a[i]);

			while (true) {
				if (n.val > treeNode.val) {
					if (treeNode.right == null) {
						treeNode.right = n;
						treeNode = root;
						break;
					} else
						treeNode = treeNode.right;
				} else {
					if (treeNode.left == null) {
						treeNode.left = n;
						treeNode = root;
						break;
					} else
						treeNode = treeNode.left;
				}
			}
		}

		return root;
	}

	private void displayBSTPreOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}

		System.out.print(root.val + ",");
		displayBSTPreOrder(root.left);

		displayBSTPreOrder(root.right);
	}

	private void displayBSTInOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		displayBSTInOrder(root.left);
		System.out.print(root.val + ",");
		displayBSTInOrder(root.right);
	}

	private

	class Node {
		int val;
		Node left;
		Node right;

		Node(int _val) {
			val = _val;
		}
	}
}