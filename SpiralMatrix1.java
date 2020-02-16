/*
Given a matrix of m x n elements (m rows, n columns),
return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

public class SpiralMatrix1 {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ret = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return ret;
    }
    helper(matrix, 0, matrix.length, matrix[0].length, ret);
    return ret;
  }

  private void helper(int[][] matrix, int offset, int m, int n, List<Integer> ret) {
    if (m <= 0 || n <= 0) {
      return;
    }
    if (m == 1) {
      for (int j = 0; j < n; ++j) {
        ret.add(matrix[offset][offset + j]);
      }
      return;
    }
    if (n == 1) {
      for (int i = 0; i < m; ++i) {
        ret.add(matrix[offset + i][offset]);
      }
      return;
    }

    for (int j = 0; j < n - 1; ++j) {
      ret.add(matrix[offset][offset + j]);
    }
    for (int i = 0; i < m - 1; ++i) {
      ret.add(matrix[offset + i][offset + n - 1]);
    }
    for (int j = n - 1; j > 0; --j) {
      ret.add(matrix[offset + m - 1][offset + j]);
    }
    for (int i = m - 1; i > 0 ; --i) {
      ret.add(matrix[offset + i][offset]);
    }

    helper(matrix, offset + 1, m - 2, n - 2, ret);
  }
}
