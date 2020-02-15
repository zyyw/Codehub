/**
 * Problem statement:
 * Given a binary tree, find the maximum path sum from root.
 * The path may end at any node in the tree and contain at least one node in it.
 *
 * idea:
 * 1. 向子树要什么 => root-2-any max path sum
 * 2. .. 由于向子树所要的正是题目所求，所以不用 helper 函数，也不用更新某个全局变量(题目所求的量)
 * 3. 向父节点报告什么 => root-2-any max path sum
 *    注意：由于是root-2-any, 所以如果当前节点的子节点返回负的 contribution 不要；当前节点直接放回root 即可
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
