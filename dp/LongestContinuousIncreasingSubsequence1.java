/**
 * Problem statement:
 * Given an integer array, find the longest increasing continuous subsequence in this array.
 * An increasing continuous subsequence:
 * Can be from right to left or from left to right.
 * Indices of the integers in the subsequence should be continuous.
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
		if (nums == null) {
			return 0;
		} else if (nums.length <= 1) {
			return nums.length;
		}
		int ret = 1;
		// left to right
		int len = 1;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i - 1] < nums[i]) {
				++len;
				ret = Math.max(ret, len);
			} else {
				len = 1;
			}
		}
		// right to left
		len = 1;
		for (int i = nums.length - 2; i >= 0; --i) {
			if (nums[i] > nums[i + 1]) {
				++len;
				ret = Math.max(ret, len);
			} else {
				len = 1;
			}
		}
		return ret;
	}
}
