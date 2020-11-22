/**
 * Problem statement:
 * Given a binary tree, and two keys, determine whether the two nodes are cousins of each other or not.
 * Two nodes are cousins of each other, if they are at the same level and have different parents.
 *
 * Assumption:
 * 1. It is not guranteed the two keys are all in the binary tree
 * 2. There are no duplicate keys in the binary tree
 *
 */

public class CousinsInBinaryTree(TreeNode root) {
	public boolean isCousin(TreeNode root, int a, int b) {
		if (root == null || root.key == a || root.key == b) {
			return false;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int cnt = 0;
			int sz = queue.size();
			for (int i = 0; i < sz; ++i) {
				TreeNode cur = queue.poll();
				int preCnt = cnt;
				if (cur.left != null) {
					queue.offer(cur.left);
					if (cur.left.key == a || cur.left.key == b) {
						++cnt;
					}
				}
				if (cur.right != null) {
					queue.offer(cur.right);
					if (cur.right.key == a || cur.right.key == b) {
						++cnt;
					}
				}
				if (cnt == 2) {
					// if preCnt == 0, two nodes share the same parent,
					// otherwise they have different parent
					return preCnt != 0;
				}
			}
			if (cnt == 1) {
				// one node at a level, the other node must be in the another level
				return false;
			}
		}
		// one or two nodes are not in the binary tree
		return false;
	}
}
