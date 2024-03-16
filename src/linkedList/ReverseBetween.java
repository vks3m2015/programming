package linkedList;

import linkedList.concepts.LinkedListOps;
import linkedList.concepts.ListNode;

public class ReverseBetween {

	
   public static ListNode reverseBetween(ListNode head, int left, int right) {
       
        ListNode preStart, start, prev = null, ptr = head, temp;
        
        //reach up to position 
        for(int pos = 1; pos < left; pos++  ) {
        	prev = ptr;
        	ptr = ptr.next;
        }
	   
        //save ptrs to use later
        preStart = prev;
        start = ptr;
       
        //reverse logic. When coming out this prev will point to last element (right element)
        for(int pos = left; pos <= right; pos++) {
        	temp = ptr.next;
        	ptr.next = prev;
        	
        	prev = ptr;
        	ptr = temp;
        }
        
        start.next = ptr;
        
        //To avoid null case and ensure preStart is never null, we can use dummy node
        if(preStart == null) 
        	head = prev;
        else
            preStart.next = prev;
	    return head;
    }
   
   //Same as above but using dummy node (or head node)
   public static ListNode reverseBetween2(ListNode head, int left, int right) {
       
	   ListNode dummy = new ListNode(-1);
	   dummy.next = head;
	   
       ListNode preStart, start, prev = dummy, ptr = head, temp;
       
       //reach up to position 
       for(int pos = 1; pos < left; pos++  ) {
       	prev = ptr;
       	ptr = ptr.next;
       }
	   
       //save ptrs to use later
       preStart = prev;
       start = ptr;
      
       //reverse logic. When coming out this prev will point to last element (right element)
       for(int pos = left; pos <= right; pos++) {
       	temp = ptr.next;
       	ptr.next = prev;
       	
       	prev = ptr;
       	ptr = temp;
       }
       
       //connect
       start.next = ptr;
       preStart.next = prev;
	    return dummy.next;
   }
   
   public static void main(String[] args) {

		int[] arr = {};
		int[] arr1 = {1};
		int[] arr2 = {1,2};
		int[] arr3 = {1,2,3,4,5,6,7,8};
		
		//printResult(arr);
		//printResult(arr1);
		//printResult(arr2, 1,2);
		printResult(arr3);
	}
	
	public static void printResult(int[] arr) {
		ListNode head = LinkedListOps.buildFromArray(arr);
		System.out.println(" List == "+LinkedListOps.displayStr(head));
		System.out.println(" Reverse of list = "+ LinkedListOps.displayStr(reverseBetween(head, 3, 6 )));
		System.out.println("==============================================================");
		
	}

}
