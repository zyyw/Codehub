/**
 * Problem statement:
 * Given a string, find the length of longest substring with at most k distinct characters.
 * 讲人话：
 * 在一个给定的字符串中，找到最多有 K 个不同字符的最长子串。返回最长子串的长度。
 *
 * Idea:
 * hashMap<Character, LastOccurenceInde>
 */

public class LongestSubstringWithAtMostKDistinctCharacters {

	public int lengthOfLongestSubstringKDistinct(String input, int k) {
		// input sanity check
		if (input == null || k <= 0) {
			return 0;
		} else if (k >= input.length()) {
			return input.length();
		}
		int left = 0;
		int ret = 1;
		int cnt = 0; // how many distinct character in window [left, right]
		Map<Character, Integer> hashMap = new HashMap<>();
		for (int right = 0; right < input.length(); ++right) {
			if (!isRepeatedInWindow(left, right, hashMap, input.charAt(right))) {
				// array[right] is another distinct character
				++cnt;
				while (cnt > k) {
					if (left == hashMap.get(input.charAt(left))) {
						--cnt;
					}
					++left;
				}
			}
			ret = Math.max(ret, right - left + 1);
			hashMap.put(input.charAt(right), right);
		}
		return ret;
	}

	private boolean isRepeatedInWindow(int left, int right, Map<Character, Integer> hashMap, char cur) {
		Integer curIndex = hashMap.get(cur);
		if (curIndex == null || curIndex < left) {
			return false;
		}
		return true;
	}
}
