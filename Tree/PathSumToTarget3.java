/**
 * Problem statement:
 * 给定一棵二叉树，是否存在一条直上直下的 subpath, 使得 subpath 的 path sum 等于 target
 *
 * Idea:
 * subarray sum equals target
 * -> prefix sum
 */
public class PathSumToTarget3 {
	public boolean pathSum(TreeNode root, int sum) {
		Set<Integer> set = new HashSet<>();
		set.add(0);
		return pathSumHelper(root, sum, 0, set);
	}

	private boolean pathSumHelper(TreeNode root, int target, int prefixSum, Set<Integer> set) {
		if (root == null) {
			return false;
		}
		// current node processing
		prefixSum += root.val;
		if (set.contains(prefixSum - target)) {
			return true;
		}
		int setSize = set.size();
		set.add(prefixSum);
		// go to each child node
		boolean retLeft = pathSumHelper(root.left, target, prefixSum, set);
		boolean retRight = pathSumHelper(root.right, target, prefixSum, set);
		if (retLeft || retRight) {
			return true;
		}
		// 如果是 k-nary tree
		// for (TreeNodeKary child : root.children) {
		//	 boolean exist = pathSumHelper(child, target, prefixSum, set);
		//   if (exist) {
		//		 return true;
		// 	 }
		// }
		// backtracking
		if (setSize < set.size()) {
			// size is incremented, which means prefixSum was not in set before adding it into it
			set.remove(prefixSum);
		}
		return false;
	}
}
