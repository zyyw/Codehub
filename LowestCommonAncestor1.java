/**
 * Problem statement:
 * Given two nodes in a binary tree, find their lowest common ancestor.
 *
 * Assumptions:
 * 1. There are no parent pointer for the nodes in the binary tree
 * 2. The given two nodes are guaranteed to be in the binary tree
 */

public class LowestCommonAncestor1 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		TreeNode retLeft = lowestCommonAncestor(root.left, one, two);
		TreeNode retRight = lowestCommonAncestor(root.right, one, two);
		if (retLeft != null && retRight != null) {
			return root;
		}
		return retLeft != null ? retLeft : retRight;
	}
}
