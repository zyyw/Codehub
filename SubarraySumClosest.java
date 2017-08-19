/**
 * Problem statement:
 * Given an integer array, find a subarray with sum closest to zero. Return the index of the first number and the last number.
 *
 * Assumption:
 * This given array is not null nor empty
 *
 * Idea:
 * 求出 prefixSum[i], 构建 Cell(prefixSum[i], index), 根据 prefixSum[i] 对 Cell 进行排序
 * 有了有序 prefixSum[i] 后，找相邻 Cell，比较 prefixSum 差值
 */

public class SubarraySumClosest {
	static class Cell {
		int sum;
		int index;
		Cell(int s, int idx) {
			sum = s;
			index = idx;
		}
	}

	public int[] subarraySumClosest(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int prefixSum = 0;
		List<Cell> list = new ArrayList<>();
		for (int i = 0; i < nums.length; ++i) {
			prefixSum += nums[i];
			list.add(new Cell(prefixSum, i));
		}
		Collections.sort(list, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.sum == c2.sum) {
					return c1.index < c2.index ? -1 : 1;
				}
				return c1.sum < c2.sum ? -1 : 1;
			}
		});
		int diff = Integer.MAX_VALUE;
		int[] ret = {0, 0};
		for (int i = 1; i < list.size(); ++i) {
			int curDiff = list.get(i).sum - list.get(i - 1).sum;
			if (curDiff <= diff) {
				diff = curDiff;
				ret[0] = Math.min(list.get(i).index, list.get(i - 1).index) + 1;
				ret[1] = Math.max(list.get(i).index, list.get(i - 1).index);
			}
		}
		return ret;
	}
}
