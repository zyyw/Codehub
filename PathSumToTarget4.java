/*
Problem statement:
Your are given a binary tree in which each node contains a value. Design an algorithm to get all paths
which sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go in a straight line down.
Example
Given a binary tree:

    1
   / \
  2   3
 /   /
4   2
for target = 6, return

[
  [2, 4],
  [1, 3, 2]
]
*/

public class PathSumToTarget4 {
  public List<List<Integer>> pathSumToTarget4(TreeNode root, int target) {
    List<TreeNode> path = new ArrayList<>();
    List<List<Integer>> ret = new ArrayList<>();
    pathSumToTarget4Helper(root, target, path, ret);
    return ret;
  }

  private void pathSumToTarget4Helper(TreeNode root, int target, List<TreeNode> path,
                                      List<List<Integer>> ret) {
    if (root == null) {
      return;
    }
    // current node processing
    path.add(root.val);
    int sum = 0;
    for (int i = path.size() - 1; i >= 0; --i) {
      sum += path.get(i);
      if (sum == target) {
        // find one any2any path, which path sum = PathSumToTarget1
        // add it to reasult
        List<Integer> onePath = new ArrayList<>();
        for (int j = i; j < path.size(); ++j) {
          onePath.add(path.get(j));
        }
        ret.add(onePath);
      }
    }
    // go to each child node
    pathSumToTarget4Helper(root.left, target, path, ret);
    pathSumToTarget4Helper(root.right, target, path, ret);
    // 如果是 k-nary tree
    // for (TreeNodeKary child : root.children) {
    //    pathSumToTarget4Helper(child, target, path, ret);
    // }
    // backtracking
    path.remove(path.size() - 1);
  }
}
