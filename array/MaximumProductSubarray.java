/**
 * Problem statement:
 * 给定一个整数数组，找到一个连续的子数组，使得子数组的各元素乘积最大。返回最大的乘积。
 *
 * Assumption:
 * The given array is not null or empty
 *
 * Idea:
 * [ DP ]
 * 1. curMax[i], 表示以 nums[i] 结尾的所有的 subarray 中，subarray product 的最大值
 *    curMin[i], 表示以 nums[i] 结尾的所有的 subarray 中，subarray product 的最小值
 * 2. base case initialization
 *    curMax[0] = nums[0];
 *    curMin[0] = nums[0];
 * 3. induction rule:
 *    for i: 1 -> n-1
 *    product1 = nums[i] * curMax[i - 1]
 *    product2 = nums[i] * curMin[i - 1]
 *    curMax[i] = max(nums[i], max(product1, product2));
 *    curMin[i] = min(nums[i], max(product1, product2));
 * 4. return value:
 *    MAX{ curMax[i] }
 *
 * 注意：
 * 关于 subarray 问题，尤其是 prefixSum 问题，注意区分两个概念。
 * 1. 不要负的 contribution
 * 2. 包括／不包括 当前元素
 * 以及：这两个概念在 2D (二维DP) 里它们各自与 induction rule 的联系
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		int curMax = nums[0];
		int curMin = nums[0];
		int ret = nums[0];
		int product1 = 1;
		int product2 = 1;
		for (int i = 1; i < nums.length; ++i) {
			product1 = nums[i] * curMax;
			product2 = nums[i] * curMin;
			curMax = Math.max(nums[i], Math.max(product1, product2));
			curMin = Math.min(nums[i], Math.min(product1, product2));
			ret = Math.max(ret, curMax);
		}
		return ret;
	}
}
