package leetcode.tree;

public class ConvertSortedArraytoBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3,4,5,6,7};
		TreeNode root = sortedArrayToBST(nums);
		
		System.out.print("Tree PreOrder : \n[");
		printTreePreOrder(root);
		System.out.println("]");
		
		
		System.out.print("Tree InOrder : \n[");
		printTreeInOrder(root);
		System.out.println("]");
		

	}

	public static void printTreePreOrder(TreeNode root) {
		if(root==null) return;
		System.out.print(root.val+", ");
		//System.out.println("\t/  \\");
		if(root.left!=null) {
			//System.out.println("/");
			printTreePreOrder(root.left);
		} else
			System.out.print(" null,");
		if(root.right!=null) {
			//System.out.println("\\");
			printTreePreOrder(root.right);
		} else
			System.out.print(" null,");
	}
	
	public static void printTreeInOrder(TreeNode root) {
		if(root==null) return;
		
		//System.out.println("\t/  \\");
		if(root.left!=null) {
			//System.out.println("/");
			printTreePreOrder(root.left);
		} else
			System.out.print(" null,");
		System.out.print(root.val+", ");
		if(root.right!=null) {
			//System.out.println("\\");
			printTreePreOrder(root.right);
		} else
			System.out.print(" null,");
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
	
		int start = 0, end=nums.length-1;
		TreeNode root = createBST(nums, start, end);
		
        return root;
	
    }

	private static TreeNode createBST(int[] nums, int start, int end) {

		if(start>end) return null;
		
		int mid = (end+start)/2; 
		
		TreeNode root = new TreeNode(nums[mid]);
		root.left = createBST(nums, start, mid-1);
		root.right = createBST(nums, mid+1, end);
		return root;
	}
}
