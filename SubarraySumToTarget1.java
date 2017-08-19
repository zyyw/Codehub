/**
 * Problem statement:
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the last number.
 *
 * If there is no such a subarray whose subarray sum equals zero, return {-1, -1}
 * If there are multiple subarray whose subarray sum equals zero, return the index pair of any one of them.
 *
 * 注意：
 * 这道题是返回下标，有时候是判断是否存在。尽管大同小异，要看清题意。
 *
 * Idea:
 * prefixSum[i] 表示 array[0:i] 所有元素的和
 *  // 错错错！！！ 因为要返回下标，所以要用 Map instead of Set; 如果只要判读是否存在，那么用 Set 即可
 * Set<Integer> set: 装所有 prefixSum; 遍历数组 nums 前, 要先把 0 装入 set 里
 *  // 对对对
 * Map<Integer, Integer>: key = prefixSum[i], value = index(i)
 * hashMap.put(0, -1);
 */

public class SubarraySumToTarget1 {
	public ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> ret = new ArrayList<>(Arrays.asList(-1, -1));
		if (nums == null || nums.length == 0) {
			return ret;
		}
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, -1);
		int prefixSum = 0;
		Integer index = null;
		for (int i = 0; i < nums.length; ++i) {
			prefixSum += nums[i];
			index = hashMap.get(prefixSum);
			if (index != null) {
				// found one subarray whose subarray sum is 0, [index + 1, i]
				ret.set(0, index + 1);
				ret.set(1, i);
				return ret;
			}
			hashMap.put(prefixSum, i);
		}
		return ret;
	}
}
