 package tree;

public class BinaryTree2 {
	
	TreeNode root;
	
	BinaryTree2(){
	}
	
	BinaryTree2(TreeNode node){
		root = node;
	}
	
	void insert(int val) {
  	  
	 TreeNode node = new TreeNode(val);	
		
  	  if(root == null) {
  		  root = node;
  		  return;
  	  }
  	  
  	  insertRec(root, node);
    }
	
	void insertRec(TreeNode parent, TreeNode treeNode) {
		
		if(treeNode.val > parent.val) {
			if(parent.right == null) {
				parent.right = treeNode;
				return;
			}
			insertRec(parent.right, treeNode);
		}
		
		else if(treeNode.val < parent.val) {
			    if(parent.left == null) {
				    parent.left = treeNode;
				    return;
			    }
			    insertRec(parent.left, treeNode);
		}
	}
	
	void inOrderTraversal() {
		inOrderTraversal(root);
		
	}
	
	void inOrderTraversal(TreeNode node) {
		
		if(node == null) return;
		
		inOrderTraversal(node.left);
		System.out.println(node.val);
		inOrderTraversal(node.right);
	}
	
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }

	public static void main(String[] args) {
		BinaryTree2 bt = new BinaryTree2();
		bt.insert(6);
		bt.insert(2);
		bt.insert(8);
		bt.insert(1);
		bt.insert(3);
		
		bt.inOrderTraversal();

	}

}
