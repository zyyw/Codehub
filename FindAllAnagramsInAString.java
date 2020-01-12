/**
 * Problem statement:
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Assumption:
 * 1. Strings consist of lowercase English letters only.
 * 2. the order of output does not matter
 *
 * Example:
 * s: "cbaebabacd" p: "abc"
 * return: [0, 6]
 *
 */

public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ret = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) {
			return ret;
		}
		// build hash table with p
		int[] hashTable = new int[26];
		for (int i = 0; i < p.length(); ++i) {
			++hashTable[p.charAt(i) - 'a'];
		}
		// fixed-size sliding window
		int left = 0;
		int right = 0;
		int cnt = p.length();
		while (right < s.length()) {
			// 1 check if current char is within pattern or not
			if (hashTable[s.charAt(right) - 'a'] >= 1) {
				--cnt;
			}
			--hashTable[s.charAt(right) - 'a'];
			++right;
			if (cnt == 0) {
				ret.add(left);
			}
			if (right - left == p.length()) {
				if (hashTable[s.charAt(left) - 'a'] >= 0) {
					++cnt;
				}
				++hashTable[s.charAt(left) - 'a'];
				++left;
			}
		}
		return ret;
	}
}
