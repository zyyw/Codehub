/*
 * Problem statement:
 * Given two strings, find the longest common subsequence (LCS).
 * Return the length of the longest common subsequence.
 */

public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String s, String t) {
		// input sanity check
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return 0;
		}
		// 1. state definition
		// dp[i][j]: 表示 s 的前 i 个字符和 t 的前 j 个字符的 LCS
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		// 2. base case initialization
		// dp[i][0] = 0, 0 <= i <= s.length();
		// dp[0][j] = 0, 0 <= j <= t.length();
		// 3. induction rule:
		// if: s[i - 1] == t[j - ]
		//    dp[i][j] = dp[i - 1][j - 1] + 1
		// else:
		// 	  dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 1; j <= t.length(); ++j) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		// 4. return value:
		// dp[s.length()][t.length()]
		return dp[s.length()][t.length()];
	}
}
