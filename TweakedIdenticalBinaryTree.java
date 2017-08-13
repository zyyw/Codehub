/**
 * Problem statement:
 * Determine whether two given binary tree are identical assuming any number of "tweaks" are allowed. 
 * A tweak is defined as a swap of the children of one node in the tree.
 *
 */
public class TweakedIdenticalBinaryTree {
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		}
		if (one.key != two.key) {
			return false;
		}
		return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) ||
			   (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left));
	}
}
