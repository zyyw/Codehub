/**
 *
 */

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left == null) {
			return 1 + minDepth(root.right);
		} else if (root.right == null) {
			return 1 + minDepth(root.left);
		}
		int retLeft = minDepth(root.left);
		int retRight = minDepth(root.right);
		return 1 + Math.min(retLeft, retRight);
	}
}
