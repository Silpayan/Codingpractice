package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

	public static void main(String[] args) {

		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");

		System.out.println(new PathSumII().pathSumCTCI(root, 22));

	}

	// List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> currentResult = new LinkedList<Integer>();
		pathSum(root, sum, currentResult, result);
		return result;
	}

	private void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {

		if (root == null)
			return;
		
		currentResult.add(new Integer(root.val));
		
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new LinkedList(currentResult));
			currentResult.remove(currentResult.size() - 1);// don't forget to remove the last integer
			return;
		} else {
			pathSum(root.left, sum - root.val, currentResult, result);
			pathSum(root.right, sum - root.val, currentResult, result);
		}
		
		currentResult.remove(currentResult.size() - 1);
	}

	private void pathSum(TreeNode root, int sum, List<Integer> list) {
		if (root == null) {
			return;
		}
		System.out.println(sum + " list = " + list);
		list.add(new Integer(root.val));

		if (root.left == null && root.right == null && sum == root.val) {
			// result.add(new LinkedList<Integer>(list));
			// list.remove(list.size() - 1);
			// System.out.println(result);
			return;
		} else {
			pathSum(root.left, sum - root.val, list);
			pathSum(root.right, sum - root.val, list);// new ArrayList<Integer>(list));
		}

	}

	/*
	 * Code from CTCI
	 */

	List<List<Integer>> pathSumCTCI(TreeNode root, int targetSum) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> currentResult = new LinkedList<Integer>();
		//System.out.println("Paths count : " + 
		countPathsWithSum(result, currentResult, root, targetSum, 0, new HashMap<Integer, Integer>());
		return result;
	}

	void countPathsWithSum(List<List<Integer>> result, List<Integer> currentResult, TreeNode node, int targetSum,
			int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null)
			return; // Base case

		/* Count paths with sum ending at the current node. */
		runningSum += node.val;
		currentResult.add(node.val);

		int sum = runningSum - targetSum;
		//int totalPaths = pathCount.getOrDefault(sum, 0);

		/*
		 * If runningSum equals targetSum, then one additional path starts at root. Add
		 * in this path .
		 */
		if (runningSum == targetSum) {
			//totalPaths++;
			result.add(new ArrayList<Integer>(currentResult));
			currentResult.remove(currentResult.size()-1);
		}

		/* Increment pathCount, recurse, then decrement pathCount. */
		//incrementHashTable(pathCount, runningSum, 1); // Increment pathCount
		countPathsWithSum(result, currentResult, node.left, targetSum, runningSum, pathCount);
		countPathsWithSum(result, currentResult, node.right, targetSum, runningSum, pathCount);
		//incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount

		if(!currentResult.isEmpty())currentResult.remove(currentResult.size()-1);
	}

	/*void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		if (newCount == 0) { // Remove when zero to reduce space usage
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}*/
}
