/**
 * Problem statement:
 * 给定一棵二叉树，找到从一个叶节点到另一个叶节点的 path sum 中的最大的那个 path sum.
 * 如果没有一条 从一个叶节点到另一个叶节点的 path，就返回 Integer.MIN_VALUE
 *
 * 翻译题意，讲人话：
 * 1. leaf-2-leaf
 * 2. maximum path sum
 *
 * Idea:
 * 1. 希望从子树中获得什么信息：
 *    子树的 maximum root-2-leaf 的 path sum
 * 2. 需要在当下层做些什么：
 *    2.1 计算经过 current root 的 maximum leaf-2-leaf path sum
 *    2.2 更新全局的 maximum leaf-2-leaf path sum (if needed)
 *    2.3 计算 current root 的 maximum root-2-leaf path sum
 * 3. 需要向父节点报告什么信息：
 *    返回 current root 的 maximum root-2-leaf path sum, computed at step 2.3
 */

public class MaximumPathSum1 {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int[] ret = {Integer.MIN_VALUE};
		maxPathSumHelper(root, ret);
		return ret[0];
	}

	private int maxPathSumHelper(TreeNode root, int[] ret) {
		if (root == null) {
			return 0;
		} else if (root.left == null) {
			return root.val + maxPathSumHelper(root.right, ret);
		} else if (root.right == null) {
			return root.val + maxPathSumHelper(root.left, ret);
		}
		// now root has both left and right children
		int retLeft = maxPathSumHelper(root.left, ret);
		int retRight = maxPathSumHelper(root.right, ret);
		ret[0] = Math.max(ret[0], retLeft + root.val + retRight);
		return root.val + Math.max(retLeft, retRight);
	}
}
