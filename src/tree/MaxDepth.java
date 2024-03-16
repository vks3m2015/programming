package tree;


//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {

	public int maxDepth(TreeNode root) {
	     
        if(root == null){
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
	
	public static void main(String[] args) {

		System.out.println(Math.abs(-1 - 0));
	}

}
