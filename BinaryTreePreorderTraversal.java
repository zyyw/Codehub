/**
 *
 */

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Deque<TreeNode> stk = new ArrayDeque<>();
		while (root != null || !stk.isEmpty()) {
			if (root != null) {
				ret.add(root.val);
				stk.offerFirst(root);
				root = root.left;
			} else {
				root = stk.pollFirst();
				root = root.right;
			}
		}
		return ret;
	}
}
