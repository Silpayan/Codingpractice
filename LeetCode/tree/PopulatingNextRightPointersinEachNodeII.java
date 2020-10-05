package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.tree.PopulatingNextRightPointersinEachNode.Node;

/*
 * 117. Populating Next Right Pointers in Each Node II
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 */

public class PopulatingNextRightPointersinEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCStringtoTreeNode.stringToTreeNode("[2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7]");//"[5,3,6,2,4,null,null,1]");
		
	}
	

    public Node connect(Node root) { //DFS
       if(root==null){
           return root;
       }
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);
       queue.add(null);
       while(!queue.isEmpty()){
           Node temp = queue.poll();
           if(temp!=null){
           Node next = queue.peek();
           temp.next=next;
               
           if(temp.left!=null){
               queue.add(temp.left);
           }
           if(temp.right!=null){
               queue.add(temp.right);
           }    
           }
           else{
               if(queue.size()>0){
                   queue.add(null);
               }
           }
       }
       return root;
   }
   
   
   public Node connectSelf(Node root) {
   if (root == null)
      return root;
       
   System.out.println(root.val);
       
   if(root.left!=null){
       //System.out.println("left "+root.val);
       if(root.right!=null)
           root.left.next = root.right;
       else {
           Node nRoot = root.next;
           while(nRoot != null){//same level travelsal
               //System.out.println(nRoot.val);
               if(nRoot.left!=null){
   		        root.left.next = nRoot.left;
                   break;
               } else {
                   if(nRoot.right != null){
   		            root.left.next = nRoot.right;
                       break;
                   }
                   else
                       nRoot=nRoot.next; 
               }
           }
       }
   }
   if (root.right != null && root.next!=null){
   	
       Node nRoot = root.next;

       do{ //same level travelsal
               //System.out.println(nRoot.val);
               if(nRoot.left!=null){
                   //System.out.println(nRoot.left.val);
   		        root.right.next = nRoot.left;
                   break;
               } else {
                   if(nRoot.right != null){
                       //System.out.println(nRoot.right.val);
   		            root.right.next = nRoot.right;
                       break;
                   }
                   else{
                       //System.out.println(nRoot.val+" "+nRoot.next.val);
                       nRoot=nRoot.next;
                       }
               }
           //System.out.println(nRoot.val);
           } while(nRoot != null);
   }
   
   connect(root.right);
   connect(root.left);
   
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
