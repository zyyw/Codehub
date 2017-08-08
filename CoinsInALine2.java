/**
 * Problem statement:
 * There are n coins with different value in a line. Two players take turns to take one or two coins from the left side
 * until there are no more coins left. The player who takes the coins with the most value wins.
 * Determin the first player will win or lose.
 * -> 单次取 1/2 个
 * -> 每次都从左边取
 * -> 所得硬币额多的赢。
 *
 * Idea:
 * 1. state
 *    dp[i], 表示还剩 i 个硬币时，此时的先手能获得的最大数额
 * 2. base case initialization
 *    dp[1] = values[values.length - 1]
 * 	  dp[2] = values[values.length - 1] + values[values.length - 2]
 * 3. induction rule:
 *    dp[i] = sum[values.length - i:] - MIN{ dp[i - 1], dp[i - 2] }
 * 4. return value
 *    dp[n]
 *
 */

public class CoinsInALine2 {
	public boolean firstWillWin(int[] values) {
		// input sanity check
		if (values == null || values.length == 0) {
			return false;
		} else if (values.length <= 2) {
			return true;
		}
		int n = values.length;
		int[] dp = new int[n + 1];
		dp[1] = values[n - 1];
		dp[2] = values[n - 1] + values[n - 2];
		int sum = values[n - 1] + values[n - 2];
		for (int i = 3; i <= n; ++i) {
			sum += values[n - i];
			dp[i] = sum - Math.min(dp[i - 1], dp[i - 2]);
		}
		return dp[n] > sum / 2;
	}
}
