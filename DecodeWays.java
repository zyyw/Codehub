/**
 * Problem statement:
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2 
 * ...   ...
 * 'Z' -> 26 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * [ Assumption ]
 * "01", return 0
 *
 * Idea:
 * dp[i] = 0
 * 1. s[0 : i-1], s[i]
 *    if: (s[i] != '0')
 *      dp[i] += dp[i - 1]
 * 2. s[0 : i-2], s[i-1 : i]
 *    if: ( "10" <= s[i-1 : i] <= "26")
 *      dp[i] += dp[i - 2]
 */

public class DecodeWays {
	public int numDecodings(String s) {
		// base cases !!!
		if (s == null || s.length() == 0) {
			return 0;
		} else if (s.charAt(0) == '0') {
			return 0;
		} else if (s.length() == 1) {
			return 1;
		}
		String left = "10";
		String right = "26";
		int[] dp = new int[s.length()];
		// s[0] != '0'
		dp[0] = 1;
		if (s.charAt(1) == '0') {
			if (s.charAt(0) > '2') {
				return 0;
			}
			dp[1] = 1;
		} else {
			// s[1] != '0'
			dp[1] = validTwoDigitsCode(s.substring(0, 2), left, right) ? 2 : 1;
		}
		// induction rule
		for (int i = 2; i < s.length(); ++i) {
			if (s.charAt(i) == '0') {
				dp[i] = 0;
			} else {
				dp[i] = dp[i - 1];
			}
			if (validTwoDigitsCode(s.substring(i - 1, i + 1), left, right)) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length() - 1];
	}

	private boolean validTwoDigitsCode(String code, String left, String right) {
		return code.compareTo(left) >= 0 && code.compareTo(right) <= 0;
	}
}
