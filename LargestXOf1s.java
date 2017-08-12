/**
 * Problem statement:
 * Give a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm lengths and four arms joining at the central point.
 * Return the arm length of the largest X shape.
 *
 * Assumptions:
 * The given matrix is not null, having size of N * M, N >= 0 and M >= 0
 *
 * Idea:
 * 1. state definition
 * topLeft[i][j]:       表示从 matrix[i][j], inclusively, 向左上延伸, 全部为1的最大长度
 * bottomLeft[i][j]:    表示从 matrix[i][j], inclusively, 向左下延伸，全部为1的最大长度
 * bottomRight[i][j]:   表示从 matrix[i][j], inclusively, 向右下延伸，全部为1的最大长度
 * topRight[i][j]:      表示从 matrix[i][j], inclusively, 向右上延伸，全部为1的最大长度
 *
 * 2. base case - initialization
 * topLeft				bottomLeft			bottomRight		  	topRight
 * .------				 |						   |		      -----.
 * |					 |						   |				   |
 * |					 |						   |				   |
 * |					 .------			 ------.				   |
 *
 * 3. induction rule
 *    topLeft[i][j] 	= matrix[i][j] == 1 ? 1 + topLeft[i - 1][j - 1] : 0
 *    bottomLeft[i][j]  = matrix[i][j] == 1 ? 1 + bottomLeft[i + 1][j - 1] : 0
 *    bottomRight[i][j] = matrix[i][j] == 1 ? 1 + bottomRight[i + 1][j + 1] : 0
 *    topRight[i][j] 	= matrix[i][j] == 1 ? 1 + topRight[i - 1][j + 1] : 0
 *
 * 4. return value
 *    MAX{ MIN{ topLeft[i][j], bottomLeft[i][j], bottomRight[i][j], topRight[i][j]  } }
 *
 */

public class LargestXOf1s {
	public int largest(int[][] matrix) {
		// input sanity check
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		// 1 state
		int[][] topLeft = new int[m][n];
		int[][] bottomLeft = new int[m][n];
		int[][] bottomRight = new int[m][n];
		int[][] topRight = new int[m][n];
		// 2. preprocess: base case initialization && induction rule
		preprocessTopLeftAndBottomRight(matrix, m, n, topLeft, bottomRight);
		preprocessBottomLeftAndTopRight(matrix, m, n, bottomLeft, topRight);
		int ret = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int cur = Math.min(Math.min(topLeft[i][j], bottomLeft[i][j]), Math.min(bottomRight[i][j], topRight[i][j]));
				ret = Math.max(ret, cur);
			}
		}
		return ret;
	}

	private void preprocessTopLeftAndBottomRight(int[][] matrix, int m, int n, int[][] topLeft, int[][] bottomRight) {
		// 1 initialize
		// the first column and the last column
		for (int i = 0; i < m; ++i) {
			topLeft[i][0] = matrix[i][0] == 1 ? 1 : 0;
			bottomRight[m - 1 - i][n - 1] = matrix[m - 1 - i][n - 1] == 1 ? 1 : 0;
		}
		// the first row and the last row
		for (int j = 1; j < n - 1; ++j) {
			topLeft[0][j] = matrix[0][j] == 1 ? 1 : 0;
			bottomRight[m - 1][n - 1 - j] = matrix[m - 1][n - 1 - j] == 1 ? 1 : 0;
		}
		// 2 induction rule
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				topLeft[i][j] = matrix[i][j] == 1 ? 1 + topLeft[i - 1][j - 1] : 0;
				bottomRight[m - 1 - i][n - 1 - j] = matrix[m - 1 - i][n - 1 - j] == 1 ? 1 + bottomRight[m - i][n - j] : 0;
			}
		}
	}

	private void preprocessBottomLeftAndTopRight(int[][] matrix, int m, int n, int[][] bottomLeft, int[][] topRight) {
		// 1 initialize
		// the first and the last column
		for (int i = 0; i < m; ++i) {
			bottomLeft[i][0] = matrix[i][0] == 1 ? 1 : 0;
			topRight[i][n - 1] = matrix[i][n - 1] == 1 ? 1 : 0;
		}
		// the first and the last row 
		for (int j = 1; j < n - 1; ++j) {
			bottomLeft[m - 1][j] = matrix[m - 1][j] == 1 ? 1 : 0;
			topRight[0][n - 1 - j] = matrix[0][n - 1 - j] == 1 ? 1 : 0;
		}
		// 2 induction rule
		for (int i = m - 2; i >= 0; --i) {
			for (int j = 1; j < n; ++j) {
				bottomLeft[i][j] = matrix[i][j] == 1 ? 1 + bottomLeft[i + 1][j - 1] : 0;
				topRight[m - 1 - i][n - 1 -j] = matrix[m - 1 - i][n - 1 - j] == 1 ? 1 + topRight[m - 2 - i][n - j] : 0;
			}
		}
	}
}
