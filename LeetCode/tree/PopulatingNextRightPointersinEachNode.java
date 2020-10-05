package leetcode.tree;


// 116. Populating Next Right Pointers in Each Node

// Next 117. Populating Next Right Pointers in Each Node II


public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCStringtoTreeNode.stringToTreeNode("[1,2,3,4,null,null,5]");//"[5,3,6,2,4,null,null,1]");
		

	}

public Node connect1(Node root) {
	if(root==null) return null;
	
	connectHelper(root.left,root.right);
	//if(root.next != null)
	connectHelper(root.right,null);
	return root;
    }

public void connectHelper(Node root, Node next) {
	if(root == null) return;
	root.next = next;
	connectHelper(root.left,root.right);
	if(root.next != null) //To check if this has a right subtree so child can refer to the right->left node of it as next 
		connectHelper(root.right,root.next.left);
	}

public Node connect(Node root) {
    if (root == null || root.left == null || root.right == null)
       return root;
    
    root.left.next = root.right;
    if (root.next != null)
        root.right.next = root.next.left;
    
    connect(root.left);
    connect(root.right);
    return root;
}


public Node connectII(Node root) {
    if (root == null)
       return root;
    
    root.left.next = root.right;
    if (root.next != null)
    	if(root.next.left!=null)
    		root.right.next = root.next.left;
    	else if(root.next.right != null)
    		root.right.next = root.next.right;
    
    connect(root.left);
    connect(root.right);
    return root;
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
}
