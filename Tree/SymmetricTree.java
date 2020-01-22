/**
 *
 */

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricHelper(root.left, root.right);
	}

	/**
	 * 这里 isSymmetricHelper() 的实际功能是判断两个树是否相等。
	 * 但是通过传递参数 (p.left, q.right) && (p.right, q.left) 来表达是 "symmetric" 的相等, 不是结构上的完全相等。
	 */
	private boolean isSymmetricHelper(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
	}
}
