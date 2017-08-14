/**
 * Problem statement:
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Assumption:
 * You may assume that duplicate do not exist in the tree.
 *
 */
public class ReconstructBinaryTreeWithPreorderAndInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length != preorder.length) {
			return null;
		}
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; ++i) {
			indexMap.put(inorder[i], i);
		}
		return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
	}

	private TreeNode buildTreeHelper(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2, Map<Integer, Integer> indexMap) {
		if (start1 > end1) {
			return null;
		} else if (start1 == end1) {
			return new TreeNode(preorder[start1]);
		}
		TreeNode root = new TreeNode(preorder[start1]);
		int index = indexMap.get(preorder[start1]);
		root.left = buildTreeHelper(preorder, start1 + 1, start1 + index - start2, inorder, start2, index - 1, indexMap);
		root.right = buildTreeHelper(preorder, start1 + index - start2 + 1, end1, inorder, index + 1, end2, indexMap);
		return root;
	}
}
