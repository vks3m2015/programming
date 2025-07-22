package linkedList;

import java.util.HashSet;
import java.util.Set;


//https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
public class IsLoopPresent {
	
	public static void main(String[] arg) {
		LinkedList2<Integer> ll = new LinkedList2<Integer>(); 
		ll.add(3);
		ll.add(7);
		ll.add(1);
		ll.add(9);
		ll.add(4);
		
	   //create loop
		ll.head.next.next.next.next.next = ll.head;
		
		ll.isLoopPresent();
		ll.detectLoop();
	}
}


class LinkedList2<E> {
	Node<E> head;
	public LinkedList2(){
	}
	
    static class Node<E>{
    	E data;
    	Node<E> next;
    	Node(E data)
    	{
    		this.data = data;
    	}
    }
    
    public void add(E data) {
    	Node<E> node = new Node<E>(data);
    	if(head == null) {
    		head = node;
    		return;
    	}	
    	
    	Node<E> temp = head;
    	
    	while(temp.next != null)
    		temp = temp.next;
    	
    	temp.next = node;
    		
    }
    
    //Floyd�s Cycle-Finding Algorithm
    public boolean isLoopPresent() {
    	Node<E> fast = head;
    	Node<E> slow = head;
    	
    	while(fast.next != null && fast.next.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    		
    		if(fast == slow)
    		{
    			System.out.println(" loop found ");
    			return true;
    		}	
    	}
    	
    	System.out.println(" loop not present");
    	return false;
    }
    
    /*  Another method - Using Hashing
     * 
     */
    public boolean detectLoop() {
    	Set<Node<E>> set = new HashSet<Node<E>>();
    	
    	Node<E> temp = head;
    	
    	if( temp == null) {
    		System.out.println(" Empty list");
    	    return false;
        } 
    	
    	while(temp != null) {
    		if(set.contains(temp)) {
    			System.out.println(" loop found");
    			return true;
    		}	
    		set.add(temp);
    		temp = temp.next;
    	}
    	
    	return false;
    }
}