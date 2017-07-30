/**
 * Problem statement:
 * Give a string s, and another string p. Find all substring in s that is an anagram of p.
 * Ruturn the starting index of anagram substring.
 *
 * Example:
 * s = "abcbac"
 * p = "ab"
 * return {0, 3}
 */

public class AllAnagrams {
	public List<Integer> allAnagrams(String s, String p) {
		List<Integer> ret = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) {
			return ret;
		}
		int[] hashPattern = new int[256];
		for (int i = 0; i < p.length(); ++i) {
			++hashPattern[p.charAt(i)];
		}
		int left = 0, right = 0, cnt = p.length();
		while (right < p.length()) {
			if (hashPattern[s.charAt(right)]) {
				// this is a char in p
				--cnt;
			}
			--hashPattern[s.charAt(right)];
			++right;
			if (cnt == 0) {
				ret.add(left);
			}
			if (right - left == p.length()) {
				// reached to the window size == p.length()
				if (hashPattern[s.charAt(left)] >= 0) {
					++cnt;
				}
				++hashPattern[s.charAt(left)];
				++left;
			}
		}
		return ret;
	}
}
