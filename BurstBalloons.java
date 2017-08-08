/**
 * Problem statement:
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Assumptions:
 * 1. You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 *
 * Idea:
 * 1. state
 * dp[i][j], 表示array[i:j] 全部打掉，获得最多的 coins
 * 2. base case initialization
 * dp[i][i] = array[i - 1] * array[i] * array[i + 1], where 1 <= i <= array.length - 2 
 * 3. induction rule
 * dp[i][j] = MAX{ dp[i][k - 1] + lastValue + dp[k + 1][j] }, where i <= k <= j
 * lastValue = array[i - 1] * array[k] * array[j + 1]
 * 注意当 k == i or k == j 时，dp[i][j] should be 0, and 此时i > j
 * 4. return value
 * dp[1][array.length - 2]
 *
 */

public class BurstBalloons {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		// add sentinel
		int[] array = new int[nums.length + 2];
		array[0] = 1;
		for (int i = 0; i < nums.length; ++i) {
			array[i + 1] = nums[i];
		}
		array[array.length - 1] = 1;
		// 1. state
		int[][] dp = new int[array.length][array.length];
		// 2. base case initialization
		for (int i = 1; i <= array.length - 2; ++i) {
			dp[i][i] = array[i - 1] * array[i] * array[i + 1];
		}
		// 3. induction rule
		for (int i = array.length - 2; i >= 1; --i) {
			for (int j = i + 1; j <= array.length - 2; ++j) {
				dp[i][j] = Integer.MIN_VALUE;
				for (int k = i; k <= j; ++k) {
					int lastValue = array[i - 1] * array[k] * array[j + 1];
					dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + lastValue + dp[k + 1][j]);
				}
			}
		}
		// 4. return value
		return dp[1][array.length - 2];
	}
}
