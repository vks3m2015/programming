package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {

	//Using Queue
	 public static List<List<Integer>> levelOrder2(TreeNode root) {
		 
			List<List<Integer>> res = new ArrayList<>();
			if (root == null)
				return res;
			
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			
			while (!queue.isEmpty()) {
				List<Integer> level = new ArrayList<>();
				int cnt = queue.size();
				
				for (int i = 0; i < cnt; i++) {
					
					TreeNode node = queue.poll();
					level.add(node.val);

					if (node.left != null) {
						queue.add(node.left);
					}

					if (node.right != null) {
						queue.add(node.right);
					}
				}
				res.add(level);
			}
			return res;
	 }

	
	
	//Recursion Approach
    public List<List<Integer>> levelOrder(TreeNode root) {

    	List<List<Integer>> result = new ArrayList<>();
    	
    	int h = height(root);
    	for(int l = 0; l < h; l++ ) {
    		List<Integer> list = new ArrayList<>();
    		traverse(root, l, list);
    		result.add(list);
    	}
		return result;
    }
    
    TreeNode traverse(TreeNode node, int level, List<Integer> list){
    	
    	if(node == null) {
    		return node;
    	}
    	
    	if(level == 0) {
    		list.add(node.val);
    		return node;
    	}
    	
    	level--;
    	node.left = traverse(node.left, level, list);
    	node.right = traverse(node.right, level, list);
    	
    	return node;
    }
    
    
    int height(TreeNode node) {
    	if(node == null) return 0;
    	return Math.max(height(node.left), height(node.right)) +1;
    }
	
	
	public static void main(String[] args) {
		System.out.println("Enter node");
		TreeNode root = BinaryTree.buildBinaryTree();
		//printBinaryTree(root);
		
		List<List<Integer>> list = levelOrder2(root);
		
		System.out.println(list.toString());

	}

}
