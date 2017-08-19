/**
 * Problem statement:
 * Given a m x n grid filled with non-negative numbers, find a path from top-left to bottom-right
 * which minizes the sum of all numbers along its path.
 *
 * Note:
 * You can only move down / right at any time.
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return Integer.MIN_VALUE;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int j = 1; j < n; ++j) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < m; ++i) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[m - 1][n - 1];
	}
}
