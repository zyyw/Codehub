/**
 *
 */

public class BinaryTreeLevelOrderTraverse {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int sz = queue.size();
			TreeNode cur = null;
			// traverse one level
			for (int i = 0; i < sz; ++i) {
				// 1. Expand
				cur = queue.poll();
				level.add(cur.val);
				// 2. generate
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			ret.add(level);
		}
		return ret;
	}
}
