package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 3, 9, 20, 15, 7 };
		TreeNode root = ConvertSortedArraytoBinarySearch.sortedArrayToBST(nums);

		System.out.println("Level Order : " + new BinaryTreeLevelOrderTraversal().levelOrder(root));

		System.out.print("Tree PreOrder : \n[");
		ConvertSortedArraytoBinarySearch.printTreePreOrder(root);
		System.out.println("]");

		System.out.print("Tree InOrder : \n[");
		ConvertSortedArraytoBinarySearch.printTreeInOrder(root);
		System.out.println("]");
	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> levelOrderNodes = new ArrayList<List<Integer>>();

		if (root == null)
			return levelOrderNodes;

		//levelOrderNodes = levelOrder(levelOrderNodes, 0, root);
		
		//return levelOrderNodes;
		
		return levelOrderusingQueue(root);
	}

	private List<List<Integer>> levelOrder(List<List<Integer>> levelOrderNodes, int i, TreeNode root) {

		List<Integer> current = new ArrayList<>();

		System.out.println(levelOrderNodes + ", " + levelOrderNodes.size());
		if (!levelOrderNodes.isEmpty() && levelOrderNodes.size() > i) {
			levelOrderNodes.get(i).add(root.val);
		} else {
			current.add(root.val);
			levelOrderNodes.add(i, current);
		}

		if (root.left != null) {
			levelOrderNodes = levelOrder(levelOrderNodes, i + 1, root.left);
		}
		if (root.right != null) {
			levelOrderNodes = levelOrder(levelOrderNodes, i + 1, root.right);
		}

		return levelOrderNodes;

	}

	public List<List<Integer>> levelOrderusingQueue(TreeNode root) { // Faster memory same.

		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if (root == null)
			return ans;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				tmp.add(node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			ans.add(tmp);
		}
		return ans;
/*
 * *
 * 
 *      List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //DFS
        if(root==null) return res;
        DFS(root,0);
        return res;
    }
    
    public void DFS(TreeNode root,int depth){
        if(root==null) return;
        while(res.size()<=depth){
            List<Integer> temp = new ArrayList<Integer>();
            res.add(temp);
        }
        //inorder
        res.get(depth).add(root.val);
        DFS(root.left,depth+1);
        DFS(root.right,depth+1);
    }
 */
	}

}
