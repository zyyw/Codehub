/**
 * Problem statement:
 * Given two node in a binary tree (with parent pointer), find their lowest common ancestor.
 *
 * Assmuption:
 * 1. there is a parent pointer in the TreeNode
 * 2. these two nodes are not guaranteed in the binary tree
 *
 */

public class LowestCommonAncestor2 {
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		if (one == null || two == null) {
			return null;
		}
		int depth1 = getDepth(one);
		int depth2 = getDepth(two);
		if (depth1 > depth2) {
			one = rebaseNode(one, depth1 - depth2);
		} else {
			two = rebaseNode(two, depth2 - depth1);
		}
		while (one != two) {
			one = one.parent;
			two = two.parent;
		}
		return one;
	}

	private TreeNodeP rebaseNode(TreeNodeP node, int diff) {
		while (diff-- > 0) {
			node = node.parent;
		}
		return node;
	}

	private int getDepth(TreeNodeP node) {
		int depth = 0;
		while (node != null) {
			++depth;
			node = node.parent;
		}
		return depth;
	}
}
