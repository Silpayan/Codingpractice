package leetcode.linkedlist;

import java.util.HashMap;

public class CopyListwithRandomPointer {

	static Node head = new Node();
	static Node node1 = new Node();
	static Node node2 = new Node();
	static Node node3 = new Node();

	public static void main(String[] args) {
		head.next = node1;head.val = 0;
		node1.next = node2; node1.val = 1;node1.random = node1;
		node2.next = node3; node2.val = 2; node2.random = node2;
		node3.next = null; node3.val = 3;node3.random = node1;

		printLinkedList(head);

		//head = reverseList(head);
		Node newHead = copyRandomList(head);
		
		printLinkedList(newHead);

	}

	public static Node copyRandomList(Node head) {
        
        /*Node newHead = new Node();
        newHead.next = head;
        newHead.val = head.val;
        Node prevNewList = newHead;*/
		
		if(head == null)	return null;
        
		HashMap<Node,Node> randomNode = new HashMap<Node,Node>();
        Node node = head;
        while(node != null){
        	
        	randomNode.put(node, new Node());
        	node = node.next;
        	
        }
        
        node = head;
        while(node != null){
            /*Node n = new Node();
            n.val = head.val;
            prevNewList.next = n;
            //randomNode.add(,);
            prevNewList = n;
            head = head.next;*/
        	randomNode.get(node).val = node.val;
        	randomNode.get(node).next = randomNode.get(node.next);
        	randomNode.get(node).random = randomNode.get(node.random);
        	node = node.next;
        	
        	
        }
        
        return randomNode.get(head);
        
    }
	
	private static void printLinkedList(Node node) {
		System.out.println("\nLinked list : ");
		int count = 0;
		
		while(node!=null){
			//print nodes
			System.out.print("["+node.val+"]->"+"("+node.random+")");
			node=node.next;
		}
		System.out.print("null");
	}
	
	
	// Definition for a Node.
	static class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	};
}
