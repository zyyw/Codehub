/*
 *
 */
public class BinaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Deque<TreeNode> stk = new ArrayDeque<>();
		TreeNode prev = null;
		while (root != null || !stk.isEmpty()) {
			if (root != null) {
				// put all current root to stack for buffer; and go to its left child
				stk.offerFirst(root);
				root = root.left;
			} else {
				root = stk.peekFirst();
				if (root.right != null && root.right != prev) {
					// right child of the current root has NOT been visited yet; go to its right child
					root = root.right;
				} else {
					// well, now both left and right children are visited; 
					// then: 1. visited the root  2. reset prev = root  3. reset root = null
					root = stk.pollFirst(); // poll out the root from the stack buffer
					ret.add(root.val);
					prev = root;
					root = null;
				}
			}
		}
		return ret;
	}	
}
