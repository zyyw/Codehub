/**
 * Problem statement:
 * Given an array of non-negative integers, you are initially positioned at index 0 of the array. 
 * A[i] means the maximum jump distance from that position (you can jump only towards the end of the array)
 * Determin if you are able to reach the last index.
 *
 * Assumption:
 * 1. The given array is not null and not empty
 *
 * Idea:
 * DP, 从右往左进行; 回头看，向右看。
 * 1. state
 * dp[i]: 表示从 index i 能否向右跳到 end of the array
 * 2. base case - initialization
 * dp[n - 1] = true
 * 3. induction rule
 * if: i + array[i] >= array.length - 1
 *   dp[i] = true;
 * else:
 *   dp[i] = OR{ dp[j] }, where i + 1 <= j <= i + array[i]
 * 4. return value
 *    dp[0]
 */

public class JumpGame1 {
	public boolean canJump(int[] array) {
		// input sanity check
		if (array == null || array.length == 0) {
			return false;
		}
		boolean[] dp = new boolean[array.length];
		dp[array.length - 1] = true;
		for (int i = array.length - 2; i >= 0; --i) {
			if (i + array[i] >= array.length - 1) {
				dp[i] = true;
				continue;
			}
			for (int j = i + 1; j <= i + array[i]; ++j) {
				if (dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[0];
	}
}
