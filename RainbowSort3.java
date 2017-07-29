/**
 * Problem statement:
 * 给定一个包含 n 个物体，颜色可能是k 种, 从 1 ~ k
 * 要求将同一颜色的物体相邻地放到一块, in the order of red, green and blue, yellow, ... etc
 * 1  表示 red
 * 1  表示 gree 
 * 2  表示 blue 
 * 3  表示 yellow 
 * .. .. .. ..
 * k  表示 etc
 *
 * Idea:
 * method 1:
 * 从 3 种颜色变成 k 种颜色。
 * rainbow sort 1, 重复 k / 2 次
 * 第一次, 1 号颜色和 k 号颜色都放在该放的位置，即首和尾
 * 第二次，在中间待排序的区间重复第一次的方法，又排好 2 种颜色，分别在待排区间的首和尾
 * ...
 */

public class RainbowSort3 {
	public int[] rainbowSort(int[] array, int k) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int color = 1;
		int left = 0;
		int right = 0;
		int end = array.length - 1;
		while (color < k - color + 1) {
			// sort head and tail color
			// search range [start, end]
			while (right <= end) {
				if (array[right] == color) {
					// color - head
					swap(array, left, right);
					++left;
					++right;
				} else if (array[right] == k - color + 1) {
					// color - tail
					swap(array, right, end);
					--end;
				} else {
					++right;
				}
			}
			// [left, end] are unsorted colors
			right = left; // right is the cursor iterating [left, end]
			// reset base color
			++color;
		}
		return array;
	}

	private void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
}
