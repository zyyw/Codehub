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
		boolean flag = false;
		TreeNode cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.left != null) {
				queue.offer(cur.left);
				if (flag) {
					return false;
				}
			} else {
				flag = true;
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				if (flag) {
					return false;
				}
			} else {
				flag = true;
			}
		}
		return true;
	}
}
