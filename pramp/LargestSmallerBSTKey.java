package pramp;

public class LargestSmallerBSTKey {

	
	  static class Node {
		    int key;
		    Node left;
		    Node right; 
		    Node parent;
		    
		    Node(int key) {
		      this.key = key;
		      left = null;
		      right = null;
		      parent = null;
		    }
		  }
		  
		  static class BinarySearchTree {
		    
		    Node root;
		    
		    int findLargestSmallerKey(int num) {
		      // your code goes here 
		      if (root==null) return -1;
		      Node n = this.root;
		      
		      while(n!=null){
		        System.out.println(n.key);
		        
		        if(n!=root && num>n.key && n.parent.key<num) return n.key;
		        if(n!=root && num>n.parent.key && num<n.key) return n.parent.key;
		        //else return n.key;
		        
		        if(n.key>num){//traverse towards left
		            n=n.left;
		          System.out.println(n.key+" left ,"+num);
		            
		        } else
		          if(n.key<num){ //traverse right
		            n=n.right;
		            System.out.println(n.key+" right ,"+num);
		          }
		      }
		      /*
		      left check - greater than me and smaller than parent
		      Right - check - greater than parent and less than me return parent
		                     - greater then me return this.key
		      */
		      
		      if(n.key>num) return -1;
		      else return n.key;
		      
		    }
		    
		    //  inserts a new node with the given number in the
		    //  correct place in the tree
		    void insert(int key) {
		      
		      // 1) If the tree is empty, create the root
		      if(this.root == null) {
		        this.root = new Node(key);
		        return;
		      }
		      
		      // 2) Otherwise, create a node with the key
		      //    and traverse down the tree to find where to
		      //    to insert the new node
		      Node currentNode = this.root;
		      Node newNode = new Node(key); 
		      
		      while(currentNode != null) {
		        if(key < currentNode.key) {
		          if(currentNode.left == null) {
		            currentNode.left = newNode;
		            newNode.parent = currentNode;
		            break;
		          } else {
		            currentNode = currentNode.left;
		          }
		        } else {
		          if(currentNode.right == null) {
		            currentNode.right = newNode;
		            newNode.parent = currentNode;
		            break;
		          } else {
		            currentNode = currentNode.right;
		          }
		        }
		      }
		    }
		  }

		  /*********************************************
		   * Driver program to test above function     *
		   *********************************************/ 
		   
		   public static void main(String[] args) {
		     
		     // Create a Binary Search Tree
		     BinarySearchTree bst = new BinarySearchTree();
		     bst.insert(20);
		     bst.insert(9);
		     bst.insert(25);
		     bst.insert(5);
		     bst.insert(12);
		     bst.insert(11);
		     bst.insert(14);
		     
		     int result = bst.findLargestSmallerKey(6);
		     System.out.println("Largest smaller number is " + result);
		    
		  }
}
