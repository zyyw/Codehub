/**
 * Problem statement:
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be continuous.
 * Return the largest sum.
 *
 * Assumption:
 * The given array is not null and has at least two elements
 *
 * Idea:
 * 1. 用两个数组, 
 * 	  // 错错错
 *    left[i] 表示从左往右算，所有以 nums[i] 结尾的 subarray 中，最大的 subarray sum
 *    right[i], 表示从右往左算，所有以 nums[i] 开头的 subarray 中，最大的 subarray sum
 *    // 正解
 *    // 要点是：不一定要结尾于／开头于 nums[i]
 *    left[i] 表示从左往右算，nums[0:i] 的 subarray 中，最大的 subarray sum
 *    right[i], 表示从右往左算，nums[i:n-1] 的 subarray 中，最大的 subarray sum
 * 2. base case initialization
 *    left[0] = nums[0]
 *    right[nums.length - 1] = nums[nums.length - 1]
 * 3. induction rule
 *      < 中间状态1: >
 *      curSumLeft, 表示从左往右看 结尾于 nums[i] 的 max subarray sum
 *      curSumLeft = nums[i] + (curSumLeft > 0 ? curSumLeft : 0);
 *    left[i] = Math.max(left[i - 1], curSumLeft);
 *      < 中间状态2: >
 *      curSumRight, 表示从右往左看 结尾于 nums[i] 的 max subarray sum
 *      curSumRight = nums[i] + (curSumRight > 0 ? curSumRight : 0);
 *    right[i] = Math.max(right[i + 1], curSumRight);
 * 4. return value
 *    MAX{ left[i] + right[i + 1] }, 0 <= i < nums.length - 1
 */

public MaximumSubarray2 {
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		if (nums == null || nums.size() < 2) {
			return Integer.MIN_VALUE;
		}
		// 1. state definition
		int n = nums.size();
		int[] left = new int[n];
		int[] right = new int[n];
		// 2. base case initialization
		left[0] = nums.get(0);
		right[n - 1] = nums.get(n - 1);
		int curSumLeft = nums.get(0);
		int curSumRight = nums.get(n - 1);
		// 3. induction rule
		for (int i = 1; i < n; ++i) {
			curSumLeft = nums.get(i) + (curSumLeft > 0 ? curSumLeft : 0);
			left[i] = Math.max(left[i - 1], curSumLeft);
			curSumRight = nums.get(n - 1 - i) + (curSumRight > 0 ? curSumRight : 0);
			right[n - 1 - i] = Math.max(right[n - i], curSumRight);
		}
		// 4. return value
		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < n - 1; ++i) {
			ret = Math.max(ret, left[i] + right[i + 1]);
		}
		return ret;
	}
}
