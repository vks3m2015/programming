package tree;

import java.util.Scanner;

public class CreateBinaryTree {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter node");
		Node root = buildBinaryTree();
		//printBinaryTree(root);
		
		 levelOrderTraversal(root);
		
		/*
		 * int[] arr = {60,50,80,40,55,75,30,45,52};
		 * 
		 * Node root = null; for(int i=0; i< arr.length; i++) {
		 * 
		 * if(i==0) { root = new Node(arr[i]); }else { insertBinarySearch
		 * Tree(root, arr[i]); }
		 * }
		 * 
		 * //printBinaryTree(root);
		 * 
		 * int h = heightOfBinaryTree(root);
		 * System.out.println("height of binary tree = "+h);
		 * 
		 * levelOrderTraversal(root);
		 */
	}
	
	public static int heightOfBinaryTree(Node node) {
		
		if(node == null) return 0;
		
		int heightLeft = heightOfBinaryTree(node.left);
		int heightRight = heightOfBinaryTree(node.right);
		
		return heightLeft >= heightRight ? heightLeft + 1 : heightRight + 1;
	}
	
	public static void levelOrderTraversal(Node root) {
		
		int h = heightOfBinaryTree(root);
		for(int i= 1; i<=h; i++) {
			System.out.print("\n Level - "+ i + " => ");
			levelOrderTraversal(root, i);
			
		}
		
	}
	
	public static void levelOrderTraversal(Node node, int h) {
		
		if( node == null )
			return;
		
		if(h==1) {
			System.out.print( " - " + node.key );
			return;
		}
		
		if(h>1) {
			levelOrderTraversal(node.left, h-1);
			levelOrderTraversal(node.right, h-1);
		}
		
	}
	
	//Suggested
   public static Node insertIntoBST(Node node, int key) {
		
		if(node == null) {
			return new Node(key);
		}
	   
		if(key < node.key) {
			node.left = insertIntoBST(node.left, key);
		
		}else if(key > node.key){
			node.right = insertIntoBST(node.right, key);
		}
		return node;
	}
	
   //Self
	public static void insertBinarySearchTree(Node node, int key) {
		if(key < node.key) {
			if(node.left == null) {
				node.left = new Node(key);
				return;
			}else
			    insertBinarySearchTree(node.left, key);
		}else {
			
			if(node.right == null) {
				node.right = new Node(key);
				return;
			}else
			   insertBinarySearchTree(node.right, key);
		}	
	}
	
	 public static Node buildBinaryTree() {

	    	int key = sc.nextInt();
	    	if(key == -1) {
	    		return null;
	    	}
	    	Node node = new Node(key);
			
			System.out.println("Insert Left Node of Node - "+ node.key);
			node.left = buildBinaryTree2();
			
			System.out.println("Insert Right Node of Node - "+ node.key);
			node.right = buildBinaryTree2();
			
			return node;
		}
	
	//Initial Implementation... More optimized method is buildBinaryTree() above
	public static Node buildBinaryTree2() {
		
		System.out.println("Enter root node");
		
		//int key;
		Node curr, temp;
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		
		Node root = new Node(key); 
		 buildBinaryTree2(root);
		
		return root;
	}
	
	public static void buildBinaryTree2(Node node) {
		
		if(node == null) return;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert Left Node of Node - "+ node.key);
		int key = sc.nextInt();
		Node temp;
		if(key == -1) {
			temp = null;
		}else {  
		  temp = new Node(key);
		  node.left = temp;
		}
		buildBinaryTree2(temp);
		
		System.out.println("Insert Right Node of Node - "+ node.key);
		key = sc.nextInt();
		
		if(key == -1) temp = null ;
		else {
		  temp = new Node(key);
		  node.right = temp;
		}
		buildBinaryTree2(temp);
	
		return ;
	}
	
	static void printBinaryTree(Node node){
		
		if(node == null) return;
		
		System.out.println(node.key);
		
		if(node.left == null && node.right == null) {
			return;
		}
		
		if(node.left == null) {
			System.out.print(" Right Node of "+ node.key + "  -> ");
			printBinaryTree(node.right);
			return;

		}
		
		if(node.right == null) {
			System.out.print(" Left Node of "+ node.key + "  -> ");
			printBinaryTree(node.left);
			return;
		}
		
		//System.out.println(node.key);
		
		System.out.print(" Left Node of "+ node.key + "  -> ");
		printBinaryTree(node.left);
		
		System.out.print(" Right Node of "+ node.key + "  -> ");
		printBinaryTree(node.right);
		
		
		
		
	}
	
	static class Node{
		
		int key;
		Node left, right;
		
		Node(int key){
			this.key = key;
		}
	}

}
