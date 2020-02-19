/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time
(i.e., you must sell the stock before you buy again).

Example 1:
Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

思路：
1. 状态定义：left[i], 是 prices[i] 左边(不包括 prices[i]) 最多交易一次的最大获利。
           leftMinPrice 是prices[i] 左边(不包括 prices[i])的价格最低位。
2. base condition: left[0] = 0, leftMinPrice = prices[0]
3. induction rule: left[i] = max(left[i - 1], prices[i] - leftMinPrice)
                    leftMinPrice = min(leftMinPrice, prices[i])

1. 状态定义：right[i], 是 prices[i] 右边(不包括 prices[i]) 最多交易一次的最大获利。
           rightMaxPrice 是 prices[i] 右边(不包括 prices[i])的价格最高位。
2. base condition: right[0] = 0, rightMaxPrice = prices[n - 1]
3. induction rule: right[i] = max(right[i + 1], rightMaxPrice - prices[i])
                   rightMaxPrice = max(rightMaxPrice, prices[i])

4. return:
   MAX{ left[i] + right[i] }
*/

public class BuyAndSellStock3 {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }
    int n = prices.length;

    // left
    int[] left = new int[n];
    int leftMinPrice = prices[0];
    for (int i = 1; i < n; ++i) {
      left[i] = Math.max(left[i - 1], prices[i] - leftMinPrice);
      leftMinPrice = Math.min(leftMinPrice, prices[i]);
    }

    // right
    int[] right = new int[n];
    int rightMaxPrice = prices[n - 1];
    for (int i = n - 2; i >= 0; --i) {
      right[i] = Math.max(right[i + 1], rightMaxPrice - prices[i]);
      rightMaxPrice = Math.max(rightMaxPrice, prices[i]);
    }

    // return
    int ret = 0;
    for (int i = 0; i < n; ++i) {
      ret = Math.max(ret, left[i] + right[i]);
    }
    return ret;
  }
}
