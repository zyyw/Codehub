/**
 * Problem statement:
 * Given a binary tree, do a level order traversal on it in a zigzag way.
 * For example:
 *      1
 *     /  \
 *    2    3
 *   /\    /\
 *  4  5  6  7
 *    /\    /\
 *   8  9  10 11
 * return:
 * [
 *   [1],
 *   [3, 2],
 *   [4, 5, 6, 7],
 *   [11, 10, 9, 8]
 * ]
 *
 * Idea:
 * Deque. 难点是怎么进，怎么出。
 *     first    |    last
 * ----------------------------
 *            1 |
 *              | 2, 3    // 进：先检查上一层的 left child (由上一层generate的), 后 right child; 出的时候，从右到左，这样就是想要的方向的 sequence 了
 *  4, 5, 6, 7  |                 // 进：先检查 right child, 后 left child, 从 first 那端进
 *              | 8, 9, 10, 11
 *              |
 * 口诀吧：
 * 左出右进左之左，右出左进右之右
 *
 */

public class BinaryTreeZigzagLevelOrderTraverse {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offerFirst(root);
		boolean curOddLevel = true;
		while (!deque.isEmpty()) {
			int sz = deque.size();
			List<Integer> level = new ArrayList<>();
			TreeNode cur = null;
			for (int i = 0; i < sz; ++i) {
				if (curOddLevel) {
					cur = deque.pollFirst();
					if (cur.left != null) {
						deque.offerLast(cur.left);
					}
					if (cur.right != null) {
						deque.offerLast(cur.right);
					}
				} else {
					cur = deque.pollLast();
					if (cur.right != null) {
						deque.offerFirst(cur.right);
					}
					if (cur.left != null) {
						deque.offerFirst(cur.left);
					}
				}
				level.add(cur.val);
			}
			ret.add(level);
			curOddLevel = !curOddLevel;
		}
		return ret;
	}
}
