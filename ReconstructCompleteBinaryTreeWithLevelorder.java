/**
 * Problem:
 * Given an array of level order traversing sequence of a complete binary tree. 
 * Build the complete binary tree with it.
 *
 * Idea:
 * Complete Binary Tree 有 children-parent index 转换方程。 (heap 的实现?!)
 * leftChildIndex = parentIndex * 2 + 1
 * rightChildIndex = (parentIndex + 1) * 2
 *
 */

public class ReconstructCompleteBinaryTreeWithLevelorder {
	public TreeNode construct(int[] level) {
		if (level == null || level.length == 0) {
			return null;
		}
		return constructHelper(level, 0);
	}

	public TreeNode constructHelper(int[] level, int rootIndex) {
		if (rootIndex >= level.length) {
			return null;
		}
		TreeNode root = new TreeNode(level[rootIndex]);
		root.left = constructHelper(level, 2 * rootIndex + 1);
		root.right = constructHelper(level, 2 * (rootIndex + 1));
		return root;
	}
}
