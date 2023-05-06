package leetcode.linkedlist;
/*
 * 5283. Convert Binary Number in a Linked List to Integer
User Accepted:2486
User Tried:2522
Total Accepted:2515
Total Submissions:2771
Difficulty:Easy
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

 */
public class ConvertBinaryNumberinaLinkedListtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(getDecimalValue(head));
	}
	
	public static int getDecimalValue(ListNode head) {
        if(head==null)
            return 0;
        int num = 0;
        
        while(head!=null){
            if(head.val==1)
                num = num*2+1;
            else
                if(head.val==0){
                    num *= 2 ;
                }
            head = head.next;
        }
        
        return num;
    }

}
