package tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class InorderTraversal {
	
	List<Integer> list = new ArrayList<>();
	
	 public List<Integer> inorderTraversal(TreeNode root) {
	 
		 if(root == null)
			 return list;
		 
		 inorderTraversal(root.left);
		 list.add(root.val);
		 inorderTraversal(root.right);
		 
		 return list;
	 }

}
