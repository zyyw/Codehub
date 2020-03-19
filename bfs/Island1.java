/**
 * Problem statement:
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *
 * Assumption:
 * You may assume all four edges of the grid are all surrounded by water
 *
 */

public class Island1 {

	//method 1 (BFS):
	static class Cell {
		int x;
		int y;
		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public int numIslands(char[][] grid) {
		// input sanity check
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return 0;
		}
		int ret = 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		Queue<Cell> queue = new ArrayDeque<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!visited[i][j] && grid[i][j] == '1') {
					++ret;
					queue.offer(new Cell(i, j));
					visited[i][j] = true;
					numIslandsHelper(grid, m, n, visited, queue);
				}
			}
		}
		return ret;
	}

	private void numIslandsHelper(char[][] grid, int m, int n, boolean[][] visited, Queue<Cell> queue) {
		Cell cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			for (int i = 0; i < dx.length; ++i) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				// out of bound check
				if (x < 0 || x >= m || y < 0 || y >= n) {
					continue;
				}
				// duplicate check
				if (visited[x][y]) {
					continue;
				}
				// other invalid cases
				if (grid[x][y] != '1') {
					continue;
				}
				queue.offer(new Cell(x, y));
				visited[x][y] = true;
			}
		}
	}

	// method 2 (DF):
	public int numIslands2(char[][] grid) {
		// input sanity check
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return 0;
		}
		int ret = 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!visited[i][j] && grid[i][j] == 1) {
					++ret;
					numIslands2Helper(grid, m, n, i, j, visited);
				}
			}
		}
		return ret;
	}

	private void numIslands2Helper(char[][] grid, int m, int n, int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		for (int k = 0; k < dx.length; ++k) {
			int x = i + dx[k];
			int y = j + dy[k];
			// out of bound check
			if (x < 0 || x >= m || y < 0 || y >= n) {
				continue;
			}
			// duplicate check
			if (visited[x][y]) {
				continue;
			}
			// other invalid condition
			if (grid[x][y] != '1') {
				continue;
			}
			numIslands2Helper(grid, m, n, x, y, visited);
		}
	}

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, -1, 1};
}
