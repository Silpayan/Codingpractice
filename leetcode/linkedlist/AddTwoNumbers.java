package leetcode.linkedlist;


/*
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

	static ListNode head1 = new ListNode(4);
	static ListNode node1 = new ListNode(5);
	static ListNode node2 = new ListNode(1);
	static ListNode node3 = new ListNode(9);
	static ListNode node4 = new ListNode(3);
	
	static ListNode head2 = new ListNode(4);
	static ListNode node21 = new ListNode(6);
	static ListNode node22 = new ListNode(6);
	static ListNode node23 = new ListNode(7);
	static ListNode node24 = new ListNode(8);
	public static void main(String[] args) {
		head1.next = node1;
		node1.next = node2;
		node2.next  = node3;
		node3.next  = node4;
		
		head2.next = node21;
		node21.next = node22;
		node22.next  = node23;
		node23.next  = node24;
		
		printLinkedList(head1);
		printLinkedList(head2);
		head1=new AddTwoNumbers().addTwoNumbers(head1, head2);
		
		printLinkedList(head1);
		
		
	}

	
public ListNode addTwoNumbersSelf(ListNode l1, ListNode l2) {
        
        ListNode lN = new ListNode(0);
        ListNode newList = lN;
        //newList.next = lN;
        ListNode n = lN;
        int carry = 0;
        
        while(l1!=null && l2!=null){
            lN = new ListNode(0);
            lN.val=(l1.val+l2.val+carry)%10;
            System.out.println(newList.val+","+lN.val);
            carry = (l1.val+l2.val+carry)/10;
            n.next = lN;
            n=n.next;
            System.out.println(newList.next.val+","+lN.val);
            l1=l1.next;
            l2=l2.next;
        }
        
        
        while(l1!=null){
            lN = new ListNode(0);
            lN.val=(l1.val+carry)%10;
            carry = (l1.val+carry)/10;
            System.out.println(lN.val);
            n.next = lN;
            n=n.next;
            l1=l1.next;
        }
        while(l2!=null){
            lN = new ListNode(0);
            lN.val=(l2.val+carry)%10;
            carry = (l2.val+carry)/10;
            System.out.println(lN.val);
            n.next = lN;
            n=n.next;
            l2=l2.next;
        }
        
        if(carry != 0){
            lN = new ListNode(0);
            lN.val=carry;
            System.out.println(lN.val);
            n.next = lN;
            //n=n.next;
        }
    
        return newList.next;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int a = 0;
        int d1, d2, sum;
        while(l1 != null || l2 != null){
            d1 = l1 == null ? 0 : l1.val;
            d2 = l2 == null ? 0 : l2.val;
            sum = d1 + d2 + a;
            cur.next = new ListNode(sum%10);
            a = sum >= 10 ? 1:0;
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(a == 1) cur.next = new ListNode(1);
        return head.next;
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
