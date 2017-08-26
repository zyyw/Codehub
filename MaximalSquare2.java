/**
 * Problem statement:
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square which diagonal is all 1 and others is 0.
 *
 * Idea:
 * [ DP ]
 * 定位角：右下角
 * 1. state definition
 *    dp[i][j], 表示以 matrix[i][j] 为右下角，对角线为 1 其它全部为 0 的, 最大的子矩阵的边长
 *    up[i][j], 表示以 matrix[i][j] 为底，inclusively, 向上延伸，全部为 0 的最大长度
 *    left[i][j], 表示以 matrix[i][j] 为底，inclusively, 向左延伸，全部为 0 的最大长度
 * 2. base case initialization
 *    dp[0][0] = matrix[0][0] == 1 ? 1 : 0
 *    up[0][0] = matrix[0][0] == 1 ? 0 : 1
 *    left[0][0] = up[0][0]
 *    第一行：
 *    dp[0][j] = matrix[0][j] == 1 ? 1 : 0
 *    up[0][j] = matrix[0][j] == 1 ? 0 : 1 
 *    left[0][j] = matrix[0][j] == 1 ? 0 : left[0][j - 1] + 1
 *    第一列：
 *    dp[i][0] = matrix[i][0] == 1 ? 1 : 0
 *    up[i][0] = matrix[i][0] == 1 ? 0 : up[i - 1][0] + 1
 *    left[i][0] = matrix[i][0] == 1 ? 0 : 1
 * 3. induction rule
 *    if matrix[i][j] == 0:
 *       dp[i][j] = 0;
 *       up[i][j] = 1 + up[i - 1][j];
 *       left[i][j] = 1 + left[i][j - 1];
 *    else:
 *       dp[i][j] = 1 + MIN dp[i - 1][j - 1], up[i - 1][j], left[i][j - 1] };
 *       up[i][j] = 0
 *       left[i][j] = 0
 * 4. return value
 *    len = MAX{ dp[i][j] }
 *    return len * len
 */

public class MaximalSquare2 {
	public int maxSquare2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		// 1. state definition
		int[][] dp = new int[m][n];
		int[][] up = new int[m][n];
		int[][] left = new int[m][n];
		// 2. base case initialization
		dp[0][0] = matrix[0][0] == 1 ? 1 : 0;
		up[0][0] = matrix[0][0] == 1 ? 0 : 1;
		left[0][0] = matrix[0][0] == 1 ? 0 : 1;
		int ret = dp[0][0];
		for (int j = 1; j < n; ++j) {
			dp[0][j] = matrix[0][j] == 1 ? 1 : 0;
			up[0][j] = matrix[0][j] == 1 ? 0 : 1;
			left[0][j] = matrix[0][j] == 1 ? 0 : (1 + left[0][j - 1]);
			ret = Math.max(ret, dp[0][j]);
		}
		for (int i = 1; i < m; ++i) {
			dp[i][0] = matrix[i][0] == 1 ? 1 : 0;
			up[i][0] = matrix[i][0] == 1 ? 0 : (1 + up[i - 1][0]);
			left[i][0] = matrix[i][0] == 1 ? 0 : 1;
			ret = Math.max(ret, dp[i][0]);
		}
		// 3. induction rule
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (matrix[i][j] == 0) {
					dp[i][j] = 0;
					up[i][j] = 1 + up[i - 1][j];
					left[i][j] = 1 + left[i][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(up[i - 1][j], left[i][j - 1]));
					up[i][j] = 0;
					left[i][j] = 0;
					ret = Math.max(ret, dp[i][j]);
				}
			}
		}
		// 4. return value
		return ret * ret;
	}
}
