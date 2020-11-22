/**
 * Problem statement:
 * Given an array of non-negative integers, you are initially positioned at an
 * arbitrary index of the array.
 * A[i] means the maximum jump distance from that position (you can either
 * jump left or jump right)
 * Determin the minimum jumps you need to reach the right end of the array.
 * Return -1 if you can not reach the right end of the array.
 *
 * Assumption:
 * 1. the input array is not null and not empty
 *
 */

public class ArrayHopper4 {
	static class Cell {
		int idx;
		int step;
		Cell(int idx, int step) {
			this.idx = idx;
			this.step = step;
		}
	}
	public int minJump(int[] array, int index) {
		if (array == null || array.length == 0) {
			return -1;
		} else if (index == array.length - 1) {
			return 0;
		}
		Queue<Cell> queue = new ArrayDeque<>();
		queue.offer(new Cell(index, 0));
		boolean[] visited = new boolean[array.length];
		visited[index] = true;
		Cell cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			// expand
			if (cur.idx + array[cur.idx] >= array.length - 1) {
				return cur.step + 1;
			}
			// generate
			for (int i = Math.max(0, cur.idx - array[cur.idx]); i <= cur.idx + array[cur.idx]; ++i) {
				// duplicate check
				if (visited[i]) {
					continue;
				}
				queue.offer(new Cell(i, cur.step + 1));
				visited[i] = true;
			}
		}
		return -1;
	}
}
