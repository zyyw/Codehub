/**
 * Problem statement:
 * Given two sorted arrays A and B, of sizes m and n respectively.
 * Define s = a + b, where a is one element from A and b is one element from B.
 * Find the Kth smallest s out of all possible s'.
 *
 * Assumption:
 * 1. A is not null and A is not of zero length, so as B;
 * 2. K > 0 and K <= m * n

      [1,      3,     5] +
[
 2:  2+1=3, 2+3=5, 2+5=7
 4:  4+1=5, 4+3=7, 4+5=9
 6:  6+1=7, 6+3=9, 6+5=11
]

 */

public class KthSmallestSumIn2SortedArray {
	static class Cell {
		int x;
		int y;
		int val;
		Cell(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.val = v;
		}
	}
	public int kthSum(int[] a, int[] b, int k) {
		// input sanity check
		if (a == null || a.length == 0 || b == null || b.length == 0 || k <= 0) {
			return Integer.MIN_VALUE;
		}
		Queue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>(){
			public int compare(Cell c1, Cell c2) {
				return c1.val < c2.val ? -1 : 1;
			}
		});
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
