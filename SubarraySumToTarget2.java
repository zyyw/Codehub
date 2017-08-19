/**
 * Problem statement:
 * Given an subarray of integer and an integer k, you need to find the total number of continuous subarrays whose sum equals k.
 *
 * For example:
 * [1, 1, 1], k = 2
 * return 2
 *
 * Idea:
 * // 错错错！！！
 *  prefixSum + Set
 *
 * // 对对对
 * prefixSum[i], 表示 nums[0:i] 所有元素的和
 * Map<Integer, Integer> hashMap
 *   key: prefixSum[i]
 *   value: prefixSum[i] 出现的次数
 *   需要统计的是：每次 prefixSum[i] - k 出现的次数，并累加
 *   物理意义：在 nums[i] 之前有多少个 prefixSum[i] - k 个记录，which mean 从 nums[i] 向前可以找到这么多个 subarray 满足 subarray sum equals k
 */

public class SubarraySumToTarget2 {
	public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int prefixSum = 0;
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, 1);
		int ret = 0;
		Integer frequency = null;
		Integer cur = null;
		for (int i = 0; i < nums.length; ++i) {
			prefixSum += nums[i];
			frequency = hashMap.get(prefixSum - k);
			ret += (frequency == null ? 0 : frequency);
			cur = hashMap.get(prefixSum);
			hashMap.put(prefixSum, 1 + (cur == null ? 0 : cur));
		}
		return ret;
	}

	/**
	 * 错误解法
	 */
	public int subarraySumWrongSolution(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int prefixSum = 0;
		Set<Integer> set = new HashSet<>();
		set.add(0);
		int ret = 0;
		for (int i = 0; i < nums.length; ++i) {
			prefixSum += nums[i];
			if (set.contains(prefixSum - k)) {
				++ret;
			}
			set.add(prefixSum);
		}
		return ret;
	}
}
