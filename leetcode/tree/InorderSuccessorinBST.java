package leetcode.tree;

/*
 * 285	Inorder Successor in BST
 * Given a BST and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 */
public class InorderSuccessorinBST {

	public static void main(String[] args) {
		TreeNode root = LCStringtoTreeNode.stringToTreeNode("[6,3,7,2,5,null,null,1]");
		TreeNode p = LCStringtoTreeNode.stringToTreeNode("[3]");
		TreeNode tn = inorderSuccessor(root, p);
		if (tn == null)
			System.out.println("null");
		else
			System.out.println(tn.val);

	}

	private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (p.right != null) {
			System.out.println("p.right!=null ");
			return find(p.right);
		}

		TreeNode succ = null;

		while (root != null) {
			//if (root.val == p.val) {
				//return succ;
			//} else 
			if (root.val > p.val) {
				succ = root;
				root = root.left;
			} else if (root.val < p.val) {
				root = root.right;
			} else
				break; // root.val=p.val succ found
		}

		return succ;
	}
	
	TreeNode findInOrderSuccessor(TreeNode inputNode) {
	      // your code goes here 
	      
	      /*
	      inputNode have right 
	          smallest node on right subtree
	      else
	        
	        first time(parent>iN)
	          return parent
	      */
		TreeNode n; 
	      if(inputNode.right!=null){
	        n=inputNode.right;
	        while(n.left!=null){
	          n=n.left;
	        }
	                
	        return n;
	        
	      } else {
	        n=inputNode.parent; //
	        while(n!=null){
	          if(n.val>inputNode.val){
	            return n;
	          } else {
	            n=n.parent;
	          }
	        }
	      }
	    
	      return null;
	      
	    }

	private static TreeNode find(TreeNode p) {
		if (p.left != null) {
			p = p.left;
		}
		return p;
	}

}
