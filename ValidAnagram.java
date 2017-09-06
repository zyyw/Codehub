/**
 * Problem statement:
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * Assumption:
 * You may assume the string contains only lowercase alphabets.
 *
 * Idea:
 * 1. iterate through s, calculate frequency of each char in s
 * 2. iterate through t, substract from the frequency hashTable
 * 3. iterate through the hashTable to see if all values are 0
 */

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int[] hash = new int[26];
		Arrays.fill(hash, 0);
		for (int i = 0; i < s.length(); ++i) {
			int index = s.charAt(i) - 'a';
			if (index < 0 || index > 25) {
				return false;
			}
			++hash[index];
		}
		for (int i = 0; i < t.length(); ++i) {
			int index = t.charAt(i) - 'a';
			if (index < 0 || index > 25) {
				return false;
			}
			--hash[index];
			if (hash[index] < 0) {
				return false;
			}
		}
		for (int i = 0; i < 26; ++i) {
			if (hash[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
