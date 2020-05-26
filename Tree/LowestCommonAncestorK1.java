/**
 * Problem statement:
 * Given k nodes in a binary tree, find their lowest common ancestor.
 *
 * Assumption:
 * 1. k >= 2
 * 2. there is no parent pointer
 * 3. the given k nodes are guaranteed in the binary tree
 */

public class LowestCommonAncestor4 {
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> set = new HashSet<>(nodes);
		return lowestCommonAncestorHelper(root, set);
	}

	private TreeNode lowestCommonAncestorHelper(TreeNode root, Set<TreeNode> set) {
		if (root == null || set.contains(root)) {
			return root;
		}
		TreeNode retLeft = lowestCommonAncestorHelper(root.left, set);
		TreeNode retRight = lowestCommonAncestorHelper(root.right, set);
		if (retLeft != null && retRight != null) {
			return root;
		}
		return retLeft != null ? retLeft : retRight;
	}
}
