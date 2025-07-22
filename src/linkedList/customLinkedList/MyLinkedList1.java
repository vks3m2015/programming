package linkedList.customLinkedList;

public class MyLinkedList1 {

	Node1 head;
	Node1 tail;
	int size;
	
	public MyLinkedList1() {
		head = null;
		tail = null;
		size = 0;
	}
	
	
	public void addAtBegin(int data) {
		size++;
		Node1 newNode = new Node1(data);
		newNode.link = head;
		head = newNode;
	}
	
	public void add(int data) {
		size++;
		Node1 newNode = new Node1(data);
		
		if(tail == null){
			head = newNode;
		} else {
			tail.link = newNode;
		}
		tail = newNode;
	}
	
	public void addAtPosition(int data, int pos) {
		Node1 newNode = new Node1(data);

		Node1 tmp = head;
		int i =1;
		
		if(pos > (size+1)) {
			System.out.println(" position is more than size of linked list");
			return;
		}	
		
		while(tmp != null) {
			//System.out.println("pos == "+pos+ " i == "+i);
			if(i >= (pos-1))
				break;
			tmp = tmp.link;
			i++;
		}
		
		newNode.link = tmp.link;
		tmp.link = newNode;
	 }
	
	public void reverse() {
		Node1 curr = head;
		Node1 prevNode = null, next = null;
		
		while(curr != null) {
		  //System.out.println(" - > "+tmp.data);
			next = curr.link;
			curr.link = prevNode;
			prevNode = curr;
			curr = next;
		}
		tail = head;
		head = prevNode;
	}
	
	public void traverse() {
		Node1 tmp = head;
		while(tmp != null) {
		  System.out.println(" - > "+tmp.data);
		  tmp = tmp.link;
		}
	}
	
	
	public static void main(String[] arg) {
		MyLinkedList1 ll = new MyLinkedList1();
		ll.add(5);
		//ll.addAtBegin(13);
		//ll.addAtBegin(12);
		ll.add(10);
		//ll.addAtBegin(7);
		ll.add(15);
		ll.add(20);
		ll.add(30);
		ll.add(35);
		ll.add(40);
		//ll.addAtPosition(7, 4);
		ll.addAtPosition(33, 6);
		//ll.addAtPosition(1, 1);
		ll.traverse();
		
		System.out.println("------------reverse ------------");
		ll.reverse();
		ll.traverse();
	}
}


class Node1{
	
	int data;
	Node1 link;
	
	public Node1(int data) {
		data =data;
	}
	
	public Node1( int data, Node1 link) {
	  	this.data = data;
	  	this.link = link;
	}
}