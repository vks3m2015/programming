package tree;

import java.util.ArrayList;

public class NodesGreaterThanValue {

	//N-ary Tree
	private static class Node{
	    int key;
	    ArrayList<Node> children;
	    
	    Node(int key){
	    	this.key = key;
	    	children = new ArrayList<>();
	    }
	    
	}
	
	
	//method to find number of nodes greater than x
	static int greaterThanX(Node node,  int x) {
		
		 int count = 0;
	
		 if (node == null) {
			 System.out.println("Null Node");
		     return 0;    
		 }
	    
	    if(node.key > x) {
	    	count++;
	    }
	    	
		
		//recursion
		for(int i=0; i< node.children.size(); i++) {
		
			count = count + greaterThanX(node.children.get(i), x);
		}
		return count;
	}
	
	public static void main(String[] args) {
		 /* Let us create below tree
          5
        / | \
        1 2 3
       / / \ \
      15 4 5 6
*/
 
		 Node root = new Node(6);
	     
		    root.children.add(new Node(1));
		    root.children.add(new Node(2));
		    root.children.add(new Node(3));
		     
		    root.children.get(0).children.add(new Node(15));
		    root.children.get(1).children.add(new Node(4));
		    root.children.get(1).children.add(new Node(5));
		    root.children.get(2).children.add(new Node(6));
		 
		    int x = 5;
		 
		    System.out.print("Number of nodes greater than " +
		                    x + " are ");
		    System.out.println(greaterThanX(root, x));
	}

}
