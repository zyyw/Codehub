/**
 * Problem statement:
 * Given an array of positive integers and a positive integer s, find the minimal length of contiguous subarray
 * of which the sum >= s. If there isn't one, return 0 instead.
 *
 * Idea:
 *   window 类型题目
 *   int i = 0;
 *   for j: 0 -> n-1
 *     while (i <= j && XXX) {
 *     }
 *
 */

public class MinimumSizeSubarraySum {
	public int minSubArraylen(int s, int nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int i = 0;
		int ret = nums.length + 1;
		for (int j = 0; j < nums.length; ++j) {
			sum += nums[j];
			while (i <= j && sum >= s) {
				ret = Math.min(ret, j - i + 1);
				sum -= nums[i];
				++i;
			}
		}
		return ret == nums.length + 1 ? 0 : ret;
	}
}
