/**
 * Problem statement:
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * Example:
 * S = "rabbbit"
 * T = "rabbit"
 * return 3. Because { rab1b2it, rab1b3it, rab2b3it }
 */

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		// input sanity check
		if (s == null || t == null) {
			return 0;
		}
		// 1. state definition
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		// 2. base case initialization
		dp[0][0] = 1;
		for (int i = 1; i <= s.length(); ++i) {
			dp[i][0] = 1;
		}
		for (int j = 1; j <= t.length(); ++j) {
			dp[0][j] = 0;
		}
		// 3. induction rule
		// if: s[i - 1] == t[j - 1]
		//     dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
		// else ( s[i - 1] != t[j - 1] ) :
		//     dp[i][j] = dp[i - 1][j]
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 1; j <= t.length(); ++j) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		// 4. return value
		// dp[s.length()][t.length()]
		return dp[s.length()][t.length()];
	}
}
