package tree;

import java.util.Scanner;


public class BinaryTree {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Enter node");
		TreeNode root = buildBinaryTree();
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
	
	//Using Queue
	public static void levelOrderTraversal2(TreeNode node) {
	}
	
	public static int heightOfBinaryTree(TreeNode node) {
		
		if(node == null) return 0;
		
		int heightLeft = heightOfBinaryTree(node.left);
		int heightRight = heightOfBinaryTree(node.right);
		
		return heightLeft >= heightRight ? heightLeft + 1 : heightRight + 1;
	}
	
	public static void levelOrderTraversal(TreeNode root) {
		
		int h = heightOfBinaryTree(root);
		for(int i= 1; i<=h; i++) {
			System.out.print("\n Level - "+ i + " => ");
			levelOrderTraversal(root, i);
			
		}
		
	}
	
	public static void levelOrderTraversal(TreeNode node, int h) {
		
		if( node == null )
			return;
		
		if(h==1) {
			System.out.print( " - " + node.val );
			return;
		}
		
		if(h>1) {
			levelOrderTraversal(node.left, h-1);
			levelOrderTraversal(node.right, h-1);
		}
		
	}
	
	//Suggested
   public static TreeNode insertIntoBST(TreeNode node, int key) {
		
		if(node == null) {
			return new TreeNode(key);
		}
	   
		if(key < node.val) {
			node.left = insertIntoBST(node.left, key);
		
		}else if(key > node.val){
			node.right = insertIntoBST(node.right, key);
		}
		return node;
	}
	
   //Self
	public static void insertBinarySearchTree(TreeNode node, int key) {
		if(key < node.val) {
			if(node.left == null) {
				node.left = new TreeNode(key);
				return;
			}else
			    insertBinarySearchTree(node.left, key);
		}else {
			
			if(node.right == null) {
				node.right = new TreeNode(key);
				return;
			}else
			   insertBinarySearchTree(node.right, key);
		}	
	}
	
	 public static TreeNode buildBinaryTree() {

	    	int key = sc.nextInt();
	    	if(key == -1) {
	    		return null;
	    	}
	    	TreeNode node = new TreeNode(key);
			
			System.out.println("Insert Left Node of Node - "+ node.val);
			node.left = buildBinaryTree();
			
			System.out.println("Insert Right Node of Node - "+ node.val);
			node.right = buildBinaryTree();
			
			return node;
		}
	
	//Initial Implementation... More optimized method is buildBinaryTree() above
	public static TreeNode buildBinaryTree2() {
		
		System.out.println("Enter root node");
		
		//int key;
		TreeNode curr, temp;
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		
		TreeNode root = new TreeNode(key); 
		 buildBinaryTree2(root);
		
		return root;
	}
	
	public static void buildBinaryTree2(TreeNode node) {
		
		if(node == null) return;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert Left Node of Node - "+ node.val);
		int key = sc.nextInt();
		TreeNode temp;
		if(key == -1) {
			temp = null;
		}else {  
		  temp = new TreeNode(key);
		  node.left = temp;
		}
		buildBinaryTree2(temp);
		
		System.out.println("Insert Right Node of Node - "+ node.val);
		key = sc.nextInt();
		
		if(key == -1) temp = null ;
		else {
		  temp = new TreeNode(key);
		  node.right = temp;
		}
		buildBinaryTree2(temp);
	
		return ;
	}
	
	static void printBinaryTree(TreeNode node){
		
		if(node == null) return;
		
		System.out.println(node.val);
		
		if(node.left == null && node.right == null) {
			return;
		}
		
		if(node.left == null) {
			System.out.print(" Right Node of "+ node.val + "  -> ");
			printBinaryTree(node.right);
			return;

		}
		
		if(node.right == null) {
			System.out.print(" Left Node of "+ node.val + "  -> ");
			printBinaryTree(node.left);
			return;
		}
		
		//System.out.println(node.key);
		
		System.out.print(" Left Node of "+ node.val + "  -> ");
		printBinaryTree(node.left);
		
		System.out.print(" Right Node of "+ node.val + "  -> ");
		printBinaryTree(node.right);
		
		
		
		
	}
	
	/*
	 * static class TreeNode{
	 * 
	 * int key; TreeNode left, right;
	 * 
	 * TreeNode(int key){ this.key = key; } }
	 */

}
