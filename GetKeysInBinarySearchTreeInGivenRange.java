/**
 * Problem statement:
 * Get the list of keys in a given binary search tree in a given range [min, max] in ascending order, both min and max are inclusive.
 *
 * In ascending order ==> 中序遍历
 *
 */

public class GetKeysInBinarySearchTreeInGivenRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> ret = new ArrayList<>();
		getRangeHelper(root, min, max, ret);
		return ret;
	}

	private void getRangeHelper(TreeNode root, int min, int max, List<Integer> ret) {
		if (root == null) {
			return;
		}
		if (min <= root.key && root.key <= max) {
			ret.add(root.key);
		}
		if (min < root.key) {
			getRangeHelper(root.left, min, max, ret);
		}
		if (root.key < max) {
			getRangeHelper(root.right, min, max, ret);
		}
	}
}
