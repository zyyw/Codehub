/**
 * Problem statement:
 * Given an array of non-negative integers, you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
 * Determine the minimum number of jumps you need to jump out of the array.
 *
 * By jump out, it means you can not stay at the end of the array. Return -1 if you can not do so.
 *
 * Assumption:
 * The given array is not null and not empty
 */

public class JumpGame3 {
	public int minJump(int[] array) {
		// input sanity check
		if (array == null || array.length == 0) {
			return -1;
		}
		int[] dp = new int[array.length];
		dp[array.length - 1] = array[array.length - 1] == 0 ? -1 : 1;
		for (int i = array.length - 2; i >= 0; --i) {
			// initialize it here
			dp[i] = -1;
			if (i + array[i] >= array.length) {
				dp[i] = 1;
				continue;
			}
			for (int j = i + array[i]; j > i; --j) {
				if (dp[j] != -1) {
					if (dp[i] == -1) {
						dp[i] = dp[j] + 1;
					} else {
						dp[i] = Math.min(dp[i], dp[j] + 1);
					}
				}
			}
		}
		return dp[0];
	}
}
