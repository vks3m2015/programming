
package tree;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBTree {

	 public int diameterOfBinaryTree(TreeNode root) {
		 int[] diameter = new int[1];
	     height(root, diameter);
	     return diameter[0];   
	 }
	 
     public int height(TreeNode node, int[] diameter) {
    	 
    	 if(node == null)
    		 return 0;
    	 
    	 int leftHeight = height(node.left, diameter);
    	 int rightHeight = height(node.right, diameter);
    	 
    	 diameter[0] = Math.max(diameter[0], rightHeight+ leftHeight);
    	 
		return 1 + Math.max(leftHeight, rightHeight);
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private class TreeNode {
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
	

}
