/**
 * Problem statement:
 * 从 root 节点到所有叶节点最长的 path 包含的节点数。
 * --> min depth: 从 root 到所有叶节点最短的 path 包含的节点数
 *
 */

public class HeightOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int retLeft = maxDepth(root.left);
		int retRight = maxDepth(root.right);
		return 1 + Math.max(retLeft, retRight);
	}
}
