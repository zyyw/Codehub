/**
 * Problem statement:
 * Given a binary tree, find the maximum path sum ending at a leaf node.
 * The path may start at the root-2-leaf(ending leaf node) path.
 * 讲人话：在所有直上直下的 path 中，找到一条(起始点不限，终点在 leaf node) 的 path 使得 path sum 最大。
 *
 * Assumption:
 * root node is not null
 *
 * Idea:
 * maximum subarray sum
 */

public class MaximumPathSum4 {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return maxPathSumHelper(root, 0);
	}

	private int maxPathSumHelper(TreeNode root, int sum) {
		// 1. base case
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		} 
		// 2. recursion rule
		sum = sum + root.val > 0 ? sum + root.val : 0;
		if (root.left == null) {
			// root.right != null
			return maxPathSumHelper(root.right, sum);
		} else if (root.right == null) {
			// root.left != null
			return maxPathSumHelper(root.left, sum);
		}
		// now root.left != null && root.right != null
		return Math.max(maxPathSumHelper(root.left, sum), maxPathSumHelper(root.right, sum));
	}
}
