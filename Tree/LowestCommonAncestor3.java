/**
 * Problem statement:
 * Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).
 * Return null if any one of the nodes is not in the tree.
 *
 * Assumption:
 * 1. there is no parent pointer in the TreeNode
 * 2. the given two nodes are not guaranteed to be in the binary tree
 */

public class LowestCommonAncestor3 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || one == null || two == null) {
			return null;
		}
		TreeNode ret = loa(root, one, two);
		if (ret != one && ret != two) {
			return ret;
		} else if (ret == one) {
			return findNode(one, two) ? ret : null;
		} else {
			return findNode(two, one) ? ret : null;
		}
	}

	private boolean findNode(TreeNode root, TreeNode node) {
		if (root == null) {
			return false;
		} else if (root == node) {
			return true;
		}
		return findNode(root.left, node) || findNode(root.right, node);
	}

	private TreeNode loa(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		TreeNode retLeft = loa(root.left, one, two);
		TreeNode retRight = loa(root.right, one, two);
		if (retLeft != null && retRight != null) {
			return root;
		}
		return retLeft != null ? retLeft : retRight;
	}
}
