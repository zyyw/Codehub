/**
 * Problem statement:
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 *
 * Idea:
 * 1. state
 *    dp[i][j], 表示以 matrix[i][j] 为右下角的最大的 1's 正方形
 *    up[i][j], 表示从 matrix[i][j] 开始, inclusively, 向上延伸的全部为 1 的最大长度
 *    left[i][j], 表示从 matrix[i][j] 开始, inclusively, 向左延伸的全部为 1 的最大长度
 * 2. base case - initialize
 * 	  dp[i][0] = matrix[i][0] == 1 ? 1 : 0
 * 	  left[i][0] = matrix[i][0] == 1 ? 1 : 0
 * 	  up[i][0] = matrix[i][0] == 1 ? up[i - 1][0] + 1 : 0   ( up[0][0] = matrix[0][0] == 1 ? 1 : 0 )
 *
 * 	  dp[0][j] = matrix[0][j] == 1 ? 1 : 0
 * 	  left[0][j] = matrix[0][j] == 1 ? left[0][j - 1] + 1 : 0 ( left[0][0] == matrix[0][0] == 1 ? 1 : 0 )
 * 	  up[0][j] = matrix[0][j] == 1 ? 1 : 0
 *
 * 3. induction rule
 *    dp[i][j] = MIN{ dp[i - 1][j - 1], up[i - 1][j], left[i][j - 1] } + 1, where matrix[i][j] == 1
 *             = 0, where matrix[i][j] != 1
 *    left[i][j] = matrix[i][j] == 1 ? 1 + left[i][j - 1] : 0
 *    up[i][j] =  matrix[i][j] == 1 ? 1 + up[i - 1][j] : 0
 *
 * 4. return value
 *    MAX{ dp[i][j] }
 *
 */

public class MaximalSquare {
	public int maxSquare(int[][] matrix) {
		// input sanity check
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		// 1. state
		int[][] dp = new int[m][n];
		int[][] left = new int[m][n];
		int[][] up = new int[m][n];
		// 2. base case initialization
		dp[0][0] = matrix[0][0] == 1 ? 1 : 0;
		left[0][0] = dp[0][0];
		up[0][0] = dp[0][0];
		int ret = dp[0][0];
		for (int i = 1; i < m; ++i) {
			dp[i][0] = matrix[i][0] == 1 ? 1 : 0;
			left[i][0] = dp[i][0];
			up[i][0] = matrix[i][0] == 1 ? 1 + up[i - 1][0] : 0;
			ret = Math.max(ret, dp[i][0]);
		}
		for (int j = 1; j < n; ++j) {
			dp[0][j] = matrix[0][j] == 1 ? 1 : 0;
			left[0][j] = matrix[0][j] == 1 ? 1 + left[0][j - 1] : 0;
			up[0][j] = dp[0][j];
			ret = Math.max(ret, dp[0][j]);
		}
		// 3. induction rule
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (matrix[i][j] != 1) {
					dp[i][j] = 0;
					left[i][j] = 0;
					up[i][j] = 0;
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(up[i - 1][j], left[i][j - 1]));
					left[i][j] = left[i][j - 1] + 1;
					up[i][j] = up[i - 1][j] + 1;
					ret = Math.max(ret, dp[i][j]);
				}
			}
		}
		// 4. return value
		return ret * ret;
	}
}
