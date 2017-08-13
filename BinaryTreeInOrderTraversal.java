/**
 *
 */
public class BinaryTreeInOrderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Deque<TreeNode> stk = new ArrayDeque<>();
		while (root != null || !stk.isEmpty()) {
			if (root != null) {
				stk.offerFirst(root);
				root = root.left;
			} else {
				root = stk.pollFirst();
				ret.add(root.val);
				root = root.right;
			}
		}
		return ret;
	}
}
