/**
 * Problem statement:
 * 给定一个包含 n 个物体，颜色可能是 red, green, or blue.
 * 要求将同一颜色的物体相邻地放到一块, in the order of red, green and blue
 * 0 - 表示 red
 * 1 - 表示 gree 
 * 2 - 表示 blue 
 *
 */

public class RainbowSort1 {
	public int[] rainbowSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int left = 0; // all the elements to the left of "left", exclusively, are red (0)
		int right = 0; // all the elements to the right of "right", inclusively,  (and < end) are elements to be searched 
		int end = array.length - 1; // all the elements to the right of "end", exclusively, are blue (2)
		while (right <= end) {
			if (array[right] == 0) {
				swap(array, left, right);
				++left;
				++right;
			} else if (array[right] == 2) {
				swap(array, right, end);
				--end;
			} else {
				// array[right] == 1
				++right;
			}
		}
		return array;
	}

	private void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
}
