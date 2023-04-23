package leetcode.tree;

import java.util.LinkedList;

public class KthSmallestElementinaBST {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		TreeNode root= LCStringtoTreeNode.stringToTreeNode("[5,3,6,2,4,null,null,1]");//"[3,1,4,null,2]");//"[5,3,6,2,4,null,null,1]");
		KthSmallestElementinaBST kthsmallBST = new KthSmallestElementinaBST();
		
		//System.out.print("Tree InOrder : \n[");
		//ConvertSortedArraytoBinarySearch.printTreeInOrder(root);
		
		System.out.println(kthsmallBST.kthSmallest(root,3));
	}
	
	int count = 0;
	int result = Integer.MIN_VALUE;
	
    public int kthSmallest(TreeNode root, int k) {//Self with correction from LC
    	inOrder(root,k);
        
        return result;
    }
    
   public void inOrder(TreeNode root, int k){
	   if(root == null) return; //Check root earlier I was checking root.left and root.right not null
	   inOrder(root.left, k);
        if(++count==k) result = root.val;//return 0 will not work as it ends the futher call, so using Result as global value helps
       inOrder(root.right, k);
   }
   
   public int kthSmallestStack(TreeNode root, int k) {
	    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

	    while (true) {
	      while (root != null) {
	        stack.add(root);//pushing the node to stack
	        root = root.left;
	      }
	      root = stack.removeLast(); //Popping last from stack for traversing to right side. 
	      if (--k == 0) return root.val;
	      root = root.right;
	    }
	  }

}
