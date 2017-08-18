/**
 * Problem statement:
 * Given an array with integers. Find two non-overlapping subarrays A and B,
 * which |Sum(A) - Sum(B)| is the largest.
 * Return the difference.
 *
 * Assumption:
 * 1. this given array is not null and contains at least two elements
 * 2. each subarray should contain at least one element
 *
 * Idea:
 * 1. 维护4个数组
 *    leftMax[i]: 从左往右看，nums[0] ~ nums[i] 间 max subarray sum。
 *       -- 为了实现这个目标需要中间变量, maxSubarraySum 表示所有以nums[i]结尾的(包含) subarray 中，max subarray sum
 *       -- maxSubarraySum 类似 localMax, 而 leftMax[i] 类似 globalMax[i]
 *    rightMax[i]: 从右往左看，nums[i] ~ nums[n-1] 间 max subarray sum。
 *       -- 同理！
 *
 *    leftMin[i]: 从左往右看，nums[0] ~ nums[i] 间 min subarray sum。
 *       -- 为了实现这个目标需要中间变量，minSubarraySum 表示所有以nums[i]结尾的(包含) subarray 中，min subarray sum
 *       -- minSubarraySum 类似 localMin, 而 leftMin[i] 类似 globalMin[i]
 *    rightMin[i]: 从右往左看，nums[i] ~ nums[n-1] 间 min subarray sum
 *       -- 同理！
 *
 *    这题实质是 maximum subarray sum 和 minimum subarray sum 的结合！
 *
 * 2. base case initialization
 *    maxSubarraySumLeft = nums[0], maxSubarraySumRight = nums[n - 1]
 *    leftMax[0] = nums[0]
 *    rightMax[n-1] = nums[n-1]
 *
 *    minSubarraySumLeft = nums[0], minSubarraySumRight = nums[n - 1]
 *    leftMin[0] = nums[0]
 *    rightMin[n-1] = nums[n-1]
 *
 * 3. induction rule
 *    maxSubarraySumLeft = nums[i] + (maxSubarraySumLeft > 0 ? maxSubarraySumLeft : 0);
 *    leftMax[i] = Math.max(leftMax[i - 1], maxSubarraySumLeft);
 *    maxSubarraySumRight = nums[i] + (maxSubarraySumRight > 0 ? maxSubarraySumRight : 0);
 *    rightMax[i] = Math.max(rightMax[i + 1], maxSubarraySumRight);
 *
 *    minSubarraySumLeft = num[i] + (minSubarraySumLeft < 0 ? minSubarraySumLeft : 0);
 *    leftMin[i] = Math.min(leftMin[i - 1], minSubarraySumLeft);
 *    minSubarraySumRight = nums[i] + (minSubarraySumRight < 0 ? minSubarraySumRight : 0);
 *    rightMin[i] = Math.min(rightMin[i + 1], minSubarraySumRight);
 *
 * 4. return value
 *    MAX{ Math.abs(leftMax[i] - rightMin[i + 1]), Math.abs(leftMin[i] - rightMax[i + 1]) }
 *    where 0 <= i < n - 1
 *
 */
public class MaximumSubarrayDifference {
	public int maxDiffSubArrays(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return Integer.MIN_VALUE;
		}
		int n = nums.length;
		// preprocess leftMax & rightMax
		// 1. state
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		int maxSubarraySumLeft = nums[0];
		int maxSubarraySumRight = nums[n - 1];
		// 2. base case initialization
		leftMax[0] = nums[0];
		rightMax[n - 1] = nums[n - 1];
		// 3. induction rule
		for (int i = 1; i < n; ++i) {
			maxSubarraySumLeft = nums[i] + (maxSubarraySumLeft > 0 ? maxSubarraySumLeft : 0);
			leftMax[i] = Math.max(leftMax[i - 1], maxSubarraySumLeft);
			maxSubarraySumRight = nums[n - 1 - i] + (maxSubarraySumRight > 0 ? maxSubarraySumRight : 0);
			rightMax[n - 1 - i] = Math.max(rightMax[n - i], maxSubarraySumRight);
		}
		// preprocess leftMin & rightMin
		// 1. state
		int[] leftMin = new int[n];
		int[] rightMin = new int[n];
		int minSubarraySumLeft = nums[0];
		int minSubarraySumRight = nums[n - 1];
		// 2. base case initialization
		leftMin[0] = nums[0];
		rightMin[n - 1] = nums[n - 1];
		// 3. induction rule
		for (int i = 1; i < n; ++i) {
			minSubarraySumLeft = nums[i] + (minSubarraySumLeft < 0 ? minSubarraySumLeft : 0);
			leftMin[i] = Math.min(leftMin[i - 1], minSubarraySumLeft);
			minSubarraySumRight = nums[n - 1 - i] + (minSubarraySumRight < 0 ? minSubarraySumRight : 0);
			rightMin[n - 1 - i] = Math.min(rightMin[n - i], minSubarraySumRight);
		}
		// 4. return value
		int ret = Integer.MIN_VALUE;
		for (int i = 1; i < n; ++i) {
			ret = Math.max(ret, Math.max(Math.abs(leftMax[i - 1] - rightMin[i]), Math.abs(leftMin[i - 1] - rightMax[i])));
		}
		return ret;
	}
}
