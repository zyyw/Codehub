/**
 * Problem statement:
 * 给定一个整数数组，把所有的 0 都移到数组的右边。 数字 0 之间的相对顺序要保持不变。
 *
 * Idea:
 * 从右往左即可.
 */


public class Move0sToTheEnd2 {
	public int[] moveZero(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int right = array.length - 1; // all elements to the right of right, exclusively, are 0s
		int left = array.length - 1; // all elements to the left of left, inclusively, are elements to be searched
		// all elements (left: right] are non-0 elements
		while (left >= 0) {
			if (array[left] == 0) {
				swap(array, left, right);
				--right;
			}
			--left;
		}
		return array;
	}

	private void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
}
