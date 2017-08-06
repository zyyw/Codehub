/**
 * Problem statement:
 * Given a dictionary containing many words, find the largest product of two words' length,
 * such that the two words do not share any common characters.
 *
 * Assumptions:
 * 1. The words only contains characters of 'a' to 'z'
 * 2. The dictionary is not null and does not contains null string, and has at least two strings
 * 3. If there is no such pair of words, just return 0
 *
 * Idea:
 * 1. sort dict by the length of each string
 * 2. BFS2
 *    [i, j] -> [i + 1, j]; [i, j + 1]
 *
 */

public class LargestProductOfStringLengthWithoutCommonCharacters {
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
			return this.val < cell.val ? 1 : -1; // anti-natural order, maxHeap
		}
	}

	public int largestProduct(String[] dict) {
		// input sanity check
		if (dict == null || dict.length <= 1) {
			return 0;
		}
		Arrays.sort(dict, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return s1.length() < s2.length() ? 1 : -1; // anti-natural order, descending order
			}
		});
		Queue<Cell> pq = new PriorityQueue<>();
		pq.offer(new Cell(0, 1, dict[0].length() * dict[1].length()));
		boolean[][] visited = new boolean[dict.length][dict.length];
		for (int i = 0; i < dict.length; ++i) {
			visited[i][i] = true;
		}
		visited[0][1] = true;
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		Cell cur = null;
		while (!pq.isEmpty()) {
			cur = pq.poll();
			if (noCommonCharacters(dict[cur.x], dict[cur.y])) {
				return dict[cur.x].length() * dict[cur.y].length();
			}
			for (int i = 0; i < 2; ++i) {
				int x2 = cur.x + dx[i];
				int y2 = cur.y + dy[i];
				// out of bound check
				if (!(x2 < dict.length && y2 < dict.length)) {
					continue;
				}
				// duplicate check
				if (visited[x2][y2]) {
					continue;
				}
				pq.offer(new Cell(x2, y2, dict[x2].length() * dict[y2].length()));
				visited[x2][y2] = true;
			}
		}
		return 0;
	}

	private boolean noCommonCharacters(String s1, String s2) {
		int[] hash = new int[256];
		Arrays.fill(hash, 0);
		for (int i = 0; i < s1.length(); ++i) {
			++hash[(int)s1.charAt(i)];
		}
		for (int i = 0; i < s2.length(); ++i) {
			if (hash[(int)s2.charAt(i)] > 0) {
				return false;
			}
		}
		return true;
	}
}
