/**
 * Problem statement:
 * 给定一棵 k 叉树，和 树中两个节点。求这两个节点的最小公共祖先
 * Assumption:
 * 1. 这两个节点一定在树里
 * 2. 树没有 parent 指针
 *
 * TreeNodeKary {
 *   int val;
 *   TreeNodeKary[] children;
 *   TreeNodeKary(int v) {
 *     this.val = v;
 *   }
 * }
 *
 */

public class LowestCommonAncestorK1 {
	public TreeNodeKary lowestCommonAncestor(TreeNodeKary root, TreeNodeKary one, TreeNodeKary two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		int cnt = 0;
		TreeNodeKary ret = null;
		TreeNodeKary cur = null;
		for(TreeNodeKary child : root.children) {
			cur = lowestCommonAncestor(child, one, two);
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
