/**
 * Problem statement:
 * Given a binary tree, find the maximum path sum from root.
 * The path may end at any node in the tree and contain at least one node in it.
 */
public class MaximumPathSum3 {
	public int maxPathSum(TreeNode root) {
		// 1 base case
		if (root == null) {
			return 0;
		}
		// 2 recursion rule
		int retLeft = maxPathSum(root.left);
		int retRight = maxPathSum(root.right);
		return root.val + Math.max(0, Math.max(retLeft, retRight)); // 要和 0 比较，避免负的 contribution !!!
	}
}
