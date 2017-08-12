/**
 *
 */
public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, null, null);
	}

	/**
	 * 这里的关键是设计 minNode, maxNode
	 * 当该层 validate 完毕后，进入其下一层／子树 validate 的时候，更新边界 minNode, maxNode.
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
}
