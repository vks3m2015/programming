package interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test16 {

	
	private static Test16 instance;
	
	
	private Test16() {}
	
	public static Test16 getInsatnce() {
		if(instance == null)
			instance = new Test16();
		return instance;
	}
	
	
	Node head;
	
	void add(Integer data) {
		
		if(head == null) {
		   head = new Node(data);
		   return;
		}
		
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = new Node(data);
		return;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
        //String dir = "path/to/dir";
       //FileInputStream fis =  new FileInputStream(new File(dir));
		
		
        
        
		
		
	}

}
 

class Node{
	Integer data;
	 Node next;
	 
	 Node(Integer data){
		 this.data = data;
	 }
	
}
 
 

 
 