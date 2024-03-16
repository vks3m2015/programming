package linkedList.concepts;

public class LinkedListOps {

	
	public static ListNode buildFromArray(int[] arr) {
		
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy, tail = dummy;
		
		for(int val : arr) {
			ListNode node = new ListNode(val);
			tail.next = node;
			tail = tail.next;
		}
		return head.next;
	}
	
	public static String displayStr(ListNode head){
		
		String listStr = "";
		ListNode ptr = head;
		while(ptr != null) {
			listStr = listStr + ptr.val + " -> ";
			ptr = ptr.next;
		}
		return listStr + "NULL";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
