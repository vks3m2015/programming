package linkedList;

import linkedList.concepts.LinkedListOps;
import linkedList.concepts.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromEndofList {
	
   public static ListNode removeNthFromEnd(ListNode head, int n) {
	   return onePassSol(head, n);
	 //  return twoPassSol(); 
    }
   
   static ListNode onePassSol(ListNode head, int n){
	   ListNode dummy = new ListNode(0);
	   dummy.next = head;
	   ListNode slow = dummy, fast = dummy;
	   
	   //most important to fix relative position of slow and fast pointer
	   for(int i = 1; i<=n; i++ ) {
		   fast = fast.next;
	   }
	   
	   while(fast.next != null) {
		   slow = slow.next;
		   fast = fast.next;
	   }
	   slow.next = slow.next.next;
	   return dummy.next;
   }
   
   
   
	/*//find length of list in one pass and in second pass remove element
	 * ListNode twoPassSol(ListNode head, int n){
	 * 
	 * }
	 */

	public static void main(String[] args) {
		int[] arr2 = {1,2,3,4,5,6};
		ListNode head = LinkedListOps.buildFromArray(arr2);
		
		ListNode resultList = removeNthFromEnd(head, 2);
		System.out.println(LinkedListOps.displayStr(resultList));
		
		
	}

	static ListNode onePassSol_alternative(ListNode head, int n){
		   ListNode dummy = new ListNode(0);
		   dummy.next = head;
		   ListNode slow = dummy, fast = dummy;
		   
		   //most important to fix relative position of slow and fast pointer
		   for(int i = 1; i<=n+1; i++ ) {
			   fast = fast.next;
		   }
		   
		   while(fast != null) {
			   slow = slow.next;
			   fast = fast.next;
		   }
		   slow.next = slow.next.next;
		   return dummy.next;
	   }
}
