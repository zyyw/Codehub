/**
 * Problem statement:
 * Given an array of integers, find three integers in the array such that the sum of these three is closest to a given number, target.
 * Return the sum of the three integers.
 */

public class ThreeSumClosest {
	public int threeSumClosest(int[] numbers, int target) {
		if (numbers == null || numbers.length < 3) {
			return 0;
		}
		int ret = Integer.MAX_VALUE;
		int retDiff = Integer.MAX_VALUE;
		Arrays.sort(numbers);
		for (int c = 2; c < numbers.length; ++c) {
			int a = 0;
			int b = c - 1;
			while (a < b) {
				int sum = numbers[a] + numbers[b] + numbers[c];
				if (sum == target) {
					return target;
				} else if (sum < target) {
					int diff = target - sum;
					if (diff < retDiff) {
						ret = sum;
						retDiff = diff;
					}
					++a;
				} else {
					int diff = sum - target;
					if (diff < retDiff) {
						ret = sum;
						retDiff = diff;
					}
					--b;
				}
			}
		}
		return ret;
	}
}
