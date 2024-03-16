package cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
	
   Map<Integer, Node> map = new HashMap<>();
   DLL dll = new DLL();
   int capacity;
   int currCount;
	
	
   public LRUCache2(int capacity) {
       this.capacity = capacity;
   }
   
   public int get(int key) {
	   Node node = map.get(key);
	   if(node == null){
	     return -1; 
	   }

	   // move the accessed node to the head;
	   this.moveToHead(node);
	   return node.value;
   }
   
	public void put(int key, int value) {

		System.out.println(" put  key = "+ key +"currCount = "+currCount + " Capacity = "+ capacity);
		if (map.get(key) == null) {

			System.out.println(" cache miss for key "+ key);
			Node newNode = new Node(key, value);
			
			if (currCount == capacity) {
				System.out.println("currCount = "+currCount + " Capacity = "+ capacity );
				Node n = popTail();	
				map.remove(n.key);
				currCount--;
			}
			
			addNodeAtBegining(newNode);
			map.put(key, newNode);
			currCount++;
			
		} else {

			Node n = map.get(key);
			moveToHead(n);
		}

	}
   
   //Recently accessed existing node move to head 
   void moveToHead(Node node) {
	   
	   if(node == dll.head) return;
	   
	   if(node == dll.tail) {
		   dll.tail = node.prev;
	   }else {
		   node.next.prev = node.prev;
	   }
	   
	   dll.head.prev = node;
	   node.prev.next = node.next;
	  
	   
	   node.next = dll.head;
	   node.prev = null;
	   
	   //Update head
	   dll.head = node;
	   
   }
   
   //Remove a node from tail - least recently used
   Node popTail() {
	   Node tail = dll.tail;
	   
	   System.out.println(" tail.key == "+ tail.key);
	   if(currCount == 1) {
		   dll.tail = null;
		   dll.head = null;
		   return tail;
	   }
	   
	   System.out.println(" dll.tail.prev = "+ dll.tail.prev);
	   //update last node
	   dll.tail.prev.next = null;
	   
	   //update tail
	   dll.tail = dll.tail.prev;
	   return tail;
   }
	
   void addNodeAtBegining(Node node) {
	   
	   if(currCount == 0) {
		   dll.head = node;
		   dll.tail = node;
		   return;
	   }
	   
	   node.next = dll.head;
	   
	   //update next node
	   dll.head.prev = node;
	   
	   //Update head
	   dll.head = node;
	   
   }
   
   
   static class DLL{
	   Node head;
	   Node tail;
	   int count;
   }
   
   static class Node{
	   int key;
	   int value;
	   Node prev, next;
	   
	   Node(int key, int value){
		   this.key = key;
		   this.value = value;
	   }
		/*
		 * Node(int key, int value, Node prev, Node next){ this.key = key; this.value =
		 * value; this.prev = prev; this.next = next; }
		 */
   }
   
   public String getCacheStr() {
	   
	   Node ptr = dll.head;
	   
	   ArrayList<String> list = new ArrayList<>();
	   
	   while(ptr!= null) {
		   
		   String str = "" + ptr.key + " -> " + ptr.value ;
		   list.add(str);
		   ptr = ptr.next;
	   }
	   
     return Arrays.toString(list.toArray());	   
   }
   
   public String getCacheStrRev() {
	   
	   Node ptr = dll.tail;
	   
	   ArrayList<String> list = new ArrayList<>();
	   
	   while(ptr!= null) {
		   
		   String str = "" + ptr.key + " -> " + ptr.value ;
		   list.add(str);
		   ptr = ptr.prev;
	   }
	   
     return Arrays.toString(list.toArray());	   
   }
   
   
	public static void main(String[] args) {
		LRUCache2 cache = new LRUCache2(1);
		
		
		cache.put(2, 100);
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		System.out.println("  get 2 "  + cache.get(2));
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		cache.put(3, 300);
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		
		System.out.println("  get 2 "  + cache.get(2));
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		System.out.println("  get 3 "  + cache.get(3));
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		
		
		System.out.println(cache.getCacheStr());
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
	}
	
	public static void test1() {
		LRUCache2 cache = new LRUCache2(2);
		cache.put(1, 100);
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		cache.put(2, 200);
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		System.out.println("  get 1 "  + cache.get(1));
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		cache.put(3, 300);
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		//cache.get(2);
		System.out.println("  get 2 "  + cache.get(2));
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		
		cache.put(4, 400);
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
		
		
		cache.get(1);
		cache.get(3);
		cache.get(4);
		
		System.out.println(cache.getCacheStr());
		System.out.println("Forward = " + cache.getCacheStr());
		System.out.println("Rev = " +cache.getCacheStrRev());
		System.out.println("=========================================");
	}

}
