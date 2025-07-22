package linkedList;

//Java program to find middle of linked list 
class Test
{ 
	Node head; // head of linked list 

	/* Linked list node */
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	/* Function to print middle of linked list */
	void printMiddle() 
	{ 
		Node slow_ptr = head; 
		Node fast_ptr = head; 
		if (head != null) 
		{ 
			while (fast_ptr != null && fast_ptr.next != null) 
			{ 
				fast_ptr = fast_ptr.next.next; 
				slow_ptr = slow_ptr.next; 
				
				System.out.println(" slow =="+slow_ptr.data + "  fast ===");
			} 
			System.out.println("The middle element is [" + 
								slow_ptr.data + "] \n"); 
		} 
	} 

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) 
	{ 
		/* 1 & 2: Allocate the Node & 
				Put in the data*/
		Node new_node = new Node(new_data); 

		/* 3. Make next of new Node as head */
		new_node.next = head; 

		/* 4. Move the head to point to new Node */
		head = new_node; 
	} 

	/* This function prints contents of linked list 
	starting from the given node */
	public void printList() 
	{ 
		Node tnode = head; 
		while (tnode != null) 
		{ 
			System.out.print(tnode.data+"->"); 
			tnode = tnode.next; 
		} 
		//System.out.println("NULL"); 
	} 

	public static void main(String [] args) 
	{ 
		Test llist = new Test(); 
		for (int i=1; i<=6; i++) 
		{ 
			llist.push(i); 
			//llist.printList(); 
			
		}
		llist.printList();
		llist.printMiddle(); 
	} 
} 
//This code is contributed by Rajat Mishra 
