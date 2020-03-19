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
 *
 * 思路：
 * 用一个minHeap 装边界柱高，从中取最矮的柱高，往其上下左右搜索。
 * 如果遇到较高的柱高，则将其放入 minHeap 作为新边界；
 * 反之，如果遇到较低的柱高，则累加该柱子可以盛水的体积 (从minHeap取出的柱高-该较低的柱高），
 * 然后仍将取出的柱高作为新边界柱高放回 minHeap 中。
 */

public class MaxWaterTrapped2 {
	static class Cell {
		int x;
		int y;
		int val;
		Cell(int i, int j, int val) {
			x = i;
			y = j;
			val = val;
		}
	}

	public int trapRainWater(int[][] heights) {
		// input sanity
		if (heights == null || heights.length <= 2 || heights[0] == null || heights[0].length <= 2) {
			return 0;
		}
		int m = heights.length;
		int n = heights[0].length;

		Queue<Cell> pq = new PriorityQueue<>(1, new Comparator<Cell>(){
			public int compare(Cell c1, Cell c2) {
				return c1.val < c2.val ? -1 : 1;
			}
		});
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; ++i) {
			// first column
			pq.offer(new Cell(i, 0, heights[i][0]));
			visited[i][0] = true;
			// last column
			pq.offer(new Cell(i, n - 1, heights[i][n - 1]));
			visited[i][n - 1] = true;
		}
		for (int j = 1; j < n - 1; ++j) {
			// first row
			pq.offer(new Cell(0, j, heights[0][j]));
			visited[0][j] = true;
			// last row
			pq.offer(new Cell(m - 1, j, heights[m - 1][j]));
			visited[m - 1][j] = true;
		}

		int water = 0;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		while (!pq.isEmpty()) {
			Cell cur = pq.poll();
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
