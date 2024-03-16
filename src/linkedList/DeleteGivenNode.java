package linkedList;

import linkedList.concepts.LinkedListOps;
import linkedList.concepts.ListNode;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteGivenNode {

  //pointer to the node to be deleted is given 	
   public static void deleteNode(ListNode node) {
	   ListNode nextNode = node.next;
		node.val = nextNode.val;
		node.next = nextNode.next;
		nextNode.next = null;
    }

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6};
		ListNode head = LinkedListOps.buildFromArray(arr);
		deleteNode(head.next.next.next);  //delete 4
		System.out.println(LinkedListOps.displayStr(head));  //1 -> 2 -> 3 -> 5 -> 6 -> NULL
	}

}
