/**
 * Prolbem statement:
 * Given three arrays sorted in ascending order. Pull one number from each array to from a coordinate (x, y, z) in a
 * 3D space. Find the coordinate of the points that is k-th closest to (0, 0, 0)
 * using euclidean distance here.
 *
 * Return:
 * a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array
 *
 * Assumption:
 * 1. The three given arrays are not null or empty AND all non-negative number
 * 2. K >= 1 and K <= a.length * b.length * c.length
 *
 */

public class KthCloestPointToXYZ_1 {
	static class Cell implements Comparable<Cell> {
		int x;
		int y;
		int z;
		long d;
		Cell(int x, int y, int z, long d) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.d = d;
		}

		@Override
		public int compareTo(Cell c) {
			return this.d < c.d ? -1 : 1;
		}
	}

	public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		// input sanity check
		List<Integer> ret = new ArrayList<>();
		if (a == null || a.length == 0 || b == null || b.length == 0 || c == null || c.length == 0 || k <= 0) {
			return ret;
		}
		Queue<Cell> pq = new PriorityQueue<>();
		pq.offer(new Cell(0, 0, 0, distance(a[0], b[0], c[0])));
		boolean[][][] visited = new boolean[a.length][b.length][c.length];
		visited[0][0][0] = true;
		int[] dx = {1, 0, 0};
		int[] dy = {0, 1, 0};
		int[] dz = {0, 0, 1};
		Cell cur = null;
		while (--k > 0) {
			cur = pq.poll();
			for (int i = 0; i < 3; ++i) {
				int x2 = cur.x + dx[i];
				int y2 = cur.y + dy[i];
				int z2 = cur.z + dz[i];
				if (!(x2 < a.length && y2 < b.length && z2 < c.length)) {
					continue;
				}
				if (visited[x2][y2][z2]) {
					continue;
				}
				pq.offer(new Cell(x2, y2, z2, distance(a[x2], b[y2], c[z2])));
				visited[x2][y2][z2] = true;
			}
		}
		ret.add(a[pq.peek().x]);
		ret.add(b[pq.peek().y]);
		ret.add(c[pq.peek().z]);
		return ret;
	}

	private long distance(int x, int y, int z) {
		return (long)(x * x) + (long)(y * y) + (long)(z * z);
	}
}
