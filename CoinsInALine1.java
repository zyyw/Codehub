/**
 * Problem statement:
 * There are n coins in a line. Two players take turns to take one or two from the right side until there are no more coins left.
 * The player who takes the last coin wins.
 *  -> 单次取 1 个或者 2 个
 *  -> 每次都从右边取
 * Determine if the first player will win or lose.
 *
 * Idea:
 * 1. state
 * dp[i], 表示还剩 i 个硬币时，先手是否能赢。
 * 2. base case initialization
 * dp[0] = true
 * dp[1] = true
 * 3. induction rule
 *    - 还是回头看的套路，回头看两个
 * dp[i] = true, if dp[i - 1] == false || dp[i - 2] == false
 * dp[i] = false, if dp[i- 1] == true && dp[i - 2] == true
 * 4. return value
 * dp[n]
 */

public class CoinsInALine1 {
	public boolean firstWillWin(int n) {
		// input sanity check
		if (n <= 0) {
			return false;
		} else if (n <= 2) {
			return true;
		}
		// 1. state
		boolean[] dp = new boolean[n + 1];
		dp[1] = true;
		dp[2] = true;
		for (int i = 3; i <= n; ++i) {
			if (dp[i - 1] == false || dp[i - 2] == false) {
				dp[i] = true;
			} else {
				dp[i] = false;
			}
		}
		return dp[n];
	}
}
