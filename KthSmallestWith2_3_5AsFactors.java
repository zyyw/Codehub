/**
 * Problem statement:
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 *
 * Idea:
 * Heap.
 * LeetCode - time limit exceeded
 *
 */

public class KthSmallestWith2_3_5AsFactors {
	static class Cell implements {
		int x;
		int y;
		int z;
		int val;
		Cell(int x, int y, int z, int v) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.val = v;
		}
	}
	public int nthUglyNumber(int n) {
		// input sanity check
		if (n <= 0) {
			return Integer.MIN_VALUE;
		}
		Queue<Cell> pq = new PriorityQueue<>(n, new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				return c1.val < c2.val ? -1 : 1;
			}
		});
		pq.offer(new Cell(0, 0, 0, 1));
		boolean[][][] visited = new boolean[n][n][n];
		visited[0][0][0] = true;
		Cell cur = null;
		int[] dx = {1, 0, 0};
		int[] dy = {0, 1, 0};
		int[] dz = {0, 0, 1};
		int[] nums = {2, 3, 5};
		int cnt = n;
		while (--cnt > 0) {
			cur = pq.poll();
			for (int i = 0; i < 3; ++i) {
				int x2 = cur.x + dx[i];
				int y2 = cur.y + dy[i];
				int z2 = cur.z + dz[i];
				// out of bound check
				if (!(x2 < n && y2 < n & z2 < n)) {
					continue;
				}
				// de-dup check
				if (visited[x2][y2][z2]) {
					continue;
				}
				pq.offer(new Cell(x2, y2, z2, cur.val * nums[i]));
				visited[x2][y2][z2] = true;
			}
		}
		return pq.peek().val;
	}
}
