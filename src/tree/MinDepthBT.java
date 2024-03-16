package tree;


//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinDepthBT {

    public int minDepth(TreeNode node) {
    	
    	if(node == null) return 0;
    	
    	int leftMin = minDepth(node.left);
    	int rightMin = minDepth(node.right);
    	
    	return (leftMin== 0 || rightMin == 0) ? (leftMin + rightMin + 1) : Math.min(leftMin, rightMin); 
    }
	
	public static void main(String[] args) {
		

	}

}
