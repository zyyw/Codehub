/**
 * Problem statement:
 * Given a binary tree and a sum, determine if the tree has a root-2-leaf path,
 * such that adding up all the values along the path
 * equals the given sum.
 *
 * Idea:
 * [ top-down !!! ]
 * 1. base case: leaf node
 * 2. recursion rule:
 *    helper(root.left, sum - root.val) || helper(root.right, sum - root.val)
 */

public class PathSumToTarget1 {
	// 上面的 code 可以优化成下面的
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			// 叶子节点
			return root.val == sum;
		}
		// go to each child node
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		// 如果是 k-nary tree
		// for (TreeNodeKary child : root.children) {
		// 	 if (hasPathSum2(child, sum - root.val)) {
		//   	 return true;
		//   }
		// }
		// return false;
	}
}
