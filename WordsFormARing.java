/**
 * Problem statement:
 * Given an array of strings, find if the strings can be concatenated to form a ring.
 * 1. two string s1, s2 can be concatenated iff the last char of s1 is identical to the first char of s2
 * 2. the first char of the first word is identical to the last char of the last word
 * 3. the ring must contains all words in the input array once and only once
 *
 * Assumption:
 * 1. the given array is not null or empty
 * 2. every word in the input array is not null || empty
 */

public class WordsFormARing {
	public boolean formRing(String[] words) {
		// input sanity check
		if (words == null || words.length == 0) {
			return false;
		}
		return formRingHelper(words, 0);
	}

	private boolean formRingHelper(String[] words, int start) {
		if (start == words.length) {
			return words[0].charAt(0) == words[start - 1].charAt(words[start - 1].length() - 1);
		}
		for (int i = start; i < words.length(); ++i) {
			if (start == 0 || words[start - 1].charAt(words[start - 1].length() - 1) == words[i].charAt(0)) {
				swap(words, start, i);
				if (formRingHelper(words, start + 1)) {
					return true;
				}
				swap(words, start, i);
			}
		}
		return false;
	}

	private void swap(String[] words, int i, int j) {
		String word = words[i];
		words[i] = words[j];
		word[j] = word;
	}
}
