package ctci;

import java.util.HashMap;

import leetcode.tree.LCStringtoTreeNode;
import leetcode.tree.PathSumII;
import leetcode.tree.TreeNode;

/*
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).
 */
public class PathWithSumBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");

		System.out.println(new PathWithSumBinaryTree().countpathsWithSum(root, 22));
	}

	int countpathsWithSum(TreeNode root, int targetSum) {
		return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}

	int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null)
			return 0; // Base case

		/* Count paths with sum ending at the current node. */
		runningSum += node.val;
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);

		/*
		 * If runningSum equals targetSum, then one additional path starts at root. Add
		 * in this path .
		 */
		if (runningSum == targetSum) {
			totalPaths++;
		}

		/* Increment pathCount, recurse, then decrement pathCount. */
		incrementHashTable(pathCount, runningSum, 1); // Increment pathCount
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
		incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount

		return totalPaths;
	}

	void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		if (newCount == 0) { // Remove when zero to reduce space usage
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}
}
