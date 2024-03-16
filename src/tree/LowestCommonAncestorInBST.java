package tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//Sol - https://www.youtube.com/watch?v=cOjLyASDJcc
public class LowestCommonAncestorInBST {

	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 
		 if(root == null || root == p || root == q )
			 return root;
		 
		 TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		 TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
		 
		 if(leftNode != null && rightNode != null)
			 return root;
		 
		 return leftNode != null ? leftNode : rightNode;
	        
	    }
	
	 public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
