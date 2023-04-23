package leetcode.linkedlist;

import javax.sound.midi.Track;

public class ReverseLinkedList {

	static ListNode head = new ListNode(4);
	static ListNode node1 = new ListNode(5);
	static ListNode node2 = new ListNode(1);
	static ListNode node3 = new ListNode(9);

	public static void main(String[] args) {
		head.next = node1;
		node1.next = node2;
		node2.next = node3;

		printLinkedList();

		head = reverseList(head);

		printLinkedList();

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

	public static ListNode reverseList(ListNode head) {

		ListNode leading = head, tailing = null;
        
        while(leading != null){
            leading = leading.next;
            head.next = tailing;
            tailing = head;
            head = leading;
        }
        return tailing;
	}
}
