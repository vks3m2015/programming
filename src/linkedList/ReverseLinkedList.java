package linkedList;

import linkedList.concepts.LinkedListOps;
import linkedList.concepts.ListNode;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {

	
	//Idea- At each node we need only prev node link
	public static ListNode reverseList(ListNode head) {
		   ListNode prev = null, ptr = head, temp;
		   
		   while(ptr != null) {
			   temp = ptr.next; 
			   ptr.next = prev;
			   prev = ptr;
			   ptr = temp;
		   }
		   head = prev;
		   return head;
	    }
	
	
	//Idea- at each node u need three var available - prev, curr, next. But improved version - we need only two prev and curr
   public static ListNode reverseList2(ListNode head) {
	   
	   if(head == null) return null;
	   
	   ListNode prev = null, curr = head, next = head.next;
	   
	   while(next != null) {
		   curr.next = prev;
		   prev = curr;
		   curr = next;
		   next = next.next;
	   }
	   curr.next = prev;
	   return curr;
    }
	
   public static void main(String[] args) {

		int[] arr = {};
		int[] arr1 = {1};
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
		System.out.println(" Reverse of list = "+ LinkedListOps.displayStr(reverseList(head)));
		System.out.println("==============================================================");
		
	}

}
