/**
 * Problem statement:
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
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
