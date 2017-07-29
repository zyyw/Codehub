/**
 * Problem statement:
 * Given a string, find the length of longest substring without repeating characters.
 *
 */

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String input) {
		// input sanity check
		if (input == null) {
			return 0;
		} else if (input.length() <= 1) {
			return input.length();
		}
		int left = 0;
		int ret = 1; // length of longest substring without repeating characters
		Map<Character, Integer> hashMap = new HashMap<>();
		for (int right = 0; right < input.length(); ++right) {
			int index = repeatedInWindow(left, right, hashMap, input.charAt(right));
			if (index != -1) {
				// repeated in window [left, right]
				left = index + 1;
			} else {
				ret = Math.max(ret, right - left + 1);
			}
			hashMap.put(input.charAt(right), right);
		}
		return ret;
	}

	private int repeatedInWindow(int left, int right, Map<Character, Integer> hashMap, char cur) {
		Integer curIndex = hashMap.get(cur);
		if (curIndex == null || curIndex < left) {
			// not repeated in window [left, right]
			return -1;
		}
		// repeated in window [left, right], return the index where it's repeated
		return curIndex.intValue();
	}
}
