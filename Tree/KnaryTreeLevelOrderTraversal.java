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

public class KnaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }

    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int sz = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < sz; ++i) {
        Node cur = queue.poll();
        level.add(cur.val);
        for (Node node : cur.children) {
          if (node == null) {
            continue;
          }
          queue.offer(node);
        }
      }
      ret.add(level);
    }

    return ret;
  }
}
