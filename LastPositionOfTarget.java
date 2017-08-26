/**
 * Problem statement:
 * Given an integer target T and an integer array A sorted in ascending order,
 * find the index of the last occurrence of T in A or return -1 if there is
 * no such index.
 */

public class LastPositionOfTarget {
	public int lastOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;
		int mi;
		while (start + 1 < end) {
			mi = (start + end) / 2;
			if (array[mi] <= target) {
				start = mi;
			} else {
				end = mi;
			}
		}
		// case 1: there is only 1 element
		// case 2: there are 2 elements
		if (array[end] == target) {
			return end;
		}
		return array[start] == target ? start : -1;
	}
}
