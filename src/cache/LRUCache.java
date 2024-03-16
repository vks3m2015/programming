package cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LRUCache {
	
	Map<Integer, Node> map = new HashMap<>();
	Node head = new Node(0,0);
	Node tail = new Node(0,0);
	int capacity;
	
	LRUCache(int capacity){
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		System.out.println("GET  KEY = "+ key ); 
	    Node node = map.get(key);
		if(node == null){
		   return -1; 
		}

		// move the accessed node to the head;
		removeNode(node);
		insertAtBegin(node);
		log();
	    return node.value;
	}
	   
    public void put(int key, int value) {
    	System.out.println("PUT  KEY = "+ key + " value = "+ value); 
    	
    	if(map.containsKey(key)) {
    		Node n = map.get(key);

    		//Need to remove from tail and then add at beginning. and need to add new node with updated value(Case when need to update value of existing key).
    		removeNode(n);
    	}
    	
    	if(map.size() == capacity) {
    		removeNode(tail.prev);
    	}
    	
    	Node node = new Node(key, value);
		insertAtBegin(node);
		map.put(key, node);
    	
		log();
    }
	
	void insertAtBegin(Node node) {
		node.prev = head;
		node.next = head.next;
		
		head.next.prev = node;
		head.next = node;
		
		addEntryToMap(node);
	}
	
	void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
		removeEntryFromMap(node);
	}
	
	void removeEntryFromMap(Node node) {
		map.remove(node.key);
	}
	
	void addEntryToMap(Node node) {
		map.put(node.key, node);
	}
	
	 class Node{
		   int key;
		   int value;
		   Node prev, next;
		   
		   Node(int key, int value){
			   this.key = key;
			   this.value = value;
		   }
	   }
	
	public void log() {
		 printForwardTraversal();
		// printBackwardTraversal();
		 System.out.println(" MAP == "+ Arrays.toString(map.keySet().toArray()));
		 System.out.println("=========================================");
	}
	 
	 public String printForwardTraversal() {
		   Node ptr = head.next;
		   ArrayList<String> list = new ArrayList<>();
		   while(ptr.next!= null) {
			   String str = "" + ptr.key + " -> " + ptr.value ;
			   list.add(str);
			   ptr = ptr.next;
		   }
		   
		 System.out.println("Forward Traversal = " + Arrays.toString(list.toArray()));  
	     return Arrays.toString(list.toArray());	   
	   }
	   
	   public String printBackwardTraversal() {
		   Node ptr = tail.prev;
		   ArrayList<String> list = new ArrayList<>();
		   while(ptr.prev!= null) {
			   String str = "" + ptr.key + " -> " + ptr.value ;
			   list.add(str);
			   ptr = ptr.prev;
		   }
		 System.out.println("Backward Traversal = " + Arrays.toString(list.toArray())); 
	     return Arrays.toString(list.toArray());	   
	   }
	
	public static void main(String[] args) {
	   test1();
	}
	
	public static void test1() {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 100);
		cache.put(2, 200);
		cache.get(1);
		cache.put(3, 300);
		cache.get(2);
		cache.put(4, 400);
		cache.get(1);
		cache.get(3);
		cache.get(4);
	}

	public static void test2() {
		 LRUCache cache = new LRUCache(1);
			cache.put(2, 100);
			cache.get(2);
			cache.put(3, 300);
			cache.get(2);
			cache.get(3);
	}
}
