/**
 * Problem statement:
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * DP:
 * 1. 状态定义：dp[i], 结尾于 nums[i] 的 LIS 的长度
 * 2. base case：dp[i] = 1
 * 3. induction rule: dp[i] = MAX{1 + (nums[j] < nums[i] ? dp[j] : 0)}
 * 4. return: MAX{ dp[i] }
 */

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		// input sanity check
		if (nums == null) {
			return 0;
		} else if (nums.length <= 1) {
			return nums.length;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int ret = 1;
		for (int i = 1; i < nums.length; ++i) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; --j) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ret = Math.max(ret, dp[i]);
		}
		return ret;
	}
}
