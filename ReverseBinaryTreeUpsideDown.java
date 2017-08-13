/**
 *
 */

public class ReverseBinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return root;
		} else if (root.left == null) {
			return root;
		}
		TreeNode ret = upsideDownBinaryTree(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null; // clear out root
		root.right = null; // clear out root
		return ret;
	}
}
