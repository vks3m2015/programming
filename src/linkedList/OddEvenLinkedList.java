package linkedList;

import linkedList.concepts.ListNode;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		
		ListNode odd = head, even = head.next, evenHead = even;
		
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	// Self (Correct) 
	public ListNode oddEvenList2(ListNode head) {

		if (head == null)
			return head;
		ListNode evenHead = head.next, oddHead = head, even = evenHead, odd = oddHead, oddPrev = null;

		if (evenHead == null || evenHead.next == null)
			return head;

		while (odd.next != null && even.next != null) {

			ListNode nextNode = odd.next.next;
			odd.next = nextNode;
			oddPrev = odd;
			odd = nextNode;

			nextNode = even.next.next;
			even.next = nextNode;
			even = nextNode;
		}

		if (odd != null) {
			odd.next = evenHead;
		} else if (oddPrev != null) {
			oddPrev.next = evenHead;
		}

		return oddHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
