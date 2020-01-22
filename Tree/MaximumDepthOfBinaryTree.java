/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from
the root node down to the farthest leaf node.

Note: A leaf is a node with no children.
*/
public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int retLeft = maxDepth(root.left);
    int retRight = maxDepth(root.right);
    return 1 + Math.max(retLeft, retRight);
  }
}
