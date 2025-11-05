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

    public ListNode deleteMiddle2(ListNode head) {
        // Create a dummy node pointing to head to handle edge cases
        // This helps when we need to delete the first node
        ListNode dummyNode = new ListNode(0, head);

        // Initialize two pointers for the two-pointer technique
        // slowPointer will eventually point to the node before the middle
        ListNode slowPointer = dummyNode;
        // fastPointer moves twice as fast to find the middle
        ListNode fastPointer = head;

        // Traverse the list using two-pointer technique
        // When fastPointer reaches the end, slowPointer will be just before the middle
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Delete the middle node by skipping it
        // Connect the node before middle to the node after middle
        slowPointer.next = slowPointer.next.next;

        // Return the head of the modified list
        return dummyNode.next;
    }
	
	public static void main(String[] args) {

	}

}
