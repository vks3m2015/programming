package linkedList;

import java.util.LinkedList;
import java.util.List;

public class MidElement {

	public static void main(String[] args) {

			LinkedList1<Integer> ll = new LinkedList1<Integer>();
			ll.add(3);
			ll.add(5);
			ll.add(8);
	        ll.add(10);
	      //  ll.add(12);
	        //ll.add(14);
	       // ll.add(16);
	        
	        ll.traverse();
	        
	       // ll.midElement();
        ll.midElement2();
	        
	        //-------------Another way that need not to implement linked list ------------------
	        
	        List<Integer> list = new LinkedList<Integer>();
	        list.add(1);
	        list.add(2);
	        list.add(3);
	        list.add(4);
	        list.add(5);
	        list.add(6);
	        
	       
	        
		}

	

}


class LinkedList1<E> {
   Node<E> head;

   static class Node<E> {
	   E data;
	   Node<E> next;
	   
	   Node(E data) {
		   this.data = data;
	   }
   }
   
   public void add( E element) {
	 Node<E> node = new Node(element);
	 Node<E> ptr = head;
	 
	 if(ptr == null) {
		 head = node;
		 return;
	 }	 
     while(ptr.next != null)
	   ptr = ptr.next;
	 
	 ptr.next = node;
   }
   
   public void traverse() {
	   Node<E> temp = head;
       String llStr = "";
	   while(temp != null) {
           llStr += " -> " + temp.data;
		  // System.out.println(" -> "+ temp.data);
		   temp = temp.next;
	   }
       System.out.println(" Linked List "+ llStr);
   }
   
   public void midElement() {
	   Node<E> fast = head; Node<E> slow = head;
	   
	   while(fast.next != null && fast.next.next != null) {
		   fast = fast.next.next;
		   //System.out.println(" ----"+fast.data);
		   slow = slow.next;
		   
	   }	   
	   
	   if(fast.next == null)
		   System.out.println("Mid Element => "+ slow.data);
	   else
		   System.out.println("Two Mid elements => " + slow.data +" and  "+slow.next.data);
	   
   }

   public void midElement2(){

       int count = 0;
       Node<E> tmp = head;
       while(tmp != null){
           count++;
           tmp = tmp.next;
       }
       int mid = count/2;

       tmp = head;
       while(mid > 0){
           mid--;
           tmp = tmp.next;
       }

       System.out.println(" Mid = "+ tmp.data);


   }
}
