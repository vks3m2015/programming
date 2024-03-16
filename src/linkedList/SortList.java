package linkedList;

import linkedList.concepts.LinkedListOps;
import linkedList.concepts.ListNode;

//https://leetcode.com/problems/sort-list/
public class SortList {
	
	//MERGE SORT
	 public ListNode sortList(ListNode head) {

		 if(head == null || head.next == null) {
			 return head;
		 }
		 
		 ListNode preMid = preMidNode(head);
		 ListNode mid = preMid.next;
		 preMid.next = null;
		 
		 //While dividing keep corner cases in consideration. It may happen of not been diving properly that may lead to infinite loop 
		 ListNode left = sortList(head);
		 ListNode right = sortList(mid);
		 
		 return merge(left, right);
	 }
	 
	 ListNode merge(ListNode list1, ListNode list2){
		 
		 ListNode dummy = new ListNode(-1);
		 ListNode tail = dummy;
		 
		 while(list1 != null && list2 != null) {
			 
			if(list1.val <= list2.val) {
				tail.next = list1;
				list1 = list1.next;
			}else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		 }
		 
		 if(list1 != null)
			 tail.next = list1;
		 
		 if(list2 != null)
			 tail.next = list2;
		 
		 return dummy.next;
	 }
	 
	 
	 public ListNode preMidNode(ListNode head) {
		 ListNode fastPtr = head, slowPtr = head, midPrev = null;
		 while(fastPtr != null && fastPtr.next != null) {
			 midPrev = slowPtr;
			 slowPtr = slowPtr.next;
			 fastPtr = fastPtr.next.next;
		 }
		 return midPrev;
	 }

	public static void main(String[] args) {
		
		int[] arr = {-1,5,3,4,0};
        int[] arr1 = {6};
        int[] arr2 = {6,5,4,2,1,-1,-2,-3};
		
		printResult(arr);
		printResult(arr1);
		printResult(arr2);
	}
	
	public static void printResult(int[] arr) {
		SortList sl = new SortList();
		ListNode head = LinkedListOps.buildFromArray(arr);
		System.out.println(" List before Sort == "+LinkedListOps.displayStr(head));
		System.out.println(" List after Sort === " +LinkedListOps.displayStr(sl.sortList(head)));
		System.out.println("=======================================================");
		
	}

}
