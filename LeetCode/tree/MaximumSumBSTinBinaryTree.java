package leetcode.tree;

/*
 * 1373. Maximum Sum BST in Binary Tree
Hard

Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class MaximumSumBSTinBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]");//"[4,3,null,1,2]");//"[1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]");
		System.out.println(new MaximumSumBSTinBinaryTree().maxSumBST(root));
	}
	
	int maxSumBST;
    public int maxSumBST(TreeNode root) {
        if(root!=null){
            try {
            maxSumBST = maxSumBST(root,null, null);
            } catch(Exception e) {
            	//do nothing
            }
        }
        
        return maxSumBST;
    }
    
	private int maxSumBST(TreeNode root, Integer lower, Integer higher) throws Exception {
		if (root == null)
			return 0;
		//System.out.println(root.val+" "+lower+" "+higher);
		int lSum=0,rSum =0;	
		boolean lEx = false,rEx=false;
		
		if (lower != null && root.val <= lower){
			System.out.println("Throwing as val <= lower : "+root.val+", "+lower);
            lEx = true;
            //throw new Exception();
            
        }
		if (higher != null && root.val >= higher){
			System.out.println("Throwing as val >= higher : "+root.val+", "+higher);
            rEx = true;
            //throw new Exception();
        }
		
		try {
			lSum = maxSumBST(root.left,lower,root.val);
		} catch(Exception e){
			lEx=true;
			
		}

		try {
			rSum = maxSumBST(root.right,root.val,higher);
		
		}catch(Exception e){
			rEx=true;
		}
		
		System.out.println(lEx+", "+lEx+", "+root.val+", "+maxSumBST);
		
		if(lEx && rEx)//both left and right subtree not BST
			return 0;
		else if(lEx)//left side not BST 
			return Math.max(rSum,maxSumBST);
		else if(rEx)
			return Math.max(lSum,maxSumBST);
		
        
        //Both side valid BST
        int tempSumBST = lSum+rSum+root.val;
            
        System.out.println(lSum+", "+rSum+", "+root.val+", "+maxSumBST);
		return Math.max(tempSumBST,maxSumBST);
	}
    
    private int maxSumBSTSelf(TreeNode root, int lower, int higher){
        
        if(root == null) return 0;
        int sum=0;
        if(root.val>lower && root.val<higher){//validate BST and add sum
            sum = root.val+maxSumBSTSelf(root.left,lower,root.val)+maxSumBSTSelf(root.right,root.val,higher);
        } else {//find max in left subtree and right subtree
            sum = Math.max(maxSumBSTSelf(root.left,lower,root.val),maxSumBSTSelf(root.right,root.val,higher));
        }
        
        
        
        return Math.max(sum,maxSumBST);
    }
    


}
