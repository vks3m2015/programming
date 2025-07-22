package linkedList;

//import java.util.LinkedList;


/* Reverse LinkedList
 * If loop is present
 * Mid of LinkedList 
 * write a program to swap the nth and length-nth node of a linked list?
 * 
 * 
 */
class Node
{
	Integer data;
	Node next;
	
	Node(Integer data)
	{
		this.data = data;
		this.next = null;
	}
	

}


class MyLinkedList
{
	Node head;
	
	public Node add(Node node)
	{
		if(head == null)
		{
			head = node;
			return head;
		}
		
		Node temp = head;
		
		while(temp.next != null)
		{
			temp = temp.next;
		}	
		
		temp.next = node;
		return head;
		
	}
	
	public void traverse()
	{
		if(head == null)
		{	
			System.out.println(" List is emplty");
		    return;
	    }   
		
        Node temp = head;
		
		while(temp != null)
		{
			System.out.println("  node is " + temp.data);
			temp = temp.next;
		}	
		
	}
	
	
    public void reverse()
    {
    	Node temp, prev = null;
    	
    	Node current = head;
    	while(current != null)
    	{
    		temp = current.next;
    		current.next = prev;
    		
       		prev = current;
    		current = temp;
    		
    	}	
    	
    	head = prev;
    }
	
	
}
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyLinkedList ls = new MyLinkedList();
		ls.add(new Node(5));
		ls.add(new Node(15));
		ls.add(new Node(51));
		
		ls.traverse();
		ls.reverse();
		System.out.println("after reverse...");
		ls.traverse();

	}

}
