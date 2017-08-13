/**
 * Problem statement:
 * 给定一个 k 叉树，树的每个节点包含着一个数字。求：
 * 所有包含字符 'A' 的节点 的 最小公共祖先。
 *
 * TreeNodeKary {
 *   char val;
 *   List<TreeNodeKary> children;
 *   TreeNodeKary(int v) {
 *     val = v;
 *     children = new ArrayList<>();
 *   }
 * }
 */

public class LoaOfCommonChar {
	public TreeNodeKary lowestCommonAncestor(TreeNodeKary root) {
		if (root == null || root.val == 'A') {
			return root;
		}
		int cnt = 0;
		TreeNodeKary ret = null;
		TreeNodeKary cur = null;
		for (TreeNodeKary child : root.children) {
			cur = lowestCommonAncestor(child);
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
