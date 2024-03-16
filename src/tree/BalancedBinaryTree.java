package tree;


//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {

	//t-> O(n)
    public boolean isBalanced(TreeNode root) {
    	int h = height(root);
    	return h < 0 ? false : true;
    }
    
    public int height(TreeNode root) {
	     
    	 if(root == null){
             return 0;
         }
         
         int leftDepth = height(root.left);
         int rightDepth = height(root.right);
     
         if(leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
         	return -1;
         }
         
         return Math.max(leftDepth, rightDepth) + 1;
    }
    
   
   //t-> O(N2)
    boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        int left=depth(root.left);
        int right=depth(root.right);
        
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth (root.right)) + 1;
    }
	
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
