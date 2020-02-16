/**
 * Problem statement:
 * Given an integer array, find a subarray where the sum of elements is in a given interval range [start, end].
 * Return the number of subarrays that meet with this requirement.
 *
 * Assumptions:
 * 1. the given array is not null or empty
 * 2. all elements in the given array are positive integer
 *
 * Idea:
 * [ Brute-force ]
 * 1. # of subarray of an array is O(N^2)
 * 2. comput sum of each subarray is O(N)
 * total time complexity: O(N^3)
 *
 * [ prefixSum ]
 *    for j: 0 -> n-1
 *       compute prefixSum[j] = sum of nums[0:i]
 *       if start <= prefixSum[j] && prefixSum[j] <= end:
 *       	ret++
 *       for i: j - 1 -> 0
 *          subarraySum = prefixSum[j] - prefixSum[i]
 *          if start <= subarraySum && subarraySum <= end 
 *             ret++
 * time complexity: O(N^2)
 */
public class SubarraySumWithinRange {
	public int subarraySumII(int[] nums, int start, int end) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] prefixSum = new int[nums.length];
		prefixSum[0]= nums[0];
		int ret = 0; 
		if (start <= prefixSum[0] && prefixSum[0] <= end) {
			++ret;
		}
		/*
		// 没有 prune, TLE
		int subarraySum = 0;
		for (int j = 1; j < nums.length; ++j) {
			prefixSum[j] = prefixSum[j - 1] + nums[j];
			for (int i = j - 1; i >= 0; --i) {
				subarraySum = prefixSum[j] - prefixSum[i];
				if (start <= subarraySum && subarraySum <= end) {
					++ret;
				}
			}
			if (start <= prefixSum[j] && prefixSum[j] <= end) {
				++ret;
			}
		}
		*/
		int subarraySum = 0;
		for (int j = 1; j < nums.length; ++j) {
			for (int i = j - 1; i >= 0; --i) {
				prefixSum[j] = prefixSum[j - 1] + nums[j];
				subarraySum = prefixSum[j] - prefixSum[i];
				if (subarraySum > end) {
					break;
				} else if (subarraySum >= start) {
					++ret;
				}
			}
			if (start <= prefixSum[j] && prefixSum[j] <= end) {
				++ret;
			}
		}
		return ret;
	}
}
