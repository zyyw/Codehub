/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

Given a n-ary tree, find its maximum depth.
*/

public class MaximumDepthOfKnaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int childDepth = 0;
    for (Node child : root.children) {
      int curDepth = maxDepth(child);
      if (curDepth > childDepth) {
        childDepth = curDepth;
      }
    }
    return 1 + childDepth;
  }
}
