/**
 * Problem statement:
 * Given a string s, find the longest palindromic substring in s.
 *
 * Idea:
 * 1. state
 * dp[i][j], 表示s[i][j] 是否为palindrome
 * 2. base case initialization
 * dp[i][i] = true
 * dp[i][i + 1] = s[i] == s[j]
 * 3. induction rule
 * dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
 * 4. return value
 * 所有 dp[i][j] true 中, 当 max(j - i + 1) 时的 i 和 j
 *
 * 注意点：
 * 1. 避免思维惯性。要看清楚，问的是longest palindromic substring 的长度还是它本身。
 * 2. dp[][] 到底是 boolean type 还是 int type
 * 3. 对于有多种初始化的 case, 要注意在初始化的过程中也更新可能出现的最优解。
 *    dp[i][i], start = 1, end = 1 (default)
 *    dp[i][i + 1] == true 时，start = i, end = i + 2
 */

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null) {
			return null;
		} else if (s.length() <= 1) {
			return new String(s);
		}
		// 1. state
		boolean[][] dp = new boolean[s.length()][s.length()];
		// 2. base case
		int start = 0;
		int end = 1;
		for (int i = 0; i < s.length() - 1; ++i) {
			dp[i][i] = true;
			dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			if (dp[i][i + 1]) {
				start = i;
				end = i + 2;
			}
		}
		dp[s.length() - 1][s.length() - 1] = true;
		// 3.induction rule
		for (int i = s.length() - 1; i >= 0; --i) {
			for (int j = i + 2; j < s.length(); ++j) {
				dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
				if (dp[i][j] && j + 1 - i > end - start) {
					start = i;
					end = j + 1;
				}
			}
		}
		return s.substring(start, end);
	}
}
