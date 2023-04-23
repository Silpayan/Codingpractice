package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * 
426. Convert Binary Search Tree to Sorted Doubly Linked List
Medium

Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 

Example 1:

Input: root = [4,2,5,1,3]

Output: [1,2,3,4,5]
 * 
 */

public class ConvertBinarySearchTreetoSortedDoublyLinkedList_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,2,5,1,3};
		TreeNode root = ConvertSortedArraytoBinarySearch.sortedArrayToBST(nums);
		
		//PrintLinkedList(root, nums.length); 
		
		root = treeToDoublyList(root);
		
		System.out.println(first.val);
		
		PrintLinkedList(root, nums.length);

	}
	
	 private static void PrintLinkedList(TreeNode root, int length) {
		// TODO Auto-generated method stub
		 System.out.println("Forward List : ");
		 for(int i=0; i<length; i++) {
			 System.out.print(root.val+", ");
			 root=root.right;
		 }
		 
		 root = root.left;
		 
		 System.out.println("\nBackward List : ");
		 for(int i=0; i<length; i++) {
			 System.out.print(root.val+", ");
			 root=root.left;
			 
		 }
		
	}

	 
	// the smallest (first) and the largest (last) nodes
	  static TreeNode first = null;
	  static TreeNode last = null;

	  public static void helper(TreeNode node) {
	    if (node != null) {
	      // left
	      helper(node.left);
	      // node 
	      if (last != null) {
	        // link the previous node (last)
	        // with the current one (node)
	        last.right = node;
	        node.left = last;
	      }
	      else {
	        // keep the smallest node
	        // to close DLL later on
	        first = node;
	      }
	      last = node;
	      // right
	      helper(node.right);
	    }
	  }

	  public static TreeNode treeToDoublyList(TreeNode root) {
	    if (root == null) return null;

	    helper(root);
	    // close DLL
	    last.right = first;
	    first.left = last;
	    return first;
	  }
	  
	public static TreeNode treeToDoublyListLC(TreeNode root) {
	        if (root == null) {
	            return null;
	        }

	        TreeNode first = null;
	        TreeNode last = null;

	        Stack<TreeNode> stack = new Stack<>();
	        while (root != null || !stack.isEmpty()) {
	            while (root != null) {
	                stack.push(root);
	                root = root.left;
	            }
	            root = stack.pop();
	            if (first == null) {
	                first = root;
	            }
	            if (last != null) {
	                last.right = root;
	                root.left = last;
	            }
	            last = root;
	            root = root.right;
	        }
	        first.left = last;
	        last.right = first;
	        return first;
	    }

}
