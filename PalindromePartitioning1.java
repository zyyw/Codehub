/**
 * Problem statement:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example:
 * s = "aab"
 * return:
 * [
 *   ["aa", "b"],
 *   ["a", "a", "b]
 * ]
 *
 * Idea:
 * s 每次从 start position 开始，选1个，2个，... n个（同时选的substring要是palindrome）
 * 如果 brute-force, 这样要 O(N^2 * N)
 * 可以预处理 s, 算出 s[i:j] 是否为palindrome, where i <= j. 时间花费 O(N^2), 独立／平行于主逻辑。
 * 这样算每次取的 substring, 只需要 O(1), 总共时间复杂度: O(N^2)
 */
public class PalindromePartitioning1 {
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ret;
		}
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		preprocess(s, isPalindrome);
		List<String> oneSol = new ArrayList<>();
		partitionHelper(s, 0, isPalindrome, ret, oneSol);
		return ret;
	}
	private void partitionHelper(String s, int start, boolean[][] isPalindrome, List<List<String>> ret, List<String> oneSol) {
		if (start == s.length()) {
			ret.add(new ArrayList<>(oneSol));
			return;
		}
		for (int i = start; i < s.length(); ++i) {
			if (isPalindrome[start][i]) {
				oneSol.add(s.substring(start, i + 1));
				partitionHelper(s, i + 1, isPalindrome, ret, oneSol);
				oneSol.remove(oneSol.size() - 1); // backtrack
			}
		}
	}
	private void preprocess(String s, boolean[][] isPalindrome) {
		int n = s.length();
		for (int i = 1; i < n; ++i) {
			isPalindrome[i][i] = true;
			isPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
		}
		isPalindrome[0][0] = true;
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i + 2; j < n; ++j) {
				isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
			}
		}
	}
}
