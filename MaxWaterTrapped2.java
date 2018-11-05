/**
 * Problem statement:
 * Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, compute how much water it is able to trap after raining.
 *
 * note:
 * 四个角上的点似乎要放到初始化里去
 * 反例：
 *  1  3  1
 *  4  2  5
 *  1  6  1
 * 如果不放四个角上的点，点 1 回被算到 water 里去 (3 - 1)
 * expect: 1
 * actual: 12 (如果不放四个角上的点)
 */

public class MaxWaterTrapped2 {
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
		public int compareTo(Cell cell) {
			return this.val < cell.val ? -1 : 1; // minHeap
		}
	}

	public int trapRainWater(int[][] heights) {
		// input sanity
		if (heights == null || heights.length <= 2 || heights[0] == null || heights[0].length <= 2) {
			return 0;
		}
		Queue<Cell> pq = new PriorityQueue<>();
		int m = heights.length;
		int n = heights[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 1; i < m - 1; ++i) {
			// first column
			pq.offer(new Cell(i, 0, heights[i][0]));
			visited[i][0] = true;
			// last column
			pq.offer(new Cell(i, n - 1, heights[i][n - 1]));
			visited[i][n - 1] = true;
		}
		for (int j = 0; j < n; ++j) {
			// first row
			pq.offer(new Cell(0, j, heights[0][j]));
			visited[0][j] = true;
			// last row
			pq.offer(new Cell(m - 1, j, heights[m - 1][j]));
			visited[m - 1][j] = true;
		}
		int water = 0;
		Cell cur = null;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		while (!pq.isEmpty()) {
			cur = pq.poll();
			for (int i = 0; i < 4; ++i) {
				int x2 = cur.x + dx[i];
				int y2 = cur.y + dy[i];
				// out of bound check
				if (x2 < 0 || x2 >= m || y2 < 0 || y2 >= n) {
					continue;
				}
				// duplicated check
				if (visited[x2][y2]) {
					continue;
				}
				if (heights[x2][y2] < cur.val) {
					water += cur.val - heights[x2][y2];
					pq.offer(new Cell(x2, y2, cur.val));
				} else {
					pq.offer(new Cell(x2, y2, heights[x2][y2]));
				}
				visited[x2][y2] = true;
			}
		}
		return water;
	}
}
