/**
 * Problem statement:
 * Given an integer array nums, and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 *
 * Idea:
 * [ prefixSum ]
 * Map<Integer, Integer>
 * key: prefixSum from nums[0] ~ nums[i]
 * value: the index of the 1st occurrence of prefixSum
 * init: hashMap.put(0, -1);
 */
public class MaximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, -1);
		int ret = 0;
		int prefixSum = 0;
		Integer cur = null;
		for (int i = 0; i < nums.length; ++i) {
			prefixSum += nums[i];
			cur = hashMap.get(prefixSum - k);
			if (cur != null && i - cur > ret) {
				ret = i - cur;
			}
			if (hashMap.get(prefixSum) == null) {
				hashMap.put(prefixSum, i);
			}
		}
		return ret;
	}
}
