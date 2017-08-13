/**
 * Problem statement:
 * Given a binary tree, you need to find the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * [ LC-543 ]
 *
 * Follow-up:
 * 如果是 k 叉树呢？
 * 1. int[] num = int[2] 求 max and 2nd max
 * 2. sum(num[i])
 */

public class DiameterOfBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		int[] ret = {0};
		diameterOfBinaryTreeHelper(root, ret);
		return ret[0];
	}

	/**
	 * return the longest depth from root to a leaf node
	 */
	private int diameterOfBinaryTreeHelper(TreeNode root, int[] ret) {
		if (root == null) {
			return 0;
		}
		int retLeft = diameterOfBinaryTreeHelper(root.left, ret);
		int retRight = diameterOfBinaryTreeHelper(root.right, ret);
		ret[0] = Math.max(ret[0], retLeft + retRight);
		return 1 + Math.max(retLeft, retRight);
	}
}
