/**
 * Problem statement:
 * 给定一个整数数组，求长度 >= k 的所有 subarray 里，maximum subarray sum 是多少
 *
 * Assumption:
 * 1. 数组不为 null 且 数组长度至少为 k
 *
 * Idea:
 * 1. curPrefixSum, 表示 nums[0:i] 的所有元素的和
 * 2. 需要在 0 ~ i-k 中维护一个 minPrefixSum 表示 nums[0:i-k] 中，始于 nums[0] 终于 nums[0:i-k] 中某个值的 min subarray sum
 *    注意这个 minPrefixSum 定义区间是 nums[0:i-k], 并且当取到 minPrefixSum 时的 subarray 始于 nums[0]
 * 3. return value
 *    MAX{ curPrefixSum - minPrefixSum }
 */

public class MaximumSubarray4 {
	public int maxSubArray(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return Integer.MIN_VALUE;
		}
		int curPrefixSum = 0;
		for (int i = 0; i < k; ++i) {
			curPrefixSum += nums[i];
		}
		int prePrefixSum = 0; // prePrefixSum 表示 nums[0:i-k] 中所有元素的和
		int minPrefixSum = 0;
		int ret = curPrefixSum;
		for (int i = k; i < nums.length; ++i) {
			curPrefixSum += nums[i];
			prePrefixSum += nums[i - k];
			minPrefixSum = Math.min(minPrefixSum, prePrefixSum);
			ret = Math.max(ret, curPrefixSum - minPrefixSum);
		}
		return ret;
	}
}
