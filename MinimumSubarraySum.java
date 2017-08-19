/**
 * Problem statement:
 * Given an array of integers, find the subarray with the samllest sum.
 *
 * Assumption:
 * This given array is not null and at least has one element
 * The subarray found contains at least one element
 *
 * Idea:
 * 1. state definition:
 * dp[i], 表示dp[0] ~ dp[i] 中以 dp[i] 结尾的所有的 subarray 的 min subarray sum
 * -- 实际只需要一个变量即可
 * 2. base case initialization
 *   dp[0] = nums[0]
 * 3. induction rule
 *    dp[i] = nums[i] + (dp[i - 1] < 0 ? dp[i - 1] : 0);
 *    讲人话：只要负的 contribution
 * 4. return value:
 *    MAX{ dp[i] }
 */
public class MinimumSubarraySum {
	public int minSubArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return Integer.MIN_VALUE;
		}
		int ret = nums.get(0);
		int minPrefixSum = nums.get(0);
		for (int i = 1; i < nums.size(); ++i) {
			minPrefixSum = nums.get(i) + (minPrefixSum < 0 ? minPrefixSum : 0);
			ret = Math.min(ret, minPrefixSum);
		}
		return ret;
	}
}
