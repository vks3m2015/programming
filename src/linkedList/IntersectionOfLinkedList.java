package linkedList;

/*
 * NEED TO OPTIMIZE
 * 
 */


//https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class IntersectionOfLinkedList {

	public static void main(String[] args) {
		
/*		LinkedList3<String> ll = new LinkedList3<String>();
		ll.add("vikas");
		ll.add("vikky");
		ll.add("ut");
		ll.add("future");
		
		ll.traverse();
		
		System.out.println("size ==  "+ll.size());*/
		
		LinkedList3<String> l1 = new LinkedList3<String>();
		 l1.head = new LinkedList3.Node<String>("A");
		 l1.head.next = new LinkedList3.Node<String>("B");
		 l1.head.next.next = new LinkedList3.Node<String>("C");
		 l1.head.next.next.next = new LinkedList3.Node<String>("D");
		 l1.head.next.next.next.next = new LinkedList3.Node<String>("E");
		
		 l1.traverse();
		 
		 System.out.println("L2==============");
		LinkedList3<String> l2 = new LinkedList3<String>();
        l2.head = new LinkedList3.Node<String>("P");
        l2.head.next = new LinkedList3.Node<String>("Q");
        l2.head.next.next =l1.head.next.next.next;
		l2.head.next.next.next = l1.head.next.next.next.next;
		
		l2.traverse();
		
		
		LinkedList3.Node<String> n= l1.intersection(l2);
		System.out.println("  res =="+ n.data);
		
	}

}

class LinkedList3<T>{
	
	Node<T> head;
	int size;
	
	static class Node<T>{
		
		T data;
		Node<T> next;
		
		Node(T data){
			this.data = data;
		}
	}
	
	public void add(T data) {
		
		Node<T> n = new Node<>(data); 
		Node<T> ptr = head;
		
		if(head == null) {
			head = n;
			size++;
			return;
		}
		
		while(ptr.next != null) {
			ptr = ptr.next;
		}
		
		
		ptr.next = n;
		size++;
		
	}
	
	public void traverse() {
		Node<T> ptr = head;
		
		int i=0;
		while(ptr != null) {
			System.out.println( ++i + " element ="+ ptr.data);
			ptr = ptr.next;
		} 
	}
	
	public int size() {
		return size;
	}
	
	public int calculateSize() {
		
		  Node<T> current = head; 
		  int count = 0; 
		  
		  while (current != null) { 
		         count++; 
		         current = current.next; 
		  } 
		  
		 return count;   
	}
	
	public Node<T> intersection(LinkedList3<T> ll2){
		
		int size2 = ll2.calculateSize();
		int size1 = this.calculateSize();
		
		System.out.println(" size1 ="+ size1 + "    size2 ="+ size2);
		int diffSize = 0;
		
		if(size2 < size1 ) {
			diffSize = size1 - size2;
			
		} else {
			diffSize = size2 - size1;
		}
		
		System.out.println(" diffSize ="+diffSize);
		
		Node<T> ptr  = head;
		for(int i=1; i<= diffSize; i++) {
			
			ptr = ptr.next;
		}
		
		Node<T> ptr2 = ll2.head;
		
		while(ptr != null) {
			
			if(ptr == ptr2) {
				return ptr;
			}
			
			ptr = ptr.next;
			ptr2 = ptr2.next;
		}
		
		return null;
		
	}
	
}
