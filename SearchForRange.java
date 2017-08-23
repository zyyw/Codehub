/**
 * Problem statement:
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 */

public class SearchForRange {
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}
		int startIndex = findFirstPosition(nums, target);
		if (startIndex == -1) {
			return new int[]{-1, -1};
		}
		int endIndex = findLastPosition(nums, target);
		return new int[]{startIndex, endIndex};
	}

	private int findFirstPosition(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mi;
		while (start + 1 < end) {
			mi = (start + end) / 2;
			if (nums[mi] < target) {
				start = mi;
			} else {
				end = mi;
			}
		}
		// case1: there is only 1 element
		// case2: there are 2 elements
		if (nums[start] == target) {
			return start;
		}
		return nums[end] == target ? end : -1;
	}

	private int findLastPosition(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mi;
		while (start + 1 < end) {
			mi = (start + end) / 2;
			if (nums[mi] <= target) {
				start = mi;
			} else {
				end = mi;
			}
		}
		if (nums[end] == target) {
			return end;
		}
		return nums[start] == target ? start : -1;
	}
}
