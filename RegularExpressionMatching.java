/**
 * Problem statement:
 * Implement regular expression matching with support for '.' and '*'
 * '.' matches any single character;
 * '*' matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example:
 * isMatch("aa", "a")    -> false
 * isMatch("aa", "aa")   -> true
 * isMatch("aaa", "aa")  -> false
 * isMatch("aa", "a*")   -> true
 * isMatch("aa", ".*")   -> true
 * isMatch("ab", ".*")   -> true
 * isMatch("aab", "c*a*b")  -> true
 *
 * Idea:
 * [ DP ]
 * 1. state definition:
 *    M[i][j]: 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配。
 * 2. base case initialization:
 *    M[0][0] = true;
 *    M[0][j] = p[j - 1] == '*' && (M[0][j - 2] || M[0][j - 1]); // 1 <= j <= p.length()
 *    M[i][0] = false; // 1 <= i <= s.length()
 * 3. induction rule:
 * 	  if: p[j - 1] == s[i - 1] || p[j - 1] == '.'
 *        M[i][j] = M[i - 1][j - 1]
 *    else if: p[j - 1] == '*'
 *        if: j < 2
 *           M[i][j] = false;
 *        else: (j >= 2)
 *    		 M[i][j] = M[i][j - 2] || // match 0 times 
 *    		 		   M[i][j - 1] ||   // match 1 times
 *					   M[i - 1][j] && (p[j - 2] == s[i - 1] || p[j - 2] == '.')
 *	  else:
 *	  	   M[i][j] = false;
 *
 */

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		// input sanity check
		if (s == null || p == null) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int j = 2; j <= p.length(); ++j) {
			dp[0][j] = p.charAt(j - 1) == '*' && (dp[0][j - 2] || dp[0][j - 1]);
		}
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 1; j <= p.length(); ++j) {
				if (singleCharMatch(s.charAt(i - 1), p.charAt(j - 1))) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					if (j < 2) {
						dp[i][j] = false;
						continue;
					}
					dp[i][j] = dp[i][j - 2] ||
								dp[i][j - 1] ||
								(dp[i - 1][j] && singleCharMatch(s.charAt(i - 1), p.charAt(j - 2)));
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	private boolean singleCharMatch(char ch, char p) {
		return p == ch || p == '.';
	}
}
