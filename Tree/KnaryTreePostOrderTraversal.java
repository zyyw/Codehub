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
*/

public class KnaryTreePostOrderTraversal {
  public List<Integer> postOrder(Node root) {
    List<Integer> ret = new ArrayList<>();
    postOrderHelper(root, ret);
    return ret;
  }

  public void postOrderHelper(Node root, List<Integer> ret) {
    if (root == null) {
      return;
    }
    for (Node node : root.children) {
      postOrderHelper(node, ret);
    }
    ret.add(root.val);
  }
}
