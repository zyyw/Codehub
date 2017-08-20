/**
 * Problem statement:
 * Given a string s, partition s such that every substring of the partitionis a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Idea:
 * 从左往右 linear scan (j)
 * 一边 scan，一边回头看(看所有)：看1个，2个，..., j个
 *   dp[i]: 表示给定 string 的前 i 个是否为 palindrome
 *   O(N^2)
 * 需要快速判读回头看的这k个元素是否是palindrome, 用一个二维数组预处理 O(N^2), 独立／平行于主逻辑
 *   isPalindrome[i][j]: 表示 string[i:j] 是否为palindrome
 *   O(1)
 */
public class PalindromePartitioning2 {
	public int minCut(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		preprocess(s, isPalindrome);
		int[] dp = new int[s.length() + 1];
		dp[0] = -1;
		for (int j = 0; j < s.length(); ++j) {
			dp[j + 1] = j;
			for (int i = j; i >= 0; --i) {
				if (isPalindrome[i][j]) {
					dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
				}
			}
		}
		return dp[s.length()];
	}
	private void preprocess(String s, boolean[][] isPalindrome) {
		if (s == null || s.length() == 0) {
			return;
		}
		for (int i = 1; i < s.length(); ++i) {
			isPalindrome[i][i] = true;
			isPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
		}
		isPalindrome[0][0] = true;
		for (int i = s.length() - 1; i >= 0; --i) {
			for (int j = i + 2; j < s.length(); ++j) {
				isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
			}
		}
	}
}
