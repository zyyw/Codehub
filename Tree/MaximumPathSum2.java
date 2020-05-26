/**
 * Problem statement:
 * 给定一棵二叉树，找到从任意一个节点到任意另一个(可能是同一个节点)的最大 path sum. (NC094)
 * Idea:
 * base case 1:               base case 2:
 *     2                            2
 *    /                            /
 *   1                            -1
 * ret = 1 + 2                ret = 2
 *
 * base case 3:               base case 4:
 *      2                           2
 *       \                           \
 *        3                           -3
 * ret = 2 + 3                ret = 2
 *
 * 翻译题目，说人话：
 * any-2-any
 * max path sum
 *
 * 备注：
 * 1. 这题需要和 MaximumPathSum5 进行区分和比较
 *
 * 1. 希望从子树中获得什么信息：
 *    子树的 maximum root-2-any path sum
 * 2. 需要在当下层做些什么
 *    2.1 计算经过 current root 的 maximum any-2-any path sum
 *    2.2 更新全局的 maximum any-2-any path sum (if needed)
 *    2.3 计算经过 current root 的 maximum root-2-any path sum
 * 3. 需要向父节点报告什么信息：
 *    current root 的 maximum root-2-any path sum, computed at step 2.3
 */
public class MaximumPathSum2 {
	public int maxPathSum(TreeNode root) {
		int[] ret = {Integer.MIN_VALUE};
		maxPathSumHelper(root, ret);
		return ret[0];
	}

	private int maxPathSumHelper(TreeNode root, int[] ret) {
		if (root == null) {
			return 0;
		}
		// 1 希望从子树中获得什么信息
		int retLeft = maxPathSumHelper(root.left, ret);
		int retRight = maxPathSumHelper(root.right, ret);
		// 2 需要在当下层做些什么
		int sumLeft = Math.max(0, retLeft);
		int sumRight = Math.max(0, retRight);
		ret[0] = Math.max(ret[0], sumLeft + root.val + sumRight);
		// 3 需要向父节点报告什么信息
		return root.val + Math.max(sumLeft, sumRight);
	}
}
