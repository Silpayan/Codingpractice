package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[1,2,3,null,5,null,4]");// "[1,2,3,null,5,null,4]");//"[8,3,10,1,6,null,14,null,null,4,7,13]");
		System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null)
			return result;

		//zigzagLevelOrder(result, root, 0);
		zigzagLevelOrderUsingQueue(result, root);
		return result;
	}

	private void zigzagLevelOrder(List<List<Integer>> result, TreeNode root, int level) {
		if (root == null)
			return;

		if (result.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();//same with ArrayList
			result.add(newLevel);
		}

		List<Integer> collection = result.get(level);
		if (level % 2 == 0)
			collection.add(root.val);// append
		else
			collection.add(0, root.val);// perpend

		zigzagLevelOrder(result, root.left, level + 1);
		zigzagLevelOrder(result, root.right, level + 1);
	}
	
	private void zigzagLevelOrderUsingQueue(List<List<Integer>> result, TreeNode root) {//Even better than Recursive
		
		//List<Integer> collection = result.get(level);
		

		
		//List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		int level = 0;

		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				root = q.poll();
				
				if (level % 2 == 0)
					tmp.add(root.val);// append
				else
					tmp.add(0, root.val);// perpend
				//tmp.add(node.val);
				if (root.left != null)
					q.add(root.left);
				if (root.right != null)
					q.add(root.right);
			}
			result.add(tmp);
			level++;
		}
		//return result;
	}
	
	
	

	private void zigzagLevelOrderSelf(List<List<Integer>> result, TreeNode root, int level) {
		if (root == null)// Not working
			return;
		// adding root.val
		if (result.size() >= level) {
			result.get(level - 1).add(root.val);
		} else {
			List<Integer> levelzzList = new ArrayList<Integer>();// 1<<level*2
			levelzzList.add(root.val);
			result.add(level - 1, levelzzList);
		}

		if (level % 2 == 1) {
			// right to left call
			zigzagLevelOrder(result, root.right, level + 1);
			zigzagLevelOrder(result, root.left, level + 1);

		} else {
			// left to right call
			zigzagLevelOrder(result, root.left, level + 1);
			zigzagLevelOrder(result, root.right, level + 1);

		}
	}

}
