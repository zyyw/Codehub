/**
 *  Problem statement:
 *  Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 *  Note: The solution set must not contain duplicate subsets.
 Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

[1, 2, 3]
 */

public class Subsets1 {
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		// input sanity check
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		if (nums == null) {
			return ret;
		}
		Arrays.sort(nums);
		ArrayList<Integer> cur = new ArrayList<>();
		subsetsHelper(nums, 0, ret, cur);
		return ret;
	}

	private void subsetsHelper(int[] nums, int start, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> cur) {
		if (start == nums.length) {
			ret.add(new ArrayList<>(cur));
			return;
		}
		// choose the current element
		cur.add(nums[start]);
		subsetsHelper(nums, start + 1, ret, cur);
		cur.remove(cur.size() - 1); // backtrack
		// not choose the current element
		subsetsHelper(nums, start + 1, ret, cur);
	}
}
