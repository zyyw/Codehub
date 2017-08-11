/**
 * Problem statement:
 * There are n coins in a line. Two players take turn to take ONE coin from one of the ends of the line until there are no more coins left.
 * The player with the larger amount of money wins.
 * Determine if the first player will win or lose?
 *
 * Idea:
 * 1. dp[i][j], 表示当剩下的硬币为 coins[i:j] 的时候，当时的先手在双方都 choose wisely 的情况下，能获得的最多硬币数值。
 * 2. base case - initialization
 *    dp[i][i] = coins[i]
 *    dp[i][i + 1] = max(coins[i], coins[j])
 * 3. induction rule
 *    dp[i][j] = max( sum[i:j] - dp[i + 1][j], sum[i:j] - dp[i][j - 1] )
 *                          取区间 [i:j] 左边					取区间 [i:j] 右边
 * 4. return value
 *    dp[0][n - 1]
 */

public class CoinsInALine3 {
	public boolean firstWillWon(int[] values) {
		// input sanity check
		if (values == null || values.length == 0) {
			return false;
		}
		// 1. state definition
		int[][] dp = new int[values.length][values.length];
		int[] sum = new int[values.length + 1]; // sum[i], 表示values[0:i - 1] 的和, values 的 前 i 个之和
		// 2. base case - initialization
		dp[0][0] = values[0];
		sum[1] = values[0];
		for (int i = 1; i < values.length; ++i) {
			dp[i][i] = values[i];
			dp[i - 1][i] = Math.max(values[i - 1], values[i]);
			sum[i + 1] = sum[i] + values[i];
		}
		// 3. induction rule
		for (int i = values.length - 1; i >= 0; --i) {
			for (int j = i + 2; j < values.length; ++j) {
				dp[i][j] = Math.max(sum[j + 1] - sum[i] - dp[i + 1][j], sum[j + 1] - sum[i] - dp[i][j - 1]);
			}
		}
		// 4. return value
		return dp[0][values.length - 1] > sum[values.length] / 2;
	}
}
