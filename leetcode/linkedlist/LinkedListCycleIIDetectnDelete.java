package leetcode.linkedlist;

/*
 * 142. Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) 
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * 
 * Detect and Delete
 */
public class LinkedListCycleIIDetectnDelete {

	static ListNode head = new ListNode(3);
	static ListNode node1 = new ListNode(2);
	static ListNode node2 = new ListNode(0);
	static ListNode node3 = new ListNode(-4);
	static ListNode node4 = new ListNode(5);

	public static void main(String[] args) {
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node1;

		printLinkedList();

		System.out.println("\nHas Cycle at : " + detectCycle(head));

		 deleteCycle(head);
		
		printLinkedList();
	}

	public static ListNode detectCycle(ListNode head) {
		int count = 0;

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println(count++);
			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				System.out.println(slow.val);
				return slow;
			}

		}
		return null;
	}
	
	public static void deleteCycle(ListNode head) {
		int count = 0;

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			System.out.println(count++);
			if (slow == fast) {
				slow = head;
				while (slow.next != fast.next) {
					slow = slow.next;
					fast = fast.next;
				}
				System.out.println(slow.val);
				fast.next = null;
				//return slow;
			}

		}
		//return null;

	}

	private static void printLinkedList() {
		ListNode node = head;
		System.out.println("\nLinked list : ");
		int count = 0;

		while (node != null) {
			// print nodes
			System.out.print("[" + node.val + "]->");
			node = node.next;
			if (count++ == 8)
				break;
		}
		System.out.print("null");
	}
}
