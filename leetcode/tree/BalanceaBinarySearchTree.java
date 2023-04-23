package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBinarySearchTree {

	public static void main(String[] args) {

		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[1,2,3,null,5,null,4]");// "[1,2,3,null,5,null,4]");//"[8,3,10,1,6,null,14,null,null,4,7,13]");
		System.out.println(new BalanceaBinarySearchTree().balanceBST(root));

	}
	
public TreeNode balanceBST(TreeNode root) {
        
        List<TreeNode> nodeList = new ArrayList<TreeNode>(); 
        storeBSTNodes(root, nodeList); 
  
        // Constucts BST from nodes[] 
        int n = nodeList.size(); 
        return buildTreeUtil(nodeList, 0, n - 1); 
    }
    
    void storeBSTNodes(TreeNode root, List<TreeNode> nodes)  
    { 
        // Base case 
        if (root == null) 
            return; 
  
        // Store nodes in Inorder (which is sorted 
        // order for BST) 
        storeBSTNodes(root.left, nodes); 
        nodes.add(root); 
        storeBSTNodes(root.right, nodes); 
    } 

    TreeNode buildTreeUtil(List<TreeNode> nodes, int start, int end)  
    { 
        // base case 
        if (start > end) 
            return null; 
  
        /* Get the middle element and make it root */
        int mid = (start + end) / 2; 
        TreeNode node = nodes.get(mid); 
  
        /* Using index in Inorder traversal, construct 
           left and right subtress */
        node.left = buildTreeUtil(nodes, start, mid - 1); 
        node.right = buildTreeUtil(nodes, mid + 1, end); 
  
        return node; 
    }

}
