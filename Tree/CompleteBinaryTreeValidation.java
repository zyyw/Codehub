/**
 * Problem statement:
 * validate if a binary tree is a complete binary tree or not
 *
 * Idea:
 * if a node doesn't not have child node, any subsequent node (level order traversal) can NOT have child either since then.
 */

public class CompleteBinaryTreeValidation {
	public boolean isComplete(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		boolean hasNullChild = false; // a flag to determine if there is a null child ahead at the same level
		TreeNode cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.left != null) {
				if (hasNullChild) {
					return false;
				}
				queue.offer(cur.left);
			} else {
				hasNullChild = true;
			}
			if (cur.right != null) {
				if (hasNullChild) {
					return false;
				}
				queue.offer(cur.right);
			} else {
				hasNullChild = true;
			}
		}
		return true;
	}
}
