/*
 * Problem statement:
 * Implment wildcard pattern matching with support for '?' and '*'
 * '?' matches any single character;
 * '*' matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial)
 *
 * Example:
 * isMatch("aa","a")     -> false
 * isMatch("aa","aa") 	 -> true
 * isMatch("aaa","aa")   -> false
 * isMatch("aa", "*") 	 -> true
 * isMatch("aa", "a*") 	 -> true
 * isMatch("ab", "?*") 	 -> true
 * isMatch("aab", "c*a*b")   -> false
 *
 * Idea:
 * [ method 1 ]
 * DFS / Recursion
 *
 * [ method 2 ]
 * DP
 * 1. state definition:
 *   M[i][j]: 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配。
 * 2. base case initialization:
 *   M[0][0] = true
 *   M[i][0] = false;  // 1 <= i <= s.length()
 *   M[0][j] = M[0][j - 1] && p[j - 1] == '*'
 * 3. induction rule:
 *   if: p[j - 1] == '?' || p[j - 1] == s[i - 1]
 *       M[i][j] = true;
 *   else if: p[j - 1] == '*'
 *       M[i][j] = M[i][j - 1] || M[i - 1][j]
 *       	      match 0 char     match 1 or N char
 *   else:
 *       M[i][j] = false;
 */

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		// input sanity check
		if (s == null || p == null) {
			return false;
		}
		return isMatchHelper2(s, p);
	}

	// method 1 (DFS):
	private boolean isMatchHelper(String s, int idx1, String p, int idx2) {
		if (idx2 == p.length()) {
			return idx1 == s.length();
		} else if (idx1 == s.length()) {
			if (p.charAt(idx2) != '*') {
				return false;
			}
			return isMatchHelper(s, idx1, p, idx2 + 1);
		}
		if (p.charAt(idx2) == s.charAt(idx1) || p.charAt(idx2) == '?') {
			return isMatchHelper(s, idx1 + 1, p, idx2 + 1);
		} else if (p.charAt(idx2) == '*') {
			while (idx2 + 1 < p.length() && p.charAt(idx2 + 1) == '*') {
				++idx2;
			}
			for (int i = idx1; i <= s.length(); ++i) {
				if (isMatchHelper(s, i, p, idx2 + 1)) {
					return true;
				}
			}
		}
		return false;
	}


	// method 2 (DP):
	private boolean isMatchHelper2(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int j = 1; j <= p.length(); ++j) {
			dp[0][j] = dp[0][j - 1] && p.charAt(j - 1);
		}
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 1; j <= p.length(); ++j) {
				if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
