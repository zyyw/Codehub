/**
 * Problem statement:
 * Given an unsorted array of integers, find the length of longest continuous
 * increasing subsequence (subarray). *
 *
 * DP:
 * 1. 状态定义：dp[i], 结尾于 nums[i] 的 LCIS 的长度
 * 2. base case: dp[0] = 1
 * 3. induction rule: dp[i] = 1 + (nums[i - 1] < nums[i] ? dp[i - 1] : 0)
 * 4. return: MAX{ dp[i] }
 *
 */

public class LongestContinuousIncreasingSubsequence1 {
	public int longestIncreasingContinuousSubsequence(int[] nums) {
		// input sanity check
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length];
		dp[0] = 1;
		int ret = 1;
		for (int i = 1; i < nums.length; ++i) {
			dp[i] = 1 + (nums[i - 1] < nums[i] ? dp[i - 1] : 0);
			ret = Math.max(ret, dp[i]);
		}

		return ret;
	}
}
