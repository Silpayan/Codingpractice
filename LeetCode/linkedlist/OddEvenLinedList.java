package leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class OddEvenLinedList {

	static ListNode head = new ListNode(1);
	static ListNode node1 = new ListNode(2);
	static ListNode node2 = new ListNode(3);
	static ListNode node3 = new ListNode(4);
	static ListNode node4 = new ListNode(5);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		head.next = node1;
		node1.next = node2;
		node2.next  = node3;
		node3.next = node4;
		
		printLinkedList();
		
		OddEvenLinedList oeLinkedList = new OddEvenLinedList();
		oeLinkedList.oddEvenList(head);
		
		printLinkedList();
		
		
	}

	public ListNode oddEvenList(ListNode head) {

		if(head == null )
			return head;
		ListNode odd = head, evenHead = head.next, even = evenHead;
		
		while(even != null && even.next != null) {
			
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even=even.next;
		}
		
		odd.next = evenHead;
		
		return head;
	}
	

	static void printLinkedList() {
		ListNode node = head;
		System.out.println("\nLinked list : ");
		do {
			//print nodes
			System.out.print("["+node.val+"]->");
			node=node.next;
		} while(node.next!=null);
		System.out.print("["+node.val+"]");
	}

}
