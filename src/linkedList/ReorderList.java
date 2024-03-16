package linkedList;

import linkedList.concepts.LinkedListOps;
import linkedList.concepts.ListNode;

//https://leetcode.com/problems/reorder-list/
public class ReorderList {

   public static void reorderList(ListNode head) {
	   if(head==null||head.next==null) return;
	   
       ListNode list1 = head;
	   ListNode preMid = preMid(head);
	   ListNode mid = preMid.next;
	   preMid.next = null;
	   ListNode list2 = reverseList(mid);
	   head = merge(list1, list2);
    }

   public static ListNode merge(ListNode ptr1, ListNode ptr2) {
	  
	   ListNode dummy = new ListNode(-1);
	   ListNode ptr3 = dummy;
	   
	   while(ptr1 != null && ptr2 != null) {
		   ptr3.next = ptr1;
		   ptr1 = ptr1.next;
		   ptr3 = ptr3.next;
		   
		   ptr3.next = ptr2;
		   ptr2 = ptr2.next;
		   ptr3 = ptr3.next;
	   }
	   
	   if(ptr1 != null)
		   ptr3.next = ptr1;
	   if(ptr2 != null)
		   ptr3.next = ptr2;
	   
	   return dummy.next;
   }
   
    public static ListNode preMid(ListNode head) {
    	ListNode slow = head, fast = head, preMid = null;
    	while( fast != null && fast.next != null) {
    		preMid = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return preMid;
    }
    
   public static ListNode reverseList(ListNode head) {
    	ListNode prev = null, ptr = head, temp;
    	
    	while(ptr != null) {
    		temp = ptr.next;
    		ptr.next = prev;
    		
    		prev = ptr;
    		ptr = temp;
    	}
    	return prev;
    }
   
    public static void main(String[] args) {

		int[] arr = {1};
		int[] arr1 = {1,2};
		int[] arr2 = {1,2,3,4,5,6};
		int[] arr3 = {1,2,3,4,5,6,7};
		
		printResult(arr);
		printResult(arr1);
		printResult(arr2);
		printResult(arr3);
	}
	
	public static void printResult(int[] arr) {
		ListNode head = LinkedListOps.buildFromArray(arr);
		System.out.println(" List == "+LinkedListOps.displayStr(head));
		ReorderList.reorderList(head);
		System.out.println(" After Reorder list = "+ LinkedListOps.displayStr(head));
		System.out.println("==============================================================");
		
	}
	
	/*
	 * List == 1 -> NULL       After Reorder list = 1 -> NULL
	 * ============================================================== 
	 * List == 1 -> 2-> NULL    After Reorder list = 1 -> 2 -> NULL
	 * ============================================================== 
	 * List == 1 -> 2-> 3 -> 4 -> 5 -> 6 -> NULL    
	 * After Reorder list = 1 -> 6 -> 2 -> 5 -> 3 -> 4-> NULL 
	 * ==============================================================
	 *  List == 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> NULL 
	 *  After Reorder list = 1 -> 7 -> 2-> 6 -> 3 -> 5 -> 4 -> NULL
	 * ==============================================================
	 */

	

}
