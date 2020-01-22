/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/
public class BinaryTreRightSideView {
  // 解法一：用 level order search, BFS
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int i = 0; i < sz; ++i) {
        // 1. exapnd
        TreeNode cur = queue.poll();
        if (i == sz - 1) {
          ret.add(cur.val);
        }
        // 2. generate
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }

    return ret;
  }

  // 解法二： DFS
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    int[] maxDepth = {0};
    rightSideViewHelper(root, 1, maxDepth, ret);
    return ret;
  }

  public void rightSideViewHelper(TreeNode root, int depth, int[] maxDepth, List<Integer> ret) {
    if (depth > maxDepth[0]) {
      ret.add(root.val);
      maxDepth[0] = depth;
    }
    if (root.right != null) {
      rightSideViewHelper(root.right, 1 + depth, maxDepth, ret);
    }
    if (root.left != null) {
      rightSideViewHelper(root.left, 1 + depth, maxDepth, ret);
    }
  }
}
