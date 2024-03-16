package linkedList;

import linkedList.concepts.LinkedListOps;
import linkedList.concepts.ListNode;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleNode {

	 public ListNode middleNode(ListNode head) {
		 ListNode fastPtr = head, slowPtr = head;
		 
		 //two condns one for even number of nodes and one for odd number of nodes 
		 while(fastPtr != null && fastPtr.next != null) {
			 slowPtr = slowPtr.next;
			 fastPtr = fastPtr.next.next;
		 }
		 return slowPtr;
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
		MiddleNode midNode = new MiddleNode();
		ListNode head = LinkedListOps.buildFromArray(arr);
		System.out.println(" List == "+LinkedListOps.displayStr(head));
		System.out.println(" mid of list = "+ LinkedListOps.displayStr(midNode.middleNode(head)));
		System.out.println("==============================================================");
		
	}

}


