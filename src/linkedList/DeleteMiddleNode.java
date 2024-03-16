package linkedList;

import linkedList.concepts.ListNode;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
public class DeleteMiddleNode {
	
	//PTR (Point to remember)
	//Slow and Fast pointer will start from same start point (head)

   public ListNode deleteMiddle(ListNode head) {
       
	   if(head.next == null) return null;
	   
	   ListNode slowPtr = head, fastPtr = head, slowPtrPrev = null;
	   
	   while(fastPtr != null && fastPtr.next != null) {
		   slowPtrPrev = slowPtr;
		   slowPtr = slowPtr.next;
		   fastPtr = fastPtr.next.next;
	   }
	   
	   slowPtrPrev.next = slowPtr.next;
	   return head;
    }
	
	public static void main(String[] args) {

	}

}
