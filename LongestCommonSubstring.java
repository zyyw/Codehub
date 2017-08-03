/**
 * Problem statement:
 * Given two strings, find the longest common substring of them.
 * Return the length of the longest common substring.
 *
 */

public class LongestCommonSubstring {
	public int longestCommonSubstring(String s, String t) {
		// input sanity check
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return 0;
		}
		// 1. state definition
		// dp[i][j]: 表示 s 的前 i 个字符和 t 的前 j 个字符的, longest common substring
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		// 2. base case initialization
		// dp[0][0] = 0
		// dp[i][0] = 0, 1 <= i <= s.length()
		// dp[0][j] = 0, 1 <= j <= t.length()
		// 3. induction rule
		int ret = 0;
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 1; j <= t.length(); ++j) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = 0;
				}
				ret = Math.max(ret, dp[i][j]);
			}
		}
		// 4. return value
		// MAX{ dp[i][j] } 
		return ret;
	}
}
