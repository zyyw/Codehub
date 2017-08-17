/**
 * Problem statement:
 * Find the contiguous subarray within an array (containing at least one element) which has the largest sum.
 *
 * Assumption:
 * The given array is not null nor empty
 *
 * Idea:
 * Linear scan, 回头看: 看一个
 * 1. dp[i], 表示所有以 nums[i] 结尾的 subarray 中最大的 subarray sum
 *    实际只需要一个变量，不需要一个数组
 * 2. base case initialization
 *    dp[0] = nums[0]
 * 3. induction rule
 *    dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0)
 *    讲人话：对于 sum, 不要负的 contribution
 * 4. return value
 *    MAX{ dp[i] }
 */

public class MaximumSubarray1 {
	public int maxSubarray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		int sum = 0;
		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; ++i) {
			sum = nums[i] + (sum > 0 ? sum : 0);
			ret = Math.max(ret, sum);
		}
		return ret;
	}	
}
