package leetcode.tree;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,9,20,15,7,8,2,6,9,};
		TreeNode root = ConvertSortedArraytoBinarySearch.sortedArrayToBST(nums);
		
		System.out.println("Max Depth : "+maxDepth(root));
		
		System.out.print("Tree PreOrder : \n[");
		ConvertSortedArraytoBinarySearch.printTreePreOrder(root);
		System.out.println("]");
		
		System.out.print("Tree InOrder : \n[");
		ConvertSortedArraytoBinarySearch.printTreeInOrder(root);
		System.out.println("]");
	}
	
	public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        
        int leftHeight = 1+maxDepth(root.left);
        
        int rightHeight = 1+maxDepth(root.right);       
        return leftHeight>rightHeight ?leftHeight: rightHeight;
    }
}
 