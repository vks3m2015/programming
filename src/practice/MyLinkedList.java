package practice;

public class MyLinkedList {

	Node start;
	Node end;
	int size;
	
	public MyLinkedList()
	{
		start = null;
		end = null;
		size = 0;
	}
	
	
	public void addAtBegin(int data)
	{
		size++;
		Node nd = new Node(data, null);
		
		nd.link = start;
		start = nd;
		
	}
	
	public void addAtEnd(int data)
	{
		size++;
		Node newNode = new Node(data, null);
		
		if(end == null)  //empty LinkedList
		{
			start = newNode;
			end = newNode;
		}
		else
		{
			end.link = newNode;
			end = newNode;
		}		
		
	}
	
	public void addAtPosition(int data, int pos)
	{
		Node newNode = new Node(data, null);
		
		Node tmp = start;
		int i =1;
		
		if(pos > (size+1))
		{
			System.out.println(" position is more than size of linked list");
			return;
		}	
		
		while(tmp != null)
		{
			//System.out.println("pos == "+pos+ " i == "+i);
			if(i >= (pos-1))
				break;
			tmp = tmp.link;
			i++;
		}
		
		newNode.link = tmp.link;
		tmp.link = newNode;
	 }
	
	public void reverse()
	{
		Node curr = start;
		Node prevNode = null, next = null;
		
		while(curr != null)
		{	
		  //System.out.println(" - > "+tmp.data);
			next = curr.link;
			curr.link = prevNode;
			prevNode = curr;
			curr = next;
		}
		end = start;
		start = prevNode;
		
	}
	
	public void traverse()
	{
		
		Node tmp = start;
		
		while(tmp != null)
		{	
		  System.out.println(" - > "+tmp.data);
		  tmp = tmp.link;
		}
		
	}
	
	
	public static void main(String[] arg)
	{
		MyLinkedList ll = new MyLinkedList();
		ll.addAtEnd(5);
		//ll.addAtBegin(13);
		//ll.addAtBegin(12);
		ll.addAtEnd(10);
		//ll.addAtBegin(7);
		ll.addAtEnd(15);
		ll.addAtEnd(20);
		ll.addAtEnd(30);
		ll.addAtEnd(35);
		ll.addAtEnd(40);
		//ll.addAtPosition(7, 4);
		ll.addAtPosition(33, 6);
		//ll.addAtPosition(1, 1);
		ll.traverse();
		
		System.out.println("------------reverse ------------");
		ll.reverse();
		ll.traverse();
	}
}


class Node{
	
	int data;
	Node link;
	
	public Node()
	{
		data =0;
		link = null;
	}
	
	public Node( int data, Node link)
	{
	  	this.data = data;
	  	this.link = link;
	}
	
	
}