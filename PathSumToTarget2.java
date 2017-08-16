/**
 * Problem statement:
 * Given a binary tree and a sum, find all root-2-leaf paths where each path's sum equals the given sum.
 *
 * Idea:
 * [ top-down !! ]
 */
public class PathSumToTarget2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		pathSumHelper(root, sum, ret, path);
		return ret;
	}

	private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> ret, List<Integer> path) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			// leaf node
			if (root.val == sum) {
				ret.add(new ArrayList<>(path));
				ret.get(ret.size() - 1).add(root.val);
			}
			return;
		}
		path.add(root.val);
		pathSumHelper(root.left, sum - root.val, ret, path);
		pathSumHelper(root.right, sum - root.val, ret, path);
		// 如果是 K 叉树
		// for (TreeNode child : root.children) {
		//   pathSumHeluper(child, sum - root.val, ret, path);
		// }
		path.remove(path.size() - 1); // backtracking
	}
}
