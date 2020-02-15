/**
 * Problem statement:
 * 给定一棵二叉树，在所有的“直上直下”的 path 里找一条 subpath, 使得它的 subpath sum 最大.
 * 要求：这条直上直下的 subpath 至少包含一个 node
 *
 * Assumption:
 * root is not null
 *
 * Idea:
 * [ Bottom-up ]
 * 1. 希望从子树中获得什么信息：
 *    以子树 root 为开始的 maximum path sum (直上直下的path), 如果是 负的，返回0.
 * 2. 需要在当下层做些什么：
 *    2.1 计算以 current root 为开始的 maximum path sum (直上直下的 path)
 *    2.2 更新全局的 maximum subpath sum (if needed)
 * 3. 需要向父节点报告什么信息：
 *    以 current root 为开始的 maximum path sum (直上直下的 path)，如果是负的，返回0. step2.1
 */

public class MaximumPathSum5 {
	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int[] ret = {Integer.MIN_VALUE};
		maxPathSumHelper(root, ret);
		return ret[0];
	}

	private TreeNode maxPathSumHelper(TreeNode root, int[] ret) {
		if (root == null) {
			return 0;
		}
		int retLeft = maxPathSumHelper(root.left, ret);
		int retRight = maxPathSumHelper(root.right, ret);
		int sum = root.val + Math.max(0, Math.max(retLeft, retRight));
		ret[0] = Math.max(ret[0], sum);
		return sum;
	}
}
