/**
 * Problem statement:
 * Given two words word1, word2, find the minimum number of steps required to convert word1 to word2.
 * One step is defined as any one of the three operations: 
 * - Insert a character
 * - Delete a character
 * - Update a character
 *
 */

public class EditDistance1 {
	public int minDistance(String word1, String word2) {
		// input sanity check
		if (word1 == null || word2 == null) {
			return 0;
		} else if (word1.length() == 0) {
			return word2.length(); // all insert
		} else if (word2.length() == 0) {
			return word1.length(); // all delete
		}
		// 1. state definition
		// dp[i][j]: 表示最少可以通过 dp[i][j] steps, 将 word1 的前 i 个字符 变换成 word2 的前 j 个字符,
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		// 2. base case - initialization
		// dp[0][0] = 0;
		// dp[i][0] = i; 1 <= i <= word1.length()
		// dp[0][j] = j; 1 <= j <= word2.length()
		dp[0][0] = 0;
		for (int i = 1; i <= word1.length(); ++i) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= word2.length(); ++j) {
			dp[0][j] = j;
		}
		// 3. induction rule
		// if: word1[i - 1] == word2[j - 1]
		// 	   dp[i][j] = dp[i - 1][j - 1]
		// else:
		// 	   dp[i][j] = MIN{ dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] } + 1
		// 	                    Delete        Insert         Update
		for (int i = 1; i <= word1.length(); ++i) {
			for (int j = 1; j <= word2.length(); ++j) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
				}
			}
		}
		// 4. return value
		// dp[word1.length()][word2.length()]
		return dp[word1.length()][word2.length()];
	}
}
