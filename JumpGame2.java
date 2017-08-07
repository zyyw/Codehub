/**
 * Problem statement:
 * Given an array of non-negative integers, you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from index i (you can jump towards the end of the array).
 * Determine the minimum number of jumps you need to reach the end of the array.
 * If you cannot reach the end of the array, return -1.
 *
 * Assumption:
 * The given array is not null and not empty.
 *
 * Idea:
 * DP 从右到左，
 * 1. state: dp[i] 表示从 index i 跳到 the end of the array 需要最少的 step
 * 2. base case - initialization
 * 	  Arrays.fill(dp, -1);
 *    dp[array.length - 1] = 0
 * 3. induction rule
 *    if: i + array[i] >= array.length - 1
 *       dp[i] = 1
 *    else:
 *       dp[i] = MIN{ dp[j] + 1 }, where dp[j] != -1, which means from index j, we can jump to the end of array by dp[j] steps
 * 4. return value
 *    dp[0]
 */

public class JumpGame2 {
	public int minJump(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int[] dp = new int[array.length];
		Arrays.fill(dp, -1);
		dp[array.length - 1] = 0;
		for (int i = array.length - 2; i >= 0; --i) {
			for (int j = i + array[i]; j > i; --j) {
				if (j >= array.length - 1) {
					dp[i] = 1;
					break;
				} else if (dp[j] != -1) {
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
