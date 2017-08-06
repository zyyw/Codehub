/**
 * Problem statement:
 * Given a matrix: 
 * for each row of the matrix is sorted in ascending order, left to right;
 * for each column of the matrix is sorted in ascending order, top to bottom 
 *
 * Return the k-th smallest number in the matrix.
 */

public class KthSmallestInSortedMatrix2 {
	static class Cell implements Comparable<Cell> {
		int x;
		int y;
		int val;
		Cell(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
		@Override
		public int compareTo(Cell c) {
			return this.val < c.val ? -1 : 1;
		}
	}

	public int kthSmallest(int[][] matrix, int k) {
		// input sanity check
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || k <= 0) {
			return Integer.MIN_VALUE;
		}
		Queue<Cell> pq = new PriorityQueue<>();
		pq.offer(new Cell(0, 0, matrix[0][0]));
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		visited[0][0] = true;
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		Cell cur = null;
		int cnt = k;
		while (--cnt > 0) {
			cur = pq.poll();
			for (int i = 0; i < 2; ++i) {
				int x2 = cur.x + dx[i];
				int y2 = cur.y + dy[i];
				// check out of bound
				if (!(x2 < matrix.length && y2 < matrix[0].length)) {
					continue;
				}
				if (visited[x2][y2]) {
					continue;
				}
				pq.offer(new Cell(x2, y2, matrix[x2][y2]));
				visited[x2][y2] = true;
			}
		}
		return pq.peek().val;
	}
}
