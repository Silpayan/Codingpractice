package leetcode.linkedlist;

/*
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.

 * To represent a cycle in the given linked list, we use an integer pos which represents the position 
 * (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 */
public class LinkedListCycle {

	static ListNode head = new ListNode(3);
	static ListNode node1 = new ListNode(2);
	static ListNode node2 = new ListNode(0);
	static ListNode node3 = new ListNode(-4);

	public static void main(String[] args) {
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;

		printLinkedList();

		//head = reverseList(head);
		if(hasCycle(head))
				System.out.println("\nHas Cycle");
		else 
			printLinkedList();

	}
	
	
	public static boolean hasCycle(ListNode head) {
        if(head==null)
        		return false;
        int count = 0;
        
        ListNode slow = head;
        ListNode fast =head;
        while(fast!=null && fast.next!= null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	System.out.println(count++);
        	if(slow==fast) {
        		return true;
        	}
        	
        }
        return false;	
    }
	
	
	private static void printLinkedList() {
		ListNode node = head;
		System.out.println("\nLinked list : ");
		int count = 0;
		
		while(node!=null){
			//print nodes
			System.out.print("["+node.val+"]->");
			node=node.next;
			if(count++==8)
				break;
		}
		System.out.print("null");
	}

}
