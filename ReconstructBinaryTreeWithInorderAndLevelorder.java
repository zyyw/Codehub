/**
 *
 * Idea:
 * Recursively construct subtree!!
 * 难点：当求构建子树的时候，子树的 level order traversal 不是显而易见的了。
 * 遍历当下 level order 数组:
 *   当中元素在 indexMap 中小于 level[0] 在 indexMap 中的元素依次放入左子树的 level order 数组
 *   当中元素在 indexMap 中大于 level[0] 在 indexMap 中的元素一次放入右子树的 level order 数组
 */

public class ReconstructBinaryTreeWithInorderAndLevelorder {
	public TreeNode reconstruct(int[] inorder, int[] level) {
		if (inorder == null || inorder.length == 0 || level == null || level.length != inorder.length) {
			return null;
		}
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; ++i) {
			indexMap.put(inorder[i], i);
		}
		return reconstructHelper(inorder, 0, inorder.length - 1, level, indexMap);
	}

	private TreeNode reconstructHelper(int[] inorder, int start1, int end1, int[] level, Map<Integer, Integer> indexMap) {
		if (start1 > end1) {
			return null;
		} else if (start1 == end1) {
			return new TreeNode(level[0]);
		}
		TreeNode root = new TreeNode(level[0]);
		int index = indexMap.get(level[0]);
		int[] levelLeft = new int[index - start1];
		int[] levelRight = new int[end1 - index];
		int idx1 = 0, idx2 = 0;
		for (int i = 1; i < level.length; ++i) {
			if (indexMap.get(level[i]) < index) {
				levelLeft[idx1++] = level[i];
			} else {
				levelRight[idx2++] = level[i];
			}
		}
		root.left = reconstructHelper(inorder, start1, index - 1, levelLeft, indexMap);
		root.right = reconstructHelper(inorder, index + 1, end1, levelRight, indexMap);
		return root;
	}
}
