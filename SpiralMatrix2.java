/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class SpiralMatrix2 {
  public int[][] generateMatrix(int n) {
    if (n <= 0) {
      return null;
    }
    int[][] matrix = new int[n][n];
    helper(matrix, 0, n, 1);
    return matrix;
  }

  private void helper(int[][] matrix, int offset, int n, int val) {
    if (n == 0) {
      return;
    }
    if (n == 1) {
      matrix[offset][offset] = val;
      return;
    }

    for (int j = 0; j < n - 1; ++j) {
      matrix[offset][offset + j] = val;
      ++val;
    }
    for (int i = 0; i < n - 1; ++i) {
      matrix[offset + i][offset + n - 1] = val;
      ++val;
    }
    for (int j = n - 1; j > 0; --j) {
      matrix[offset + n - 1][offset + j] = val;
      ++val;
    }
    for (int i = n - 1; i > 0; --i) {
      matrix[offset + i][offset] = val;
      ++val;
    }

    helper(matrix, offset + 1, n - 2, val);
  }
}
