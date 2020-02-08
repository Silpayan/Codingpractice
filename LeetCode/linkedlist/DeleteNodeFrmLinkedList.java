package leetcode.linkedlist;

public class DeleteNodeFrmLinkedList {

	static ListNode head = new ListNode(4);
	static ListNode node1 = new ListNode(5);
	static ListNode node2 = new ListNode(1);
	static ListNode node3 = new ListNode(9);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		head.next = node1;
		node1.next = node2;
		node2.next  = node3;
		
		printLinkedList();
		
		deleteNode(node2);
		
		printLinkedList();
		
		
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
	
	static  void deleteNode(ListNode node) {
		if(node.next!=null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}
	
	public static  void deleteNodefromHead(ListNode node) {
		
		System.out.println("\ndeleting Node : "+node.val);
		ListNode delNode = head, trailingNode=null;
		do {
			//print nodes
			System.out.print("["+delNode.val+"]->");
			if(delNode.val == node.val) {
				trailingNode.next=delNode.next;
				break;
			}
			
			trailingNode = delNode;
			delNode=delNode.next;
				
		} while(delNode.next!=null);
        
    }

}



// Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
	public Object leading;
     ListNode(int x) { val = x; }
 }
