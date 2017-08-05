/**
 * Idea:
 * 对于重复的元素，如果它的前一个没有选，则它自己也不能选。
 */

public class Subsets2 {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
		ArrayList<ArrayList<Integer>> retvv = new ArrayList<>();
		// input sanity check
		if (nums == null) {
			return retvv;
		}
		Arrays.sort(nums);
		ArrayList<Integer> cur = new ArrayList<>();
		subsetsWithDupHelper(nums, 0, retvv, cur);
		return retvv;
	}

	private void subsetsWithDupHelper(int[] nums, int start, ArrayList<ArrayList<Integer>> retvv, ArrayList<Integer> cur) {
		// base case
		if (start == nums.length) {
			retvv.add(new ArrayList<>(cur));
			return;
		}
		// choose the current element: nums[start]
		cur.add(nums[start]);
		subsetsWithDupHelper(nums, start + 1, retvv, cur);
		cur.remove(cur.size() - 1); // backtrack
		// not choose the current element: nums[start]
		while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
			++start;
		}
		subsetsWithDupHelper(nums, start + 1, retvv, cur);
	}
}
