/**
 *
 */

public class BalancedBinaryTreeValidation {
	public boolean isBalanced(TreeNode root) {
		boolean[] ret = {true};
		height(root, ret);
		return ret[0];
	}

	/*
		@root: 当前子树的根节点
		@ret: 所有搜索过的子树，是否全部都是 balanced
		返回值：当前子树的树高
	*/
	private int height(TreeNode root, boolean[] ret) {
		if (ret[0] == false) {
			return 0;
		}
		if (root == null) {
			return 0;
		}
		int retLeft = height(root.left, ret);
		int retRight = height(root.right, ret);
		if (retLeft - retRight > 1 || retRight - retLeft > 1) {
			ret[0] = false;
		}
		return 1 + Math.max(retLeft, retRight);
	}
}
