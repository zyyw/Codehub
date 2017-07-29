/**
 * Problem statement:
 * 给定一个包含 n 个物体，颜色可能是 red, green, or blue, yellow.
 * 要求将同一颜色的物体相邻地放到一块, in the order of red, green and blue, yellow
 * 0 - 表示 red
 * 1 - 表示 gree 
 * 2 - 表示 blue 
 * 3 - 表示 yellow 
 *
 * Idea:
 * 从 3 种颜色变成 4 种颜色。
 * rainbowSort1 + moveZeros1
 * 0, 1, (2, 3)
 */


public class RainbowSort2 {
	public int[] rainbowSort(int[] array) {
		// input sanity check
		if (array == null || array.length <= 0) {
			return array;
		}
		// step 1: rainbow sort 1
		int left = 0; // [0, left) - 0
					   // [left, right) - 1
		int right = 0; // [right, end] - to be searched
		int end = array.length - 1; // (end, array.length) - (2, 3)
		while (right <= end) {
			if (array[right] == 0) {
				swap(array, left, right);
				++left;
				++right;
			} else if (array[right] == 1) {
				++right;
			} else {
				// array[right] == 2 or 3
				swap(array, right, end);
				--end;
			}
		}
		// [end + 1, array.length - 1] are either 2 or 3
		// step 2: moveZero1
		left = end + 1; // [end + 1, left) - 2
		right = end + 1; // [right, array.length) - to be searched
		while (right < array.length) {
			if (array[right] == 2) {
				swap(array, left, right);
				++left;
			}
			++right;
		}
		return array;
	}

	private void swap(int[] array, int idx1, idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
}
