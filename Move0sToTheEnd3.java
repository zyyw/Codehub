/**
 * Problem statement:
 * 给定一个整数数组，把所有的 0 都移到数组的右边。 非 0 数字 之间的相对顺序要保持不变。
 *
 * Idea:
 * 从左往右
 */


public class Move0sToTheEnd2 {
	public int[] moveZero(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int left = 0; // all elements to the left of left, exclusively, are non-0 elements
		int right = 0; // all elements to the right of right, inclusively, are elements to be searched
		// all elements (left: right] are non-0 elements
		while (right < array.length) {
			if (array[right] != 0) {
				swap(array, left, right);
				++left;
			}
			++right;
		}
		return array;
	}

	private void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
}
