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
		}
		if (root.left == null && root.right == null) {
			// leaf node
			if (root.val == sum) {
				ret.add(new ArrayList<>(path));
				ret.get(ret.size() - 1).add(root.val);
			}
			return;
		}
		// current node processing
		path.add(root.val);
		// go to each child node
		pathSumHelper(root.left, sum - root.val, ret, path);
		pathSumHelper(root.right, sum - root.val, ret, path);
		// 如果是 K 叉树
		// for (TreeNode child : root.children) {
		//   pathSumHelper(child, sum - root.val, ret, path);
		// }
		// 下面这步很重要！返回上一层之前，要把当下节点(即 上一层节点的子节点) 从 path 里拿出来
		path.remove(path.size() - 1); // backtracking
	}
}
