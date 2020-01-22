/**
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
*/

public class KnaryTreePreOrderTraversal {
  public List<Integer> preOrder(Node root) {
    List<Integer> ret = new ArrayList<>();
    preOrderHelper(root, ret);
    return ret;
  }

  public void preOrderHelper(Node root, List<Integer> ret) {
    if (root == null) {
      return;
    }
    ret.add(root.val);
    for (Node node : root.children) {
      preOrderHelper(node, ret);
    }
  }
}
