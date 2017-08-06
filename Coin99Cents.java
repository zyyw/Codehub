/**
 * Problem statement:
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways
 * to pay a target number of cents.
 *
 * Assumption:
 * 1. coins. representing the different denominations of coins.
 *    1.1 no dudplicates
 *    1.2 all positive integers
 *    1.3 sorted in descending order
 * 2. target >= 0
 * 3. for each type of coins in the coins array, you have infinite number of it
 *
 * Return:
 * 1. a list of ways of combination of coins to sum up to be target
 * 2. each way of combination is represented as a list of integer. and the number at each index means the number of coins
 *    used for the denomination at corresponding index
 *
 * Example:
 * {2, 1}, 4
 * [
 *   [0, 4]
 *   [1, 2]
 *   [2, 0]
 * ]
 *
 * Idea:
 * 1 base case:
 *   当 index == coins.length 时。
 *   为什么根据 index 来作为 base case / termination rule?
 *   因为，函数体表示，在取 coins[index] 时，取多少个 (for 循环) 
 *   for 循环里的递归表示，当下硬币 coins[index] 选取的个数已经确定，寻找下一个硬币需要选取的个数。
 *   index 表示 递归的深度，level
 *   另外 curTarget == 0 时，是一个 valid combination / solution
 * 2 recursion rule:
 *   每个 coin, identified by index, 可选个数 i 的范围: 0, 1, 2, ..., i; where curTarget - coins[index] * i >= 0
 */

public class Coin99Cents {
	public List<List<Integer>> combinations(int target, int[] coins) {
		// input sanity check
		List<List<Integer>> ret = new ArrayList<>();
		if (coins == null || coins.length == 0 || target < 0) {
			return ret;
		}
		List<Integer> oneWay = new ArrayList<>();
		combinationsHelper(target, coins, 0, ret, oneWay);
		return ret;
	}

	private void combinationsHelper(int curTarget, int[] coins, int index, List<List<Integer>> ret, List<Integer> oneWay) {
		// base case:
		if (index == coins.length) {
			if (curTarget == 0) {
				ret.add(new ArrayList<>(oneWay));
			}
			return;
		}
		// Recursion rule
		for (int i = 0; curTarget - coins[index] * i >= 0; ++i) {
			oneWay.add(i);
			combinationsHelper(curTarget - coins[index] * i, coins, index + 1, ret, oneWay);
			oneWay.remove(oneWay.size() - 1);
		}
	}
}
