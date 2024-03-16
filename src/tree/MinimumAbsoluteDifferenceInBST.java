package tree;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
public class MinimumAbsoluteDifferenceInBST {

	int min = Integer.MAX_VALUE;
	Integer prev = null;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return min;

		getMinimumDifference(root.left);

		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;

		getMinimumDifference(root.right);

		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
