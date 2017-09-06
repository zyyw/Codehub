/**
 * Problem statement:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Idea:
 * 从右到左，大的范围到小的范围。
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return ret;
		}
		Arrays.sort(nums);
		for (int c = nums.length - 1; c >= 2; --c) {
			int a = 0;
			int b = c - 1;
			while (a < b) {
				int sum = nums[a] + nums[b] + nums[c];
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[a]);
					list.add(nums[b]);
					list.add(nums[c]);
					ret.add(list);
					// de-dup
					while (a < b && nums[a] == nums[a + 1]) {
						++a;
					}
					// de-dup
					while (a < b && nums[b - 1] == nums[b]) {
						--b;
					}
					++a;
				} else if (sum < 0) {
					++a;
				} else {
					--b;
				}
			}
			// de-dup
			while (c >= 2 && nums[c - 1] == nums[c]) {
				--c;
			}
		}
		return ret;
	}
}
