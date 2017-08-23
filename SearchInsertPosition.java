/**
 * Problem statement:
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * Assumption:
 * 1. there is no duplicates in the array
 * 2. it is not null
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = nums.length - 1;
		int mi = 0;
		while (start + 1 < end) {
			mi = (start + end) / 2;
			if (nums[mi] <= target) {
				start = mi;
			} else {
				end = mi;
			}
		}
		// case 1: there  is only 1 element
		// case 2: there are 2 elements
		if (target <= nums[start]) {
			return start;
		} else if (target <= nums[end]) {
			return end;
		} else {
			return end + 1;
		}
	}
}
