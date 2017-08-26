/**
 * Problem statement:
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log N) time complexity.
 *
 * If the target number does not exist in the array, return -1.
 */

public class FirstPositionOfTarget {
	public int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		int mi = 0;
		// for number of elements >= 3
		while (start + 1 < end) {
			mi = (start + end) / 2;
			if (nums[mi] < target) {
				start = mi;
			} else {
				end = mi;
			}
		}
		// case 1: only 1 element
		// case 2: there are 2 elements
		if (nums[start] == target) {
			return start;
		}
		return nums[end] == target ? end : -1;
	}
}
