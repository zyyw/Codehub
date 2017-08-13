/**
 * Problem statement:
 * Find distance between two given keys of a binary tree, no parent pointers are given.
 * Distance between two nodes is the minimum number of edges to be traversed to reach one node from the other.
 *
 * Assumption:
 * 1. there are no parent pointer
 * 2. there are no duplicated keys in the binary tree
 * 3. the given two keys are guaranteed to be in the binary tree
 *
 * Idea:
 * 1. find the LOA of the given two keys
 * 2. get distance from LOA to the two keys nodes, respectively
 * 3. sum distance
 */

public class DistanceOfTwoNodesInBinaryTree {
	public int distance(TreeNode root, int k1, int k2) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		TreeNode loaNode = loa(root, k1, k2);
		return distance(loaNode, k1) + distance(loaNode, k2) - 2;
	}

	/**
	 *  return how many "nodes" are there in the path of node and k
	 */
	private int distance(TreeNode node, int k) {
		if (node == null) {
			return 0;
		} else if (node.val == k) {
			return 1;
		}
		int disLeft = distance(node.left, k);
		int disRight = distance(node.right, k);
		int curMax = Math.max(disLeft, disRight);
		return curMax == 0 ? 0 : curMax + 1;
	}

	private TreeNode loa(TreeNode root, int k1, int k2) {
		if (root == null || root.val == k1 || root.val == k2) {
			return root;
		}
		TreeNode retLeft = loa(root.left, k1, k2);
		TreeNode retRight = loa(root.right, k1, k2);
		if (retLeft != null && retRight != null) {
			return root;
		}
		return retLeft != null ? retLeft : retRight;
	}
}
