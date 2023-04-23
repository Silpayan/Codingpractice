package leetcode.linkedlist;

import java.util.List;

/*
 * 19. Remove Nth Node From End of List
 * 
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 */
public class RemoveNthFromEnd {


	static ListNode head = new ListNode(4);
	static ListNode node1 = new ListNode(5);
	static ListNode node2 = new ListNode(1);
	static ListNode node3 = new ListNode(9);
	static ListNode node4 = new ListNode(3);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		head.next = node1;
		node1.next = node2;
		node2.next  = node3;
		node3.next  = node4;
		
		printLinkedList();
		
		head=removeNthFromEnd(head,2);
		
		printLinkedList();
		
		
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode fastNode = dummy, lazyNode = dummy;
		//int counter=1;
		System.out.println();
		
		// Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        fastNode = fastNode.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (fastNode != null) {
	        fastNode = fastNode.next;
	        lazyNode = lazyNode.next;
	    }
	 
	    
		System.out.println("lazyVal = "+lazyNode.val);
		lazyNode.next = lazyNode.next.next;
		
		System.out.println();
		
		return dummy.next;
    }
	
	private static void printLinkedList() {
		ListNode node = head;
		System.out.println("\nLinked list : ");
		while(node!=null){
			//print nodes
			System.out.print("["+node.val+"]->");
			node=node.next;
		}
		//System.out.print("["+node.val+"]");
	}


}
