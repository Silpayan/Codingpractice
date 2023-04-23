package leetcode.linkedlist;

import java.util.List;

public class mergeTwoSortedLists {

	static ListNode head1 = new ListNode(1);
	static ListNode node2 = new ListNode(4);
	static ListNode node3 = new ListNode(9);
	
	static ListNode head2 = new ListNode(2);
	static ListNode node11 = new ListNode(3);
	static ListNode node22 = new ListNode(5);
	static ListNode node33 = new ListNode(7);
	static ListNode node44 = new ListNode(8);

	public static void main(String[] args) {
		head1.next = node2;
		node2.next = node3;
		
		head2.next = node11;
		node11.next = node22;
		node22.next = node33;
		node33.next = node44;

		printLinkedList(head1);
		printLinkedList(head2);

		head1 = mergeRecursive(head1, head2);

		printLinkedList(head1);
		printLinkedList(head2);

	}

	private static ListNode merge(ListNode head1, ListNode head2) {
		// TODO Auto-generated method stub
		ListNode list1 = head1;
		ListNode list3 = new ListNode(0);
		ListNode list2 = head2, currentNode=list3;
		
		
		while(list1!=null && list2!=null){
			System.out.println("list1: "+list1.val+" list2 : "+list2.val);
			if(list1.val<list2.val) {
				currentNode.next = list1;
				currentNode = currentNode.next; 
				list1 = list1.next;
			} else
			{
				currentNode.next = list2;
				currentNode = currentNode.next; 
				list2 = list2.next;
			}
		}
		
		if(list1 !=null)
            currentNode.next = list1;
        else
            currentNode.next = list2;
		
		list1 = list2 = null;//freeing up ref
		
		
		return list3.next;
	}
	
	private static ListNode mergeRecursive(ListNode l1, ListNode l2) {
		
		if( l1 == null && l2== null ) return null;
		if( l1 == null ) return l2;
		if( l2 == null) return l1;

		if(l1.val<l2.val) {
			l1.next = mergeRecursive(l1.next, l2);
			return l1;
		} else
			{
			l2.next = mergeRecursive(l1, l2.next);
			return l2;
			}
		
	}

	private static void printLinkedList(ListNode head) {
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
