/**
 * Problem statement:
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutation is the substring of the second string.
 *
 * Assumption:
 * the input string only contains lowercase letters
 *
 */
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s2 == null || s2.length() < s1.length()) {
			return false;
		} else if (s1.length() == 0) {
			return true;
		}
		// build hash
		int[] hash = new int[26];
		Arrays.fill(hash, 0);
		for (int i = 0; i < s1.length(); ++i) {
			++hash[s1.charAt(i) - 'a'];
		}
		int left = 0;
		int right = 0;
		int cnt = s1.length();
		while (right < s2.length()) {
			if (hash[s2.charAt(right) - 'a'] >= 1) { 
				--cnt;
			}
			--hash[s2.charAt(right) - 'a'];
			++right;
			if (cnt == 0) {
				return true;
			}
			if (right - left == s1.length()) {
				if (hash[s2.charAt(left) - 'a'] >= 0) {
					++cnt;
				}
				++hash[s2.charAt(left) - 'a'];
				++left;
			}
		}
		return false;
	}
}
