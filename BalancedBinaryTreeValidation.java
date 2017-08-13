/**
 *
 */

public class BalancedBinaryTreeValidation {
	public boolean isBalanced(TreeNode root) {
		boolean[] ret = {true};
		isBalancedHelper(root, ret);
		return ret[0];
	}

	private int isBalancedHelper(TreeNode root, boolean[] ret) {
		if (ret[0] == false) {
			return 0;
		}
		if (root == null) {
			return 0;
		}
		int retLeft = isBalancedHelper(root.left, ret);
		int retRight = isBalancedHelper(root.right, ret);
		if (retLeft - retRight > 1 || retRight - retLeft > 1) {
			ret[0] = false;
		}
		return 1 + Math.max(retLeft, retRight);
	}
}
