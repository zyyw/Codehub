/**
 * Problem statement:
 * Given a binary tree, determine if it is a binary search tree or not.
 * BST 的性质:
 * 1. 左节点 值 < 当前节点 值 < 右节点 值
 * 2. BST 中序遍历 是个递增序列
 */
public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, null, null);
	}

	/**
	 * 这里的关键是设计 minNode, maxNode
	 * 当该层 validate 完毕后，进入其下一层／子树 validate 的时候，更新边界 minNode, maxNode.
	 * 这里的 base case:
	 * 1. root == null, return true
	 * 2. root.left violate BST: root.left.val >= root.val
	 * 3. root.right violate BST: root.val >= root.right.val
	 * 这里的 root.left 是上一层top-down传下来的 maxNode (即，上一层的 root)。压低上界
	 * 这里的 root.right 是上一层top-down传下来的 minNode (亦，上一层的root)。提升下界
	 * 备注：
	 * 1. validate left child 的时候，left child 的上限变小了, 即传递 root as the maxNode of its left child
	 * 2. 同理，validate right child 的时候，right child 的下限变大了，即传递 root as the minNode of its right child
	 * 同时注意，minNode 和 maxNode 的初始值为 NULL. 这是实现层面上的技巧
	 */
	private boolean isValidBSTHelper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
		if (root == null) {
			return true;
		}
		if (minNode != null && minNode.val >= root.val) {
			return false; // violate BST rule
		}
		if (maxNode != null && root.val >= maxNode.val) {
			return false; // violate BST rule
		}
		return isValidBSTHelper(root.left, minNode, root) && isValidBSTHelper(root.right, root, maxNode);
	}

	// 解法二：
	// 利用 BST 中序遍历是一个递增的有序数列
	public boolean isValidBST2(TreeNode root) {
		TreeNode prev = null;
		Deque<TreeNode> stk = ArrayDeque<>();
		while (root != null || !stk.isEmpty()) {
			if (root != null) {
				stk.offerFirst(root);
				root = root.left;
			} else {
				root = stk.pollFirst();
				if (prev != null && prev.val >= root.val) {
					return false;
				}
				prev = root;
				root = root.right;
			}
		}
		return true;
	}
}
