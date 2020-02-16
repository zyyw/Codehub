/**
 * Problem statement:
 * Given a string, find the length of longest substring without repeating characters.
 *
 Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		// input sanity check
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		int ret = 0;
		int left = 0;
		int right = 0;
		Set<Character> set = new HashSet<>();
		while (left <= right && right < n) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				ret = Math.max(ret, right - left + 1);
				++right;
			} else {
				set.remove(s.charAt(left));
				++left;
			}
		}
		return ret;
	}
}
