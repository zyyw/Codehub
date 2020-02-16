/**
 * Problem statement:
 * Given an array of integers, and a number k, find k non-overlapping subarrays which have the largest sum.
 * The number in each array should be contiguous.
 * Return the largest sum.
 *
 * Assumption:
 * The given array is not null and has at least k elements.
 *
 * Idea:
 * 1. state definition:
 *    dp[i][j], 表示从数组前 i 个元素，选 j 个子数组，能得到 max sum 是多少 ( 0 <= j <= k )
 *              隐含条件：不一定选第 i 个元素
 *    localMax[i][j], 表示从数组前 i 个元素(一定选第 i 个元素)，选 j 个子数组，能得到的 max sum 是多少 ( 0 <= j <= k )
 *
 * 2. base case initialization
 *    所有dp[i][j] = Integer.MIN_VALUE, where i < j;
 *    所有localMax[i][j] = Integer.MIN_VALUE, where i < j;
 *    实际上只需要:
 *      dp[j - 1][j] = Integer.MIN_VALUE;
 *      localMax[i - 1][j] = Integer.MIN_VALUE;
 * 3. induction rule:
 *    dp[i][j] = max(dp[i - 1][j], localMax[i][j])
 *                    不选第 i 个      选第 i 个
 *
 *    localMax[i][j] = max(dp[i - 1][j - 1], localMax[i - 1][j]) + nums[i - 1]
 *
 * 4. return value:
 *    dp[n][k]
 *
 * 难点：
 * 1. localMax 作为中间状态
 * 2. base/corner case 的初始化
 */

public class MaximumSubarray3 {
	public int maxSubArray(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return Integer.MIN_VALUE;
		}
		int n = nums.length;
		int[][] dp = new int[n + 1][k + 1];
		int[][] localMax = new int[n + 1][k + 1];
		for (int j = 1; j <= k; ++j) {
			localMax[j - 1][j] = Integer.MIN_VALUE;
			dp[j - 1][j] = Integer.MIN_VALUE;
			for (int i = j; i <= n; ++i) {
				localMax[i][j] = Math.max(dp[i - 1][j - 1], localMax[i - 1][j]) + nums[i - 1];
				dp[i][j] = Math.max(dp[i - 1][j], localMax[i][j]);
			}
		}
		return dp[n][k];
	}
}
