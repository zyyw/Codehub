/**
 * Problem statement:
 * 给定一棵 k 叉树，和 树中 k 个节点。求这两个节点的最小公共祖先
 * Assumption:
 * 1. 这 k 个节点一定在树里
 * 2. 树没有 parent 指针
 *
 * TreeNodeKary {
 *   int val;
 *   List<TreeNodeKary> children;
 *   TreeNodeKary(int v) {
 *     val = v;
 *     children = new ArrayList<>();
 *   }
 * }
 */

public class LowestCommonAncestorK2 {
	public TreeNodeKary lowestCommonAncestor(TreeNodeKary root, List<TreeNodeKary> nodes) {
		Set<TreeNodeKary> set = new HashSet<>(nodes);
		return lowestCommonAncestorHelper(root, set);
	}

	private TreeNodeKary lowestCommonAncestorHelper(TreeNodeKary root, Set<TreeNodeKary> set) {
		if (root == null || set.contains(set)) {
			return root;
		}
		int cnt = 0;
		TreeNodeKary ret = null;
		TreeNodeKary cur = null;
		for (TreeNodeKary child : root.children) {
			cur = lowestCommonAncestorHelper(child, set);
			if (cur != null) {
				++cnt;
				ret = cur;
			}
			if (cnt == 2) {
				return root;
			}
		}
		return ret;
	}
}
