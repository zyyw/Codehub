/**
 * Problem statement:
 * Given a binary tree and a sum, determine if the tree has a root-2-leaf path, such that adding up all the values along the path
 * equals the given sum.
 *
 * Idea:
 * [ top-down !!! ]
 * 1. base case: leaf node
 * 2. recursion rule:
 *    helper(root.left, sum - root.val) || helper(root.right, sum - root.val)
 */

public class PathSumToTarget1 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null) {
			// leaf node
			return root.val == sum;
		} else if (root.left == null) {
			// root.right != null;
			return hasPathSum(root.right, sum - root.val);
		} else if (root.right == null) {
			// root.left != null
			return hasPathSum(root.left, sum - root.val);
		}
		// now root has both left child and right child
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	// 似乎上面的 code 可以优化成下面的
	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			// 叶子节点
			return root.val == sum;
		}
		// go to each child node
		return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
		// 如果是 k-nary tree
		// for (TreeNodeKary child : root.children) {
		//   boolean exist = hasPathSum2(child, sum - root.val);
		// 	 if (exist) {
		//   	 return true;
		//   }
		// }
		// return false;
	}
}
