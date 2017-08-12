/**
 * Problem statement:
 * Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths 
 * and the four arms joining at the central point.
 * Return the arm length of the largest cross.
 *
 * Idea:
 * 对于矩阵中的每一个点，维持四个数组：
 * 1. state definition
 * up[i][j], 从点 matrix[i][j] 向上延伸，inclusively, 全部为 1 的最大长度
 * down[i][j], 从点 matrix[i][j] 向下延伸，inclusively, 全部为 1 的最大长度
 * left[i][j], 从点 matrix[i][j] 向左延伸，inclusively, 全部为 1 的最大长度
 * right[i][j], 从点 matrix[i][j] 向右延伸，inclusively, 全部为 1 的最大长度
 *
 * 2. base case inialization
 *    -> first row
 *    up[0][j] = matrix[0][j] == 1 ? 1 : 0
 *    -> last row
 *    down[m - 1][j] = matrix[m - 1][j] == 1 ? 1 : 0
 *    -> first column
 *    left[i][0] = matrix[i][0] == 1 ? 1 : 0
 *    -> last column
 *    right[i][n - 1] = matrix[i][n - 1] == 1 ? 1 : 0
 *
 * 3. induction rule
 *    up[i][j] = matrix[i][j] == 1 ? up[i - 1][j] + 1 : 0
 *    down[i][j] = matrix[i][j] == 1 ? down[i + 1][j] + 1 : 0
 *    left[i][j] = matrix[i][j] == 1 ? left[i][j - 1] + 1 : 0
 *    right[i][j] = matrix[i][j] == 1 ? right[i][j + 1] + 1 : 0
 *
 * 4. return value
 *    MAX{ MIN{up[i][j], down[i][j], left[i][j], right[i][j]} }
 */

public class LongestCrossOf1s {
	public int largest(int[][] matrix) {
		// input sanity check
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] up = new int[m][n];
		int[][] down = new int[m][n];
		int[][] left = new int[m][n];
		int[][] right = new int[m][n];
		preprocessUpAndDow(matrix, m, n, up, down);
		preprocessLeftAndRight(matrix, m, n, left, right);
		int ret = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int curMin = Math.min(Math.min(up[i][j], down[i][j]), Math.min(left[i][j], right[i][j]));
				ret = Math.max(ret, curMin);
			}
		}
		return ret;
	}

	private void preprocessUpAndDow(int[][] matrix, int m, int n, int[][] up, int[][] down) {
		// initialization - the first row and the last row
		for (int j = 0; j < n; ++j) {
			up[0][j] = matrix[0][j] == 1 ? 1 : 0;
			down[m - 1][j] = matrix[m - 1][j] == 1 ? 1 : 0;
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				up[i][j] = matrix[i][j] == 1 ? 1 + up[i - 1][j] : 0;
				down[m - 1 - i][j] = matrix[m - 1 - i][j] == 1 ? 1 + down[m - i][j] : 0;
			}
		}
	}

	private void preprocessLeftAndRight(int[][] matrix, int m, int n, int[][] left, int[][] right) {
		// initialization - the first column and the last column
		for (int i = 0; i < m; ++i) {
			left[i][0] = matrix[i][0] == 1 ? 1 : 0;
			right[i][n - 1] = matrix[i][n - 1] == 1 ? 1 : 0;
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				left[i][j] = matrix[i][j] == 1 ? 1 + left[i][j - 1] : 0;
				right[i][n - 1 - j] = matrix[i][n - 1 - j] == 1 ? 1 + right[i][n - j] : 0;
			}
		}
	}
}
