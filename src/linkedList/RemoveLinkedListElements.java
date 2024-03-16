package linkedList;

import linkedList.concepts.ListNode;

//https://leetcode.com/problems/remove-linked-list-elements/description/
public class RemoveLinkedListElements {
	
	
   public ListNode removeElements(ListNode head, int val) {
       ListNode dummy = new ListNode(0);
       dummy.next= head;
	   ListNode ptr = dummy;
	   
	   while(ptr.next != null) {
		 
		   if(ptr.next.val == val) {
			   ptr.next = ptr.next.next;
		   }
		   else       //careful with this else
		       ptr = ptr.next;
	   }
	   return dummy.next;
    }

	public static void main(String[] args) {
		
	}

}
