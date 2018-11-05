/**
 * Problem statement:
 * Given two sorted arrays A and B, of sizes m and n respectively.
 * Define s = a + b, where a is one element from A and b is one element from B.
 * Find the Kth smallest s out of all possible s'.
 *
 * Assumption:
 * 1. A is not null and A is not of zero length, so as B;
 * 2. K > 0 and K <= m * n
 */

public class KthSmallestSumIn2SortedArray {
	static class Cell implements Comparable<Cell> {
		int x;
		int y;
		int val;
		Cell(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.val = v;
		}
		@Override
		public int compareTo(Cell c) {
			return this.val < c.val ? -1 : 1
		}
	}
	public int kthSum(int[] a, int[] b, int k) {
		// input sanity check
		if (a == null || a.length == 0 || b == null || b.length == 0 || k <= 0) {
			return Integer.MIN_VALUE;
		}
		Queue<Cell> pq = new PriorityQueue<>();
		pq.offer(new Cell(0, 0, a[0] + b[0]));
		boolean[][] visited = new int[a.length][b.length];
		visited[0][0] = true;
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		Cell cur = null;
		while (--k > 0) {
			cur = pq.poll();
			for (int i = 0; i < 2; ++i) {
				int x2 = cur.x + dx[i];
				int y2 = cur.y + dy[i];
				// check out of bound
				if (!(x2 < a.length && y2 < b.length)) {
					continue;
				}
				// check duplicates
				if (visited[x2][y2]) {
					continue;
				}
				pq.offer(new Cell(x2, y2, a[x2] + b[y2]));
				visited[x2][y2] = true;
			}
		}
		return pq.peek().val;
	}
}
