/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/
public class Search2dMatrix1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int num = matrix[mi / n][mi % n];
            if (num < target) {
                lo = mi + 1;
            } else if (num > target) {
                hi = mi;
            } else {
                return true;
            }
        }
        return false;
    }
}
