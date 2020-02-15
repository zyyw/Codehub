/**
 * Problem statement:
 * Give you an integer matrix (with row size n, column size m)，
 * find the longest increasing continuous subsequence in this matrix.
 * The definition of the longest increasing continuous subsequence here
 * can start at any row or column and go up/down/right/left any direction
 *
 * Idea:
 * 记忆化搜索。本质是 DFS + 子状态记忆
 */

public class LongestContinuousIncreasingSubsequence2 {
	public int longestIncreasingContinuousSubsequenceII(int[][] matrix) {
		// input sanity check
		if (matrix == null || matrix.length == 0 || matrix[0] == null ||  matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		// dp[i][j]: 以点(i, j)结尾的最长的continuous increasing subsequence 的长度
		int[][] dp = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		int ret = 1;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!visited[i][j]) {
					longestIncreasingContinuousSubsequenceIIHelper(matrix, m, n, i, j, dp, visited);
				}
				ret = Math.max(ret, dp[i][j]);
			}
		}
		return ret;
	}

	private void longestIncreasingContinuousSubsequenceIIHelper(int[][] matrix, int m, int n, int i, int j, int[][] dp, boolean[][] visited) {
		// base case - initialization
		visited[i][j] = true;
		dp[i][j] = 1;
		// recursion rule: 记忆化搜索
		for (int k = 0; k < dx.length; ++k) {
			int x = i + dx[k];
			int y = j + dy[k];
			// out of bound check
			if (x < 0 || x >= m || y < 0 || y >= n) {
				continue;
			}
			if (matrix[x][y] >= matrix[i][j]) {
				continue;
			}
			// now matrix[x][y] < matrix[i][j]
			if (visited[x][y]) {
				dp[i][j] = Math.max(dp[i][j], dp[x][y] + 1);
				continue;
			}
			longestIncreasingContinuousSubsequenceIIHelper(matrix, m, n, x, y, dp, visited);
			dp[i][j] = Math.max(dp[i][j], dp[x][y] + 1);
		}
	}

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};
}
