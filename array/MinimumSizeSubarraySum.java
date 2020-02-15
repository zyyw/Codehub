/**
 * Problem statement:
 * Given an array of positive integers and a positive integer s,
 * find the minimal length of contiguous subarray
 * of which the sum >= s. If there isn't one, return 0 instead.
 *
 * Idea:
 *   window 类型题目
 *   int i = 0;
 *   for j: 0 -> n-1
 *     while (i <= j && XXX) {
 *     }
 *
 * Write it down:
 * 首先选定两个指针 left 和 right, 分别记录窗口的左边和右边边界。
 * 1. 然后让 right 向右移动，直到窗口内元素的和大于或等于 s, 或者 right 达到数组最右边。
 * 2. 当窗口内元素和大于或等于 s, 并且 left <= right 时，更新待求最小窗口值，
 *    并且向右移动 left, 将移除的元素从窗口内元素和中减去。
 * 3. 重复步骤1和步骤2，直到 right 到达数组最右边，并且 left 也到达临界位置，即 left 再往
 *    右移动就会越过 right 或者窗口内元素和就会小于 s.
 */

public class MinimumSizeSubarraySum {
	public int minSubArraylen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int left = 0;
		int ret = nums.length + 1;
		for (int right = 0; right < nums.length; ++right) {
			sum += nums[right];
			while (left <= right && sum >= s) {
				ret = Math.min(ret, right - left + 1);
				sum -= nums[left];
				++left;
			}
		}
		return ret == nums.length + 1 ? 0 : ret;
	}
}
