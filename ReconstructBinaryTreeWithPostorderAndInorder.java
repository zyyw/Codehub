/**
 *
 */

public class ReconstructBinaryTreeWithPostorderAndInorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0 || postorder == null || postorder.length != inorder.length) {
			return null;
		}
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; ++i) {
			indexMap.put(inorder[i], i);
		}
		return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
	}

	private TreeNode buildTreeHelper(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2, Map<Integer, Integer> indexMap) {
		if (start2 > end2) {
			return null;
		} else if (start2 == end2) {
			return new TreeNode(postorder[end2]);
		}
		TreeNode root = new TreeNode(postorder[end2]);
		int index = indexMap.get(postorder[end2]);
		root.left = buildTreeHelper(inorder, start1, index - 1, postorder, start2, end2 - (end1 - index + 1), indexMap);
		root.right = buildTreeHelper(inorder, index + 1, end1, postorder, end2 - (end1 - index), end2 - 1, indexMap);
		return root;
	}
}
