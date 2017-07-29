/**
 * Problem statement:
 * Sort an array of integer using quick sort
 *
 */

public class QuickSort {

	public int[] quickSort(int[] array) {
		// input sanity check
		if (array == null || array.length <= 1) {
			return array;
		}
		quickSortHelper(array, 0, array.length - 1);
		return array;
	}

	private void quickSortHelper(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
		int mi = partition(array, start, end);
		quickSortHelper(array, start, mi - 1);
		quickSortHelper(array, mi + 1, end);
	}

	private int partition(int[] array, int start, int end) {
		// choose array[start] as pivot
		int pivot = array[start];
		int mi = start; // 在循环的过程中，array[start + 1 : mi] < pivot
		for (int i = start + 1; i <= end; ++i) {
			if (array[i] < pivot) {
				swap(array, ++mi, i);
			}
		}
		swap(array, start, mi);
		return mi;
	}

	private void swap(int[] array, int idx1, int idx2) {
		int num = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = num;
	}

}
