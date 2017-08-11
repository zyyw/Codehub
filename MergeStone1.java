/**
 * Problem statement:
 * There is a stone game. At the beginning of the game the player picks n piles of stones in a line.
 * The goal is to merge the stones in one pile observing the following rules:
 * 1. At each step of the game,the player can merge two adjacent piles to a new pile.
 * 2. The score is the number of stones in the new pile.
 * You are to determine the minimum of the total score.
 *
 * Idea:
 * 1. state:
 * dp[i][j]: 表示将 nums[i:j] 之间, inclusively, 的石子 merge 到 1 pile 需要的cost
 * 2. base case initialization
 * dp[i][i] = 0
 * 3. induction rule
 * dp[i][j] = MIN{ dp[i][k] + dp[k + 1][j] } + sum(s[i:j]), i <= k < j
 * 4. return value
 * dp[0][nums.length - 1]
 */

public class MergeStone1 {
	public int stoneGame(int[] nums) {
		// input sanity check
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		int[] sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; ++i) {
			sum[i + 1] = sum[i] + nums[i];
		}
		// 1. state
		int[][] dp = new int[nums.length][nums.length];
		// 2. base case initialization
		for (int i = 0; i < nums.length; ++i) {
			dp[i][i] = 0;
		}
		// 3. induction rule
		for (int i = nums.length - 1; i >= 0; --i) {
			for (int j = i + 1; j < nums.length; ++j) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; ++k) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
				}
			}
		}
		// return value
		return dp[0][nums.length - 1];
	}
}
