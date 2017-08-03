/**
 * Problem statement:
 * Given three strings: s, s1, s2.
 * determine if s3 can be formed by the interleaving of s1 and s2
 * 
 * Assume:
 * s, s1, s2 are not null
 *
 */

public class InterleavingString {
	public boolean isInterleave(String s, String s1, String s2) {
		// input sanity check
		if (s == null || s1 == null || s2 == null) {
			return false;
		} else if (s.length() != s1.length() + s2.length()) {
			return false;
		}
		// 1. state definition
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1]; 
		// 2. base case - initialization
		dp[0][0] = true;
		for (int i = 1; i <= s1.length(); ++i) {
			dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s.charAt(i - 1);
		}
		for (int j = 1; j <= s2.length(); ++j) {
			dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s.charAt(j - 1);
		}
		// 3. Induction rule
		// THIS IS WRONG:
		// if: s1[i - 1] == s[i + j - 1]
		//   dp[i][j] = dp[i - 1][j]
		// else if: s2[j - 1] == s[i + j - 1]
		//   dp[i][j] = dp[i][j - 1]
		// else:
		//   dp[i][j] = false;
		// THIS IS CORRECT:
		//   dp[i][j] = (s1[i - 1] == s[i + j - 1] && dp[i - 1][j]) || (s2[j - 1] == s[i + j - 1] && dp[i][j - 1]);
		for (int i = 1; i <= s1.length(); ++i) {
			for (int j = 1; j <= s2.length(); ++j) {
				dp[i][j] = (s.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) || 
							(s.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]);
			}
		}
		// 4. return value
		// dp[s1.length()][s2.length()]
		return dp[s1.length()][s2.length()];
	}
}
